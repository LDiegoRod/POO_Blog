package blog;

import java.time.LocalDateTime;

public class Comentario {
    private LocalDateTime fechaCreacion;
    private String email;
    private String ip;
    private String texto;

    public Comentario(String email, String ip, String texto) {
        this.fechaCreacion = LocalDateTime.now();
        this.email = email;
        this.ip = ip;
        this.texto = texto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEmail() {
        return email;
    }

    public String getIp() {
        return ip;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        String resultado = "";
        resultado += "Fecha: " + fechaCreacion + "\n";
        resultado += "Correo: " + email + "\n";
        resultado += "IP: " + ip + "\n";
        resultado += "Comentario: " + texto;
        return resultado;
    }
}