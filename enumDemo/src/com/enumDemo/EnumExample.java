package com.enumDemo;

public class EnumExample {

	 public static void main(String[] args) {
	        // Create a variable of type AccessLevel
	        AccessLevel level = AccessLevel.ADMIN;  // AccessLevel is the type, an enum (a bit like a class that just holds constants)
	                                                                                               // -  level is the declared var (which isn't variable Lol) that holds the constant -  ADMIN is the constant value
            System.out.println("\n-----------------------------------Example 1------------------------------------------------\n");
	        // Print the access level and its description
	        System.out.println("Access Level: " + level);  //Print the value of the enum referenced by "level"
	   //    System.out.println("Description: " + level.getDescription()); //Print the result of the getDescription() method of the enum AccessLevel - referenced by "level"
	        
	        
            System.out.println("\n-------------------------------Example 2---------------------------------------\n");
            	        // Use a switch statement to handle different access levels - Alternative descriptions determined by a switch - defined here rather than in the AccessLevel enum structure
	        switch (level) {
	            case ADMIN:
	                System.out.println("You have all permissions.");
	                break;
	            case USER:
	                System.out.println("You have limited permissions.");
	                break;
	            case GUEST:
	                System.out.println("You have minimal permissions.");
	                break;
	            default:
	                System.out.println("Invalid access level.");
	                break;
	        }
            System.out.println("\n---------------------------Example 3-----------------------------------------\n");
            	        // List all access levels using values() method
	        System.out.println("\nAvailable Access Levels:");
	        for (AccessLevel access : AccessLevel.values()) {    // .values() is a predefined method of enum - treats the enum structure a bit like an Array
	          System.out.println(access + ": " + access.getDescription()); // Loop through all the possible values of the AccessLevel enum structure and print them out by repeatedly calling getDescription() method
	        }
	        
            System.out.println("\n---------------------------Example 4-----------------------------------------\n");
            	        // Using ordinal() method
	        System.out.println("Ordinal of " + level + ": " + level.getOrdinal());  //.getOrdinal() returns the position of the value being used in the enum structure - again a bit like an Array
	        //This method returns the ordinal (position) of the enum constant, which is the zero-based index position  so in this example ( 0 is ADMIN, 1 is USER and 2 is  Guest)
	        
	        System.out.println("\n---------------------------Example5----------------------------------------------\n");
	        	        // Check if one level is higher than another
	        AccessLevel anotherLevel = AccessLevel.USER;
	      System.out.println(level + " is higher than " + anotherLevel + ": " + level.isHigherThan(anotherLevel)); // .isHigherThan()  is a predefined method that compares the ordinals of the enum values
	        
	        System.out.println("\n---------------------------Example 6------------------------------------------\n");
	        	     // Using valueOf() method to get enum from string
	        String levelName = "GUEST";
	        try {
	        AccessLevel retrievedLevel = AccessLevel.valueOf(levelName);  //.valueOf(String n)  is a predefined method of enum that takes a string n and tries to find a matching value or thows an illegalArgumentException
	        System.out.println("Retrieved Access Level from string: " + retrievedLevel);
	       System.out.println("Description: " + retrievedLevel.getDescription());
	        }catch(IllegalArgumentException e){e.printStackTrace();}
	        
	        System.out.println("\n------------------------------Example 7-------------------------------------\n");
	        	        // List all access levels using values() method
	        System.out.println("\nAvailable Access Levels:");
	        for (AccessLevel access : AccessLevel.values()) { //Using for each loop and .getDescription() method of the enum structure to print out access levels of each constant
	         System.out.println(access + ": " + access.getDescription()); 
	        }
	        System.out.println("\n----------------------------------End--------------------------------------------\n");
	   
	 int x = 3;
	 switch(x) {
	 case 1:
		 System.out.println("Choice one");
		 break;
	 case 2:
		 System.out.println("Choice two");
		 break;
	 case 3:
		 System.out.println("This one should print");
		 break;
		default:
			 System.out.println("Oops!");
	 	}
	 
	 }//end of main
	 
	}//end of class