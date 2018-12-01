package tcc.example.com.lowonganpekerjaan;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import tcc.example.com.lowonganpekerjaan.Fragment.HomeFragment;
import tcc.example.com.lowonganpekerjaan.Fragment.PasangLowkerFragment;
import tcc.example.com.lowonganpekerjaan.Fragment.ProfileFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fl_menu);
        bottomNavigationView = findViewById(R.id.bnv_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_home) {
            gotoFragment(new HomeFragment());
        } else if (item.getItemId() == R.id.action_profil) {
            gotoFragment(new ProfileFragment());
        }
        else if (item.getItemId() == R.id.action_pasang_lowker) {
            gotoFragment(new PasangLowkerFragment());
        }
        return true;
    }
    void gotoFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_menu, fragment);
        fragmentTransaction.commit();
    }
}

