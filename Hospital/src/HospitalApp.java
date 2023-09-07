import java.util.Scanner;

public class HospitalApp {
    public static void main(String[] args) {
        final int exit = 0;
        final int addPatient = 1;
        final int printPatient= 2;
        Scanner input = new Scanner(System.in);
        int option = -1;

        Hospital hospital = new Hospital();


        while (option != exit){
            System.out.println("Dostępne opcje");
            System.out.println(exit + " - Wyjście z programu" );
            System.out.println(addPatient + " - Dodaj pacjenta");
            System.out.println(printPatient + " - Wyświetl listę pacjentów");

            System.out.println("Wybierz opcję");
            option = input.nextInt();
            input.nextLine();


            switch (option) {
                case addPatient:
                    Patient patient = new Patient();
                    System.out.println("Imię");
                    patient.setFirstname(input.nextLine());
                    System.out.println("Nazwisko");
                    patient.setLastname(input.nextLine());
                    System.out.println("PESEL:");
                    patient.setPesel(input.nextLine());
                    hospital.addPatient(patient);
                    break;

                case printPatient:
                    hospital.printPatients();
                    break;
                case exit:
                    System.out.println("Zamykam program");
                    break;
                default:
                    System.out.println("Nie prawidłowa opcja");

            }
        }
                input.close();
    }
}
