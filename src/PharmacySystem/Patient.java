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
    /**
     * Adds a medication to this patient's medication list.
     * The medication will be added even if it already exists in the list.
     *
     * @param medication the medication to add to this patient's list.
     * @return true if the medication was successfully added
     */
    public boolean addMedication(Medication medication) {
        medications.add(medication);
        return true;
    }

    /**
     * Removes the first occurrence of the specified medication from this patient's medication list.
     * If the medication appears multiple times, only the first occurrence is removed.
     *
     * @param medication the medication to remove from this patient's list.
     * @return true if the medication was found and removed, false if not found
     */
    public boolean removeMedication(Medication medication) {
        return medications.remove(medication);
    }

    /**
     * Checks if this patient is currently assigned the specified medication.
     *
     * @param medication the medication to search for.
     * @return true if the patient has this medication, false otherwise
     */
    public boolean hasMedication(Medication medication) {
        return medications.contains(medication);
    }

    /**
     * Returns a defensive copy of all medications assigned to this patient.
     * Modifications to the returned list will not affect the patient's internal medication list.
     *
     * @return a new ArrayList containing all medications for this patient.
     */
    public List<Medication> getMedications() {
        return new ArrayList<>(medications);
    }

    /**
     * Returns the total number of medications currently assigned to this patient.
     * This count includes duplicate medications if they exist.
     *
     * @return the count of medications.
     */
    public int getMedicationCount() {
        return medications.size();
    }

    // Prescriptions
    /**
     * Adds a prescription to this patient's prescription history.
     * maintaining a complete history of all prescriptions issued to this patient.
     *
     * @param prescription the prescription to add, must not be null
     * @return true if the prescription was successfully added
     */
    public boolean addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
        return true;
    }

    /**
     * Removes the first occurrence of the specified prescription from this patient's prescription history.
     * This operation should be used carefully as it permanently removes prescription records.
     *
     * @param prescription the prescription to remove
     * @return true if the prescription was found and removed, false if not found
     */
    public boolean removePrescription(Prescription prescription) {
        return prescriptions.remove(prescription);
    }

    /**
     * Checks if this patient has the specified prescription in their history.
     * This includes both active and expired prescriptions.
     *
     * @param prescription the prescription to search for
     * @return true if the patient has this prescription, false otherwise
     */
    public boolean hasPrescription(Prescription prescription) {
        return prescriptions.contains(prescription);
    }

    /**
     * Returns a copy of all prescriptions (active and expired) for this patient.
     *
     * @return a new ArrayList containing all prescriptions for this patient
     */
    public List<Prescription> getPrescriptions() {
        return new ArrayList<>(prescriptions);
    }

    /**
     * Returns the total number of prescriptions in this patient's history.
     * This count includes both active and expired prescriptions.
     *
     * @return the count of prescriptions
     */
    public int getPrescriptionCount() {
        return prescriptions.size();
    }

    // Get active prescriptions
    /**
     * Returns a list of all currently active (non-expired) prescriptions for this patient.
     * This method creates a new list containing only valid prescriptions.
     *
     * @return a new ArrayList containing only active prescriptions.
     */
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