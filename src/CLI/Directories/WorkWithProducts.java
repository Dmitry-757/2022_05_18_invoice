package CLI.Directories;

import BusinessModel.Product;
import BusinessModel.StoreService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static CLI.CLI.sc;

public class WorkWithProducts {
    //************* work with products ********************
    static void workWithProducts() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New product, 2 - Change product, 3 - Delete product, 4 - go back");
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1 -> createNewProduct();
                    case 2 -> changeProduct();
                    case 3 -> deleteProduct();
                    case 4 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }
    }

    private static void deleteProduct() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        String name;
        sc.nextLine();
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
        sc.nextLine();
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
        sc.nextLine();
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
