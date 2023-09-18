import java.util.ArrayList;
import java.util.List;

class HospitalQueue {
    private List<Patient> queue;
    private int maxSize;

    public HospitalQueue(int maxSize) {
        this.queue = new ArrayList<>(maxSize);
        this.maxSize = maxSize;
    }

    public void addPatient(Patient patient) {
        if (isFull()) {
            System.out.println("Kolejka jest pełna. Nie można dodać kolejnego pacjenta.");
        } else {
            queue.add(patient);
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Kolejka pacjentów jest pusta.");
        } else {
            System.out.println("Kolejka pacjentów:");
            for (int i = 0; i < queue.size(); i++) {
                Patient patient = queue.get(i);
                System.out.println("Pacjent " + (i + 1) + ": " );
            }
        }
    }

    public int getSize() {
        return queue.size();
    }

    public Patient getPatient(int index) {
        if (isValidIndex(index)) {
            return queue.get(index);
        }
        return null;
    }

    private boolean isEmpty() {
        return queue.isEmpty();
    }

    private boolean isFull() {
        return queue.size() >= maxSize;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < queue.size();
    }

}
