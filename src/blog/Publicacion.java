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

    public void agregarComentario(String emailAutor, String direccionIp, String texto) {
        Comentario nuevoComentario = new Comentario(emailAutor, direccionIp, texto);
        comentarios.add(nuevoComentario);
    }

    public void borrarComentario(int posicion) {
        if (posicion >= 0 && posicion < comentarios.size()) {
            comentarios.remove(posicion);
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
        resultado += "Creador: " + nombreCreador + "\n";
        resultado += "Fecha de publicacion: " + fechaPublicacion + "\n";
        resultado += "Comentarios:\n";

        for (int i = 0; i < comentarios.size(); i++) {
            resultado += "[" + i + "] " + comentarios.get(i).toString() + "\n";
        }

        return resultado;
    }
}