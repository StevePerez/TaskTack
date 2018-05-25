package armando.gt.com.tasktack;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import armando.gt.com.tasktack.Fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    Fragment mFragmentGenerico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentGenerico = new MainFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorDeCosas,mFragmentGenerico).commit();
    }
}
