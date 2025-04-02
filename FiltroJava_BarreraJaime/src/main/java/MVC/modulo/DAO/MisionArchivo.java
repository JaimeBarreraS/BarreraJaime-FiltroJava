package MVC.modulo.DAO;

import java.io.BufferedReader;
import java.io.FileReader;

public class MisionArchivo {
    private static final String ARCHIVO = "src/main/java/MVC/util/misiones_completadas.txt";

    public static void mostrarMisionesCompletadas() {
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            System.out.println("Misiones completadas");
            while ((linea = br.readLine()) !=null){
                System.out.println(linea);
            }
        } catch (Exception e) {
            System.out.println("Error al mostrar misiones completadas: " + e.getMessage());
        }
    }
}
