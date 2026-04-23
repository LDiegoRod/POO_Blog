package blog;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Publicacion {
    private static int contadorCodigo = 1;

    private int codigo;
    private String titulo;
    private String texto;
    private String nombreCreador;
    private LocalDateTime fechaPublicacion;
    private ArrayList<Comentario> comentarios;

    public Publicacion(String titulo, String texto, String nombreCreador) {
        this.codigo = contadorCodigo;
        contadorCodigo++;
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

    public void agregarComentario(String emailAutor, String direccionIp, String texto) {
        Comentario nuevoComentario = new Comentario(emailAutor, direccionIp, texto);
        comentarios.add(nuevoComentario);
    }

    public void borrarComentario(int posicionComentario) {
        if (posicionComentario >= 0 && posicionComentario < comentarios.size()) {
            comentarios.remove(posicionComentario);
        } else {
            System.out.println("Posicion de comentario no valida.");
        }
    }

    @Override
    public String toString() {
        String resultado = "Publicacion\n";
        resultado += "Codigo: " + codigo + "\n";
        resultado += "Titulo: " + titulo + "\n";
        resultado += "Texto: " + texto + "\n";
        resultado += "Nombre del creador: " + nombreCreador + "\n";
        resultado += "Fecha de publicacion: " + fechaPublicacion + "\n";
        resultado += "Comentarios:\n";

        for (int i = 0; i < comentarios.size(); i++) {
            resultado += "[" + i + "] " + comentarios.get(i).toString() + "\n";
        }

        return resultado;
    }
}