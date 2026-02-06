public class Performer {
    private int id;
    private String name;
    private String type;
    private Stage stage;
    private double performanceFee;

    public Performer() {}
    public Performer(String name, String type, Stage stage, double fee) {
        this.name = name;
        this.type = type;
        this.stage = stage;
        this.performanceFee = fee;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Stage getStage() { return stage; }
    public void setStage(Stage stage) { this.stage = stage; }

    public double getPerformanceFee() { return performanceFee; }
    public void setPerformanceFee(double performanceFee) { this.performanceFee = performanceFee; }
}
