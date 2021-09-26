package com.greatlearning.stockersmain;
import com.greatlearning.stockersoperations.PricesSorting;
import java.util.*;
import com.greatlearning.stockersoperations.SpecificStockPrice;
public class Driver {

	public static void main(String[] args) {
		int rise=0;
		int decline=0;
		int k=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of companies:");
		int companies = sc.nextInt();
		
		double[] prices = new double[companies];
		int j=1;
		for (int i=0; i<companies; i++) {
		System.out.println("Enter Current stock price of the company"+j+ ":");
		prices[i] = sc.nextDouble();
		System.out.println("Whether company's stock price rose today compare yesterday?");
		boolean bn = sc.nextBoolean();
		if(bn == true) 
			rise = rise+1;
		
		else 
			decline = decline+1;
		j++;
	    }
		System.out.println(companies);
		
		
		System.out.println("Enter the operation that you want to perform");
		System.out.println("1. Display the companies stock prices in ascending order");
		System.out.println("2. Display the companies stock prices in descending order");
		System.out.println("3. Display the total no of companies for which stock prices rose today");
		System.out.println("4. Display the total no of companies for which stock prices declined today");
		System.out.println("5. Search a specific stock price");
		System.out.println("6. press 0 to exit");
		Scanner sc1 = new Scanner(System.in);
		int option = sc1.nextInt();
		
		switch(option) {
			case 1: 
				//Merge Sort
				System.out.println("Stock prices in ascending order are");
				PricesSorting ob = new PricesSorting();
				ob.ascOrder(prices, 0 , prices.length-1);
				System.out.println(Arrays.toString(prices));
				break;
			
			case 2:
				//Merge Sort and reverse of that for descending order
				System.out.println("Stock prices in descending order are");
				double[] descprice = new double[companies];
				PricesSorting ob1 = new PricesSorting();
				ob1.ascOrder(prices, 0 , prices.length-1);
				for(int i=companies-1; i>=0;i--) {
					descprice[k]=prices[i];
					k++;
				}
				System.out.println(Arrays.toString(descprice));
				break;
				
			case 3: 
				System.out.println("Total no. of comapanies whose stock price rose today: ");
				System.out.println(rise);
				break;
				
			case 4:
				System.out.println("Total no. of comapanies whose stock price declined today: ");
				System.out.println(decline);
				break;
				
			case 5: 
				//Binary Search after Merge Sorting
				PricesSorting ob2 = new PricesSorting();
				ob2.ascOrder(prices, 0 , prices.length-1);
				SpecificStockPrice ob3 = new SpecificStockPrice();
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter the key value");
				double x = sc2.nextDouble();
				int result = ob3.search(prices,0,companies-1,x);
				if (result == -1)
		            System.out.println("Stock of value "+x+" is not present");
		        else
		            System.out.println("Stock of value "+prices[result]+" is present");
				break;
				
			default:
				System.out.println("Exited Successfully");
				break;
		
		}
		

	}
}
