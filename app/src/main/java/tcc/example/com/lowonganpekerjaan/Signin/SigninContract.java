package tcc.example.com.lowonganpekerjaan.Signin;

/**
 * Angarsa Labs...!
 * Created by Angga on 05/10/2018.
 */
public interface SigninContract {
        void checkLogin();
        void signup();
        void formBelumLegkap();
        void wrongPass(int i);
        void loginSuccess();
        void loginFailed(String f);
}
