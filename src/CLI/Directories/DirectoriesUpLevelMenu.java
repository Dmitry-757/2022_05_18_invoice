package CLI.Directories;
import static CLI.CLI.sc;



public class DirectoriesUpLevelMenu {
    public static void workWithDirectories() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - work with Clients, 2 - work with Stores, 3 - work with Products, 4 - go back");
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1 -> WorkWithClients.workWithClients();
                    case 2 -> WorkWithStores.workWithStores();
                    case 3 -> WorkWithProducts.workWithProducts();
                    case 4 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }
    }
}
