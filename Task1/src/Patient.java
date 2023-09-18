class Patient {
    private String firstName;
    private String lastName;
    private String pesel;
    private String idNumber;
    private String gender;

    public Patient(String firstname, String lastname, String pesel,
                   String idNumber, Gender gender) {

        this.firstName = firstname;
        this.lastName = lastname;
        this.pesel = pesel;
        this.idNumber = idNumber;


    }

    public String getFirstName() {  return firstName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



}

