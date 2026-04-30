package blog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Blog {
    private static int consecutivo = 1;

    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private List<Publicacion> publicaciones;

    public Blog(String nombre, String descripcion) {
        this.codigo = consecutivo++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDateTime.now();
        this.publicaciones = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void crearPublicacion(String titulo, String texto, String nombreCreador) {
        Publicacion publicacionNueva = new Publicacion(titulo, texto, nombreCreador);
        publicaciones.add(publicacionNueva);
    }

    public Map<Integer, String> obtenerTitulosPublicaciones() {
        Map<Integer, String> resultado = new HashMap<>();

        for (Publicacion publicacionActual : publicaciones) {
            resultado.put(publicacionActual.getCodigo(), publicacionActual.getTitulo());
        }

        return resultado;
    }

    public String obtenerPublicacion(int codigoPublicacion) {
        Publicacion publicacionBuscada = buscarPublicacion(codigoPublicacion);
        return publicacionBuscada.toString();
    }

    public void agregarComentario(int codigoPublicacion, String email, String ip, String texto) {
        Publicacion publicacionBuscada = buscarPublicacion(codigoPublicacion);
        publicacionBuscada.agregarComentario(email, ip, texto);
    }

    public void borrarComentario(int codigoPublicacion, int posicion) {
        Publicacion publicacionBuscada = buscarPublicacion(codigoPublicacion);
        publicacionBuscada.borrarComentario(posicion);
    }

    private Publicacion buscarPublicacion(int codigoPublicacion) {
        for (Publicacion publicacionActual : publicaciones) {
            if (publicacionActual.getCodigo() == codigoPublicacion) {
                return publicacionActual;
            }
        }

        throw new IllegalArgumentException("No existe una publicacion con ese codigo.");
    }
}