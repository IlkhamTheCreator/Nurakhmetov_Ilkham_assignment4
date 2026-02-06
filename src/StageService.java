import java.util.List;

public class StageService {
    private StageRepository repo = new StageRepository();

    public void addStage(Stage s) {
        if (s.getName() == null || s.getName().isEmpty())
            throw new InvalidInputException("Stage name empty");

        repo.create(s);
    }

    public List<Stage> getAll() {
        return repo.getAll();
    }

    public Stage getById(int id) {
        return repo.getById(id);
    }
}
