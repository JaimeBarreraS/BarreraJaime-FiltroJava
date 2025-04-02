package MVC.modulo.DAO;

import MVC.modulo.Mision;
import MVC.util.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MisionDAO {
    public List<Mision> obtenerMisionesDisponibles(int idNinja) throws SQLException {
        List<Mision> misiones = new ArrayList<>();
        Connection conn = ConexionBD.conectar();
        String query = "SELECT * FROM mision WHERE id NOT IN (SELECT id_mision FROM misionNinja WHERE id_ninja = ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idNinja);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                misiones.add(new Mision(
                        rs.getInt("id"),
                        rs.getString("descripcion"),
                        rs.getString("rango"),
                        rs.getDouble("recompensa")
                ));
            }
        } return misiones;
    }

    public boolean asignarMision(int idNinja, int idMision) throws SQLException {
        String sql = "INSERT INTO misionNinja (id_ninja, id_mision, fecha_inicio) VALUES (?, ?, CURDATE())";
        try (Connection conn = ConexionBD.conectar()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idNinja);
            stmt.setInt(2, idMision);
            return stmt.executeUpdate() > 0;
        }
    }
}
