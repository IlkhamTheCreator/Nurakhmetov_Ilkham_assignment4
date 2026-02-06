import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StageRepository {

    public void create(Stage stage) {
        String sql = "INSERT INTO stages(name, location) VALUES (?, ?) ON CONFLICT (name) DO NOTHING";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, stage.getName());
            ps.setString(2, stage.getLocation());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                stage.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Insert stage failed", e);
        }
    }

    public List<Stage> getAll() {
        List<Stage> list = new ArrayList<>();
        String sql = "SELECT * FROM stages";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Stage s = new Stage(rs.getString("name"), rs.getString("location"));
                s.setId(rs.getInt("id"));
                list.add(s);
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Select stages failed", e);
        }
        return list;
    }

    public Stage getById(int id) {
        String sql = "SELECT * FROM stages WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Stage s = new Stage(rs.getString("name"), rs.getString("location"));
                s.setId(rs.getInt("id"));
                return s;
            } else {
                throw new ResourceNotFoundException("Stage not found");
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Select stage failed", e);
        }
    }
}
