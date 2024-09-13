package com.cestar.view;

import java.util.Scanner;

import com.cestar.controller.Controller;

/**
 * The UserMenu class provides a user interface for interacting with the Library Management System.
 * @author Jhansi Saranu , Sunitha Thota , Venkata Mani Krishna Lam , Sree Harsha Guntamadugu.
 */
public class UserMenu {
	
	/**
	 * The main method starts the UserMenu application.
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {
		
		Controller controller = new Controller();
		
		Scanner scanner = new Scanner(System.in);
		
		int userChoice = 0;
		
		while(userChoice != 6) {
			
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("========================== Please Select From the Following Options ===================");
			System.out.println("========================== Enter 1 to Display All Records         ===================");
			System.out.println("========================== Enter 2 to Insert a New Record         ===================");
			System.out.println("========================== Enter 3 to Find Record by Id            ===================");
			System.out.println("========================== Enter 4 to Delete Record by Id          ===================");
			System.out.println("========================== Enter 5 to Update Record by Id          ===================");
			System.out.println("========================== Enter 6 to Exit the Application        ===================");
			System.out.println("------------------------------------------------------------------------------------");
			
			userChoice = scanner.nextInt();
			
			switch(userChoice) {
			
			case 1: {
				controller.display();
				break;
			}
			
			case 2:{
				controller.insert();
				break;
			}
			case 3:{
				controller.findById();
				break;
			}
			
			case 4:{
				controller.delete();
				break;
			}
			
			case 5: {
				controller.updateById();
				break;
			}
			
			case 6:{
				System.out.println("Thank you for using the Library Management System!");
				System.exit(0);
			}
			
			default:{
				System.out.println("Invalid choice. Please select a valid option.");
				break;
			}
			
			}
			
			
		}
	}
}
