package com.greatlearning.stockersoperations;

public class PricesSorting {
	public void ascOrder(double[] prices, int left, int right) {
		if (left<right) {
			int mid = (left+right)/2;
			
			ascOrder(prices, left, mid);
			ascOrder(prices, mid+1, right);
			
			merge(prices, left, mid, right);
		}
	}
	
	void merge(double prices[],int left, int mid, int right) {
		int size1 = mid - left + 1;
		int size2 = right - mid;
		
		double l[] = new double [size1];
		double r[] = new double [size2];
		
		for(int i=0; i<size1; i++) {
			l[i]=prices[left+i];
		}
		
		for(int j=0;j<size2; j++) {
			r[j]=prices[mid+1+j];
		}
		
		int i=0 , j=0;
		
		int k = left;
		
		while(i<size1 && j<size2) {
			if(l[i]<=r[j]) {
				prices[k]=l[i];
				i++;
			}
			else {
				prices[k]=r[j];
				j++;
			}
			k++;
		}
		
		while(i<size1) {
			prices[k]=l[i];
			i++;
			k++;
		}
		
		while(i<size2) {
			prices[k]=r[j];
			j++;
			k++;
		}
	}
}
