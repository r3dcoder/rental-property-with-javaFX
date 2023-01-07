package helper;

import java.lang.reflect.Field;

public class ObjectFieldValidation {

	public ObjectFieldValidation() {
		// TODO Auto-generated constructor stub
	}

	public boolean allFieldsAreNotNull(Object obj) {
		for (Field field : obj.getClass().getDeclaredFields()) {
			field.setAccessible(true); // Make the field accessible, even if it is private
			try {
				if (field.get(obj) == null) {
					// The field is null
					return false;
				}
			} catch (IllegalAccessException e) {
				// Log the exception or do something else here
				e.printStackTrace();
			}
		}
		// All fields are not null
		return true;
	}
}
