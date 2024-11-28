package testApp2;

import java.util.Arrays;
import java.util.Date;

class User {
	public int id;
}

class Employee extends User {
	public String name;
	private String password;
	
	private void calculateSalary() {
		
	}
	
	private boolean setUpdated(Date updated) {
		return true;
	}
}

public class App {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException, NoSuchMethodException {

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
		
		
		var nameField = clazz.getField("name");
		System.out.println(nameField);
		
		System.out.println();
		System.out.println();
		
		var setUpdatedMethod = clazz.getDeclaredMethod("setUpdated", Date.class);
		System.out.println(setUpdatedMethod);
		
		var methodExists = Arrays.stream(clazz.getDeclaredMethods()).anyMatch(m -> m.getName().equals("setUpdated"));
		System.out.println(methodExists);
	}
}
