package customer.models;

import java.io.Serializable;

public class Customer implements Serializable  {
    private static final long serialVersionUID = 1L;
	private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String gender;

    public Customer(String firstName, String lastName, String email, String phoneNumber, String address, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.setGender(gender);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String toString() {
		String str = "First Name: " + firstName + " \n" ;
		str+="Last Name: " + lastName + " \n";
		str+="email: " + email + " \n";
		str+="address: " + address + " \n";
		str+="gender: " + gender + " \n";
		return str;
	}
}
