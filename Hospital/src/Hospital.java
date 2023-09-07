public class Hospital {
    private final int maxPatientsNumber = 10;
    private Patient[] patients = new Patient[maxPatientsNumber];
    private int regPatients = 0;

    void addPatient (Patient patient) {
        if (regPatients < maxPatientsNumber) {
            patients[regPatients] = patient;
            regPatients++;
        }   else {
            System.out.println("Zapisano maksymalną liczbę pacjętów, zapraszamy jutro");
        }
    }

    void printPatients(){
        for (int i = 0; i <regPatients ; i++) {
            System.out.println(patients[i].getFirstname() + " "
                    + patients[i].getLastname() + " "
                    + patients[i].getPesel());

        }
    }
}
