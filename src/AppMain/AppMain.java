package AppMain;

import CLI.CLI;

public class AppMain {
    public static  boolean terminate;

    public static void main(String[] args) {
        CLI cli = new CLI();
        while (!terminate){
            cli.upLevelMenu();
        }

    }
}
