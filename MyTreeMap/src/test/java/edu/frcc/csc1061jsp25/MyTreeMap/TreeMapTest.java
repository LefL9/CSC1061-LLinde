package edu.frcc.csc1061jsp25.MyTreeMap;

import java.util.Map;

public class TreeMapTest {

	public static void main(String[] args) {
		
		
		MyTreeMap<Integer, Integer> map = new MyTreeMap<>();
		map.put(8, 8);
		map.put(12, 12);
		map.put(4, 4);
		map.put(14, 14);
		map.put(10, 10);
		map.put(6, 6);
		map.put(2, 2);
		map.put(1, 1);
		map.put(3, 3);
		map.put(7, 7);
		map.put(5, 5);
		map.put(11, 11);
		map.put(9, 9);
		map.put(13, 13);
		map.put(15, 15);
		
		System.out.println("The value of key 6 " + map.get(6));
		
		for(Integer value : map) {
			System.out.print(value + " ");
		}
		System.out.println();
		
		System.out.println("\nRemoved key: 5");
		map.remove(5);
		for (Integer value : map) {
		    System.out.print(value + " ");
		}
		System.out.println("\n");

		System.out.println("Removed key: 6");
		map.remove(6);
		for (Integer value : map) {
		    System.out.print(value + " ");
		}
		System.out.println("\n");

		System.out.println("Removed key: 3");
		map.remove(3);
		for (Integer value : map) {
		    System.out.print(value + " ");
		}
		System.out.println("\n");

		System.out.println("Removed key: 4");
		map.remove(4);
		for (Integer value : map) {
		    System.out.print(value + " ");
		}
		System.out.println("\n");

		System.out.println("Removed key: 8");
		map.remove(8);
		for (Integer value : map) {
		    System.out.print(value + " ");
		}
		System.out.println();
	}

}
