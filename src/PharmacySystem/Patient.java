package PharmacySystem;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private List<Medication> medications;
    private List<Prescription> prescriptions;

    // Constructor
    public Patient(String id, String name, int age, String phoneNumber) {
        super(id, name, age, phoneNumber);
        this.medications = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    // Medications
    public boolean addMedication(Medication medication) {
        medications.add(medication);
        return true;
    }

    public boolean removeMedication(Medication medication) {
        return medications.remove(medication);
    }

    public boolean hasMedication(Medication medication) {
        return medications.contains(medication);
    }

    public List<Medication> getMedications() {
        return new ArrayList<>(medications);
    }

    public int getMedicationCount() {
        return medications.size();
    }

    // Prescriptions
    public boolean addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        return true;
    }

    public boolean removePrescription(Prescription prescription) {
        return prescriptions.remove(prescription);
    }

    public boolean hasPrescription(Prescription prescription) {
        return prescriptions.contains(prescription);
    }

    public List<Prescription> getPrescriptions() {
        return new ArrayList<>(prescriptions);
    }

    public int getPrescriptionCount() {
        return prescriptions.size();
    }

    // Get active prescriptions
    public List<Prescription> getActivePrescriptions() {
        List<Prescription> activeScript = new ArrayList<>();
        for (Prescription prescription : prescriptions) {
            if (prescription.isValid()) {
                activeScript.add(prescription);
            }
        }
        return activeScript;
    }

    // toString
    public String toString() {
        return "Patient: " + getName() + " (ID: " + getId() +
                ", Medications: " + getMedicationCount() +
                ", Prescriptions: " + getPrescriptionCount() + ")";
    }
}