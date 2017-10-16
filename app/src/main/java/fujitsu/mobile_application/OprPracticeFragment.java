package fujitsu.mobile_application;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OprPracticeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OprPracticeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OprPracticeFragment extends Fragment {

    int value[] = {20, 30, 30, 20};
    String category[] = {"Category A","Category B","Category C","Category D"};
    PieChart cha;
    PieData data;
    View v;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public OprPracticeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OprPracticeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OprPracticeFragment newInstance(String param1, String param2) {
        OprPracticeFragment fragment = new OprPracticeFragment();
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
        setupPieChart();
    }

    private void setupPieChart() {
        //Populating a list of Pie Entries
        List<PieEntry> pieEntries = new ArrayList<>();
        for (int i = 0; i < value.length; i++){
            pieEntries.add(new PieEntry(value[i], category[i]));
        }

        PieDataSet dataset = new PieDataSet(pieEntries, "Data Gathered");
        dataset.setColors(ColorTemplate.MATERIAL_COLORS);
        dataset.setValueTextSize(17f);
        data = new PieData(dataset);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_opr_practice, container, false);
        v = inflater.inflate(R.layout.fragment_opr_practice, container, false);

        cha = (PieChart) v.findViewById(R.id.chart);
        cha.setData(data);
        cha.animateY(1000);
        cha.invalidate();
        return v;
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
            Toast.makeText(context, "Operation Practice", Toast.LENGTH_SHORT).show();

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
