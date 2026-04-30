package blog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private static int consecutivo = 1;

    private int codigo;
    private String titulo;
    private String texto;
    private String nombreCreador;
    private LocalDateTime fechaPublicacion;
    private List<Comentario> comentarios;

    public Publicacion(String titulo, String texto, String nombreCreador) {
        this.codigo = consecutivo++;
        this.titulo = titulo;
        this.texto = texto;
        this.nombreCreador = nombreCreador;
        this.fechaPublicacion = LocalDateTime.now();
        this.comentarios = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void agregarComentario(String email, String ip, String texto) {
        Comentario comentario = new Comentario(email, ip, texto);
        comentarios.add(comentario);
    }

    public void borrarComentario(int posicion) {
        if (posicion < 0 || posicion >= comentarios.size()) {
            throw new IllegalArgumentException("La posicion del comentario no es valida.");
        }

        comentarios.remove(posicion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Publicacion #").append(codigo).append("\n");
        sb.append("Titulo: ").append(titulo).append("\n");
        sb.append("Texto: ").append(texto).append("\n");
        sb.append("Autor: ").append(nombreCreador).append("\n");
        sb.append("Fecha de publicacion: ").append(fechaPublicacion).append("\n");
        sb.append("Comentarios:\n");

        if (comentarios.isEmpty()) {
            sb.append("No hay comentarios registrados.\n");
        } else {
            for (int i = 0; i < comentarios.size(); i++) {
                Comentario comentarioActual = comentarios.get(i);
                sb.append("Comentario ").append(i).append(":\n");
                sb.append(comentarioActual.toString()).append("\n");
            }
        }

        return sb.toString();
    }
}