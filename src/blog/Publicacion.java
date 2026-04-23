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
