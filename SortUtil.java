package com.example.demo.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {//降序排列
	/** 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	 *对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
	 * 针对所有的元素重复以上的步骤，除了最后一个。
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 *   
	 */  
	public static int[] bubbleSortDesc(int[] numbers) { 
	    int temp; // 记录临时中间值   
	    int size = numbers.length; // 数组大小   3
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers[i] < numbers[j]) { // 交换两数的位置   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	            }   
	        }   
	    }
		return numbers;  
}
	/** 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	 *对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
	 * 针对所有的元素重复以上的步骤，除了最后一个。
	 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	 *   
	 */  
	public static List<Integer> bubbleSortDescLsit(List<Integer> numbers) {  		
	    int temp; // 记录临时中间值   
	    int size = numbers.size(); // 数组大小   3
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers.get(i) < numbers.get(j)) { // 交换两数的位置   
	                temp = numbers.get(i);   
	                numbers.set(i, numbers.get(j));  
	                numbers.set(j, temp);  
	            }   
	        }   
	    }
		return numbers;  
}
	
	public static int[] bubbleSortAsc(int[] numbers) {   
	    int temp; // 记录临时中间值   
	    int size = numbers.length; // 数组大小   3
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers[i] > numbers[j]) { // 交换两数的位置   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	            }   
	        }   
	    }
		return numbers;  
}
	
	/**
	 * 从数列中挑出一个元素，称为“基准”.
	 *重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，  
	 * 该基准是它的最后位置。这个称为分割（partition）操作。  
	 * 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。  
	 */  
	public static int[] quickSortDesc(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; // 记录临时中间值   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] > base) && (i < end))   
	                i++;   
	            while ((numbers[j] < base) && (j > start))   
	                j--;   
	            if (i <= j) {   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        } while (i <= j);   
	        if (start < j)   
	            quickSortDesc(numbers, start, j);   
	        if (end > i)   
	            quickSortDesc(numbers, i, end);   
	    }
	    return numbers;
	}
	
	/**
	 * 从数列中挑出一个元素，称为“基准”.
	 *重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分割之后，  
	 * 该基准是它的最后位置。这个称为分割（partition）操作。  
	 * 递归地把小于基准值元素的子数列和大于基准值元素的子数列排序。  
	 */  
	public static int[] quickSortAsc(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）   
	        int temp; // 记录临时中间值   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] < base) && (i < end))   
	                i++;   
	            while ((numbers[j] > base) && (j > start))   
	                j--;   
	            if (i <= j) {   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        } while (i <= j);   
	        if (start < j)   
	        	quickSortAsc(numbers, start, j);   
	        if (end > i)   
	        	quickSortAsc(numbers, i, end);   
	    }
	    return numbers;
	}
	
	public static Integer[] sortArrays(Integer[] numbers){
		Arrays.sort(numbers, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2){//如果前者的学号大于后者的学号，就是前者大于后者，返回1系统就会识别是前者大于后者，由于要降序就反过来
					return -1;
				}
				if(o1<o2){ //小于同理  
					return 1;
				}
				return 0;
			}
		});
		return numbers;	
	}
	
	public static List<Integer> sortList(List<Integer> list){
		Collections.sort(list, new Comparator<Integer>() {//降序

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2){//如果前者的学号大于后者的学号，就是前者大于后者，返回1系统就会识别是前者大于后者，由于要降序就反过来
					return -1;
				}
				if(o1<o2){ //小于同理  
					return 1;
				}
				return 0;
			}
		});
		return list;
		
	} 
	
	public static void main(String[] args) {
		Integer str[]={1,8,6,4};
		//quickSortDesc(str, 0, 3);
		sortArrays(str);
		for(int a:str){
			System.out.println(a);
		}
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(85);
		list.add(2);
		list.add(32);
		//bubbleSortDescLsit(list);
		
	/*	TreeSet<Integer> hs = new TreeSet<Integer>();//TreeSet有序，且为升序，不允许重复值
		hs.add(1);
		hs.add(10);
		hs.add(10);
		hs.add(2);
		hs.add(100);
		for(int a:hs){
			System.out.println(a);
		}*/
		Collections.sort(list, new Comparator<Integer>() {//降序

			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1>o2){//如果前者的学号大于后者的学号，就是前者大于后者，返回1系统就会识别是前者大于后者，由于要降序就反过来
					return -1;
				}
				if(o1<o2){ //小于同理  
					return 1;
				}
				return 0;
			}
		});
		
		for(int a:list){
			//System.out.println(a);
		}
	}
}
