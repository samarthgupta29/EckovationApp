package com.example.eckovation.ui.main;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.eckovation.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AllFeedFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AllFeedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AllFeedFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AllFeedFragment() {
        // Required empty public constructor
    }

    private RecyclerView allFeedRecyclerView;
    private RecyclerView.LayoutManager allFeedRecyclerViewLayoutManager;
    private RecyclerView.Adapter allFeedAdapter;
    private AllFeedRepository allFeedRepository;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AllFeedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AllFeedFragment newInstance(String param1, String param2) {
        AllFeedFragment fragment = new AllFeedFragment();
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
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_all_feed, container, false);
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
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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

    public String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            String myJson = inputStreamToString(getActivity().getAssets().open("all_feed.json"));
            final AllFeed[] allFeed = new Gson().fromJson(myJson, AllFeed[].class);
            List<AllFeed> allFeedList = Arrays.asList(allFeed);
            System.out.println(allFeedList);
            allFeedRepository = new AllFeedRepository(getContext());
            allFeedRepository.insertTask(new AllFeed());

            allFeedRecyclerView = getView().findViewById(R.id.all_feed_rv);
            allFeedRecyclerView.setHasFixedSize(true);
            allFeedRecyclerViewLayoutManager = new LinearLayoutManager(getContext());
            allFeedRecyclerView.setLayoutManager(allFeedRecyclerViewLayoutManager);
            allFeedRecyclerView.setItemAnimator(new DefaultItemAnimator());
            allFeedAdapter = new AllFeedAdapter(allFeedList);
            allFeedRecyclerView.setAdapter(allFeedAdapter);
            allFeedRepository.getTasks().observe(this, new Observer<List<AllFeed>>() {
                @Override
                public void onChanged(@Nullable List<AllFeed> allFeeds) {
//                    allFeedAdapter = new AllFeedAdapter(allFeeds);
//                    allFeedRecyclerView.setAdapter(allFeedAdapter);
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
