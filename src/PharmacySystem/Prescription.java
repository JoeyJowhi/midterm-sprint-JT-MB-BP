package PharmacySystem;
import java.time.LocalDate;

public class Prescription {
    private String id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate issueDate;
    private LocalDate prescriptionExpiry;
    private int quantityPrescribed;
    private String instructions;

    public Prescription(String id, Doctor doctor, Patient patient, Medication medication) {
        this(id, doctor, patient, medication, 30, "Take as directed by Doctor.");
    }

    public Prescription(String id, Doctor doctor, Patient patient, Medication medication,
                        int quantityPrescribed, String instructions) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.quantityPrescribed = quantityPrescribed;
        this.instructions = instructions;
        this.issueDate = LocalDate.now();
        this.prescriptionExpiry = issueDate.plusYears(1);
    }

    // Check if prescription is expired.
    /**
     * Checks if this prescription has expired.
     * A prescription is considered expired if its expiry date is before the current date.
     *
     * @return true if the prescription has expired, false if still valid
     */
    public boolean isExpired() {
        return prescriptionExpiry.isBefore(LocalDate.now());
    }

    // Check if prescription is valid.
    /**
     * Checks if this prescription is still valid (not expired).
     *
     * @return true if the prescription is still valid, false if expired
     */
    public boolean isValid() {
        return !isExpired();
    }

    /**
     * Calculates the number of days until this prescription expires.
     *
     * @return the number of days until expiry (negative if already expired)
     */
    public long getDaysUntilExpiry() {
        return LocalDate.now().until(prescriptionExpiry).getDays();
    }

    // Getters and Setters
    /**
     * Gets the unique identifier for this prescription.
     *
     * @return the prescription ID
     */
    public String getId() { return id; }

    /**
     * Gets the doctor who issued this prescription.
     *
     * @return the prescribing doctor
     */
    public Doctor getDoctor() { return doctor; }

    /**
     * Gets the patient for whom this prescription was issued.
     *
     * @return the patient receiving the prescription
     */
    public Patient getPatient() { return patient; }

    /**
     * Gets the medication that was prescribed.
     *
     * @return the prescribed medication
     */
    public Medication getMedication() { return medication; }

    /**
     * Gets the date this prescription was issued.
     *
     * @return the issue date
     */
    public LocalDate getIssueDate() { return issueDate; }

    /**
     * Gets the date this prescription expires.
     *
     * @return the expiry date (automatically set to 1 year from issue date)
     */
    public LocalDate getPrescriptionExpiry() { return prescriptionExpiry; }

    /**
     * Gets the quantity of medication prescribed.
     *
     * @return the prescribed quantity
     */
    public int getQuantityPrescribed() { return quantityPrescribed; }

    /**
     * Gets the instructions for taking this medication.
     *
     * @return the medication instructions
     */
    public String getInstructions() { return instructions; }

    /**
     * Sets the quantity of medication prescribed.
     * Only accepts positive values; negative or zero values are ignored.
     *
     * @param quantityPrescribed the new quantity
     */
    public void setQuantityPrescribed(int quantityPrescribed) {
        if (quantityPrescribed > 0) {
            this.quantityPrescribed = quantityPrescribed;
        }
    }

    public String toString() {
        return "Prescription Details:\n" +
                "  ID: " + id + "\n" +
                "  Patient: " + patient.getName() + "\n" +
                "  Doctor: " + doctor.getName() + "\n" +
                "  Medication: " + medication.getName() + "\n" +
                "  Quantity: " + quantityPrescribed + "\n" +
                "  Instructions: " + instructions + "\n" +
                "  Issue Date: " + issueDate + "\n" +
                "  Expiry Date: " + prescriptionExpiry + "\n" +
                "  Status: " + (isValid() ? "Valid" : "Expired");
    }
}