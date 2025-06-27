package PharmacySystem;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private List<Patient> patients;


    // Constructor
    public Doctor(String id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // setters and getters
    /**
     * A quick getter for the purpose of getting the specialization as a string.
     *
     * @return The specialization as a string.
     */
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    /**
     * A quick getter for the purpose of getting Patients as a List.
     *
     * @return The list of patients.
     */
    public List<Patient> getPatients() {
        return patients;
    }

    public void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void removePatient(Patient patient) {
        this.patients.remove(patient);
    }

    //toString
    public String toString() {
        return "Doctor ID: " + getId() +
                ", Name: " + getName() +
                ", Age: " + getAge() +
                ", Phone: " + getPhoneNumber() +
                ", Specialization: " + specialization +
                ", Patients: " + getPatients().toString();
    }

}
