package tcc.example.com.lowonganpekerjaan.View.Fragment.Profile;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import tcc.example.com.lowonganpekerjaan.Model.User;
import tcc.example.com.lowonganpekerjaan.R;
import tcc.example.com.lowonganpekerjaan.View.Activity.MainActivity;

public class ProfileFragment extends Fragment implements ProfileView{
    SharedPreferences userDetails;
    ProfilePresenter profilePresenter;
    TextView etName,etAge,etAddress,etUsername;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName=view.findViewById(R.id.et_name);
        etAge=view.findViewById(R.id.et_age);
        etAddress=view.findViewById(R.id.et_address);
        etUsername=view.findViewById(R.id.et_email);
        userDetails = this.getActivity().getSharedPreferences("userdetails",  Context.MODE_PRIVATE);
//        profilePresenter=new ProfilePresenter(this);
//        profilePresenter.getData(userDetails.getString("id","error"));
        onSuccses();
    }

    @Override
    public void onSuccses(User user) {

    }

    public void onSuccses(){
        etName.setText(userDetails.getString("name",""));
        etAge.setText(userDetails.getString("age",""));
        etAddress.setText(userDetails.getString("address",""));
        etUsername.setText(userDetails.getString("username",""));
    }

    @Override
    public void onFailed() {
        Toast.makeText(getActivity(),"gagal",Toast.LENGTH_SHORT).show();
    }
}
