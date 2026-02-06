import java.util.List;

public class PerformerService {
    private PerformerRepository repo = new PerformerRepository();

    public void addPerformer(Performer p) {
        if (p.getName() == null || p.getName().isEmpty())
            throw new InvalidInputException("Performer name empty");

        if (p.getStage() == null)
            throw new InvalidInputException("Stage is required");

        if (p.getPerformanceFee() <= 0)
            throw new InvalidInputException("Performance fee must be > 0");

        repo.create(p);
    }

    public List<Performer> getAll() {
        return repo.getAll();
    }
}
