package example;

import java.util.Arrays;

public class Activity4 {
    static void ascendingSort(int array[]) {
        // Sorting logic
        for (int i = 1; i < array.length; i++) {
            int key = array[i]; // Assign key
            int j = i - 1; // Assign value to compare with
            
            while (j >= 0 && key < array[j]) {
                // Swap if key is smaller
                array[j + 1] = array[j];
                j--;
            }
            // Move key to the next value
            array[j + 1] = key;
        }
    }
    
    public static void main(String args[]) {
        // Unsorted array
        int[] data = { 9, 5, 1, 4, 3 };
        // Pass the unsorted array to the sorting function
        ascendingSort(data);
        // Print sorted array
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
