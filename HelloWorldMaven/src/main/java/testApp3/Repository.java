package testApp3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Repository<T> {
	public void save(T t) {
		var clazz = t.getClass();
		
		var fields = clazz.getDeclaredFields();
		
		var fieldList = Arrays
			.stream(fields)
			.filter(f -> f.getAnnotationsByType(Field.class).length > 0)
			.collect(Collectors.toList());
		
		System.out.println(fieldList);
		
	}
}
