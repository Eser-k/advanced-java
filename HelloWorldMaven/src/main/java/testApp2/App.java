package testApp2;

import java.util.Arrays;

class User {
	public int id;
}

class Employee extends User {
	public String name;
	private String password;
	
	private void calculateSalary() {
		
	}
}

public class App {
	public static void main(String[] args) throws ClassNotFoundException {

		var clazz = Employee.class;

		// Only shows public Fields
		System.out.println(Arrays.asList((clazz.getFields())));
		
		// Also shows private Fields
		System.out.println(Arrays.asList((clazz.getDeclaredFields())));
		
		System.out.println();
		
		// Only shows public Methods
		Arrays.asList(clazz.getMethods()).forEach(System.out::println);
		
		System.out.println();
		System.out.println();
		
		// Also shows private Methods
		Arrays.asList(clazz.getDeclaredMethods()).forEach(System.out::println);
	}
}
