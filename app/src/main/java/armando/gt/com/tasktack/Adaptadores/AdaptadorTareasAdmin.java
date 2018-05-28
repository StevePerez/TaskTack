package armando.gt.com.tasktack.Adaptadores;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import armando.gt.com.tasktack.Entidad.Tasrea;
import armando.gt.com.tasktack.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdaptadorTareasAdmin extends RecyclerView.Adapter<AdaptadorTareasAdmin.ViewHolder> implements View.OnClickListener {
    private static final String TAG = "AdaptadorTareasAdmin";
    private Context contextTarea;
    private ArrayList<Tasrea> mTasreas = new ArrayList<>();
    private View.OnClickListener listener;

    public AdaptadorTareasAdmin(Context contextTarea, ArrayList<Tasrea> mTasreas) {
        this.contextTarea = contextTarea;
        this.mTasreas = mTasreas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tareas_admin,parent,false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Iniciando el casteo de datos");

        Glide.with(contextTarea)
                .load(R.drawable.user)
                .into(holder.mCircleImageViewUserProfile);

        holder.mTextViewNombreTaarea.setText(mTasreas.get(position).getNombre_tarea().toString());
        holder.mTextViewNombreUser.setText(mTasreas.get(position).getNombre_usuario().toString());

        Glide.with(contextTarea)
                .load(mTasreas.get(position).getImagen_tarea())
                .into(holder.mImageViewTarea);

        holder.mTextViewDescripcion.setText(mTasreas.get(position).getDescripcion().toString());
        holder.mTextViewPorcentaje.setText("Completado en un " + mTasreas.get(position).getPorcentaje().toString());

        //Botones de CRUD

        holder.mTextViewAniadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contextTarea, "Estas añadiendo a otra persona!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.mTextViewEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contextTarea, "Estas editando esta tarea!", Toast.LENGTH_SHORT).show();
            }
        });

        holder.mTextViewEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contextTarea, "Estas Elimando Estos!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mTasreas.size();
    }

    public void setOnClickListener (View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView mCircleImageViewUserProfile;
        private TextView mTextViewNombreTaarea;
        private TextView mTextViewNombreUser;
        private ImageView mImageViewTarea;
        private TextView mTextViewDescripcion;
        private TextView mTextViewPorcentaje;
        private TextView mTextViewAniadir;
        private TextView mTextViewEditar;
        private TextView mTextViewEliminar;

        public ViewHolder(View itemView) {
            super(itemView);

            mCircleImageViewUserProfile = itemView.findViewById(R.id.imgLogin);
            mTextViewNombreTaarea = itemView.findViewById(R.id.txtNombreTarea);
            mTextViewNombreUser = itemView.findViewById(R.id.txtNombreAdmin);
            mImageViewTarea = itemView.findViewById(R.id.imgTareaAdmin);
            mTextViewDescripcion = itemView.findViewById(R.id.txtDescripcionTareaAdmin);
            mTextViewPorcentaje = itemView.findViewById(R.id.txtPorcentaje);
            mTextViewAniadir = itemView.findViewById(R.id.txtAnadir);
            mTextViewEditar = itemView.findViewById(R.id.txtEditar);
            mTextViewEliminar = itemView.findViewById(R.id.txtEliminar);

        }
    }
}
