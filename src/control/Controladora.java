package control;

import java.util.Map;
import java.util.TreeMap;

import blog.Blog;

public class Controladora {
    private Map<Integer, Blog> blogs;

    public Controladora() {
        blogs = new TreeMap<>();
        cargarDatosIniciales();
    }

    public void crearBlog(String nombre, String descripcion) {
        Blog b = new Blog(nombre, descripcion);
        blogs.put(b.getCodigo(), b);
    }

    public void borrarBlog(int codigoBlog) {
        if (!blogs.containsKey(codigoBlog)) {
            throw new IllegalArgumentException("No existe un blog con ese codigo.");
        }
        blogs.remove(codigoBlog);
    }

    public Map<Integer, String> obtenerBlogs() {
        Map<Integer, String> resultado = new TreeMap<>();

        for (Blog b : blogs.values()) {
            resultado.put(b.getCodigo(), b.getNombre());
        }

        return resultado;
    }
    
    public void crearPublicacion(int codigoBlog, String titulo, String texto, String nombreCreador) {
        if (!blogs.containsKey(codigoBlog)) {
            throw new IllegalArgumentException("No existe un blog con ese codigo.");
        }

        blogs.get(codigoBlog).crearPublicacion(titulo, texto, nombreCreador);
    }

    public Map<Integer, String> obtenerPublicaciones(int codigoBlog) {
        if (!blogs.containsKey(codigoBlog)) {
            throw new IllegalArgumentException("No existe un blog con ese codigo.");
        }

        return blogs.get(codigoBlog).obtenerTitulosPublicaciones();
    }

    public String obtenerPublicacion(int codigoBlog, int codigoPublicacion) {
        if (!blogs.containsKey(codigoBlog)) {
            throw new IllegalArgumentException("No existe un blog con ese codigo.");
        }

        return blogs.get(codigoBlog).obtenerPublicacion(codigoPublicacion);
    }
