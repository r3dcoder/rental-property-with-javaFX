package property.models;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String postcode;
    private String password;

    public User(String firstName, String lastName, String email, String postcode, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.postcode = postcode;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPassword() {
        return password;
    }
}

