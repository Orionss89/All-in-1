public class Patient {
    private String firstname;
    private String lastname;
    private String pesel;

    public Patient(String firstname, String lastname, String pesel) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pesel = pesel;
    }

    public Patient() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

}
