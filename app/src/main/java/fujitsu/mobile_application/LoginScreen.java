package fujitsu.mobile_application;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        final EditText etUsername = (EditText)findViewById(R.id.etUsername);
        final EditText etPassword = (EditText)findViewById(R.id.etPassword);
        final Button btLogin = (Button)findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                //check connectivity
                ConnectivityManager cm = (ConnectivityManager) getApplicationContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (null != activeNetwork) {
                    if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                        validateUser(username,password);
                    if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                        validateUser(username,password);
                }
                else
                    Toast.makeText(getApplicationContext(), "No internet Connectivity", Toast.LENGTH_SHORT).show();
            };
        });
    }

//validate user credentials
    public void validateUser(final String username,final String password){

        Response.Listener<String> responseListener;
        responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        String firstName = jsonResponse.getString("firstName");
                        String userID    = jsonResponse.getString("userID");
                        String lastName  = jsonResponse.getString("lastName");
                        String emailAdd  = jsonResponse.getString("emailAdd");
                        String homeAdd   = jsonResponse.getString("homeAdd");
                        String Dept      = jsonResponse.getString("Dept");
                        String Div       = jsonResponse.getString("Div");
                        String acctType  = jsonResponse.getString("AcctType");

                        Intent intent = new Intent(LoginScreen.this, MainScreen.class);
                        intent.putExtra("username", username);
                        intent.putExtra("firstName", firstName);
                        intent.putExtra("lastName", lastName);
                        intent.putExtra("userID", userID);
                        intent.putExtra("emailAdd", emailAdd);
                        intent.putExtra("homeAdd", homeAdd);
                        intent.putExtra("Dept", Dept);
                        intent.putExtra("Div", Div);
                        intent.putExtra("acctType", acctType);

                        LoginScreen.this.startActivity(intent);
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(LoginScreen.this);
                        builder.setMessage("Login Failed")
                                .setNegativeButton("Retry", null)
                                .create()
                                .show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
        RequestQueue queue = Volley.newRequestQueue(LoginScreen.this);
        queue.add(loginRequest);
    }
}
