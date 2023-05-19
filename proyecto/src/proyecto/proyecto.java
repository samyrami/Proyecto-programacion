package proyecto;
import java.util.*;

public class proyecto {
    private static Map<Integer, String> diccionarioEstudiantes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("------------------------  BASE DE DATOS ESTUDIANTIL  --------------------------");
        System.out.println("Usuario, con el fin de registrar los datos proporcione la siguiente información");


        boolean continuarIngresando = true;

        while (continuarIngresando) {
            System.out.println("\nIngrese los datos del estudiante:");
            System.out.print(" -> ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print(" -> Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print(" -> Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print(" -> Edad: ");
            int edad = scanner.nextInt();
            scanner.nextLine();

            agregarEstudiante(id, nombre, apellido, edad);

            System.out.print("¿Desea ingresar otro estudiante? (SI / NO): ");
            String respuesta = scanner.nextLine();

            if (!respuesta.equalsIgnoreCase("SI")) {
                continuarIngresando = false;
            }
        }

        boolean continuarPrograma = true;

        while (continuarPrograma) {
            System.out.println();
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Listar estudiantes");
            System.out.println("2. Buscar estudiante por Id");
            System.out.println("3. Buscar estudiante por nombre o apellido");
            System.out.println("4. Eliminar estudiante");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarEstudiantes();
                    break;
                case 2:
                    System.out.print("Ingrese el ID del estudiante a buscar: ");
                    int idBusqueda = scanner.nextInt();
                    scanner.nextLine();
                    buscarEstudiante(idBusqueda);
                    break;
                case 3:
                    System.out.print("Ingrese el nombre o apellido del estudiante a buscar: ");
                    String nombreOApellidoBusqueda = scanner.nextLine();
                    buscarEstudiantePorNombreOApellido(nombreOApellidoBusqueda);
                    break;

                case 4:
                    System.out.print("Ingrese el ID del estudiante a eliminar: ");
                    int idEliminacion = scanner.nextInt();
                    scanner.nextLine();
                    eliminarEstudiante(idEliminacion);
                    break;
                case 5:
                    continuarPrograma = false;
                    System.out.print("Gracias por ingresar a la base de datos. Esperamos vuelva pronto ");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
    
    public static void buscarEstudiantePorNombreOApellido(String nombreOApellido) {
        List<String> estudiantesEncontrados = new ArrayList<>();

        for (String estudiante : diccionarioEstudiantes.values()) {
            if (estudiante.contains(nombreOApellido)) {
                estudiantesEncontrados.add(estudiante);
            }
        }

        if (estudiantesEncontrados.isEmpty()) {
            System.out.println("No se encontraron estudiantes con el nombre o apellido proporcionado.");
        } else {
            System.out.println("Estudiantes encontrados:");
            for (String estudiante : estudiantesEncontrados) {
                System.out.println(estudiante);
            }
        }
    }


    public static void agregarEstudiante(int id, String nombre, String apellido, int edad) {
        String estudiante = String.format("ID: %d, Nombre: %s, Apellido: %s, Edad: %d", id, nombre, apellido, edad);
        diccionarioEstudiantes.put(id, estudiante);
        System.out.println("Estudiante agregado correctamente.");
    }

    public static void listarEstudiantes() {
        if (diccionarioEstudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en la lista.");
        } else {
            System.out.println("Estudiantes en la lista:");
            for (String estudiante : diccionarioEstudiantes.values()) {
                System.out.println(estudiante);
            }
        }
    }

    public static void buscarEstudiante(int id) {
        if (diccionarioEstudiantes.containsKey(id)) {
            String estudiante = diccionarioEstudiantes.get(id);
            System.out.println("Estudiante encontrado:");
            System.out.println(estudiante);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }
    public static void eliminarEstudiante(int id) {
        if (diccionarioEstudiantes.containsKey(id)) {
            diccionarioEstudiantes.remove(id);
            System.out.println("Estudiante eliminado correctamente.");
        } else {
            System.out.println("Estudiante no encontrado. No se puede eliminar.");
        }
    }
}