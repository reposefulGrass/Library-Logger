/*
|* Author -- Leigh Wingo                          
|*                                                 
|* Date -- 3/19/2017 (m/d/y)                       
|*                                                
|* Usage -- Either run the batch file that comes with with file or 
|*     compile/run the LibraryLogger class    
|*                                                  
|* Purpose -- To log the students that come into the library. (with pretty CLI)                
*/

/* NOTES
|*      - Transfer the printHelp and printLogo methods to the LibraryLogger class.
*/

import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class LibraryLogger {
    public static void main (String... args) throws NoSuchMethodError {
        // Input from the command line.
        Scanner input = new Scanner(System.in);
        String command = "";

        UIController.printLogo();

        // Simply take any input.
        //input.next(); <--- remove?
        input.nextLine();
        UIController.clearScreen();

        System.out.println("Type 'help' to see a list of commands.");

        //command = UIController.getCommand(input).toLowerCase();
        while (!(command.equals("quit"))) {
            command = UIController.getCommand(input).toLowerCase().trim();
            
			switch (command) {
                case "quit": 
                    break;

                case "help": 
                    UIController.printHelp();
                    break;

                case "log":  
                    log(input);
                    break;

                case "check":
                    try {
                        checkId();
                    } catch (FileNotFoundException error) {
                        System.out.println("Could not find log.dat");
                    }
                    break;

                case "erase":
                    try {
                        eraseLog();
                    } catch (IOException error) {
                        System.out.println(error);
                    }
                    break;
                
                case "clear":  
                    UIController.clearScreen();
                    System.out.println("Type 'help' to see a list of commands.");
                    break;

                default:
                    System.out.printf("Command '%s' was not found!\n", command); 
                    break;
            }
        }
    }

    public static void checkId () throws FileNotFoundException {
        int count = 0;

        System.out.print("\nEnter an ID ~| ");
        String id = input.nextLine();

        count = getIdCount(id);
        String plural = (count > 1 || count == 0) ? "times" : "time";

        System.out.printf("The ID %s was found %d %s\n", id, count, plural);
    }

    public static int getIdCount (String id) throws FileNotFoundException {
        Scanner file = new Scanner(new File("log.dat"));
        int count = 0;

        while (file.hasNextLine()) {
            String tempId = file.nextLine();
            if (id.equals(tempId)) {
                count++;
            }
        }

        return count;
    }

    public static void eraseLog () throws IOException {
        FileWriter anon = new FileWriter("log.dat");
        anon.close();
    }

    public static void log (Scanner input) {
        System.out.print("\nEnter an ID ~| ");
        String id = input.nextLine();

        if (isValidId(id)) {
            final boolean APPEND = true;
            final boolean OUTPUT_PER_PRINT = true;
            PrintWriter output = null;

            try {
                output = new PrintWriter(
                    new FileWriter("log.dat", APPEND), OUTPUT_PER_PRINT);
            } catch (IOException error) {
                System.out.println(error);
            } finally {
                if (output != null) {
                    output.println(id);
                    output.close();
                }
            }
        } else {
            System.out.println("The Id was not valid.");
        }
    }

    public static boolean isValidId (String id) {
        return id.matches("\\d+");
    }
}
