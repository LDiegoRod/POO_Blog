package blog;

import java.time.LocalDateTime;

public class Comentario {
    private LocalDateTime fechaCreacion;
    private String emailAutor;
    private String direccionIp;
    private String texto;

    public Comentario(String emailAutor, String direccionIp, String texto) {
        this.fechaCreacion = LocalDateTime.now();
        this.emailAutor = emailAutor;
        this.direccionIp = direccionIp;
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "fechaCreacion=" + fechaCreacion +
                ", emailAutor='" + emailAutor + '\'' +
                ", direccionIp='" + direccionIp + '\'' +
                ", texto='" + texto + '\'' +
                '}';
    }
}