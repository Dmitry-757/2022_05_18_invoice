package CLI.Invoices;
import BusinessModel.Client;
import BusinessModel.Invoice;
import BusinessModel.StoreService;
import CLI.Directories.WorkWithClients;
import CLI.Directories.WorkWithProducts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CLI.CLI.sc;

public class InvoicesUpLevelMenu {
    public static void workWithInvoices() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New invoice, 2 - change invoice, 3 - Delete invoice, 4 - print one invoice, 5 - print all invoices, 6 - go back");
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
                    case 5 -> printAllInvoices();
                    case 6 -> printInvoicesByClient();
                    case 7 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }
    }

    private static void printInvoicesByClient() {
        WorkWithClients.printClients();
        System.out.println("Input inn of client");
        if (sc.hasNextInt()) {
            int inn = sc.nextInt();
            sc.nextLine();
            System.out.println("inn of client = " + inn);
            Client client = StoreService.getClientByINN(inn);
            if (client != null) {
                for( Invoice invc:StoreService.getInvoiceByParam(client)){
                    System.out.println(invc.toString());
                }
            } else
                System.out.println("client by INN `" + inn + "` is not found");
        } else {
            System.out.println("wrong input ...");
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

    private static void printAllInvoices() {
        for(Invoice invc:StoreService.getAllInvoices()){
            System.out.println(invc.toString());
        }
    }


}
