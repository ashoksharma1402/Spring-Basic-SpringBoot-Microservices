package test;

import java.util.List;
import java.util.ArrayList;

public class Test {
public static void main(String args[])
{
List<String> mobiles = new ArrayList<String>();
mobiles.add("Redmi");
mobiles.add("Samsung");
mobiles.add("Realme");
mobiles.add("Apple");
System.out.println(mobiles);
//Redmi, Samsung, Realme, Apple
for(String phone : mobiles)
{
if(phone.equals("Redmi"))
{
mobiles.remove(phone);
//ArrayList remove() method
}
}
}
}