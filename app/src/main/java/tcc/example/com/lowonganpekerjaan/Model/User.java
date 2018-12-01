package tcc.example.com.lowonganpekerjaan.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("addres")
    @Expose
    private String addres;

    private int age;

    @SerializedName("last_name")
    @Expose

    private String lastName;

    @SerializedName("username")
    @Expose
    private String username;


    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("id")
    @Expose
    private int id;

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
