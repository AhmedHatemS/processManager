import java.util.*;
import java.lang.*;
import java.io.*; //BufferedReader, InputStreamReader;

class ProcessManager {
    Scanner input;
    int operation;
    String pid = "";
    String signals = "";
    String command = "";
    String line = "";
    Process proc;
    BufferedReader reader;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        try {
            //know args number
            int argsCount = args.length;
            //if have no args, options appear 1 to 7. else, help.
            if (argsCount > 0 && ("--help".equals(args[0]) || "-h".equals(args[0]))) {
                System.out.println("\nProcess manager help!\n" +
                        "This process manager is used to manage processes, list, display, run, stop and send segnals to processes.\n" +
                        "Write ProcessManager -h or ProcessManager --help to get help or man processManager for user manual.\n" +
                        "It is developed by: @Dest team.");
            } else {
                //program functions
                do {
                    System.out.println("\nAvaliable options are:\n" +
                            "1. List all the processes in the system.\n" +//Ahmed
                            "2. List all the processes in the system.\n" +//Omnia
                            "3. Display process ID of all processes.\n" +//Sara
                            "4. Run a specific process.\n" +//Sara
                            "5. Stop a specific process.\n" +//Sara
                            "6. Send specific signals to specific process.\n" +//Rewaa
                            "7. Exit.");
                    System.out.print("Enter the number of operation you want: ");
                    operation = input.nextInt();
                    switch (operation) {
                        case 1:
                            listAllProcesses();
                            break;
                        case 2:
                            listAllProcessesGrouped();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            sendSignalToProcess();
                            break;
                        case 7:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("The number is incorrect.");
                    }
                } while (operation != 7);
            }
        } catch (Exception e) {
            System.out.println("Exception found: " + e);
        }
    }

    private static void listAllProcesses() {
        command = "ps ax";
        proc = Runtime.getRuntime().exec(command);
        reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        proc.waitFor();
    }

    private static void listAllProcessesGrouped() {
        command = "ps aux";
        proc = Runtime.getRuntime().exec(command);
        reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        proc.waitFor();
    }

    private static void sendSignalToProcess() {
        listAllProcesses();
        System.out.println();
        System.out.print("Enter process id: ");
        pid = input.nextLine();
        printAllSignals();
        System.out.print("Enter signals number: ");
        signals = input.nextLine();
        command = "kill -" + signals + " " + pid;
        proc = Runtime.getRuntime().exec(command);
        reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        line = "";
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        proc.waitFor();
    }

    public static void printAllSignals() {
        command = "kill -l";
        proc = Runtime.getRuntime().exec(command);
        reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        proc.waitFor();
    }
}