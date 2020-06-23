import java.util.*;

public class Solution {

    public static void downHeapify(int[] arr, int st, int n){
        int parentIndex = st;
        int leftChild = 2 * parentIndex + 1;
        int rightChild = leftChild + 1;
        
        while(leftChild < n)
        {
            int minIndex = parentIndex;
            
            if(arr[leftChild] < arr[minIndex])
            {
                minIndex = leftChild;
            }
            
            if(rightChild<n && arr[rightChild]<arr[minIndex])
            {
                minIndex = rightChild;
            }
            
            if(minIndex == parentIndex)
            {
                return;
            }
            
            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;
            
            parentIndex = minIndex;
            leftChild = 2 * parentIndex + 1;
        	rightChild = leftChild + 1;
        }
    }
    
    
	public static void inplaceHeapSort(int input[]) {
		//build the heap
        int n = input.length;
        
        for(int i=(n/2)-1; i>=0; i--)
        {
            downHeapify(input, i, n);
        }
        
        //swap elements from starting and respective last index one by one
        for(int i=n-1; i>=0; i--)
        {
            int temp = input[i];
            input[i] = input[0];
            input[0] = temp;
            
            downHeapify(input, 0, i);
        }
	}
}