package fujitsu.mobile_application;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WellbeingFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    TextView tvCurDate;
    String dateToday;
    Calendar calendar;
    String userID;

    public WellbeingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userID = getArguments().getString("userID").toString();
        }
        //get current date
        calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        dateToday = df.format(calendar.getTime());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_wellbeing, container, false);

        //set current date to textview
        tvCurDate = (TextView) v.findViewById(R.id.emFragDate);
        tvCurDate.setText(dateToday);

        //insert current mood
        final Button btMood = (Button)v.findViewById(R.id.sbmtMood);
        final TextView tvMoodToday = (TextView)v.findViewById(R.id.currentMood);

        btMood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                //final TextView userMood = (TextView) v.findViewById(R.id.currentMood);

                final SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyyMMdd");
                final String moodToday = tvMoodToday.getText().toString();
                final String dateToday = sqlDateFormat.format(calendar.getTime());

                //check connectivity

                ConnectivityManager cm = (ConnectivityManager) v.getContext()
                        .getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (null != activeNetwork) {
                    if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                        insertMood(userID,dateToday,moodToday);
                    if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                        insertMood(userID,dateToday,moodToday);
                }
                else
                    Toast.makeText(getContext(), "No internet Connectivity", Toast.LENGTH_SHORT).show();
            };
        });

        return v;
    }

    public void insertMood(final String user2ID,final String dateToday, final String moodToday){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if (success) {
                        Toast.makeText(getContext(), "Mood saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getContext(), "Mood not saved", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        InsertRequest insertRequest = new InsertRequest(user2ID, dateToday, moodToday, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(insertRequest);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context, "Wellbeing", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
