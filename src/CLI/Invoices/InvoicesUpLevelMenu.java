package CLI.Invoices;
import BusinessModel.Invoice;
import BusinessModel.StoreService;
import CLI.Directories.WorkWithProducts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CLI.CLI.sc;

public class InvoicesUpLevelMenu {
    public static void workWithInvoices() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New invoice, 2 - change invoice, 3 - Delete invoice, 4 - print one invoice, 5- print all invoices, 6 - go back");
            //sc.nextLine();
            if (sc.hasNextInt()) {
                int choice=sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> {
                        try {
                            CreateNewInvoice.createNewInvoice();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
//                    case 2 -> changeInvoice();
//                    case 3 -> deleteInvoice();
                    case 4 -> printInvoice();
                    case 5 -> printInvoices();
                    case 6 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }

    }

    private static void printInvoice() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я0-9]*");
        System.out.println("List of numbers of existing invoices:");
        for( Invoice invc:StoreService.getAllInvoices()){
            System.out.println(invc.getInvoiceNumber());
        }

        System.out.println("Enter number of invoice");

        String invoiceNumber;
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            invoiceNumber = matcher.group();
            System.out.println("number of invoice = " + invoiceNumber);

            for( Invoice invc:StoreService.getInvoiceByParam(invoiceNumber)){
                System.out.println(invc.toString());
            }

        } else {
            System.out.println("wrong input...");
        }


    }

    private static void printInvoices() {
        for(Invoice invc:StoreService.getAllInvoices()){
            System.out.println(invc.toString());
        }
    }


}
