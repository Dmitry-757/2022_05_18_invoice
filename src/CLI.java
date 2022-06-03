import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CLI {
    private Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
//        System.out.println("1 - Work with Invoices, 2 - Work with directories");
//        System.out.println("1 - New Invoice, 2 - Change Invoice, 3 - Delete Invoice");

    }


    public void upLevelMenu() {
        System.out.println("1 - Work with Directories, 2 - Work with Invoices, 3 - terminate program");
        if (sc.hasNextInt()) {
            switch (sc.nextInt()) {
                case 1 -> workWithDirectories();
                case 2 -> workWithInvoices();
                case 3 -> AppMain.terminate = true;
                default -> System.out.println("Wrong input!");
            }
        }
    }


    public void workWithDirectories() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - work with Clients, 2 - work with Stores, 3 - work with Products, 4 - go back");
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1 -> workWithClients();
                    case 2 -> workWithStores();
                    case 3 -> workWithProducts();
                    case 4 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }

    }

    //************* work with products ********************
    private void workWithProducts() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New Product, 2 - Change Product, 3 - Delete Product, 4 - go back");
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

    private void deleteProduct() {
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
                StoreService.deleteProduct(product);
            } else
                System.out.println("Product by name `" + name + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }

    }

    private void changeProduct() {
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
                System.out.println("Product by name `" + name + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }

    private void createNewProduct() {
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




    //************* work with stores ********************
    private void workWithStores() {
        boolean goBack = false;
        while (!goBack) {
            System.out.println("1 - New Store, 2 - Change Store, 3 - Delete Store, 4 - go back");
            if (sc.hasNextInt()) {
                switch (sc.nextInt()) {
                    case 1 -> createNewStore();
                    case 2 -> changeStore();
                    case 3 -> deleteStore();
                    case 4 -> goBack = true;
                    default -> System.out.println("Wrong input!");
                }
            }
        }
    }

    private void deleteStore() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        String name;
        sc.nextLine();
        System.out.println("Input name of deleting store");
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of deleting store = " + name);
            Store store = StoreService.getStoreByName(name);
            if (store != null) {
                StoreService.deleteStore(store);
            } else
                System.out.println("Store by name `" + name + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }

    private void changeStore() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        String name;
        sc.nextLine();
        System.out.println("Input name of changing store");
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of changing store = " + name);
            Store store = StoreService.getStoreByName(name);
            if (store != null) {
                System.out.println("Input new name of product");
                line = sc.nextLine();
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String newName = matcher.group();
                    store.setStoreName(newName);
                    System.out.println("new name of store = " + newName);
                }
            } else
                System.out.println("Store by name `" + name + "` is not found");
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }

    private void createNewStore() {
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
        System.out.println("Input name of store");
        String name;
        sc.nextLine();
        String line = sc.nextLine();
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            name = matcher.group();
            System.out.println("name of store = " + name);
            try {
                new Store(name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("wrong input - can`t find name...");
        }
    }
    //************* work with store ***********************
    //*****************************************************


    private void workWithClients() {
        System.out.println("1 - New Client, 2 - Change Client, 3 - Delete Client");
    }


    private void workWithInvoices() {
        System.out.println("1 - New Invoice, 2 - Change Invoice, 3 - Delete Invoice");
    }

}
