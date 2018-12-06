package tcc.example.com.lowonganpekerjaan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataKetertarikanResponse {
    @SerializedName("sukses")
    @Expose
    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
