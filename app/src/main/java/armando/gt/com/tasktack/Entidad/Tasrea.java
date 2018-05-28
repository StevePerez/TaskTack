package armando.gt.com.tasktack.Entidad;

public class Tasrea {
    String nombre_tarea;
    String nombre_usuario;
    String imagen_tarea;
    String descripcion;
    String Porcentaje;

    public Tasrea() {
    }

    public Tasrea(String nombre_tarea, String nombre_usuario, String imagen_tarea, String descripcion, String porcentaje) {
        this.nombre_tarea = nombre_tarea;
        this.nombre_usuario = nombre_usuario;
        this.imagen_tarea = imagen_tarea;
        this.descripcion = descripcion;
        Porcentaje = porcentaje;
    }

    public String getNombre_tarea() {
        return nombre_tarea;
    }

    public void setNombre_tarea(String nombre_tarea) {
        this.nombre_tarea = nombre_tarea;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getImagen_tarea() {
        return imagen_tarea;
    }

    public void setImagen_tarea(String imagen_tarea) {
        this.imagen_tarea = imagen_tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPorcentaje() {
        return Porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        Porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Tasrea{" +
                "nombre_tarea='" + nombre_tarea + '\'' +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", imagen_tarea='" + imagen_tarea + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", Porcentaje='" + Porcentaje + '\'' +
                '}';
    }
}
