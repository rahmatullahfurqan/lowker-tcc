package tcc.example.com.lowonganpekerjaan.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tcc.example.com.lowonganpekerjaan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PasangLowkerFragment extends Fragment {


    public PasangLowkerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pasang_lowker, container, false);
    }

}
