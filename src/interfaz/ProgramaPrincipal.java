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
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

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
        System.out.print("Codigo del blog a borrar: ");
        int codigo = Integer.parseInt(sc.nextLine());

        controladora.borrarBlog(codigo);
        System.out.println("Blog borrado correctamente.");
    }

    private static void menuBlogs() {
        mostrarBlogs();
        System.out.print("Seleccione el codigo del blog con el que desea trabajar: ");
        int codigoBlog = Integer.parseInt(sc.nextLine());

        int opcion;
        do {
            System.out.println("\n=== MENU BLOG ===");
            System.out.println("1. Crear publicacion");
            System.out.println("2. Ver publicacion y comentarios");
            System.out.println("3. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

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