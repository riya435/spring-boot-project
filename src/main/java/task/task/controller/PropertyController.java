package task.task.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import task.task.model.Property;
import task.task.validator.PropertyValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private List<Property> properties = new ArrayList<>(List.of(
            new Property(1, "123 Main St", "Springfield", "IL", 250000.00, 1500.0),
            new Property(2, "456 Oak Ave", "Fairfield", "CA", 320000.00, 1800.0),
            new Property(3, "789 Pine Dr", "Austin", "TX", 200000.00, 1400.0),
            new Property(4, "321 Maple Ln", "Orlando", "FL", 270000.00, 1600.0),
            new Property(5, "654 Cedar St", "Seattle", "WA", 300000.00, 1900.0)
    ));

    @PostMapping
    public ResponseEntity<Object> createProperty(@RequestBody Property property) {
        String validationError = PropertyValidator.validate(property);
        if (validationError != null) {
            return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST); // Return 400 if validation fails
        }

        if (properties.stream().anyMatch(p -> p.getId().equals(property.getId()))) {
            return new ResponseEntity<>("Property with the same ID already exists", HttpStatus.BAD_REQUEST);
        }

        properties.add(property);
        return new ResponseEntity<>(property, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProperty(@PathVariable Integer id, @RequestBody Property updatedProperty) {
        String validationError = PropertyValidator.validate(updatedProperty);
        if (validationError != null) {
            return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);
        }

        for (Property property : properties) {
            if (property.getId().equals(id)) {
                property.setAddress(updatedProperty.getAddress());
                property.setCity(updatedProperty.getCity());
                property.setState(updatedProperty.getState());
                property.setPrice(updatedProperty.getPrice());
                property.setAreaInSqFt(updatedProperty.getAreaInSqFt());
                return new ResponseEntity<>(property, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>("Property not found", HttpStatus.NOT_FOUND);
    }

    // Other methods (GET and DELETE) remain the same...
}
