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
