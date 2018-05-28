package armando.gt.com.tasktack.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import armando.gt.com.tasktack.Adaptadores.AdaptadorTareasAdmin;
import armando.gt.com.tasktack.Adaptadores.AdaptadorTareasMias;
import armando.gt.com.tasktack.Entidad.Tasrea;
import armando.gt.com.tasktack.R;

public class TareasPorHacerFragmentTab extends Fragment {
    private static final String TAG = "TareasPorHacerFragmentT";
    //Widgets
    private RecyclerView mRecyclerViewTareasMias;
    private ArrayList<Tasrea> mTasreas;

    public TareasPorHacerFragmentTab() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tareas_por_hacer, container, false);
        initRecycler(view);
        return view;
    }

    private void initRecycler(View view) {
        mTasreas = new ArrayList<>();
        mRecyclerViewTareasMias = view.findViewById(R.id.recyclerview_tareas_mias);
        mRecyclerViewTareasMias.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerViewTareasMias.setHasFixedSize(true);

        llenarDatos();

        AdaptadorTareasMias adaptador = new AdaptadorTareasMias(getContext(),mTasreas);
        mRecyclerViewTareasMias.setAdapter(adaptador);

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
