package CLI.Invoices;

import BusinessModel.Invoice;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CLI.CLI.sc;

import BusinessModel.InvoiceString;
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
                    case 2 -> {
                        try {
                            changeString(invoice);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 3 -> {
                        try {
                            deleteString(invoice);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case 4 -> printStrings(invoice);
                    case 5 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }

    }

    private static void deleteString(Invoice invoice) throws Exception {
        InvoiceString invStr;
        List<InvoiceString> invStrList = invoice.getInvoiceStrings();
        System.out.println("Enter number of string for changing");
        System.out.println("Available numbers from "+
                (Math.max(invStrList.size(), 0))+
                " to "+invStrList.size());
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice<=invStrList.size()) {
                invStr = (InvoiceString) invStrList.toArray()[choice - 1];
                invoice.removeString(invStr);
            }
            else throw new Exception("Wrong number of string!");
        }
    }

    private static void changeString(Invoice invoice) throws Exception {
        InvoiceString invStr = null;
        List<InvoiceString> invStrList = invoice.getInvoiceStrings();
        System.out.println("Enter number of string for changing");
        System.out.println("Available numbers from "+
                (Math.max(invStrList.size(), 0))+
                " to "+invStrList.size());
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice<=invStrList.size())
                invStr = (InvoiceString) invStrList.toArray()[choice-1];
            else throw new Exception("Wrong number of string!");
        }

        String name;
        Product product;
        double quantity;

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
        if (invoice.getProductSet().contains(product)){
            throw new Exception("wrong input - product "+ name+" already present in strings!");
        }

        System.out.println("Input quantity of product");
        if (sc.hasNextDouble()) {
            quantity = sc.nextInt();
            sc.nextLine();
            System.out.println("quantity = " + quantity);
        } else {
            throw new Exception("wrong input quantity...");
        }

        invoice.correctString(invStr, product, quantity);

    }

    private static void printStrings(Invoice invoice) {
        System.out.println(invoice.getTablePart());
    }

    private static void addNewString(Invoice invoice) throws Exception {
        //sc.nextLine();
        String name;
        Product product;
        double quantity;

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
        if (invoice.getProductSet().contains(product)){
            throw new Exception("wrong input - product "+ name+" already present in strings!");
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
