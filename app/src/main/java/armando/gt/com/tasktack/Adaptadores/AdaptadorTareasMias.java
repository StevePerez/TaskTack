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

public class AdaptadorTareasMias extends RecyclerView.Adapter<AdaptadorTareasMias.ViewHolder> implements View.OnClickListener {
    private static final String TAG = "AdaptadorTareasAdmin";
    private Context contextTarea;
    private ArrayList<Tasrea> mTasreas = new ArrayList<>();
    private View.OnClickListener listener;

    public AdaptadorTareasMias(Context contextTarea, ArrayList<Tasrea> mTasreas) {
        this.contextTarea = contextTarea;
        this.mTasreas = mTasreas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tareas_asignadas,parent,false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Iniciando el casteo de datos");

        Glide.with(contextTarea)
                .load(mTasreas.get(position).getImagen_tarea())
                .into(holder.mImageViewTarea);

        holder.mTextViewNombre.setText(mTasreas.get(position).getNombre_tarea().toString());
        holder.mTextViewDescripcion.setText(mTasreas.get(position).getDescripcion().toString());

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
        private ImageView mImageViewTarea;
        private TextView mTextViewNombre;
        private TextView mTextViewDescripcion;

        public ViewHolder(View itemView) {
            super(itemView);

            mImageViewTarea = itemView.findViewById(R.id.imgTarea);
            mTextViewDescripcion = itemView.findViewById(R.id.tv_descripcion);
            mTextViewNombre = itemView.findViewById(R.id.tv_nombre);
        }
    }
}
