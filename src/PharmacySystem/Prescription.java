package PharmacySystem;
import java.time.LocalDate;
import java.util.Objects;

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
    public boolean isExpired() {
        return prescriptionExpiry.isBefore(LocalDate.now());
    }

    // Check if prescription is valid.
    public boolean isValid() {
        return !isExpired();
    }

    public long getDaysUntilExpiry() {
        return LocalDate.now().until(prescriptionExpiry).getDays();
    }

    // Getters and Setters
    public String getId() { return id; }
    public Doctor getDoctor() { return doctor; }
    public Patient getPatient() { return patient; }
    public Medication getMedication() { return medication; }
    public LocalDate getIssueDate() { return issueDate; }
    public LocalDate getPrescriptionExpiry() { return prescriptionExpiry; }
    public int getQuantityPrescribed() { return quantityPrescribed; }
    public String getInstructions() { return instructions; }

    public void setQuantityPrescribed(int quantityPrescribed) {
        if (quantityPrescribed > 0) {
            this.quantityPrescribed = quantityPrescribed;
        }
    }

    // ADD TOSTRING!!
}