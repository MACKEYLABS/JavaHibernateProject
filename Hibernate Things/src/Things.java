import java.util.Scanner;

public class Things {
	public static void main(String[] args) {
		
try {
    Scanner scnr = new Scanner(System.in);
	
    ThingsList thingsList = new ThingsList(); 
    System.out.println("Welcome to my Things List Program!");
    System.out.println("Enter a number from the choices below: ");
    
    while (true) {
        if (thingsList.getListSize() > 0) {
            System.out.println();
        }

        System.out.println("1. Add an Item");
        System.out.println("2. Delete an Item");
        System.out.println("3. List the Items");
        System.out.println("4. Exit the Program");
        
        int option = scnr.nextInt();
        //scnr.nextLine(); 
        System.out.println(scnr.nextLine()); 
        
        switch (option) { 
   
            case 1:
                System.out.print("Enter the item name: ");
                String item = scnr.nextLine();
                thingsList.add(item);
                break;
       
            case 2:
                System.out.print("Enter the item id you want to delete: ");
                int id = Integer.parseInt(scnr.nextLine());
                thingsList.delete(id); 
                break;
                
            case 3:
                thingsList.list();
                break;
                
            case 4:
                System.exit(0);
                
            default:
                System.out.println("Invalid option!");
                System.out.println("Please select a number from the display options:");
                break;
            	}    
    	}
    
	} catch (NumberFormatException e){
    	System.out.println("Uh Oh, you entered a letter instead of a number!");
    	main(args);
    }
  }
}

