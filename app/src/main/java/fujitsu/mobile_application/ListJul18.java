package fujitsu.mobile_application;

/**
 * Created by h.delrosario on 10/10/2017.
 */

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListJul18 extends AppCompatActivity {

    ListView SubjectListView;
    ProgressBar progressBarSubject;
    String ServerURL = "https://thumping-blower.000webhostapp.com/EventJul18.php";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SubjectListView = (ListView)findViewById(R.id.listview1);

        progressBarSubject = (ProgressBar)findViewById(R.id.progressBar);

        new GetHttpResponse(ListJul18.this).execute();
    }

    private class GetHttpResponse extends AsyncTask<Void, Void, Void>
    {
        public Context context;

        String ResultHolder;

        List<subjects> subjectsList;

        public GetHttpResponse(Context context)
        {
            this.context = context;
        }

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            HttpServicesClass httpServiceObject = new HttpServicesClass(ServerURL);
            try
            {
                httpServiceObject.ExecutePostRequest();

                if(httpServiceObject.getResponseCode() == 200)
                {
                    ResultHolder = httpServiceObject.getResponse();

                    if(ResultHolder != null)
                    {
                        JSONArray jsonArray = null;

                        try {
                            jsonArray = new JSONArray(ResultHolder);

                            JSONObject jsonObject;

                            subjects subjects;

                            subjectsList = new ArrayList<subjects>();

                            for(int i=0; i<jsonArray.length(); i++)
                            {
                                subjects = new subjects();

                                jsonObject = jsonArray.getJSONObject(i);

                                subjects.SubjectName = jsonObject.getString("subjects");

                                subjectsList.add(subjects);
                            }
                        }
                        catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    Toast.makeText(context, httpServiceObject.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result)

        {
            progressBarSubject.setVisibility(View.GONE);

            SubjectListView.setVisibility(View.VISIBLE);

            if(subjectsList != null)
            {
                ListAdapterClass adapter = new ListAdapterClass(subjectsList, context);

                SubjectListView.setAdapter(adapter);
            }
        }
    }

}