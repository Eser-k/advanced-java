package testApp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Repository<T> {
	public void save(T t) {
		var clazz = t.getClass();
		var classAnnotations = clazz.getAnnotationsByType(Entity.class);
		
		var tableName = clazz.getSimpleName().toLowerCase();
		
		if (classAnnotations.length > 0) {
			var tableNameAttribute = classAnnotations[0].value();
			
			if(tableNameAttribute.length() > 0) {
				tableName = tableNameAttribute;
			}
			
		}
		
		var fields = clazz.getDeclaredFields();

		ArrayList<String> fieldList = new ArrayList<>();
		
		for (var field : fields) {

			var annotations = field.getAnnotationsByType(Field.class);
			
			if (annotations.length == 0) {
				continue;
			}

			var columnName = annotations[0].columnName();
			var isKey = annotations[0].isKey();

			if (columnName.length() == 0) {
				columnName = field.getName();
			}
			
			if(!isKey) {
				fieldList.add(field.getName());
			}

			System.out.println("Table Name: " + tableName + ", " + "columnName: " + columnName + ", " + "isKey: " + isKey);
		}
		
		String sqlFields = fieldList.stream().collect(Collectors.joining(","));
		String sqlPlaceholders = fieldList.stream().map(s -> "?").collect(Collectors.joining(","));
		
		String sqlStatement = "INSERT INTO " + tableName + " (" + sqlFields + ") " + "values " + "(" + sqlPlaceholders + ");";
		System.out.println(sqlStatement);
		
		/*
		 * var fieldList = Arrays .stream(fields) .filter(f ->
		 * f.getAnnotationsByType(Field.class).length > 0)
		 * .collect(Collectors.toList());
		 * 
		 * System.out.println(fieldList);
		 */
	}
}
