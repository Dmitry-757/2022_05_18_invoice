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
            switch (sc.nextInt()) {
                case 1 -> DirectoriesUpLevelMenu.workWithDirectories();
                case 2 -> InvoicesUpLevelMenu.workWithInvoices();
                case 3 -> AppMain.terminate = true;
                default -> System.out.println("Wrong input!");
            }
        }
    }


//    public void workWithDirectories() {
//        boolean goBack = false;
//        while (!goBack) {
//            System.out.println("1 - work with Clients, 2 - work with Stores, 3 - work with Products, 4 - go back");
//            if (sc.hasNextInt()) {
//                switch (sc.nextInt()) {
//                    case 1 -> workWithClients();
//                    case 2 -> workWithStores();
//                    case 3 -> workWithProducts();
//                    case 4 -> goBack = true;
//                    default -> System.out.println("Wrong input!");
//                }
//            }
//        }
//
//    }

//    //************* work with products ********************
//    private void workWithProducts() {
//        boolean goBack = false;
//        while (!goBack) {
//            System.out.println("1 - New product, 2 - Change product, 3 - Delete product, 4 - go back");
//            if (sc.hasNextInt()) {
//                switch (sc.nextInt()) {
//                    case 1 -> createNewProduct();
//                    case 2 -> changeProduct();
//                    case 3 -> deleteProduct();
//                    case 4 -> goBack = true;
//                    default -> System.out.println("Wrong input!");
//                }
//            }
//        }
//    }
//
//    private void deleteProduct() {
//        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//        String name;
//        sc.nextLine();
//        System.out.println("Input name of deleting product");
//        String line = sc.nextLine();
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            name = matcher.group();
//            System.out.println("name of deleting product = " + name);
//            Product product = StoreService.getProductByName(name);
//
//            if (product != null) {
//                StoreService.deleteDirectoryItem(product);
//
//            } else
//                System.out.println("product by name `" + name + "` is not found");
//        } else {
//            System.out.println("wrong input - can`t find name...");
//        }
//
//    }
//
//    private void changeProduct() {
//        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//        String name;
//        sc.nextLine();
//        System.out.println("Input name of changing product");
//        String line = sc.nextLine();
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            name = matcher.group();
//            System.out.println("name of changing product = " + name);
//            Product product = StoreService.getProductByName(name);
//
//            if (product != null) {
//                System.out.println("Input new name of product");
//                line = sc.nextLine();
//                matcher = pattern.matcher(line);
//                if (matcher.find()) {
//                    String newName = matcher.group();
//                    product.setProductName(newName);
//                    System.out.println("new name of product = " + newName);
//                }
//            } else
//                System.out.println("product by name `" + name + "` is not found");
//        } else {
//            System.out.println("wrong input - can`t find name...");
//        }
//    }
//
//    private void createNewProduct() {
//        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//        System.out.println("Input name of product");
//        String name;
//        sc.nextLine();
//        String line = sc.nextLine();
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            name = matcher.group();
//            System.out.println("name of product = " + name);
//            try {
//                new Product(name);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        } else {
//            System.out.println("wrong input - can`t find name...");
//        }
//    }
//    //************* work with products ********************
//    //*****************************************************




//    //************* work with stores ********************
//    private void workWithStores() {
//        boolean goBack = false;
//        while (!goBack) {
//            System.out.println("1 - New store, 2 - Change store, 3 - Delete store, 4 - go back");
//            if (sc.hasNextInt()) {
//                switch (sc.nextInt()) {
//                    case 1 -> createNewStore();
//                    case 2 -> changeStore();
//                    case 3 -> deleteStore();
//                    case 4 -> goBack = true;
//                    default -> System.out.println("Wrong input!");
//                }
//            }
//        }
//    }
//
//    private void deleteStore() {
//        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//        String name;
//        sc.nextLine();
//        System.out.println("Input name of deleting store");
//        String line = sc.nextLine();
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            name = matcher.group();
//            System.out.println("name of deleting store = " + name);
//            Store store = StoreService.getStoreByName(name);
//            if (store != null) {
//                StoreService.deleteDirectoryItem(store);
//            } else
//                System.out.println("store by name `" + name + "` is not found");
//        } else {
//            System.out.println("wrong input - can`t find name...");
//        }
//    }
//
//    private void changeStore() {
//        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//        String name;
//        sc.nextLine();
//        System.out.println("Input name of changing store");
//        String line = sc.nextLine();
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            name = matcher.group();
//            System.out.println("name of changing store = " + name);
//            Store store = StoreService.getStoreByName(name);
//            if (store != null) {
//                System.out.println("Input new name of product");
//                line = sc.nextLine();
//                matcher = pattern.matcher(line);
//                if (matcher.find()) {
//                    String newName = matcher.group();
//                    store.setName(newName);
//                    System.out.println("new name of store = " + newName);
//                }
//            } else
//                System.out.println("store by name `" + name + "` is not found");
//        } else {
//            System.out.println("wrong input - can`t find name...");
//        }
//    }
//
//    private void createNewStore() {
//        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//        System.out.println("Input name of store");
//        String name;
//        sc.nextLine();
//        String line = sc.nextLine();
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            name = matcher.group();
//            System.out.println("name of store = " + name);
//            try {
//                new Store(name);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        } else {
//            System.out.println("wrong input - can`t find name...");
//        }
//    }
//    //************* work with stores ***********************
//    //*****************************************************


//    //************* work with clients ********************
//    private void workWithClients() {
//        boolean goBack = false;
//        while (!goBack) {
//            System.out.println("1 - New client, 2 - client, 3 - Delete client, 4 - go back");
//            if (sc.hasNextInt()) {
//                switch (sc.nextInt()) {
//                    case 1 -> createNewClient();
//                    case 2 -> changeClient();
//                    case 3 -> deleteClient();
//                    case 4 -> goBack = true;
//                    default -> System.out.println("Wrong input!");
//                }
//            }
//        }
//    }
//
//    private void deleteClient() {
//        sc.nextLine();
//        System.out.println("Input inn of deleting client");
//        if (sc.hasNextInt()) {
//            int inn = sc.nextInt();
//            System.out.println("inn of deleting client = " + inn);
//            Client client = StoreService.getClientByINN(inn);
//            if (client != null) {
//                StoreService.deleteDirectoryItem(client);
//            } else
//                System.out.println("client by INN `" + inn + "` is not found");
//        } else {
//            System.out.println("wrong input - can`t find name...");
//        }
//    }
//
//    private void changeClient() {
//        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//        //String name;
//        sc.nextLine();
//        System.out.println("Input inn of changing client");
//        if (sc.hasNextInt()) {
//            int inn = sc.nextInt();
//            System.out.println("inn of changing client = " + inn);
//            Client client = StoreService.getClientByINN(inn);
//            if (client != null) {
//                System.out.println("Input new name of client");
//                sc.nextLine();
//                String line = sc.nextLine();
//                Matcher matcher = pattern.matcher(line);
//                if (matcher.find()) {
//                    String newName = matcher.group();
//                    client.setName(newName);
//                    System.out.println("new name of client = " + newName);
//                }
//            } else
//                System.out.println("client by INN `" + inn + "` is not found");
//        } else {
//            System.out.println("wrong input - can`t find name...");
//        }
//    }
//
//    private void createNewClient() {
//        sc.nextLine();
//        System.out.println("Input inn of new client");
//        if (sc.hasNextInt()) {
//            int inn = sc.nextInt();
//            System.out.println("inn of new client = " + inn);
//
//            Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//            System.out.println("Input name of client");
//            String name;
//            sc.nextLine();
//            String line = sc.nextLine();
//            Matcher matcher = pattern.matcher(line);
//            if (matcher.find()) {
//                name = matcher.group();
//                System.out.println("name of client = " + name);
//                try {
//                    new Client(name, inn);
//                } catch (Exception e) {
//                    System.out.println(e.getMessage());
//                }
//            } else {
//                System.out.println("wrong input - can`t find name...");
//            }
//        }
//    }
//    //************* work with clients ***********************
//    //*****************************************************




    //************ work with invoices ***********************
//    private void workWithInvoices() {
//        boolean goBack = false;
//        while (!goBack) {
//            System.out.println("1 - New invoice, 2 - invoice, 3 - Delete invoice, 4 - go back");
//            sc.nextLine();
//            if (sc.hasNextInt()) {
//                switch (sc.nextInt()) {
//                    case 1 -> {
//                        try {
//                            createNewInvoice();
//                        } catch (Exception e) {
//                            System.out.println(e.getMessage());
//                        }
//                    }
////                    case 2 -> changeInvoice();
////                    case 3 -> deleteInvoice();
//                    case 4 -> goBack = true;
//                    default -> System.out.println("Wrong input!");
//                }
//            }
//        }
//
//    }

//    private void createNewInvoice() throws Exception {
//        String invoiceNumber = null;
//        EInvoiceType type = null;
//        Client client = null;
//        Store store = null;
//
//        //number of invoice
//        Pattern pattern = Pattern.compile("^[0-9a-zA-Zа-яА-Я]*");
//        System.out.println("Input invoice Number");
//        String name;
//        sc.nextLine();
//        String line = sc.nextLine();
//        Matcher matcher = pattern.matcher(line);
//        if (matcher.find()) {
//            invoiceNumber = matcher.group();
//            System.out.println("invoice Number = " + invoiceNumber);
//        } else {
//            throw new Exception("wrong input invoice Number!");
//        }
//
//
//        //type of invoice
//        //sc.nextLine();
//        System.out.println("Input type of new invoice: 1-in, 2-out");
//        if (sc.hasNextInt()) {
//            int intValue = sc.nextInt();
//            switch (intValue){
//                case 1 -> type = EInvoiceType.IN;
//                case 2 -> type = EInvoiceType.OUT;
//                default -> {
//                    throw new Exception("Wrong choice of type of invoice!");
//                }
//            }
//            System.out.println("type of new invoice = " + (type != null ? type.name() : null));
//            //sc.nextLine();
//
//            //client
//            System.out.println("Choose client from:");
//            for (Map.Entry<Integer, Client> entry: StoreService.getClientMap().entrySet()){
//                System.out.println("Inn="+entry.getKey()+"  name="+entry.getValue());
//            }
//            System.out.println("Input Inn of client");
//            int inn = 0;
//            sc.nextLine();
//            if (sc.hasNextInt()) {
//                inn = sc.nextInt();
//                System.out.println("Inn of client = " + inn);
//                if(StoreService.getClientMap().containsKey(inn)){
//                    client = StoreService.getClientMap().get(inn);
//                }
//                else throw new Exception("client with inn="+inn+" was not found!");
//            }
//            else throw new Exception("Wrong input of client`s inn!");
//
//            //store
//            pattern = Pattern.compile("^[a-zA-Zа-яА-Я]*");
//            System.out.println("Input name of store");
//            name = null;
//            sc.nextLine();
//            line = sc.nextLine();
//            matcher = pattern.matcher(line);
//            if (matcher.find()) {
//                name = matcher.group();
//                System.out.println("name of store = " + name);
//                if(StoreService.getStoreMap().containsKey(name)){
//                    store = StoreService.getStoreMap().get(name);
//                }
//                else {
//                    throw new Exception("store was not found!");
//                }
//            } else {
//                throw new Exception("wrong input name of store!");
//            }
//
//            new Invoice(invoiceNumber, type, store, client);
//        }
//    }

    //************ work with invoices ***********************
    //*******************************************************

}
