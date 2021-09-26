package com.greatlearning.stockersoperations;

public class SpecificStockPrice {

	public int search(double prices[], int left, int right, double x) {
		if(right>=left) {
			int mid = left + (right-left)/2;
			
			if(prices[mid] == x)
				return mid;
			
			if(prices[mid]>x)
				return search(prices,left,mid-1,x);
			
			return search(prices,mid+1,right,x);
		}
		
		return -1;
	}
}
