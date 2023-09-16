import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class HospitalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HospitalQueue hospitalQueue = new HospitalQueue(10);

        int maxAttempts = 3;
        int currentAttempts = 0;

        while (hospitalQueue.getSize() < 2
        ) {
            System.out.println("Dodawanie pacjenta " + (hospitalQueue.getSize() + 1));
            currentAttempts = 0;
            while (currentAttempts < maxAttempts) {
                String firstName = getInput(scanner, "Imię pacjenta:");
                String lastName = getInput(scanner, "Nazwisko pacjenta:");

                boolean validFirstName = PatientValidator.validateName(firstName);
                boolean validLastName = PatientValidator.validateName(lastName);

                if (validFirstName && validLastName) {
                    String pesel = getInput(scanner, "Pesel pacjenta:");
                    String idNumber = getInput(scanner, "Seria i numer dowodu osobistego pacjenta (np. AB123456):");
                    Gender gender = null;

                    for (int i = 0; i < maxAttempts; i++) {
                        gender = getGenderInput(scanner);
                        if (gender != null) {
                            break;
                        } else {
                            System.out.println("Błąd: Nieprawidłowa płeć. Wprowadź 'M' dla mężczyzny lub 'K' dla kobiety. Pozostało prób: " + (maxAttempts - i - 1));
                        }
                    }

                    if (gender != null) {
                        Patient patient = new Patient(firstName, lastName, pesel, idNumber, gender);
                        hospitalQueue.addPatient(patient);

                        System.out.println("Pacjent dodany do kolejki.");
                        break;
                    } else {
                        System.out.println("Brak prób. Następny pacjęt.");
                        break;
                    }
                } else {
                    if (!validFirstName) {
                        System.out.println("Błąd wprowadzania imienia. Pozostało prób: " + (maxAttempts - currentAttempts - 1));
                    }
                    if (!validLastName) {
                        System.out.println("Błąd wprowadzania  nazwiska. Pozostało prób: " + (maxAttempts - currentAttempts - 1));
                    }
                    currentAttempts++;
                    if (currentAttempts >= maxAttempts) {
                        System.out.println("Brak prób. Na dziś już wystarczy .");
                        break;
                    }
                }
            }
        }

        hospitalQueue.displayQueue();

        saveQueueToFile(hospitalQueue, "Lista pacjentów na dziś.txt");
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

    public static class ValidationException extends Exception {
        public ValidationException(String message) {
            super(message);
        }
    }

    private static void saveQueueToFile(HospitalQueue hospitalQueue, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Kolejka pacjentów:\n");
            for (int i = 0; i < hospitalQueue.getSize(); i++) {
                Patient patient = hospitalQueue.getPatient(i);
                writer.write("Pacjent " + (i + 1) + ": " + patient.getFirstName() + " " + patient.getLastName() + "\n");
            }
            System.out.println("Dane zostały zapisane do pliku " + fileName);
        } catch (IOException e) {
            System.out.println("Błąd podczas zapisywania danych do pliku.");
            e.printStackTrace();
        }
    }
}
