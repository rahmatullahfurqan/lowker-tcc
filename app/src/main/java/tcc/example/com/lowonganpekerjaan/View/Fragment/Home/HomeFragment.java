package tcc.example.com.lowonganpekerjaan.View.Fragment.Home;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tcc.example.com.lowonganpekerjaan.Adapter.PekerjaanAdapter;
import tcc.example.com.lowonganpekerjaan.Model.Pekerjaan;
import tcc.example.com.lowonganpekerjaan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements HomeView {
    List<Pekerjaan> pekerjaanList = new ArrayList<>();
    RecyclerView rvJobs;
    PekerjaanAdapter pekerjaanAdapter;
    HomePresenter homePresenter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvJobs=view.findViewById(R.id.rv_jobs);
        pekerjaanAdapter=new PekerjaanAdapter(pekerjaanList,getContext(),this);
        rvJobs.setLayoutManager(new LinearLayoutManager(this.getContext()));
        rvJobs.setAdapter(pekerjaanAdapter);
        homePresenter=new HomePresenter(this);
        homePresenter.getData();
    }

    @Override
    public void detail(Pekerjaan pekerjaan) {
       startActivity(new Intent(getContext(),DetailHomeActivity.class)
               .putExtra("cover",pekerjaan.getImage())
               .putExtra("id_vacancies",String.valueOf(pekerjaan.getId()))
               .putExtra("tanggal",pekerjaan.getTanggal())
               .putExtra("judul",pekerjaan.getTitle())
               .putExtra("keterangan",pekerjaan.getKeterangan()));
    }

    @Override
    public void getDataSuccses(List<Pekerjaan> pekerjaan) {
        pekerjaanList.clear();
        pekerjaanList.addAll(pekerjaan);
        pekerjaanAdapter.notifyDataSetChanged();
    }

    @Override
    public void getDataFailed() {
        Toast.makeText(getContext(),"gaga'",Toast.LENGTH_SHORT).show();
    }
}
