package fujitsu.mobile_application;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class InsertRequest extends StringRequest {
    //private static final String INSERT_REQUEST_URL = "https://thumping-blower.000webhostapp.com/moodToday.php";

    private static final String INSERT_REQUEST_URL = "https://thumping-blower.000webhostapp.com/moodToday.php";
    // private static final String INSERT_REQUEST_URL = "http://192.168.0.100/moodToday.php";
    private Map<String, String> params;

    public InsertRequest(String userID, String date, String mood, Response.Listener<String> listener){
        super(Method.POST, INSERT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("user_Datestamp", userID + "-" + date);
        params.put("mood", mood);
    }

    @Override
    public Map<String, String> getParams(){
        return params;
    }
}
