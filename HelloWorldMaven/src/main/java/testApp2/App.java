package testApp2;

import java.lang.reflect.InvocationTargetException;
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

	public boolean setUpdated(int sequence) {

		System.out.println("setUpdated: " + sequence);

		return true;
	}
}

public class App {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
			NoSuchMethodException, IllegalAccessException, InvocationTargetException {

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

		System.out.println();
		System.out.println();

		// Checking if a method exists
		var setUpdatedMethod = clazz.getDeclaredMethod("setUpdated", int.class);
		System.out.println(setUpdatedMethod);

		var methodExists = Arrays.stream(clazz.getDeclaredMethods()).anyMatch(m -> m.getName().equals("setUpdated"));
		System.out.println(methodExists);

		System.out.println();
		System.out.println();

		// Calling a function
		setUpdatedMethod.invoke(new Employee(), 5);

		System.out.println();
		System.out.println();
		
		// Setting Fields
		var nameField = clazz.getField("name");
		var user = new Employee();
		nameField.set(user, "Pluto");
		System.out.println("Name of the user: " + user.name);

	}
}
