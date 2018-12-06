package tcc.example.com.lowonganpekerjaan.View.Fragment.Home;

import java.util.List;

import tcc.example.com.lowonganpekerjaan.Model.Pekerjaan;

public interface HomeView {
    void detail(Pekerjaan pekerjaan);
    void getDataSuccses(List<Pekerjaan> pekerjaan);
    void getDataFailed();
}
