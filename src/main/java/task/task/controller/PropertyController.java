package task.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import task.task.model.Property;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

	private List<Property> properties = Arrays.asList(
			new Property(1, "123 Main St", "Springfield", "IL", 250000.00, 1500.0),
			new Property(2, "456 Oak Ave", "Fairfield", "CA", 320000.00, 1800.0),
			new Property(3, "789 Pine Dr", "Austin", "TX", 200000.00, 1400.0),
			new Property(4, "321 Maple Ln", "Orlando", "FL", 270000.00, 1600.0),
			new Property(5, "654 Cedar St", "Seattle", "WA", 300000.00, 1900.0));

	@GetMapping("/{id}")
	public ResponseEntity<Property> getPropertyById(@PathVariable Integer id) {
		Optional<Property> property = properties.stream().filter(p -> p.getId().equals(id)).findFirst();

		if (property.isPresent()) {
			return new ResponseEntity<>(property.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Property> createProperty(@RequestBody Property property) {
		properties.add(property);
		return new ResponseEntity<>(property, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Property> updateProperty(@PathVariable Integer id, @RequestBody Property updatedProperty) {
		Optional<Property> existingProperty = properties.stream().filter(property -> property.getId().equals(id))
				.findFirst();

		if (existingProperty.isPresent()) {
			Property property = existingProperty.get();
			property.setAddress(updatedProperty.getAddress());
			property.setCity(updatedProperty.getCity());
			property.setState(updatedProperty.getState());
			property.setPrice(updatedProperty.getPrice());
			property.setAreaInSqFt(updatedProperty.getAreaInSqFt());

			return new ResponseEntity<>(property, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProperty(@PathVariable Integer id) {
		boolean isRemoved = properties.removeIf(property -> property.getId().equals(id));

		if (isRemoved) {
			return new ResponseEntity<>("Property deleted successfully", HttpStatus.OK);
		}

		return new ResponseEntity<>("Property not found", HttpStatus.NOT_FOUND);
	}
}
