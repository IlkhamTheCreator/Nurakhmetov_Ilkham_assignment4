import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    StageService stageService = new StageService();
    PerformerService performerService = new PerformerService();

    while (true) {
      System.out.println("\nMusic Festival Menu:");
      System.out.println("1. Add Stage");
      System.out.println("2. Add Performer");
      System.out.println("3. Show All Stages");
      System.out.println("4. Show All Performers");
      System.out.println("0. Exit");
      System.out.print("Choose: ");

      int choice = scanner.nextInt();
      scanner.nextLine(); // consume newline

      try {
        if (choice == 1) {
          System.out.print("Stage name: ");
          String name = scanner.nextLine();
          System.out.print("Location: ");
          String location = scanner.nextLine();
          Stage stage = new Stage(name, location);
          stageService.addStage(stage);
          System.out.println("Stage added!");

        } else if (choice == 2) {
          System.out.print("Performer name: ");
          String name = scanner.nextLine();
          System.out.print("Type (SoloArtist/Band): ");
          String type = scanner.nextLine();

          System.out.print("Stage ID: ");
          int stageId = scanner.nextInt();
          scanner.nextLine();

          Stage stage = stageService.getById(stageId);
          System.out.print("Performance fee: ");
          double fee = scanner.nextDouble();
          scanner.nextLine();

          Performer performer = new Performer(name, type, stage, fee);
          performerService.addPerformer(performer);
          System.out.println("Performer added!");

        } else if (choice == 3) {
          List<Stage> stages = stageService.getAll();
          System.out.println("\nStages:");
          for (Stage s : stages) {
            System.out.println(s.getId() + " | " + s.getName() + " | " + s.getLocation());
          }

        } else if (choice == 4) {
          List<Performer> performers = performerService.getAll();
          System.out.println("\nPerformers:");
          for (Performer p : performers) {
            System.out.println(p.getId() + " | " + p.getName() + " | " + p.getType() +
                    " | Stage: " + p.getStage().getName() +
                    " | Fee: " + p.getPerformanceFee());
          }

        } else if (choice == 0) {
          System.out.println("Goodbye!");
          break;
        }

      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

    scanner.close();
  }
}
