package interfaz;

import java.util.Map;
import java.util.Scanner;

import control.Controladora;

public class ProgramaPrincipal {
    private static Controladora controladora = new Controladora();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n=== ADMINISTRACION DE BLOGS ===");
            System.out.println("1. Crear blog nuevo");
            System.out.println("2. Trabajar con blog");
            System.out.println("3. Borrar blog");
            System.out.println("4. Salir");

            opcion = leerEntero("Seleccione una opcion: ");

            try {
                switch (opcion) {
                    case 1:
                        crearBlog();
                        break;
                    case 2:
                        menuBlogs();
                        break;
                    case 3:
                        borrarBlog();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion invalida.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 4);

        sc.close();
    }

    private static void crearBlog() {
        System.out.print("Nombre del blog: ");
        String nombre = sc.nextLine();

        System.out.print("Descripcion del blog: ");
        String descripcion = sc.nextLine();

        controladora.crearBlog(nombre, descripcion);
        System.out.println("Blog creado correctamente.");
    }

    private static void borrarBlog() {
        mostrarBlogs();
        int codigo = leerEntero("Codigo del blog a borrar: ");

        controladora.borrarBlog(codigo);
        System.out.println("Blog borrado correctamente.");
    }

    private static void menuBlogs() {
        mostrarBlogs();
        int codigoBlog = leerEntero("Seleccione el codigo del blog con el que desea trabajar: ");

        try {
            controladora.obtenerPublicaciones(codigoBlog);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        int opcion;
        do {
            System.out.println("\n=== MENU BLOG ===");
            System.out.println("1. Crear publicacion");
            System.out.println("2. Ver publicacion y comentarios");
            System.out.println("3. Regresar");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    crearPublicacion(codigoBlog);
                    break;
                case 2:
                    menuPublicaciones(codigoBlog);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 3);
    }

    private static void crearPublicacion(int codigoBlog) {
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();

        System.out.print("Texto: ");
        String texto = sc.nextLine();

        System.out.print("Nombre del creador: ");
        String nombre = sc.nextLine();

        controladora.crearPublicacion(codigoBlog, titulo, texto, nombre);
        System.out.println("Publicacion creada correctamente.");
    }

    private static void menuPublicaciones(int codigoBlog) {
        mostrarPublicaciones(codigoBlog);

        int codigoPublicacion = leerEntero("Seleccione el codigo de la publicacion: ");

        System.out.println("\n=== PUBLICACION ===");
        System.out.println(controladora.obtenerPublicacion(codigoBlog, codigoPublicacion));

        int opcion;
        do {
            System.out.println("1. Crear comentario");
            System.out.println("2. Borrar comentario");
            System.out.println("3. Regresar");

            opcion = leerEntero("Seleccione una opcion: ");

            switch (opcion) {
                case 1:
                    agregarComentario(codigoBlog, codigoPublicacion);
                    break;
                case 2:
                    borrarComentario(codigoBlog, codigoPublicacion);
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }

            if (opcion == 1 || opcion == 2) {
                System.out.println("\n=== PUBLICACION ACTUALIZADA ===");
                System.out.println(controladora.obtenerPublicacion(codigoBlog, codigoPublicacion));
            }

        } while (opcion != 3);
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero entero.");
            }
        }
    }

    private static void agregarComentario(int codigoBlog, int codigoPublicacion) {
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("IP: ");
        String ip = sc.nextLine();

        System.out.print("Texto del comentario: ");
        String texto = sc.nextLine();

        controladora.agregarComentario(codigoBlog, codigoPublicacion, email, ip, texto);
        System.out.println("Comentario agregado correctamente.");
    }

    private static void borrarComentario(int codigoBlog, int codigoPublicacion) {
        int posicion = leerEntero("Posicion del comentario a borrar: ");

        controladora.borrarComentario(codigoBlog, codigoPublicacion, posicion);
        System.out.println("Comentario borrado correctamente.");
    }

    private static void mostrarBlogs() {
        Map<Integer, String> blogs = controladora.obtenerBlogs();

        System.out.println("\n=== LISTADO DE BLOGS ===");
        for (Integer codigo : blogs.keySet()) {
            System.out.println(codigo + " - " + blogs.get(codigo));
        }
    }

    private static void mostrarPublicaciones(int codigoBlog) {
        Map<Integer, String> publicaciones = controladora.obtenerPublicaciones(codigoBlog);

        System.out.println("\n=== LISTADO DE PUBLICACIONES ===");
        for (Integer codigo : publicaciones.keySet()) {
            System.out.println(codigo + " - " + publicaciones.get(codigo));
        }
    }
}