class HospitalQueue {
    private Patient[] queue;
    private int size;
    private int maxSize;

    public HospitalQueue(int maxSize) {
        this.queue = new Patient[maxSize];
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void addPatient(Patient patient) {
        if (size < maxSize) {
            queue[size] = patient;
            size++;
        } else {
            System.out.println("Kolejka jest pełna. Nie można dodać kolejnego pacjenta.");
        }
    }

    public void displayQueue() {
        if (size == 0) {
            System.out.println("Kolejka pacjentów jest pusta.");
            return;
        }

        System.out.println("Kolejka pacjentów:");
        for (int i = 0; i < size; i++) {
            System.out.println("Pacjent " + (i + 1) + ": " + queue[i].getFirstName() + " " + queue[i].getLastName());
        }
    }

    public int getSize() {
        return size;
    }

    public Patient getPatient(int index) {
        if (index >= 0 && index < size) {
            return queue[index];
        }
        return null;
    }
}
