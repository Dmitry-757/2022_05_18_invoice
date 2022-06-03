import java.util.Scanner;

public class CLI {
//    private Scanner sc = new Scanner(System.in);
    private  Scanner sc;

    public CLI() {
        try (Scanner sc = new Scanner(System.in)){
            this.sc = sc;
        }
    }

    public static void main(String[] args) {
//        System.out.println("1 - Work with Invoices, 2 - Work with directories");
//        System.out.println("1 - New Invoice, 2 - Change Invoice, 3 - Delete Invoice");

    }

    public void upLevelMenu() {
        System.out.println("1 - Work with Invoices, 2 - Work with directories");
        if(sc.hasNextInt()){
            switch (sc.nextInt()){
                case 1 -> workWithDirectories();
                case 2 -> workWithInvoices();
                default -> System.out.println("Wrong input!");
            }
        }
    }


    public void workWithDirectories(){
        System.out.println("1 - work with Clients, 2 - work with Stores, 3 - work with Products");
    }

    private void workWithInvoices() {
        System.out.println("1 - New Invoice, 2 - Change Invoice, 3 - Delete Invoice");
    }

}
