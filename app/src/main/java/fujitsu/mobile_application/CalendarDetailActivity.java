package fujitsu.mobile_application;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.view.View;

public class CalendarDetailActivity extends Activity {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    String[] rank;
    String[] country;
//    Integer[] population;
    String[] population;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from listview_main.xml
        setContentView(R.layout.listview_main);

        // Generate sample data into string arrays
        rank = new String[] { "Event_Title 1" , "Event_Title 2"  };

        country = new String[] { "Event_Description 1" , "Event_Description 2" };

//        population = new String[] { "Event_Image 1" , "Event_Image 2" };
        population = new String[] {"R.drawable.maincoffee", "R.drawable.mainwomen"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.listview);

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(CalendarDetailActivity.this, rank, country, population);
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        // Capture ListView item click
        list.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i = new Intent(CalendarDetailActivity.this, SingleItemView.class);
                // Pass all data rank
                i.putExtra("rank", rank);
                // Pass all data country
                i.putExtra("country", country);
                // Pass all data population
                i.putExtra("population", population);
                // Pass listview item click position
                i.putExtra("position", position);
                // Open SingleItemView.java Activity
                startActivity(i);
            }

        });
    }
}

