package fujitsu.mobile_application;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EnvironmentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EnvironmentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EnvironmentFragment extends ListFragment {
    String team;

    String[] players = {"Sibol – Plant a Tree, Plant Hope. This is the theme of the recent tree planting activity of the Philippines GDC in partnership with the Junior Chamber International, Philippines. Sibol is a Filipino term for growth, bud, or sprout. Growing/ Planting Trees had been a yearly advocacy of the Philippines GDC to help preserve biodiversity and reduce greenhouse gases in the atmosphere to mitigate the effects of global climate change.",
            "PH GDC has a target to increase the ratio of recycables vs non-recycables. Here's what we can do to help: Rinse plastic and metal containers, Soiled cartons and small spoons go to the Residual Waste Bin"};
    String[] desc = {"How the Philippines GDC Helps Preserve Biodiversity", "Proper Waste Segragation"};
    int[] images = {R.drawable.tree, R.drawable.recycle};
    int[] imagemain = {R.drawable.maintree, R.drawable.mainrecycle};
    ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //MAP
        HashMap<String, String> map = new HashMap<String, String>();
        //FILL
        for (int i = 0; i < players.length; i++) {
            map = new HashMap<String, String>();
            map.put("Player", players[i]);
            map.put("Desc", desc[i]);
            map.put("Image", Integer.toString(images[i]));
            map.put("Imagemain", Integer.toString(imagemain[i]));
            data.add(map);
        }
        //KEYS IN MAP
        String[] from = {"Player","Desc", "Image"};
        //IDS OF VIEWS
        int[] to = {R.id.textView3, R.id.nameTxt, R.id.imageView1};
        //ADAPTER
        adapter = new SimpleAdapter(getActivity(), data, R.layout.model, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {

                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), data.get(pos).get("Desc"), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getActivity(), DetailActivity.class);
                i.putExtra("Play",data.get(pos).get("Desc"));
                i.putExtra("Detail",data.get(pos).get("Player"));
                i.putExtra("Category","Environment");
                i.putExtra("Img",data.get(pos).get("Imagemain"));
//                i.putExtra("Head",Integer.toString(R.drawable.environment1));
                startActivity(i);

            }
        });
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EnvironmentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EnvironmentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EnvironmentFragment newInstance(String param1, String param2) {
        EnvironmentFragment fragment = new EnvironmentFragment();
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

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_environment, container, false);
//    }

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
            Toast.makeText(context, "Environment", Toast.LENGTH_SHORT).show();
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
