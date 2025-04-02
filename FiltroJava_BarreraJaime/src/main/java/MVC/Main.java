package MVC;

import MVC.modulo.DAO.MisionDAO;
import MVC.modulo.DAO.NinjaDAO;
import MVC.modulo.Mision;
import MVC.modulo.Ninja;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        NinjaDAO ninjaDAO = new NinjaDAO();
        MisionDAO misionDAO = new MisionDAO();

        while (true){
            System.out.println("\n--- Gestion de Ninjas de Konoha ---");
            System.out.println("1. Listar Ninjas con Habilidades");
            System.out.println("2. Mostrar Misiones Disponibles");
            System.out.println("3. Mostrar Misiones Completadas de un Ninja");
            System.out.println("4. Asignar Mision a un Ninja");
            System.out.println("5. Marcar Mision como Completada");
            System.out.println("6. Mostrar Todas las misiones completadas (Archivo)");
            System.out.println("7. Salir");
            System.out.println("Selecciones una Opcion: ");

            int opcion = scanner.nextInt();
            switch (opcion){
                case 1:
                    listarNinjasConHabilidades(ninjaDAO);
                    break;
                case 2:
                    mostrarMisionesDisponibles(misionDAO, scanner);
                    break;
                case 3:
                    mostrarMisionesCompletadasDeNinja(misionDAO, scanner);
                    break;
                case 4:
                    asignarMision(misionDAO, scanner);
                    break;
                case 5:
                    mostrarMisionesDisponibles(misionDAO, scanner);
                    break;
                case 6:
                    mostrarMisionesDisponibles(misionDAO, scanner);
                    break;
                case 7:
                    System.out.println("Saliendo....");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opcion no valida");
            }
        }
    }

    private static void listarNinjasConHabilidades (NinjaDAO ninjaDAO){
        try {
            List<Ninja> ninjas = ninjaDAO.ObtenerNinjasConHabilidades();
            System.out.println("\n --- Listar Ninjas con Habilidades ---");
            ninjas.forEach( n ->
                    System.out.println(n.getId() + " - " + n.getNombre() + " | Rango: " + n.getRango() + " | Habilidades: " + n.getHabilidades())
            );
        } catch (SQLException e) {
            System.out.println("Error al obtener las ninjas:  " + e.getMessage());
        }
    }

    private static void mostrarMisionesDisponibles (MisionDAO misionDAO, Scanner scanner){
        System.out.println("Ingresar ID del ninja: ");
        int idNinja = scanner.nextInt();
        try {
            List<Mision> misiones = misionDAO.obtenerMisionesDisponibles(idNinja);
            System.out.println("\n --- Misiones Disponibles ---");
            misiones.forEach(m ->
                    System.out.println(m.getId() + " - " + m.getDescripcion() + " | Rango: " + m.getRango()));
        } catch (SQLException e) {
        System.out.println("Error al obtener misiones: " + e.getMessage());
        }
    }

    private static void mostrarMisionesCompletadasDeNinja (MisionDAO misionDAO, Scanner scanner){
        System.out.println("Ingresar ID del ninja: ");
        int idNinja = scanner.nextInt();
        try {
            List<Mision> misiones = misionDAO.obtenerMisionesDisponibles(idNinja);
            System.out.println("\n --- Misiones Completadas ---");
            misiones.forEach(m ->
                    System.out.println(m.getId() + " - " + m.getDescripcion() + " | Completada" ));
        } catch (SQLException e) {
            System.out.println("Error al obtener misiones completadas: " + e.getMessage());
        }
    }

    private static void asignarMision (MisionDAO misionDAO, Scanner scanner) throws SQLException {
        System.out.println("Ingresar ID del ninja: ");
        int idNinja = scanner.nextInt();
        System.out.println("Ingresar ID del mision: ");
        int idMision = scanner.nextInt();

        if (misionDAO.asignarMision(idNinja,idMision)){
            System.out.println("Mision asignado exitosa");
        } else {
            System.out.println("Mision no asignado");
        }
    }

    private static void completarMision (MisionDAO misionDAO, Scanner scanner) throws SQLException {
        System.out.println("Ingresar ID del ninja: ");
        int idNinja = scanner.nextInt();
        System.out.println("Ingresar ID del mision a completar: ");
        int idMision = scanner.nextInt();

        if (misionDAO.asignarMision(idNinja,idMision)){
            System.out.println("Mision marcada como completada");
        } else {
            System.out.println("No se pudo completar mision");
        }
    }
}
