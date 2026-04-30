package blog;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class Blog {
    private static int consecutivo = 1;

    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private Map<Integer, Publicacion> publicaciones;

    public Blog(String nombre, String descripcion) {
        this.codigo = consecutivo++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaCreacion = LocalDateTime.now();
        this.publicaciones = new TreeMap<>();
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
        Publicacion p = new Publicacion(titulo, texto, nombreCreador);
        publicaciones.put(p.getCodigo(), p);
    }

    public Map<Integer, String> obtenerTitulosPublicaciones() {
        Map<Integer, String> resultado = new TreeMap<>();

        for (Publicacion p : publicaciones.values()) {
            resultado.put(p.getCodigo(), p.getTitulo());
        }

        return resultado;
    }

    public String obtenerPublicacion(int codigoPublicacion) {
        if (!publicaciones.containsKey(codigoPublicacion)) {
            throw new IllegalArgumentException("No existe una publicacion con ese codigo.");
        }
        return publicaciones.get(codigoPublicacion).toString();
    }

    public void agregarComentario(int codigoPublicacion, String email, String ip, String texto) {
        if (!publicaciones.containsKey(codigoPublicacion)) {
            throw new IllegalArgumentException("No existe una publicacion con ese codigo.");
        }
        publicaciones.get(codigoPublicacion).agregarComentario(email, ip, texto);
    }

    public void borrarComentario(int codigoPublicacion, int posicion) {
        if (!publicaciones.containsKey(codigoPublicacion)) {
            throw new IllegalArgumentException("No existe una publicacion con ese codigo.");
        }
        publicaciones.get(codigoPublicacion).borrarComentario(posicion);
    }
}