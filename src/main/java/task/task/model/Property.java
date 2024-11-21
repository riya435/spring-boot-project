package task.task.model;

public class Property {
	private Integer id;
	private String address;
	private String city;
	private String state;
	private Double price;
	private Double areaInSqFt;

	// Constructors
	public Property() {
	}

	public Property(Integer id, String address, String city, String state, Double price, Double areaInSqFt) {
		this.id = id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.price = price;
		this.areaInSqFt = areaInSqFt;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getAreaInSqFt() {
		return areaInSqFt;
	}

	public void setAreaInSqFt(Double areaInSqFt) {
		this.areaInSqFt = areaInSqFt;
	}
}