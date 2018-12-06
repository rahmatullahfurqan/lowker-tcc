package tcc.example.com.lowonganpekerjaan.Model;

import com.google.gson.annotations.SerializedName;

public class Pekerjaan {
    @SerializedName("image_url")
    private String image;

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String title;

//    @SerializedName("type")
//    private String type;

    @SerializedName("about")
    private String keterangan;

    @SerializedName("education")
    private String pendidikan;

    @SerializedName("location")
    private String lokasi;

    @SerializedName("date_start")
    private String tanggal;


    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

}
