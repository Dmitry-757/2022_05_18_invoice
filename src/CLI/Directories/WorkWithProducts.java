package CLI.Directories;


import BusinessModel.Product;
import BusinessModel.StoreService;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CLI.CLI.sc;

public class WorkWithProducts {
    //************* work with products ********************
    static void workWithProducts() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New product, 2 - Change product, 3 - Delete product, 4 - print products,  5 - go back");
            if (sc.hasNextInt()) {
                int choice=sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 -> createNewProduct();
                    case 2 -> changeProduct();
                    case 3 -> deleteProduct();
                    case 4 -> printProducts();
                    case 5 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }
    }

    public static void printProducts() {
        System.out.println("current products:");
        for (Map.Entry<String, Product> entry : StoreService.getProductMap().entrySet()) {
            System.out.println("name=" + entry.getKey() );
        }
    }

    private static void deleteProduct() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        String name;
        //sc.nextLine();
        printProducts();
        System.out.println("Input name of deleting product");
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of deleting product = " + name);
            Product product = StoreService.getProductByName(name);

            if (product != null) {
                StoreService.deleteDirectoryItem(product);

            } else
                System.out.println("product by name `" + name + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }

    }

    private static void changeProduct() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        String name;
        //sc.nextLine();
        printProducts();
        System.out.println("Input name of changing product");
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of changing product = " + name);
            Product product = StoreService.getProductByName(name);

            if (product != null) {
                System.out.println("Input new name of product");
                line = sc.nextLine();
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String newName = matcher.group();
                    product.setProductName(newName);
                    System.out.println("new name of product = " + newName);
                }
            } else
                System.out.println("product by name `" + name + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }

    private static void createNewProduct() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        System.out.println("Input name of product");
        String name;
        //sc.nextLine();
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of product = " + name);
            try {
                new Product(name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }
    //************* work with products ********************
    //*****************************************************

}
