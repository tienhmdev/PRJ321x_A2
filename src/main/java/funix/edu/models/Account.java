package funix.edu.models;

public class Account {
	public static final int ADMIN_ROLE = 1;
	public static final int MEMBER_ROLE = 2;
	
	private String userMail;
	private String password;
	private int role;
	private String name;
	private String address;
	private String phone;


	public Account(String username, String password) {
		super();
		this.userMail = username;
		this.password = password;
	}

	public Account(String username, String password, String name, String address, String phone) {
		super();
		this.userMail = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getUsername() {
		return userMail;
	}

	public String getPassword() {
		return password;
	}

	public int getRole() {
		return role;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setUsername(String username) {
		this.userMail = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
