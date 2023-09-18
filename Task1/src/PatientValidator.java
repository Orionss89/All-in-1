

class PatientValidator {
    public static boolean validateName(String name) {
        return name.matches("^[a-zA-Z]+$");
    }
    public static boolean validatelastName(String lastname) {
        return lastname.matches("^[0-9]{11}$");
    }


}
