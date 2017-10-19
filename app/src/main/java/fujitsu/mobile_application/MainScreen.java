package fujitsu.mobile_application;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView botNavigation;
    private TextView moodToday;

    String userID;
    String Username;
    String firstName;
    String lastName;
    String emailAdd;
    String homeAdd;
    String Dept;
    String Div;
    String acctType;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        //drawer navigation
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.open, R.string.close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set drawer navigation Name and Email
        View header = navigationView.getHeaderView(0);
        Intent intent = getIntent();
        TextView userFullName = (TextView)header.findViewById(R.id.sideMenu_userName);
        TextView userEmailAdd = (TextView)header.findViewById(R.id.sideMenu_userEmail);
        userFullName.setText(intent.getStringExtra("firstName") + " " + intent.getStringExtra("lastName"));
        userEmailAdd.setText(intent.getStringExtra("emailAdd"));

        //set bundle for passing data to fragments
        userID    = intent.getStringExtra("userID");
        Username  = intent.getStringExtra("username");
        firstName = intent.getStringExtra("firstName");
        lastName  = intent.getStringExtra("lastName");
        emailAdd  = intent.getStringExtra("emailAdd");
        homeAdd   = intent.getStringExtra("homeAdd");
        Dept      = intent.getStringExtra("Dept");
        Div       = intent.getStringExtra("Div");
        acctType  = intent.getStringExtra("acctType");

        bundle = new Bundle();
        bundle.putString("userID", userID);
        bundle.putString("username", Username);
        bundle.putString("firstName", firstName);
        bundle.putString("lastName", lastName);
        bundle.putString("emailAdd", emailAdd);
        bundle.putString("homeAdd", homeAdd);
        bundle.putString("Dept", Dept);
        bundle.putString("Div", Div);
        bundle.putString("acctType", acctType);

        //bottom navigation
        botNavigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        botNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //set default screen when logged
        setDefaultGripWindow();
    }

    public void setDefaultGripWindow(){
        FragmentManager mainFrag = getSupportFragmentManager();
        FragmentTransaction mainTrans = mainFrag.beginTransaction();
        setTitle("Wellbeing");
        WellBeingFrag wellFrag = new WellBeingFrag();
        wellFrag.setArguments(bundle);
        mainTrans.replace(R.id.frag_content, wellFrag).commit();
        botNavigation.setSelectedItemId(R.id.botMenu_wellbeing);
    }

//Create option menu-------------------------------------------------------------------------
    //@Override
    //public boolean onCreateOptionsMenu(Menu menu){
    //    getMenuInflater().inflate(R.menu.option_menu,menu);
    //    return super.onCreateOptionsMenu(menu);
    //}

    //Action when option menu item was clicked
    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
    //    int id = item.getItemId();
        //option Menu
    //    if(id==R.id.mnuLogout){
    //        Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();
    //        startActivity(new Intent(this, LoginScreen.class));
    //        finish();
    //    }
    //    return super.onOptionsItemSelected(item);
    //}

//end Create option menu related-------------------------------------------------------------

//bottom navigation menu action--------------------------------------------------------------
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager botFragmentManager = getSupportFragmentManager();
            FragmentTransaction botTransaction = botFragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.botMenu_environment :
                    setTitle("Environment");
                    EnvironmentFragment envFrag = new EnvironmentFragment();
                    envFrag.setArguments(bundle);
                    botTransaction.replace(R.id.frag_content, envFrag).commit();
                    return true;

                case R.id.botMenu_community :
                    setTitle("Community Involvement & Development");
                    CommunityFragment comFrag = new CommunityFragment();
                    comFrag.setArguments(bundle);
                    botTransaction.replace(R.id.frag_content, comFrag).commit();
                    return true;

                case R.id.botMenu_diversity :
                    setTitle("Diversity & Inclusion");
                    DiversityFragment divFrag = new DiversityFragment();
                    divFrag.setArguments(bundle);
                    botTransaction.replace(R.id.frag_content, divFrag).commit();
                    return true;

                case R.id.botMenu_wellbeing :
                    setTitle("Wellbeing");
                    WellBeingFrag welFrag = new WellBeingFrag();
                    welFrag.setArguments(bundle);
                    botTransaction.replace(R.id.frag_content, welFrag).commit();
                    return true;

                case R.id.botMenu_operating :
                    setTitle("Operating Practices");
                    OperatingFragment oprFrag = new OperatingFragment();
                    oprFrag.setArguments(bundle);
                    botTransaction.replace(R.id.frag_content, oprFrag).commit();
                    return true;
                default: return false;
            }
        }

    };

//end bottom navigation menu related---------------------------------------------------------

//drawer navigation menu action---------------------------------------------------------------
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        FragmentManager sideFragmentManager = getSupportFragmentManager();
        FragmentTransaction sideTransaction = sideFragmentManager.beginTransaction();

        // Handle navigation view item clicks here.
        LinearLayout bottomViewLay = (LinearLayout) findViewById(R.id.bottomViewLayout);

        switch (item.getItemId()) {
            case R.id.sideMenu_grip :
                bottomViewLay.setVisibility(LinearLayout.VISIBLE);
                sideTransaction.replace(R.id.frag_content, new WellbeingFragment()).commit();
                break;
            case R.id.sideMenu_calendar :
                sideTransaction.replace(R.id.frag_content, new CalendarFragment()).commit();
                bottomViewLay.setVisibility(LinearLayout.GONE);
                break;
            case R.id.sideMenu_WellBeing :
                sideTransaction.replace(R.id.frag_content, new WellbeingFragment()).commit();
                bottomViewLay.setVisibility(LinearLayout.GONE);
                break;
            case R.id.sideMenu_Graph :
                sideTransaction.replace(R.id.frag_content, new OprPracticeFragment()).commit();
                bottomViewLay.setVisibility(LinearLayout.GONE);
                break;
//            case R.id.nav_slideshow:
//                bottomViewLay.setVisibility(LinearLayout.GONE);
//                break;
//            case R.id.nav_manage:
//                bottomViewLay.setVisibility(LinearLayout.GONE);
//                break;
//            case R.id.nav_share:
//                bottomViewLay.setVisibility(LinearLayout.GONE);
//                break;
            case R.id.sideMenu_logout:
                Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, LoginScreen.class);
                intent.putExtra("finish", true);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //open and close of drawer
//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public void onBackPressed() {

    }


//end drawer navigation related--------------------------------------------------------------

    public void onRadioButtonClicked(View view){
        boolean radioChecked = ((RadioButton)view).isChecked();
        FrameLayout moodFrLayout = (FrameLayout) findViewById(R.id.moodFrameLayout);
        moodToday = (TextView) moodFrLayout.findViewById(R.id.currentMood);
        switch (view.getId())
        {
            case R.id.rbHappy :
                if(radioChecked){
                    moodToday.setText("H1");
                }
                break;
            case R.id.rbSad :
                if(radioChecked){
                    moodToday.setText("S1");
                }
                break;
            case R.id.rbAngry:
                if(radioChecked){
                    moodToday.setText("A1");
                }
                break;
            case R.id.rbLove:
                if(radioChecked){
                    moodToday.setText("L1");
                }
                break;
            case R.id.rbSick:
                if(radioChecked){
                    moodToday.setText("S2");
                }
                break;
//            case R.id.rbSporty:
//                if(radioChecked){
//                    moodToday.setText("S3");
//                }
//                break;
//            case R.id.rbGeeky:
//                if(radioChecked){
//                    moodToday.setText("G1");
//                }
//                break;
            case R.id.rbHeartBroken:
                if(radioChecked){
                    moodToday.setText("H2");
                }
                break;
            case R.id.rbRelaxed:
                if(radioChecked){
                    moodToday.setText("R1");
                }
                break;
            case R.id.rbStressed:
                if(radioChecked){
                    moodToday.setText("S4");
                }
                break;
            case R.id.rbInspired:
                if(radioChecked){
                    moodToday.setText("I1");
                }
                break;
        }
    }
}
