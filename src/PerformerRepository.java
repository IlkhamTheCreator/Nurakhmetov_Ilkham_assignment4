import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerformerRepository {

    public void create(Performer p) {
        String sql = "INSERT INTO performers(name, type, stage_id, performance_fee) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, p.getName());
            ps.setString(2, p.getType());
            ps.setInt(3, p.getStage().getId());
            ps.setDouble(4, p.getPerformanceFee());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();
            if (keys.next()) {
                p.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Insert performer failed", e);
        }
    }

    public List<Performer> getAll() {
        List<Performer> list = new ArrayList<>();
        String sql = "SELECT p.id, p.name, p.type, p.performance_fee, s.id as stage_id, s.name as stage_name, s.location " +
                "FROM performers p LEFT JOIN stages s ON p.stage_id = s.id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Stage stage = new Stage(rs.getString("stage_name"), rs.getString("location"));
                stage.setId(rs.getInt("stage_id"));

                Performer p = new Performer(
                        rs.getString("name"),
                        rs.getString("type"),
                        stage,
                        rs.getDouble("performance_fee")
                );
                p.setId(rs.getInt("id"));

                list.add(p);
            }

        } catch (SQLException e) {
            throw new DatabaseOperationException("Select performers failed", e);
        }
        return list;
    }
}
