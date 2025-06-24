package PharmacySystem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class MedicationTrackingSystem {
    private static ArrayList<Doctor> doctorList = new ArrayList<>();
    private static ArrayList<Patient> patientList = new ArrayList<>();
    private static ArrayList<Medication> medicationInventory = new ArrayList<>();
    private static ArrayList<Prescription> prescriptionList = new ArrayList<>();
    private static Hashtable<Doctor, ArrayList<Prescription>> doctorPrescriptionList = new Hashtable<>();


    //List Manipulation Methods
        //Adding
    /**
    * Adds the given Doctor to a list of the current Doctors tracked (since runtime began, does not persist) within the system.
    *
    * @param newDoctor An object of the Doctor class to be added to the doctorList.
    */
    public static void addToDoctorList(Doctor newDoctor) {
        doctorList.add(newDoctor);
    }

    /**
     * Adds the given Patient to a list of the current Patients tracked (since runtime began, does not persist) within the system.
     *
     * @param newPatient An object of the Patient class to be added to the patientList.
     */
    public static void addToPatientList(Patient newPatient) {
        patientList.add(newPatient);
    }

    /**
     * Adds the given Patient to a list of the given Doctor's designated Patients.
     *
     * @param assigned An object of the Doctor class used to access the addPatient method.
     * @param assignee An object of the Patient class to be added to the assigned's list of Patients.
     */
    public static void addToDoctorsPatientsList(Doctor assigned, Patient assignee) {
        assigned.addPatient(assignee);
    }

    /**
     * Adds the given Medication to a list of the current Medication inventory tracked (since runtime began, does not persist) within the system.
     *
     * @param newMedication An object of the Medication class to be added to the Medication inventory.
     */
    public static void addToMedicationInventory(Medication newMedication) {
        medicationInventory.add(newMedication);
    }

        //Removing
    /**
     * Removes the given Doctor from a list of the current Doctors tracked (since runtime began, does not persist) within the system.
     *
     * @param markedDoctor An object of the Doctor class to be removed from the doctorList. Note that the markedDoctor must first exist inside the list prior to removing it.
     */
    public static void removeFromDoctorList(Doctor markedDoctor) {
        doctorList.remove(markedDoctor);
    }

    /**
     * Removes the given Patient from a list of the current Patients tracked (since runtime began, does not persist) within the system.
     *
     * @param markedPatient An object of the Patient class to be removed from the patientList. Note that the markedPatient must first exist inside the list prior to removing it.
     */
    public static void removeFromPatientList(Patient markedPatient) {
        patientList.remove(markedPatient);
    }

    /**
     * Removes the given Patient from the list of the given Doctor's Patients.
     *
     * @param assigned An object of the Doctor class whose list will have a Patient removed from.
     * @param assigneeForRemoval An object of the Patient class to be removed form the assigned's list. Note that the Patient must be present in the assigned's list prior to removal.
     */
    public static void removeFromDoctorsPatientsList(Doctor assigned, Patient assigneeForRemoval) {
        assigned.removePatient(assigneeForRemoval);
    }

    /**
     * Removes the given Medication from a list of the current Medication inventory tracked (since runtime began, does not persist) within the system.
     *
     * @param markedMedication An object of the Medication class to be removed from the Medication inventory. Note that the markedMedication must first exist inside the inventory prior to removing it.
     */
    public static void removeFromMedicationInventory(Medication markedMedication) {
        medicationInventory.remove(markedMedication);
    }

        //Editing
    /**
     * Replaces the first given Doctor's data in the doctorList with the second.
     *
     * @param doctorToEdit An object of the Doctor class to be replaced in the doctorList. Note that the Doctor must first exist inside the doctorList prior to replacing it.
     * @param newDoctorData An object of the Doctor class to replace the data of the doctorToEdit in the doctorList.
     */
    public static void editDoctor(Doctor doctorToEdit, Doctor newDoctorData) {
        doctorList.set(doctorList.indexOf(doctorToEdit), newDoctorData);
    }

    /**
     * Replaces the first given Patient's data in the patientList with the second.
     *
     * @param patientToEdit An object of the Patient class to be replaced in the patientList. Note that the Patient must first exist inside the patientList prior to replacing it.
     * @param newPatientData An object of the Patient class to replace the data of the patientToEdit in the patientList.
     */
    public static void editPatient(Patient patientToEdit, Patient newPatientData) {
        patientList.set(patientList.indexOf(patientToEdit), newPatientData);
    }

    /**
     * Replaces the first given Medication's data in the Medication inventory with the second.
     *
     * @param medicationToEdit An object of the Medication class to be replaced in the Medication inventory. Note that the Medication must first exist inside the inventory prior to replacing it.
     * @param newMedicationData An object of the Medication class to replace the data of the medicationToEdit in the inventory.
     */
    public static void editMedication(Medication medicationToEdit, Medication newMedicationData) {
        medicationInventory.set(medicationInventory.indexOf(medicationToEdit), newMedicationData);
    }


    //Search Methods
    /**
     * Searches the doctorList for a Doctor with the name field that matches the given query.
     *
     * @param query The name of the Doctor to search for.
     */
    public static Doctor searchDoctors(String query) {
        Doctor result = null;

        for (Doctor doc : doctorList) {
            if (Objects.equals(doc.getName(), query)) {
                result = doc;
            }
        }

        return result;
    }

    /**
     * Searches the patientList for a Patient with the name field that matches the given query.
     *
     * @param query The name of the Patient to search for.
     */
    public static Patient searchPatients(String query) {
        Patient result = null;

        for (Patient pat : patientList) {
            if (Objects.equals(pat.getName(), query)) {
                result = pat;
            }
        }

        return result;
    }

    /**
     * Searches the Medication inventory for a Medication with the name field that matches the given query.
     *
     * @param query The name of the Medication to search for.
     */
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
    /**
     * Links the given Prescription to the patient it's for and to the Doctor who issued it.
     *
     * @param prescription An object of the Prescription class to link.
     */
    public static void linkPrescription(Prescription prescription) {
        prescription.getPatient().addPrescription(prescription);
        prescriptionList.add(prescription);

        doctorPrescriptionList.computeIfAbsent(prescription.getDoctor(), (doc)->new ArrayList<>());

        doctorPrescriptionList.get(prescription.getDoctor()).add(prescription);
    }

    /**
     * Lists the Prescriptions issued by the given Doctor.
     *
     * @param doc The doctor whose issued Prescriptions to list.
     */
    public static String doctorListIssuedPrescriptions(Doctor doc) {
        return doctorPrescriptionList.get(doc).toString();
    }


    //Misc Methods
    /**
     * Generates a system report containing all currently tracked Medication, Doctors, Patients, and Prescriptions.
     *
     * @return A string containing the system report formatted similarly to a receipt.
     */
    public static String generateReport() {
        return String.format("""
                ---System Generated Report---
                Drug Inventory: %s
                
                ------
                
                Current Doctors: %s
                
                ------
                
                Current Patients: %s
                
                ------
                
                Issued Prescriptions: %s
                
                ---End of System Generated Report---
                """, medicationInventory.toString(), doctorList.toString(), patientList.toString(), prescriptionList.toString());
    }

    /**
     * Adds the given quantity to the quantity in stock of every currently tracked Medication.
     *
     * @param quantity The integer to add to the Medication quantities.
     */
    public static void restock(int quantity) {
        medicationInventory.forEach((med)->med.setQuantityInStock(med.getQuantityInStock() + quantity));
    }

    /**
     * Sifts through each Medication currently tracked in the inventory and compares their expiry dates to the current date.
     *
     * @return A string for each Medication found to be expired. Also returns a string to state when the check has concluded, if this was the only string printed then no expired Medications were found.
     */
    public static String expiredCheck() {
        medicationInventory.forEach((med)->{
            if (LocalDate.now().isAfter(med.getExpiryDate())) {
                System.out.printf("\nEXPIRED: %s\n", med);
            }
        });

        return "---expiredCheck Concluded---";
    }

    //Getters
    /**
     * A quick getter for the purpose of displaying the entire doctorList as a string.
     *
     * @return A toString() formatted ArrayList of all currently tracked Doctors.
     */
    public static String getDoctorList() {
        return doctorList.toString();
    }

    /**
     * A quick getter for the purpose of displaying the entire patientList as a string.
     *
     * @return A toString() formatted ArrayList of all currently tracked Patients.
     */
    public static String getPatientList() {
        return patientList.toString();
    }

    /**
     * A quick getter for the purpose of displaying the entire Medication inventory as a string.
     *
     * @return A toString() formatted ArrayList of all currently tracked Medication.
     */
    public static String getMedicationInventory() {
        return medicationInventory.toString();
    }

    /**
     * A quick getter for the purpose of displaying the entire prescriptionList as a string.
     *
     * @return A toString() formatted ArrayList of all currently tracked Prescriptions.
     */
    public static String getPrescriptionList() {
        return prescriptionList.toString();
    }
}