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
