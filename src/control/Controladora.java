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
    public void agregarComentario(int codigoBlog, int codigoPublicacion, String email, String ip, String texto) {
        if (!blogs.containsKey(codigoBlog)) {
            throw new IllegalArgumentException("No existe un blog con ese codigo.");
        }

        blogs.get(codigoBlog).agregarComentario(codigoPublicacion, email, ip, texto);
    }

    public void borrarComentario(int codigoBlog, int codigoPublicacion, int posicion) {
        if (!blogs.containsKey(codigoBlog)) {
            throw new IllegalArgumentException("No existe un blog con ese codigo.");
        }

        blogs.get(codigoBlog).borrarComentario(codigoPublicacion, posicion);
    }

    private void cargarDatosIniciales() {
        crearBlog("Cartas Yu-Gi-Oh", "Blog dedicado a estrategias, cartas y curiosidades de Yu-Gi-Oh");
        crearBlog("Futbol y censura", "Blog sobre casos curiosos donde el futbol ha sido restringido o prohibido en ciertos paises");

        crearPublicacion(1, "Las mejores cartas trampa para defenderte", 
                "En este post se comentan algunas cartas trampa utiles para frenar ataques y controlar el duelo.", 
                "Luis");

        crearPublicacion(1, "Por que el Mago Oscuro sigue siendo tan famoso", 
                "Aunque han salido cartas mas modernas, el Mago Oscuro sigue siendo una de las cartas mas representativas de Yu-Gi-Oh.", 
                "Diego");

        crearPublicacion(2, "Paises donde el futbol ha sido restringido temporalmente", 
                "En algunos lugares se han aplicado restricciones al futbol por razones politicas, sociales o de seguridad.", 
                "Luis");

        crearPublicacion(2, "Razones por las que un torneo puede ser prohibido", 
                "Un torneo puede ser suspendido o prohibido por conflictos, falta de permisos o situaciones extraordinarias.", 
                "Diego");

        agregarComentario(1, 1, "luis@mail.com", "192.168.0.10", "Buen tema, casi nunca se habla de las cartas trampa.");
        agregarComentario(1, 1, "diego@mail.com", "192.168.0.11", "Seria bueno mencionar tambien cartas de contraefecto.");

        agregarComentario(1, 2, "grace@mail.com", "192.168.0.12", "El Mago Oscuro es iconico, aunque ya no sea tan competitivo.");
        agregarComentario(1, 2, "dorys@mail.com", "192.168.0.13", "Me gusto el enfoque nostalgico de la publicacion.");

        agregarComentario(2, 3, "rulio@mail.com", "192.168.0.14", "Interesante, no sabia que eso habia pasado en algunos paises.");
        agregarComentario(2, 3, "dima@mail.com", "192.168.0.15", "Podrias agregar ejemplos concretos de casos reales.");

        agregarComentario(2, 4, "lidiete@mail.com", "192.168.0.16", "Buen resumen, se entiende facil.");
        agregarComentario(2, 4, "mickey@mail.com", "192.168.0.17", "Seria interesante compararlo con otros deportes.");
    }
}