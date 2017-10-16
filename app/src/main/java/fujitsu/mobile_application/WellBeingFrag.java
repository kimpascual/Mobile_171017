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
 * {@link DiversityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiversityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WellBeingFrag extends ListFragment {
    String team;

    String[] players = {"Medical insurance in the Philippines is an essential life investment. Fujitsu cares for the health & well-being of its employee thus providing them with medical benefits like HMO. Fujitsu has partnered with Maxicare Healthcare Corporation, one of the pioneers in the health maintenance organization (HMO) industry. \n" +
            "\n" +
            "Maxicare stands proud of its valuable achievements. With more than 56,000 affiliated doctors and specialists, more than 1,000 hospitals and clinics and a growing number of primary and customer care centers in key cities nationwide, Maxicare now services over 1.1 million members across the country from corporate segment, small and medium-sized enterprises to families and individuals.\n" +
            "\n" +
            "Employees are also given with the benefit of enrolling their dependents and also receive the medical care they deserve.\n" +
            "Below is the quick guide on how to to enroll the dependents to HMO.",
            "Tired of sitting in front of you computer 8 hours everyday? Good news, Fujitsu has found a way to keep their employees active and healthy by setting recreational and friendly competitive activities to pump their energy. \n" +
                    "\n" +
                    "Introducing the Net Park, Vertical Run - breaking the norms of a typical marathon. Our bodies were meant to move -- they actually crave exercise. Regular exercise is necessary for physical fitness and good health. It reduces the risk of heart disease, cancer, high blood pressure, diabetes and other diseases. It can improve your appearance and delay the aging process.\n" +
                    "\n" +
                    "See below for the happy winners of this event!","Team bonding brings people together by encouraging collaboration and teamwork. Sports activities like this Camaraderie league helps people see each other in a different light thus allowing them to connect in a different setting. Competition has been shown to increase production. So, by channeling that increased production into a fun, employees can bond in a way impossible by other means." + "\n" + "Picture below is the team champion of the league - Titan Elite"};
    String[] desc = {"Partnering with new HMO, renewal of health card for employees", "2017 Fujitsu Vertical Run", "Fujitsu Camaraderie League"};
    int[] images = {R.drawable.wellbeinglogo2, R.drawable.wellbeinglogo1, R.drawable.wellbeinglogo3};
    int[] imagemain = {R.drawable.hmodependent1, R.drawable.vertical_run, R.drawable.basketball1};
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
                i.putExtra("Category","Diversity");
                i.putExtra("Img",data.get(pos).get("Imagemain"));
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

    public WellBeingFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiversityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiversityFragment newInstance(String param1, String param2) {
        DiversityFragment fragment = new DiversityFragment();
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
//        return inflater.inflate(R.layout.fragment_diversity, container, false);
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
            Toast.makeText(context, "WellBeing", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
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
