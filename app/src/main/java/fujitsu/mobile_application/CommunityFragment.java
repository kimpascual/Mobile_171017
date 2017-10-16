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
 * {@link CommunityFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CommunityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CommunityFragment extends ListFragment {
    String team;

    String[] players = {"As part of its commitment to reach out to underserved communities in the Philippines, the Philippines GDC Employees handed over cash and boxes of schools supplies, clothes and basic necessities to the Holy Family Foundation, Inc. –a non-stock and non-profit social welfare agency that aims to protect and rehabilitate marginalized children and youth. This is one of the year-end activities initiated by the Philippines GDC employees to engage and be involved with the Community as part of the Global Responsible Business Program.Weeks prior to the handing over of donations, a creative idea spearheaded by the GDC's Ophie Indiongco is the building of \"Giving Christmas Trees\" out of all the materials for donation.Representatives from the Holy Foundation visited the GDC. Dressed in red dresses, the girls expressed their gratitude through a a medley of songs and dances before being toured around the Net Square and Eco Tower offices at Bonifacio Global City Taguig." ,
            "The Philippines Global Delivery Center (PH GDC) remains true to its commitment to reach out to underserved communities as its employees and on-the-job trainees from Fujitsu Japan handed over boxes of school supplies, clothes, and basic necessities to the Tuloy sa Don Bosco Foundation, Inc. last 23 February 2017.\n" +
                    "\n" +
                    "\"We've been helping this Foundation for three years already,\" relays Quality Assurance Office Manager Ophie Indiongco, \"What's good with them is their holistic program for the kids. They have different technical trainings and courses, like air conditioning maintenance, sewing, culinary arts. The latest one that they have is entertainment, like ballet. And they're competing internationally and are good football players.\"\n" +
                    "\n" +
                    "The visit included a guided tour of the 4.5-hectare complex at San Jose Subdivision, Muntinlupa City, wherein employees had a glimpse of the Foundation's sturdy dormitories, football field, gymnasium, classrooms, chapel, and their very own hydroponic farming which they call Aquaponics.\n" +
                    "\n" +
                    "Tuloy was founded in 1993 by Fr. Marciano \"Rocky Evangelista\" of Salesians of Don Bosco. Relying a hundred percent on donations, the Foundation has already taken in hundreds of children off the streets over the years, and has provided them a home, alternative learning courses, and values formation. The Foundation's education program is accredited by the Department of Education as non-formal, and is crafted to tailor fit to the needs of the children whose mental skills lag behind children their age in normal schools.\n" +
                    "\n" +
                    "This visit is an initiative of the PH GDC as part of the Community Involvement and Development, Environment, and Diversity and Inclusion pillars of the Global Responsible Business Program (GRiP).\n"};
    String[] desc = {"CSR and Diversity Activities at the Philippines GDC","Philippines GDC's Outreach Program at Tuloy sa Don Bosco Foundation"};
    int[] images = {R.drawable.donation1, R.drawable.donation};
    int[] imagemain = { R.drawable.donation1,R.drawable.tuloy};
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
                i.putExtra("Category","Community");
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

    public CommunityFragment() {
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
            Toast.makeText(context, "Community", Toast.LENGTH_SHORT).show();
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

