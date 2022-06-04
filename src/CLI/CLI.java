package CLI;
import AppMain.*;
import CLI.Directories.DirectoriesUpLevelMenu;
import CLI.Invoices.InvoicesUpLevelMenu;


import java.util.Scanner;

public class CLI {
    public static Scanner sc = new Scanner(System.in);

    public void upLevelMenu() {
        System.out.println("1 - Work with Directories, 2 - Work with Invoices, 3 - terminate program");
        if (sc.hasNextInt()) {
            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> DirectoriesUpLevelMenu.workWithDirectories();
                case 2 -> InvoicesUpLevelMenu.workWithInvoices();
                case 3 -> AppMain.terminate = true;
                default -> System.out.println("Wrong input!");
            }
        }
    }

}
