package blog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Blog {
    private static int contadorCodigos = 1;

    private int codigo;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private ArrayList<Publicacion> publicaciones;

    public Blog(String nombre, String descripcion) {
        this.codigo = contadorCodigos;
        contadorCodigos++;
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
        Publicacion nuevaPublicacion = new Publicacion(titulo, texto, nombreCreador);
        publicaciones.add(nuevaPublicacion);
    }

    public Map<Integer, String> getTitulosPublicaciones() {
        Map<Integer, String> titulos = new HashMap<>();

        for (int i = 0; i < publicaciones.size(); i++) {
            Publicacion publicacion = publicaciones.get(i);
            titulos.put(publicacion.getCodigo(), publicacion.getTitulo());
        }

        return titulos;
    }

    public void agregarComentario(int codigoPublicacion, String emailAutor, String direccionIp, String texto) {
        for (int i = 0; i < publicaciones.size(); i++) {
            Publicacion publicacion = publicaciones.get(i);

            if (publicacion.getCodigo() == codigoPublicacion) {
                publicacion.agregarComentario(emailAutor, direccionIp, texto);
                return;
            }
        }

        System.out.println("No se encontro la publicacion con ese codigo.");
    }

    public void borrarComentario(int codigoPublicacion, int posicionComentario) {
        for (int i = 0; i < publicaciones.size(); i++) {
            Publicacion publicacion = publicaciones.get(i);

            if (publicacion.getCodigo() == codigoPublicacion) {
                publicacion.borrarComentario(posicionComentario);
                return;
            }
        }

        System.out.println("No se encontro la publicacion con ese codigo.");
    }

    @Override
    public String toString() {
        String resultado = "Blog\n";
        resultado += "Codigo: " + codigo + "\n";
        resultado += "Nombre: " + nombre + "\n";
        resultado += "Descripcion: " + descripcion + "\n";
        resultado += "Fecha de creacion: " + fechaCreacion + "\n";
        resultado += "Publicaciones:\n";

        for (int i = 0; i < publicaciones.size(); i++) {
            resultado += publicaciones.get(i).toString() + "\n";
        }

        return resultado;
    }
}