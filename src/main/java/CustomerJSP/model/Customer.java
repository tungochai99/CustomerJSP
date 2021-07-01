package CustomerJSP.model;

public class Customer {
	private int code;
	private String name;
	private String address;
	private String email;
	
	public Customer() {
		
	}

	public Customer(int code, String name, String address, String email) {
		super();
		this.code = code;
		this.name = name;
		this.address = address;
		this.email = email;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
