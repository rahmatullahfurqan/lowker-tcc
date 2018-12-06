package tcc.example.com.lowonganpekerjaan.View.Activity.Signin;

import tcc.example.com.lowonganpekerjaan.Model.User;

/**
 * Angarsa Labs...!
 * Created by Angga on 05/10/2018.
 */
public interface SigninContract {
        void checkLogin();
        void signup();
        void formBelumLegkap();
        void wrongPass();
        void loginSuccess(User user);
        void loginFailed();
}
