package testApp;

class User {

}

class Employee extends User {

}

public class App {
	public static void main(String[] args) throws ClassNotFoundException {

		var clazz1 = Employee.class;

		System.out.println(clazz1);

		var clazz2 = Class.forName("testApp.Employee");

		System.out.println(clazz2);

		User u = new Employee();

		var clazz3 = u.getClass();

		System.out.println(clazz3);

	}
}
