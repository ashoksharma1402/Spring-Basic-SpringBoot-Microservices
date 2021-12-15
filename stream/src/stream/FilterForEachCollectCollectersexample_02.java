package stream;

import java.util.ArrayList;
import java.util.List;

class Product{
	Integer id;
	String name;
	double price;

	public Product(Integer id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class FilterForEachCollectCollectersexample_02 {

	public static void main(String[] args) {
		
		List<Product> productList=new ArrayList<Product>();
		
		productList.add(new Product(1, "HP", 25000));
		productList.add(new Product(2, "DELL", 30000));
		productList.add(new Product(3, "LENOVO", 28000));
		productList.add(new Product(4, "SONY", 23000));
		productList.add(new Product(5, "APPLE", 90000));
		
		productList.stream()
					.filter(prod->prod.price>25000)
					.forEach(prod->System.out.println(prod.price));
	}
}
