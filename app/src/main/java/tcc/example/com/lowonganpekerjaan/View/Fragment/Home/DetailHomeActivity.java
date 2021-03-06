package tcc.example.com.lowonganpekerjaan.View.Fragment.Home;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tcc.example.com.lowonganpekerjaan.Model.DataKetertarikanResponse;
import tcc.example.com.lowonganpekerjaan.R;
import tcc.example.com.lowonganpekerjaan.Service;
import tcc.example.com.lowonganpekerjaan.View.Activity.MainActivity;

public class DetailHomeActivity extends AppCompatActivity {
    TextView judul,tanggal,keterangan,tipe;
    ImageView cover;
    ProgressBar progressBar;
    SharedPreferences userDetails;
    String username,name,address,age,idUser,idVacancies,nameVacancies,detailVacancies;
    Service service = new Service();
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);
        judul=findViewById(R.id.tv_list_event_title);
        tanggal=findViewById(R.id.tanggal);
        cover=findViewById(R.id.iv_list_event_cover);
        keterangan=findViewById(R.id.keterangan);
        submit=findViewById(R.id.btn_submit);
        tipe=findViewById(R.id.type);
        progressBar=findViewById(R.id.progres_bar);
        progressBar.setVisibility(View.INVISIBLE);
        userDetails = getSharedPreferences("userdetails",  Context.MODE_PRIVATE);
        username=userDetails.getString("username","");
        name=userDetails.getString("name","");
        age=userDetails.getString("age","");
        tipe.setText(getIntent().getStringExtra("type"));
        address=userDetails.getString("address","");
        idUser=userDetails.getString("id","");
        idVacancies=getIntent().getStringExtra("id_vacancies");
        nameVacancies=getIntent().getStringExtra("judul");
        detailVacancies=getIntent().getStringExtra("keterangan");
        judul.setText(nameVacancies);
        tanggal.setText(getIntent().getStringExtra("tanggal"));
        keterangan.setText(detailVacancies);
        String image = getIntent().getStringExtra("cover");
        if(image!= null) Picasso.get().load(image).fit().centerInside().into(cover);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setData();
            }
        });

    }

    private void setData() {
        progressBar.setVisibility(View.VISIBLE);
        service.setDataAPI().setDataKetertarikan(username,name,age,address,idUser,idVacancies,nameVacancies,detailVacancies).enqueue(new Callback<DataKetertarikanResponse>() {
            @Override
            public void onResponse(Call<DataKetertarikanResponse> call, Response<DataKetertarikanResponse> response) {
                if (response.code()==200)
                {
                    if (response.body().getStatus()==200)
                    {
                        sukses();
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        gagal(response.body().getStatus());
                    }
                }
                else
                {
                    gagal(response.code());
                }
            }

            @Override
            public void onFailure(Call<DataKetertarikanResponse> call, Throwable t) {
                gagal(10);
            }
        });
    }
    void sukses(){
        Toast.makeText(this,"jangan lupa kirim lamaran, kami akan merekomendasikan anda :)",Toast.LENGTH_SHORT).show();
    }
    void gagal(int i){
        Toast.makeText(this,String.valueOf(i),Toast.LENGTH_SHORT).show();
    }
}

