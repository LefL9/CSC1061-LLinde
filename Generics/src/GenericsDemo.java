import java.util.ArrayList;
import java.util.List;

public class GenericsDemo {
	public static void main(String[] args) {
		List<String> colors = new ArrayList<>();

		colors.add("Red");
		colors.add("Apple");

		List<Integer> ints = new ArrayList<>();
		Integer num1 = Integer.valueOf(5);
		ints.add(num1);

		// auto boxing
		ints.add(6);
		// auto unboxing
		int inum = num1;
		//System.out.println(inum);
		
		
		List<Double> dbs = new ArrayList<>();
		dbs.add(Double.valueOf(3.4));
		dbs.add(3.4);
		
		ReverseList<Integer> intList = new ReverseList<>();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		
		for(Integer i: intList.getList()) {
			System.out.println(i);
		}
		
		ReverseList<String> strList = new ReverseList<>();
		strList.add("six");

	}
}
