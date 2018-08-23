
/*
|* Author -- Corey Wingo                          
|*                                                 
|* Date -- 3/19/2017 (m/d/y)                       
|*                                                  
|* Purpose -- To support the LibraryLogger with a controller to the
|*     console.
*/

/* A class to control the input and output of the Command Line. */
class UIController {
    private static Console console = System.console();

    public static void clearScreen () {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static void flushScreen () {
        console.flush();
    }

    public static String getCommand (Scanner input) {
        System.out.print("\n ~| ");
        return input.nextLine();
    }

    public static void printHelp () {
        System.out.println("\n" + "Command List: ");
        System.out.println("\t+ log     -- Log a student for the week");
        System.out.println("\t+ check   -- Display the number of times a student has checked in");
        System.out.println("\t+ erase   -- Clear the log");
        System.out.println("\t+ clear   -- Clear the screen");
        System.out.println("\t+ quit    -- Quit the LibraryLogger");
    }

    // the width of the screen is 80, height 25.
    public static void printLogo () {
        String logo = 
            "\n" +
            "\n" +
            "     _     _ _                            _"                                        + "\n" +
            "    | |   (_) |                          | |"                                       + "\n" +                        
            "    | |    _| |__  _ __ __ _ _ __ _   _  | |     ___   __ _  __ _  ___ _ __"        + "\n" +
            "    | |   | | '_ \\| '__/ _` | '__| | | | | |    / _ \\ / _` |/ _` |/ _ \\ '__|"    + "\n" +
            "    | |___| | |_) | | | (_| | |  | |_| | | |___| (_) | (_| | (_| |  __/ |"          + "\n" +   
            "    \\_____/_|_.__/|_|  \\__,_|_|   \\__, | \\_____/\\___/ \\__, |\\__, |\\___|_|"  + "\n" +  
            "                                   __/ |               __/ | __/ |"                 + "\n" +          
            "                                  |___/               |___/ |___/"                  + "\n";

        System.out.print(
            logo + 
            "\n\n\n" + 
            "\t\t\t    " + 
            "Type enter to start...\n\n\t\t\t\t  | ");
    }
}
