/**
 * Erick Williams
 * CS111
 * Coding Assignment 1
 * 2/12/16
 */
import java.util.Scanner;

public class ShoppingList 
{
	int maxSize;
	int currentSize;
	String[] list;
	Scanner input=new Scanner(System.in);
	
	public ShoppingList(int maxSize)
	{
		currentSize=0;
		list= new String[maxSize];
	}
	
	public int getCurrentSize()
	{
		return currentSize;
	}
	
	public int getMaxSize()
	{
		return maxSize;
	}
	
	public void insertAtEnd(String newItem)
	{
		list[currentSize]=newItem;
		currentSize++;
	}
	
	public void insertAtPosition(int position,String newItem)
	{
		for(int i=position;i<currentSize;i++)
		{
			String temp=list[position];
			list[position]=list[position+1];
			list[i+1]=temp;
		}
		list[position]=newItem;
		currentSize++;
	}
	
	public void deleteAtEnd()
	{
		System.out.println("Are you sure you want to delete "+list[currentSize-1]+"? Enter 'yes' or 'no'.");
		String response=input.nextLine();
		if(response.equals("yes"))
		{
			list[currentSize-1]=null;
			currentSize--;
			System.out.println("The last item has been deleted from the list!");
		}
	}
	
	public void deleteAtPosition(int position)
	{
		System.out.println("Are you sure you want to delete "+list[position-1]+"? Enter 'yes' or 'no'.");
		String response=input.nextLine();
		if(response.equals("yes"))
		{
			for(int i=position;i<currentSize;i++)
			{
				String temp=list[i];
				list[i]=list[i-1];
				list[i-1]=temp;
			}
			list[position]=null;
			currentSize--;
			System.out.println("The item has been deleted!");
		}
	}
	
	public void displayItemAt(int position)
	{
		System.out.println(list[position-1]);
	}
	
	public void displayList()
	{
		for(int i=0;i<currentSize;i++)
		{
			System.out.println(list[i]);
		}
	}
	
	public void sortList()
	{
         String temp;

         for(int i=0;i<currentSize-1;i++)
         {
             for(int j=0;j<currentSize-1;j++)
             {
            	 if(list[j].compareToIgnoreCase(list[j+1])>0)
                 {        
            		 temp=list[j];
                     list[j]=list[j+1];
                     list[j+1]=temp; 
                 } 
              } 
         } 
	}
	
	public void findItem(String name)
	{
		int check=0;
		for(int i=0;i<currentSize;i++)
		{
			if(list[i].equals(name))
			{
				System.out.println("\nThe item is at position "+(i+1)+".");
			}
			else
			{
				check++;
			}
		}
		if(check==currentSize)
		{
			System.out.println("The item cannot be found in the list.");		
		}
	}
}
