package MVC.modulo.DAO;

import MVC.modulo.Ninja;
import MVC.util.ConexionBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NinjaDAO {
    public List<Ninja> ObtenerNinjasConHabilidades() throws SQLException {
        List<Ninja> ninjas = new ArrayList<>();
        Connection conn = ConexionBD.conectar();
        String query = """ 
                SELECT n.id, n.nombre, n.rango, n.aldea, h.nombre AS habilidad
                FROM ninja n 
                LEFT JOIN habilidad h ON n.id = h.id_ninja 
                ORDER BY n.id; 
                """;
        try (Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Ninja ninja = new Ninja(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("rango"),
                        rs.getString("aldea"));
                        if (rs.getString("habilidad") != null){
                            ninja.agregarHabilidad(rs.getString("habilidad"));
                        }
                        ninjas.add(ninja);
            }
        }return ninjas;
    }
}
