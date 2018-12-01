package tcc.example.com.lowonganpekerjaan.Fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tcc.example.com.lowonganpekerjaan.R;

public class DetailHomeActivity extends AppCompatActivity {
    TextView judul,tanggal,perusahaan,keterangan;
    ImageView cover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);
        judul=findViewById(R.id.tv_list_event_title);
        tanggal=findViewById(R.id.tanggal);
        cover=findViewById(R.id.iv_list_event_cover);
        perusahaan=findViewById(R.id.perusahaan);
        keterangan=findViewById(R.id.keterangan);

        judul.setText(getIntent().getStringExtra("judul"));
        tanggal.setText(getIntent().getStringExtra("tanggal"));
        perusahaan.setText(getIntent().getStringExtra("perusahaan"));
        keterangan.setText(getIntent().getStringExtra("keterangan"));
        String image = getIntent().getStringExtra("cover");
        if(image!= null) Picasso.get().load(image).fit().centerInside().into(cover);

    }
}
