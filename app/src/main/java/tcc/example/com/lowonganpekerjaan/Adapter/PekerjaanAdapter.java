package tcc.example.com.lowonganpekerjaan.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import tcc.example.com.lowonganpekerjaan.Fragment.HomeView;
import tcc.example.com.lowonganpekerjaan.Model.Pekerjaan;
import tcc.example.com.lowonganpekerjaan.R;

public class PekerjaanAdapter extends RecyclerView.Adapter<PekerjaanAdapter.ViewHolder> {
    List<Pekerjaan> pekerjaanList = new ArrayList<>();
    Context context;
    HomeView homeView;
    public PekerjaanAdapter(List<Pekerjaan> list,Context ctx,HomeView view){
        pekerjaanList=list;
        context=ctx;
        homeView=view;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_pekerjaan, parent , false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(pekerjaanList.get(position));
    }

    @Override
    public int getItemCount() {
        return pekerjaanList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cover;
        TextView judul,tanggal,type,perusahaan,pendidikan,lokasi;
        CardView cv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv_list_event);
            cover = itemView.findViewById(R.id.iv_list_event_cover);
            judul = itemView.findViewById(R.id.tv_list_event_title);
            tanggal=itemView.findViewById(R.id.tanggal);
            type =itemView.findViewById(R.id.type);
            perusahaan=itemView.findViewById(R.id.perusahaan);
            pendidikan=itemView.findViewById(R.id.pendidikan);
            lokasi=itemView.findViewById(R.id.lokasi);
        }
        public void bind(final Pekerjaan pekerjaan){
            judul.setText(pekerjaan.getTitle());
            tanggal.setText(pekerjaan.getTanggal());
            type.setText(pekerjaan.getType());
            perusahaan.setText(pekerjaan.getPerusahaan());
            pendidikan.setText(pekerjaan.getPendidikan());
            lokasi.setText(pekerjaan.getLokasi());
            if(pekerjaan.getImage() != null) Picasso.get().load(pekerjaan.getImage()).fit().centerInside().into(cover);
            cv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    homeView.detail(pekerjaan);
                }
            });
        }

    }
}
