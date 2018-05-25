package armando.gt.com.tasktack.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import armando.gt.com.tasktack.R;


public class MainFragment extends Fragment {
    private static final String TAG = "MainFragment";
    private AppBarLayout appBar;
    private TabLayout pestanas;
    private ViewPager viewPager;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        if (savedInstanceState == null){
            insertarTabs(container);

            //Setear adaptador al viewpager.
            viewPager = (ViewPager) view.findViewById(R.id.pager);
            viewPager.setAdapter(new sliderAdapter(getChildFragmentManager()));
            pestanas.setupWithViewPager(viewPager);
        }
        return view;
    }

    private void insertarTabs(ViewGroup container) {
        View padre = (View) container.getParent();
        appBar = (AppBarLayout) padre.findViewById(R.id.appbar);
        pestanas = new TabLayout(getActivity());
        pestanas.setTabTextColors(Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF"));
        appBar.addView(pestanas);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(appBar!=null){
            appBar.removeView(pestanas);
        }
    }

    private class sliderAdapter extends FragmentPagerAdapter {

        final  String tabs[]={getString(R.string.tab_no1),getString(R.string.tab_no2)};

        public sliderAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    TareasPorHacerFragmentTab youtubeFragmentTab = new TareasPorHacerFragmentTab();
                    return youtubeFragmentTab;

                case 1:
                    TareasAdminFragmentTab radioFragmentTab = new TareasAdminFragmentTab();
                    return radioFragmentTab;

            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }
    }
}
