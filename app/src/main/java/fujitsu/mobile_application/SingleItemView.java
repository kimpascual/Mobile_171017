package fujitsu.mobile_application;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.dmallcott.dismissibleimageview.DismissibleImageView;

public class SingleItemView extends Activity {

    // Declare Variables
    TextView txtrank;
    TextView txtcountry;
    TextView txtpopulation;
    DismissibleImageView txtDismissible;
    String[] rank;
    String[] country;
//    int[] population;
    String[] population;
    int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleitemview);
        // Retrieve data from CalendarDetailActivity on listview item click
        Intent i = getIntent();
        // Get the listview item click position
        position = i.getExtras().getInt("position");
        // Get the list of rank
        rank = i.getStringArrayExtra("rank");
        // Get the list of country
        country = i.getStringArrayExtra("country");
        // Get the list of population
        population = i.getStringArrayExtra("population");
//        population = i.getIntArrayExtra("population");



        // Locate the TextViews in singleitemview.xml
        txtrank = (TextView) findViewById(R.id.rank);
        txtcountry = (TextView) findViewById(R.id.country);
        txtpopulation = (TextView) findViewById(R.id.population);
        txtDismissible = (DismissibleImageView) findViewById(R.id.imageEvent);

        // Load the text into the TextViews followed by the position
        txtrank.setText(rank[position]);
        txtcountry.setText(country[position]);
        txtpopulation.setText(population[position]);
        txtDismissible.setImageResource(Integer.parseInt(population[position]));

    }
}
