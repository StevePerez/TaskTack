package armando.gt.com.tasktack.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import armando.gt.com.tasktack.Actividad.NuevaTareaActivity;
import armando.gt.com.tasktack.Adaptadores.AdaptadorTareasAdmin;
import armando.gt.com.tasktack.Entidad.Tasrea;
import armando.gt.com.tasktack.R;


public class TareasAdminFragmentTab extends Fragment {
    private static final String TAG = "TareasAdminFragmentTab";

    //Widgets
    private RecyclerView mRecyclerViewTareasAdmin;
    private ArrayList<Tasrea> mTasreas;

    public TareasAdminFragmentTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tareas_admin_fragment_tab, container, false);
        initRecycler(view);

        FloatingActionButton mFloatingActionButton = view.findViewById(R.id.fab);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NuevaTareaActivity.class);
                getContext().startActivity(intent);
            }
        });

        return view;
    }

    private void initRecycler(View view) {
        mTasreas = new ArrayList<>();
        mRecyclerViewTareasAdmin = view.findViewById(R.id.recyclerview_tareas_admin);
        mRecyclerViewTareasAdmin.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewTareasAdmin.setHasFixedSize(true);

        llenarDatos();

        AdaptadorTareasAdmin adaptador = new AdaptadorTareasAdmin(getContext(),mTasreas);
        mRecyclerViewTareasAdmin.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Hola que hace!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void llenarDatos() {
        mTasreas.add(new Tasrea("Trabajo Accion","Armando Santos","http://ceplatam.com/img/blog/post/9.jpg","Primer proyecto","35%"));
        mTasreas.add(new Tasrea("Seminario","Steve Perez","http://ceplatam.com/img/blog/post/9.jpg","Primer proyecto","55%"));
        mTasreas.add(new Tasrea("Tesis","Daniel Blanco","http://ceplatam.com/img/blog/post/9.jpg","Primer proyecto","88%"));
        mTasreas.add(new Tasrea("Drawable","Erick Ruiz","http://ceplatam.com/img/blog/post/9.jpg","Primer proyecto","96%"));
        mTasreas.add(new Tasrea("Task Track","Arnoldo Chua","http://ceplatam.com/img/blog/post/9.jpg","Primer proyecto","85%"));
        mTasreas.add(new Tasrea("Meet Guate","Mario Hugo","http://ceplatam.com/img/blog/post/9.jpg","Primer proyecto","32"));
        mTasreas.add(new Tasrea("Root","Pedro Julio","http://ceplatam.com/img/blog/post/9.jpg","Primer proyecto","44%"));
    }

}
