import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Biblioteca ---");
            System.out.println("1. Registrar Persona");
            System.out.println("2. Registrar Material");
            System.out.println("3. Prestar Material");
            System.out.println("4. Devolver Material");
            System.out.println("5. Renovar Material");
            System.out.println("6. Incrementar Cantidad de Material");
            System.out.println("7. Consultar Historial");
            System.out.println("8. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Cedula: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Nombres: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Rol (Estudiante/Docente/Administrativo): ");
                    String rol = scanner.nextLine();
                    biblioteca.registrarPersona(new Persona(cedula, nombres, apellidos, rol));
                    break;
                case 2:
                    System.out.print("Identificador del material: ");
                    String identificador = scanner.nextLine();
                    System.out.print("Título del material: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Fecha de registro (dd/MM/yyyy): ");
                    String fechaRegistro = scanner.nextLine();
                    System.out.print("Cantidad registrada: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    biblioteca.registrarMaterial(new Material(identificador, titulo, fechaRegistro, cantidad));
                    break;
                case 3:
                    System.out.print("Identificador del material a prestar: ");
                    String idPrestamo = scanner.nextLine();
                    System.out.print("Cedula de la persona: ");
                    String cedulaPrestamo = scanner.nextLine();
                    biblioteca.prestarMaterial(idPrestamo, cedulaPrestamo);
                    break;
                case 4:
                    System.out.print("Identificador del material a devolver: ");
                    String idDevolucion = scanner.nextLine();
                    System.out.print("Cedula de la persona: ");
                    String cedulaDevolucion = scanner.nextLine();
                    biblioteca.devolverMaterial(idDevolucion, cedulaDevolucion);
                    break;
                case 5:
                    System.out.print("Identificador del material a renovar: ");
                    String idRenovacion = scanner.nextLine();
                    System.out.print("Cedula de la persona: ");
                    String cedulaRenovacion = scanner.nextLine();
                    biblioteca.renovarMaterial(idRenovacion, cedulaRenovacion);
                    break;
                case 6:
                    System.out.print("Identificador del material a incrementar: ");
                    String idIncremento = scanner.nextLine();
                    System.out.print("Cantidad a incrementar: ");
                    int incremento = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    biblioteca.incrementarCantidad(idIncremento, incremento);
                    break;
                case 7:
                    biblioteca.consultarHistorial();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}