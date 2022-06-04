package CLI.Invoices;

import BusinessModel.Client;
import BusinessModel.Invoice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CLI.CLI.sc;

import BusinessModel.Product;
import BusinessModel.StoreService;
import CLI.Directories.*;

public class WorkWithStringsOfInvoice {
    public static void workWithStringsOfInvoice(Invoice invoice){
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New string, 2 - change string, 3 - Delete string, 4 - print strings, 5 - go back");
            //sc.nextLine();
            if (sc.hasNextInt()) {
                int choice=sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> {
                        try {
                            addNewString(invoice);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
//                    case 2 -> changeInvoice();
//                    case 3 -> deleteInvoice();
                    case 4 -> printStrings(invoice);
                    case 5 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }

    }

    private static void printStrings(Invoice invoice) {
        System.out.println(invoice.getTablePart());
    }

    private static void addNewString(Invoice invoice) throws Exception {
        //sc.nextLine();
        String name;
        Product product;
        double quantity = 0;

        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        WorkWithProducts.printProducts();
        System.out.println("Input name of product");

        //sc.nextLine();
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of product = " + name);
        } else {
            throw new Exception("wrong input - can`t find name...");
        }
        product = StoreService.getProductByName(name);
        if (product == null) {
            throw new Exception("wrong input - can`t find product " + name);
        }

        System.out.println("Input quantity of product");
        if (sc.hasNextDouble()) {
            quantity = sc.nextInt();
            sc.nextLine();
            System.out.println("quantity = " + quantity);
        } else {
            throw new Exception("wrong input quantity...");
        }

        invoice.addString(product, quantity);
    }
}
