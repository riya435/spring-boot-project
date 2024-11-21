package task.task.validator;

import task.task.model.Property;

public class PropertyValidator {

	public static String validate(Property property) {
		if (property.getId() == null || property.getId() <= 0) {
			return "Invalid ID: ID must be a positive number.";
		}
		if (property.getAddress() == null || property.getAddress().isEmpty()) {
			return "Invalid Address: Address cannot be empty.";
		}
		if (property.getCity() == null || property.getCity().isEmpty()) {
			return "Invalid City: City cannot be empty.";
		}
		if (property.getState() == null || property.getState().isEmpty()) {
			return "Invalid State: State cannot be empty.";
		}
		if (property.getPrice() == null || property.getPrice() <= 0) {
			return "Invalid Price: Price must be greater than 0.";
		}
		if (property.getAreaInSqFt() == null || property.getAreaInSqFt() <= 0) {
			return "Invalid Area: Area in SqFt must be greater than 0.";
		}
		return null; // No validation errors
	}
}
