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
