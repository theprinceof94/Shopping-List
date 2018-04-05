/**
 * Erick Williams
 * CS111
 * Coding Assignment 1
 * 2/12/16
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class SLTester 
{
	public static void main(String[] args) 
	{
		boolean flag=false;
		Scanner input = new Scanner(System.in);
		int built=0;
		ShoppingList sL= new ShoppingList(0);
		
		while(flag==false)
		{
			System.out.println("\n");
			System.out.println("Welcome to Shopping List! Please choose an option below: ");
			System.out.println("To create a shopping list, enter (1).");
			System.out.println("To add an item to the end, enter (2).");
			System.out.println("To add an item at a position, enter (3).");
			System.out.println("To delete an item at the end, enter (4).");
			System.out.println("To delete an item at a position, enter (5).");
			System.out.println("To display an item at a position, enter (6).");
			System.out.println("To display your shopping list, enter (7).");
			System.out.println("To sort your shopping list alphabetically, enter (8).");
			System.out.println("To find the index of an item, enter (9).");
			System.out.println("To quit, enter (10).");
			
			int response=input.nextInt();
			
			try{
				
			if(response==1)
			{
				System.out.println("How large should the list be? Please enter a number.");
				int mS=input.nextInt();
				sL = new ShoppingList(mS);
				System.out.println("\nA new shopping list has been created!");
				built++;
			}
			else if(response==2&&built>0)
			{
				try{
				System.out.println("What item would you like to add?");
				Scanner input1=new Scanner(System.in);
				String nI=input1.nextLine();
				sL.insertAtEnd(nI);
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					System.out.println("\nThe list is full.");
				}
			}
			else if(response==3&&built>0)
			{
				System.out.println("What item would you like to add?");
				Scanner input2=new Scanner(System.in);
				String nI=input2.nextLine();
				
				System.out.println("What position would you like to add it to?");
				int pos=input2.nextInt();
				
				sL.insertAtPosition(pos-1,nI);
			}
			else if(response==4&&built>0)
			{
				sL.deleteAtEnd();
			}
			else if(response==5&&built>0)
			{
				System.out.println("What position would you like to delete? Please enter a number.");
				int pos=input.nextInt();
				sL.deleteAtPosition(pos);
			}
			else if(response==6&&built>0)
			{
				System.out.println("What position would you like to see? Please enter a number.");
				int pos=input.nextInt();
				sL.displayItemAt(pos);
			}
			else if(response==7&&built>0)
			{
				System.out.println("\nThis is your whole shopping list!");
				sL.displayList();
			}
			else if(response==8&&built>0)
			{
				System.out.println("This is your list in alphabetical order!");
				sL.sortList();
				sL.displayList();
			}
			else if(response==9&&built>0)
			{
				System.out.println("What item would you like to find the index of?");
				Scanner input3=new Scanner(System.in);
				String item=input3.nextLine();
				sL.findItem(item);
			}
			else if(response==10)
			{
				System.out.println("\nThank you for using Shopping List!");
				flag=true;
			}
			else
			{
				System.out.println("\nInvalid entry! Please try again. Note that a list must be made before any other operations may be performed.");
			}
			
			}
			
			catch(ArrayIndexOutOfBoundsException | InputMismatchException e)
			{
				System.out.println("\nInvalid entry. Try again.");
			}
		}
	}
}
