package testApp3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Repository<T> {
	public void save(T t) {
		var clazz = t.getClass();
		
		var fields = clazz.getDeclaredFields();
		
		for(var field : fields) {
			
			var annotations = field.getAnnotationsByType(Field.class);
			if(annotations.length == 0) {
				continue;
			}
			
			var fieldName = annotations[0].value();
			var isKey = annotations[0].isKey();
			
			System.out.println("fieldName: " + fieldName + ", " + "isKey: " + isKey);
		}
		
		/*
		var fieldList = Arrays
			.stream(fields)
			.filter(f -> f.getAnnotationsByType(Field.class).length > 0)
			.collect(Collectors.toList());
		
		System.out.println(fieldList);
		*/
	}
}
