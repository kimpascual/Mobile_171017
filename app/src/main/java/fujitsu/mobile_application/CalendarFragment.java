package fujitsu.mobile_application;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CalendarFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CalendarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMM - yyyy", Locale.getDefault());
    private SimpleDateFormat dateFormatDay = new SimpleDateFormat("yyyy-MM-dd");

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    TextView calendarMonth;

    public CalendarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarFragment newInstance(String param1, String param2) {
        CalendarFragment fragment = new CalendarFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        //calendar setup
        compactCalendar = (CompactCalendarView) view.findViewById(R.id.comCalendarView);
        compactCalendar.setUseThreeLetterAbbreviation(true);
        calendarMonth = (TextView) view.findViewById(R.id.calMonth);

        Event ev1 = new Event(Color.BLUE, 1509095401000L, "test");
        compactCalendar.addEvent(ev1);
        Event ev2 = new Event(Color.BLUE, 1502961001000L, "test");
        compactCalendar.addEvent(ev2);

        Event ev3 = new Event(Color.BLUE, 1494148201000L, "test");
        compactCalendar.addEvent(ev3);
//        List<Event> events = compactCalendar.getEvents(1503824400000L);
//        Log.d(TAG, "Events: "+ events);

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked){
                if (dateFormatDay.format(dateClicked).toString().compareTo("2017-10-27") == 0){
                    Toast.makeText(CalendarFragment.this.getContext(), "There is an event", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), ListEvents.class);
                    i.putExtra("Date", "Sample date");
                    startActivity(i);

                }else  if (dateFormatDay.format(dateClicked).toString().compareTo("2017-08- 17") == 0){
                    Toast.makeText(CalendarFragment.this.getContext(), "There is an event", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), ListEvents.class);
                    i.putExtra("Date", "Sample date");
                    startActivity(i);

                }else  if (dateFormatDay.format(dateClicked).toString().compareTo("2017-06-7") == 0){
                    Toast.makeText(CalendarFragment.this.getContext(), "There is an event", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getActivity(), ListEvents.class);
                    i.putExtra("Date", "Sample date");
                    startActivity(i);

                }else {
                    Toast.makeText(CalendarFragment.this.getContext(), "No Event", Toast.LENGTH_SHORT).show();
//                    Fragment fragment = new CalendarFeed();
//                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                    fragmentTransaction.replace(R.id.calendarline, fragment);
//                    fragmentTransaction.addToBackStack(null);
//                    fragmentTransaction.commit();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                calendarMonth.setText(dateFormatMonth.format(firstDayOfNewMonth));
            }



        });
        // Inflate the layout for this fragment
        return view;

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
            Toast.makeText(context, "Calendar", Toast.LENGTH_SHORT).show();
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
