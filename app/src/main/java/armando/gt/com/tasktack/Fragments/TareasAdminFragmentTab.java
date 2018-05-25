package armando.gt.com.tasktack.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import armando.gt.com.tasktack.R;


public class TareasAdminFragmentTab extends Fragment {

    public TareasAdminFragmentTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tareas_admin_fragment_tab, container, false);

        return view;
    }

}
