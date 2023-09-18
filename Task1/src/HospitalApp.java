import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HospitalApp {
    private static final int MAX_ATTEMPTS = 3;
    private static final int MAX_QUEUE_SIZE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalQueue hospitalQueue = new HospitalQueue(MAX_QUEUE_SIZE);

        while (hospitalQueue.getSize() < 2) {
            System.out.println("Dodawanie pacjenta " + (hospitalQueue.getSize() + 1));
            int currentAttempts = 0;
            String firstName = null;
            String lastName = null;

            // Loop to handle incorrect input for first name and last name
            while (currentAttempts < MAX_ATTEMPTS) {
                firstName = getInput(scanner, "Imię pacjenta:");
                lastName = getInput(scanner, "Nazwisko pacjenta:");
                if (PatientValidator.validateName(firstName) && PatientValidator.validateName(lastName)) {
                    break;
                } else {
                    System.out.println("Błąd imienia lub nazwiska nie używaj polskich znaków. Pozostało prób: " + (MAX_ATTEMPTS - currentAttempts - 1));
                }

                currentAttempts++;
                if (currentAttempts >= MAX_ATTEMPTS) {
                    System.out.println("Brak prób. Na dziś już wystarczy.");
                    return; // Zakończ pętlę, jeśli przekroczono maksymalną liczbę prób
                }
            }

            String pesel = getInput(scanner, "Pesel pacjenta:");
            String idNumber = getInput(scanner, "Seria i numer dowodu osobistego pacjenta (np. AB123456):");
            Gender gender = getGenderInput(scanner);

            if (gender != null) {
                Patient patient = new Patient(firstName, lastName, pesel, idNumber, gender);
                hospitalQueue.addPatient(patient);
                System.out.println("Pacjent dodany do kolejki.");
            } else {
                System.out.println("Błąd: Nieprawidłowa płeć. Wprowadź 'M' dla mężczyzny lub 'K' dla kobiety.");
            }
        }

        hospitalQueue.displayQueue();
        saveQueueToFile(hospitalQueue, "Lista pacjentów na dziś.txt");
        scanner.close();
    }

    private static Gender getGenderInput(Scanner scanner) {
        String genderInput = getInput(scanner, "Płeć pacjenta (M/K):").toUpperCase();
        try {
            return Gender.valueOf(genderInput);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private static void saveQueueToFile(HospitalQueue hospitalQueue, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Kolejka pacjentów:\n");
            for (int i = 0; i < hospitalQueue.getSize(); i++) {
                Patient patient = hospitalQueue.getPatient(i);
                writer.write("Pacjent " + (i + 1) + ": " + patient.getFirstName() + " " + patient.getLastName() +
                        " " + patient.getIdNumber() +  " " + patient.getPesel() + "\n");
            }
            System.out.println("Dane zostały zapisane do pliku " + fileName);
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania danych do pliku.");
            e.printStackTrace();

        }
    }

}
