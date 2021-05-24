import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class ProcessManager{
	public static void main(String[] args)
	{
		try
		{	
			//know args number
			int argsCount = args.length;
			//if have no args, options appear 1 to 7. else, help.
			if(argsCount > 0 && ("--help".equals(args[0]) || "-h".equals(args[0])))
			{
				System.out.println("\nProcess manager help!\n"+
						"This process manager is used to manage processes, list, display, run, stop and send segnals to processes.\n"+
						"Write ProcessManager -h or ProcessManager --help to get help or man processManager for user manual.\n"+
						"It is developed by: @Dest team.");
			} else {
				Scanner input = new Scanner(System.in);
				int operation;
				String command ="";
				Process proc;
				BufferedReader reader;
				String line ="";
				//program functions
				do{
					System.out.println("\nAvaliable options are:\n"+
						"1. List all the processes in the system.\n"+//Ahmed
						"2. List all the processes in the system.\n"+//Omnia
						"3. Display process ID of all processes.\n"+//Rewaa
						"4. Run a specific process.\n"+//Sara
						"5. Stop a specific process.\n"+//Sara
						"6. Send specific signals to specific process.\n"+//Sara
						"7. Exit.");
					System.out.print("Enter the number of operation you want: ");
					operation = input.nextInt();
					switch (operation)
					{
						case 1:
							command = "ps ax";
							proc = Runtime.getRuntime().exec(command);
							reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
							line = "";
							while((line = reader.readLine()) != null) {
								System.out.print(line + "\n");
							}
							proc.waitFor();
							break;
						case 2:
							command = "ps aux";
							proc = Runtime.getRuntime().exec(command);
							reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
							line = "";
							while((line = reader.readLine()) != null) {
								System.out.print(line + "\n");
							}
							proc.waitFor();
							break;
	case 3: 
	break;
	case 4: 
	break;
	case 5: 
	break;
	case 6: 
	break;
	case 7:	
	System.exit(0);	
	break;
						default: System.out.println("The number is incorrect.");
					}
				}while (operation != 7);
			}
		} catch (Exception e){
			System.out.println("Exception found: "+e);
		}
	}
}

