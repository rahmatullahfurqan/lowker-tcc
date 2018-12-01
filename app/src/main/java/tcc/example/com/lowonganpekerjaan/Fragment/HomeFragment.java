package tcc.example.com.lowonganpekerjaan.Fragment;


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
        Pekerjaan p = new Pekerjaan();
        p.setId(1);
        p.setTitle("Android Developer");
        p.setImage("https://cdn0-production-images-kly.akamaized.net/HO9I2UDBLapmtSphCma1bjY7Us4=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2362997/original/074516100_1537355462-apa_yang_salah_dari_foto_ini.jpg6.jpg");
        p.setType("Part Time");
        p.setTanggal("29 September 2018");
        p.setPerusahaan("Software House");
        p.setPendidikan("SMA");
        p.setLokasi("Yogyakarta");
        p.setKeterangan("butuh seorang developer handal");
        pekerjaanList.add(p);
        pekerjaanList.add(p);
        pekerjaanList.add(p);
        rvJobs=view.findViewById(R.id.rv_jobs);
        rvJobs.setLayoutManager(new LinearLayoutManager(this.getContext()));
        pekerjaanAdapter=new PekerjaanAdapter(pekerjaanList,getContext(),this);
        rvJobs.setAdapter(pekerjaanAdapter);
    }

    @Override
    public void detail(Pekerjaan pekerjaan) {
       startActivity(new Intent(getContext(),DetailHomeActivity.class)
               .putExtra("cover",pekerjaan.getImage())
               .putExtra("perusahaan",pekerjaan.getPerusahaan())
               .putExtra("tanggal",pekerjaan.getTanggal())
               .putExtra("judul",pekerjaan.getTitle())
               .putExtra("keterangan",pekerjaan.getKeterangan()));
    }
}
