package CLI.Invoices;
import static CLI.CLI.sc;

public class InvoicesUpLevelMenu {
    public static void workWithInvoices() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New invoice, 2 - invoice, 3 - Delete invoice, 4 - go back");
            sc.nextLine();
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1 -> {
                        try {
                            CreateNewInvoice.createNewInvoice();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
//                    case 2 -> changeInvoice();
//                    case 3 -> deleteInvoice();
                    case 4 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }

    }

}
