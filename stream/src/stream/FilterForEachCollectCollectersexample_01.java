package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterForEachCollectCollectersexample_01 {
	public static void main(String[] args) {
		List<Integer> numberList=Arrays.asList(10,15,20,25,30);
		List<Integer> evenNumberList= new ArrayList<Integer>();
		
		evenNumberList=numberList.stream().filter(n->n%2==0).collect(Collectors.toList());
		System.out.println(evenNumberList);
		
		System.out.println("==============");
		
		numberList.stream().filter(n->n%2==0).forEach(System.out::println);
		
		System.out.println("==============");
		
		numberList.stream().filter(n->n%2==0).forEach(n->System.out.println(n));
		
		System.out.println("==============");
		
		List<String> names= Arrays.asList("Melisesndre","sansa","Jon","Daenerys","Jeffery");
		List<String> longNames = new ArrayList<String>();
		
		longNames = names.stream().filter(str->str.length()>6).collect(Collectors.toList());
		System.out.println(longNames);
		
		System.out.println("==============================");
		
		names.stream().filter(str->str.length()>6).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("==============================");
		
		List<String> namesWithNull= Arrays.asList("Melisesndre",null,"sansa",null,"Jon",null,"Daenerys",null,"Jeffery", null);
		List<String> namesWithNoNull= new ArrayList<String>();
		
		namesWithNoNull = namesWithNull.stream().filter(n->n!=null).collect(Collectors.toList());
		System.out.println(namesWithNoNull);
		System.out.println("==============================");
		namesWithNull.stream().filter(n->n!=null).collect(Collectors.toList()).forEach(System.out::println); //print only name
		System.out.println("==============================");
		namesWithNull.stream().filter(n->n==null).collect(Collectors.toList()).forEach(System.out::println); //print only null
		System.out.println("==============================");
		namesWithNull.stream().filter(n->n==null).forEach(System.out::println); //print only null
		System.out.println("==============================");
		namesWithNull.stream().filter(n->n==null).forEach(n->System.out.println(n)); //print only null
		System.out.println("==============================");
	}

}
