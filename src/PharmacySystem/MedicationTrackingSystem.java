package PharmacySystem;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class MedicationTrackingSystem {
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static ArrayList<Medication> medicationInventory = new ArrayList<>();
    private static Hashtable<Doctor, ArrayList<Prescription>> doctorPrescriptionList = new Hashtable<>();


    //List Manipulation Methods
        //Adding
    public static void addToDoctorList(Doctor newDoctor) {
        doctorList.add(newDoctor);
    }

    public static void addToPatientList(Patient newPatient) {
        patientList.add(newPatient);
    }

    public static void addToDoctorsPatientsList(Doctor assigned, Patient assignee) {
        assigned.addPatient(assignee);
    }

    public static void addToMedicationInventory(Medication newMedication) {
        medicationInventory.add(newMedication);
    }

        //Removing
    public static void removeFromDoctorList(Doctor markedDoctor) {
        doctorList.remove(markedDoctor);
    }

    public static void removeFromPatientList(Patient markedPatient) {
        patientList.remove(markedPatient);
    }

    public static void removeFromDoctorsPatientsList(Doctor assigned, Patient assigneeForRemoval) {
        assigned.removePatient(assigneeForRemoval);
    }

    public static void removeFromMedicationInventory(Medication markedMedication) {
        medicationInventory.remove(markedMedication);
    }

        //Editing
    public static void editDoctor(Doctor doctorToEdit, Doctor newDoctorData) {
        doctorList.set(doctorList.indexOf(doctorToEdit), newDoctorData);
    }

    public static void editPatient(Patient patientToEdit, Patient newPatientData) {
        patientList.set(patientList.indexOf(patientToEdit), newPatientData);
    }

    public static void editMedication(Medication medicationToEdit, Medication newMedicationData) {
        medicationInventory.set(medicationInventory.indexOf(medicationToEdit), newMedicationData);
    }


    //Search Methods
    public static Doctor searchDoctors(String query) {
        Doctor result = null;

        for (Doctor doc : doctorList) {
            if (Objects.equals(doc.getName(), query)) {
                result = doc;
            }
        }

        return result;
    }

    public static Patient searchPatients(String query) {
        Patient result = null;

        for (Patient pat : patientList) {
            if (Objects.equals(pat.getName(), query)) {
                result = pat;
            }
        }

        return result;
    }

    public static Medication searchDrugs(String query) {
        Medication result = null;

        for (Medication drug : medicationInventory) {
            if (Objects.equals(drug.getName(), query)) {
                result = drug;
            }
        }

        return result;
    }


    //Prescription Class Methods
    public void linkPrescription(Prescription prescription) {
        prescription.getPatient().addPrescription(prescription);

        doctorPrescriptionList.put(prescription.getDoctor(), new ArrayList<>().add(prescription)); //fix this bru
    }
}