package fujitsu.mobile_application;

/**
 * Created by h.delrosario on 10/12/2017.
 */

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
public class OperatingFragment extends ListFragment {
    String team;

    String[] players = {"Dear GDC Community,\n" +
            "\n" +
            "As part of the GRiP Program, we're excited to be celebrating WORLD STANDARD DAY with the International Organization for Standardization (ISO) on 14th October 2017!\n" +
            "We would like to pay tribute to experts worldwide in their effort in developing technical agreements that are published as international standards.\n" +
            "You may not know these thousands of experts personally but you definitely benefit from their standardisation work. From the fresh water supply, cleaner energy, city infrastructure, transportation and ever-evolving technology, there are so many impacts that standardization has on our society.\n" +
            "We'd like to get everyone in the GDCs involved in World Standards Day by producing a video skit or vlog of how well you recognize the ISO and its role in our communities and in our work.\n" +
            " \n" +
            "Guidelines of the video skit.\n" +
            "•\tThe theme is \"Standards Make Cities Smarter.\" \n" +
            "•\tThe video may contain one or more or all of the ISO certifications that are applied in our GDCs. The video must show how ISO helps to improve our standard of living and making our cities smarter.\n" +
            "o\tISO 9001, Quality Management System\n" +
            "o\tISO 27001, Information Security Management\n" +
            "o\tISO 20000, IT Service Management\n" +
            "o\tISO 14001, Environmental Management\n" +
            "•\tThere is no maximum nor minimum number of group members.\n" +
            "•\tLength of video should not exceed one minute and a half (1.5).\n" +
            "•\tContent must be professional and suitable for all audiences (no violence, profanity, offensive, nor sexually-suggestive language or gestures).\n" +
            "•\tNote: Get permission or consent of your customers first if you are going to show or use their logo.\n" +
            "•\tRegister your team by sending an email to Mr. Saldie Carino at s.carino@ph.fujitsu.com\n" +
            "\n" +
            " \n" +
            "Prize\n" +
            "1st place - \tPhp 10,000.00\n" +
            "2nd place - \tPhp 5,000.00\n" +
            "3rd place - \tPhp 3,000.00\n" +
            " \n" +
            " \n" +
            "Criteria for judging\n" +
            "•\tFun and creativity – 50%\n" +
            "•\tShow relevance of ISO standards in making a city smarter –  50%\n" +
            "\n" +
            " \n" +
            "Details of Submission\n" +
            "•\tVideos submitted must be in mp4 format\n" +
            "•\tEmail your video to s.carino@ph.fujitsu.com\n" +
            "•\tDeadline of submission is on October 6, 2017\n" +
            "•\tAnnouncement of winners will be on October 14, 2017\n" +
            "•\tUpload of winning videos on GDC Connect will be on October 16, 2017\n" +
            "\n" +
            " \n" +
            "So call your friends, write down your skit, and say – lights, camera, action! \n",

            "\"Best. Training. Ever.,\" says Ms. Toni Rose Garcia (Application Systems Engineer) when asked how she wanted to refer to the recently concluded Sense and Respond Phase 1-3 training (S&RT) at the Philippines Global Delivery Center (PH GDC).\n" +
                    "\n" +
                    "Ms. Garcia is one of 20 participants who attended the S&RT which ran from 18-28 July 2017. The training, which ran for nine days, is the first of more S&RTs to take place within the year as the organization strives to create more value and eliminate waste in its operations, underpinned by the culture of continuous improvement, to meet its customers' needs.\n" +
                    "\n" +
                    "As Fujitsu's approach to Lean, it is essential for PH GDC employees to have an understanding of what Sense and Respond is, its tools, and its benefits to the business, customer, and colleagues. For this training, each PH GDC line of service (Business Application Services, Remote Infrastructure Management, Service Desk, and Business Process Outsourcing) recommended representatives (also called Champions) to take the training, which is a combination of managers, team leaders, and new hires.\n" +
                    "\"We're happy to say that we received a lot of nominations, but we only have seats for 20,\" relays Mr. Arnephi Delos Reyes (ITIL Process Controller and Training Specialist) who conducted the training.\n" +
                    "\n" +
                    "Since most of the participants took the S&RT for the first time, for the first day, the overview was discussed for the participants to have a full grasp of Sense and Respond. In the succeeding days, various activities were held, such as Demand Analysis and Problem Solving activities, wherein each participant can also tailor fit the approach to their own LoS.\n" +
                    "\n" +
                    "\"It's general. You have guidelines like, 'How can I fit this to my team?' Sense and Respond is very flexible,\" adds Mr. Delos Reyes.\n" +
                    "\n" +
                    "The training received favorable responses from the participants – from the lively and engaging hosting and activities to the content and its practical use for the company and the participant.\n" +
                    "\n" +
                    "\"It was enjoyable.  In doing the activities, we gained ideas of what the other towers are doing, how are we interconnected, how can my job affect them, and how their job can affect me. So in a way since different LoS are there, different departments, we got a full grasp on what Fujitsu is doing,\" shares Ms. Claire Beltran (Finance Business Analyst).\n" +
                    "\n" +
                    "For Mr. Joseph Zacarias (Service Desk Manager), what stood out the most during the training was the standardization of work, \"Cause sometimes in operations, we complicate our lives in terms of applying too many things. But in the end, if we could see, it's really basic. Mostly some basic things that we have to change. It creates a really big impact for the desk or for the group.  For the team, there's a practice of Sense and Respond of the desk. So I guess, one good practice would be is to measure first how we're doing in terms of the standards for the desk, then look at the opportunities. We need to find out which ones are really impacting the customers. We have to eliminate the waste in terms of efforts that are given value for our work. So it's going to be vast. But from my standpoint, from what I see is that we have to measure first how the desk is really doing. Then go straight from there.\"\n" +
                    "\n" +
                    "Moving forward, another round of Sense and Respond trainings are slated to run from August to October. The Sense and Respond trainings are under the Operating Practices pillar of the Global Responsible Business Program.\n",

            "Carried out by SGS Philippines, the external audit took place on 7-8 June 2017, in which the external auditor examined the GDC's Environmental Management policies, procedures and activities and made rounds to inspect the work areas in the Net Square office of the PH GDC.   \n" +
                    "\n" +
                    "Results were announced on the afternoon of the 8th, wherein SGS Philippines declared the PH GDC's successful retention of ISO 14001:2004 (Environmental Management System) certification. The PH GDC received positive comments from SGS Philippines, saying that, \"The organization has demonstrated the ability of the management system to systemically achieve requirements of the audit standard. There being no major non-conformity, you are being, still, recommended for continuing the certification for ISO 14001.\" \n" +
                    "\n" +
                    "The PH GDC has undergone Surveillance 2 audit for ISO 14001:2004. Four floors in the Net Square have been certified, and the PH GDC is getting ready in expanding the certification to its Ecotower and Cebu offices next year as the organization will move to a new version which is ISO 14001:2015.\n",

            "After a four-day extensive external audit 14–17 February, 2017, the Philippines Global Delivery Center (PH GDC) successfully passed the certifications in ISO 20000-1:2011 and ISO 9001:2008, as well as the recertification in ISO 27001:2013.\n" +
                    "\n" +
                    "The results were announced on the afternoon of the 17th, wherein SGS Philippines declared the PH GDC’s recertification in ISO 27001:2013 (Information Security Management System) with expanded scope from Retail Applications Services to the entire Business Application Services and GSOP TPS5. \n" +
                    "\n" +
                    "For the surveillance audits, the PH GDC passed ISO 20000-1:2011 (Service Management System) for OCEANIA Remote Infrastructure Management and Service Desk, and ISO 9001:2008 (Quality Management Systems) for Fujitsu Development Center and Business Process Outsourcing. \n" +
                    "\n" +
                    "The PH GDC received positive comments from SGS Philippines, saying that “The organization’s commitment to demonstrate quality service management and information security is commendable.  Internal audit programs, trainings and plans are comprehensive and provided. Internal auditors are Lead Auditor Certification passers and audit criteria include compliance to customer requirements and Fujitsu Global Business Requirements.”\n"};

    String[] desc = {"World Standard Day Video Making Contest", "Sense and Respond Trainings Kick Start at the Philippines GDC", "The Philippines Global Delivery Center (PH GDC) successfully passed the second Surveillance Audit for ISO 14001:2004", "Successful ISO Re-Certification for the Philippines GDC"};

    int[] images = {R.drawable.standard, R.drawable.op_snr_logo, R.drawable.op_iso_logo2, R.drawable.op_iso_logo1};

    int[] imagemain = {R.drawable.op_video_contest, R.drawable.op_snr, R.drawable.op_iso2, R.drawable.op_iso1};

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
                i.putExtra("Category","Operating");
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

    public OperatingFragment() {
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
            Toast.makeText(context, "Operating", Toast.LENGTH_SHORT).show();
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