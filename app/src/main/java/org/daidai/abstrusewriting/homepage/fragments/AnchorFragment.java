package org.daidai.abstrusewriting.homepage.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.daidai.abstrusewriting.R;
import org.daidai.abstrusewriting.fragments.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AnchorFragment extends BaseFragment {


    public AnchorFragment() {
        // Required empty public constructor
    }

    @Override
    public String getFragmentTitle() {
        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anchor, container, false);
    }

}
