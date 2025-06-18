package PharmacySystem;
import java.util.ArrayList;
import java.util.Objects;

public class MedicationTrackingSystem {
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static ArrayList<Medication> medicationInventory = new ArrayList<>();


    //List Manipulation Methods
        //Adding
    public static void addToDoctorList(Doctor newDoctor) {
        doctorList.add(newDoctor);
    }

    public static void addToMedicationInventory(Medication newMedication) {
        medicationInventory.add(newMedication);
    }

    public static void addToPatientList(Patient newPatient) {
        patientList.add(newPatient);
    }

        //Removing
    public static void removeFromDoctorList(Doctor markedDoctor) {
        doctorList.remove(markedDoctor);
    }

    public static void removeFromMedicationInventory(Medication markedMedication) {
        medicationInventory.remove(markedMedication);
    }

    public static void removeFromPatientList(Patient markedPatient) {
        patientList.remove(markedPatient);
    }

        //Editing
    public static void editDoctor(Doctor doctorToEdit, Doctor newDoctorData) {
        doctorList.set(doctorList.indexOf(doctorToEdit), newDoctorData);
    }

    public static void editMedication(Medication medicationToEdit, Medication newMedicationData) {
        medicationInventory.set(medicationInventory.indexOf(medicationToEdit), newMedicationData);
    }

    public static void editPatient(Patient patientToEdit, Patient newPatientData) {
        patientList.set(patientList.indexOf(patientToEdit), newPatientData);
    }


    //Search Methods
    public static Medication searchDrugs(String query) {
        Medication result = null;

        for (Medication drug : medicationInventory) {
            if (Objects.equals(drug.getName(), query)) {
                result = drug;
            }
        }

        return result;
    }


}
