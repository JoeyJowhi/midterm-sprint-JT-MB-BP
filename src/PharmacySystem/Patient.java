package PharmacySystem;

public class Patient extends Person {
    private Medication[] medications;
    private Prescription[] prescriptions;
    private int medicationCount;
    private int prescriptionCount;

    // Constructor
    public Patient(String id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new Medication[20];  // Max 20 medications
        this.prescriptions = new Prescription[15];  // Max 15 prescriptions
        this.medicationCount = 0;
        this.prescriptionCount = 0;
    }

    // Medications

    public boolean addMedication(Medication medication) {
        if (medicationCount < medications.length) {
            medications[medicationCount++] = medication;
            return true;
        }
        return false;
    }

    public boolean removeMedication(Medication medication) {
        for (int i = 0; i < medicationCount; i++) {
            if (medications[i].equals(medication)) {
                medications[i] = null; //
                return true;
            }
        }
        return false;
    }

    public boolean hasMedication(Medication medication) {
        for (int i = 0; i < medicationCount; i++) {
            if (medications[i] != null && medications[i].equals(medication)) {
                return true;
            }
        }
        return false;
    }

    public Medication[] getMedications() {
        return medications;
    }

    public int getMedicationCount() {
        int count = 0;
        for (int i = 0; i < medications.length; i++) {
            if (medications[i] != null) {
                count++;
            }
        }
        return count;
    }

    // Prescriptions

    public boolean addPrescription(Prescription prescription) {
        if (prescriptionCount < prescriptions.length) {
            prescriptions[prescriptionCount++] = prescription;
            return true;
        }
        return false;
    }

    public boolean removePrescription(Prescription prescription) {
        for (int i = 0; i < prescriptionCount; i++) {
            if (prescriptions[i].equals(prescription)) {
                prescriptions[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean hasPrescription(Prescription prescription) {
        for (int i = 0; i < prescriptionCount; i++) {
            if (prescriptions[i] != null && prescriptions[i].equals(prescription)) {
                return true;
            }
        }
        return false;
    }

    public Prescription[] getPrescriptions() {
        return prescriptions;
    }

    public int getPrescriptionCount() {
        int count = 0;
        for (int i = 0; i < prescriptions.length; i++) {
            if (prescriptions[i] != null) {
                count++;
            }
        }
        return count;
    }

    // Get active prescriptions
    public Prescription[] getActivePrescriptions() {
        Prescription[] active = new Prescription[15];
        int activeCount = 0;

        for (int i = 0; i < prescriptionCount; i++) {
            if (prescriptions[i] != null && prescriptions[i].isValid()) {
                active[activeCount++] = prescriptions[i];
            }
        }
        return active;
    }

    // toString
    public String toString() {
        return "Patient: " + getName() + " (ID: " + getId() +
                ", Medications: " + getMedicationCount() +
                ", Prescriptions: " + getPrescriptionCount() + ")";
    }
}