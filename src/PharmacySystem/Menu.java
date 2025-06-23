package PharmacySystem;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int patientCount = 1, doctorCount = 1, prescriptionCount = 1;
        while (true) {
            final Scanner userInput = new Scanner(System.in);

            System.out.println("\n---Pharmacy Tracking System---\nEnter a Number:\n   1. Add a New Patient\n   2. Add a New Doctor\n   3. Add a New Medication\n   4. Add a New Prescription\n   5. Generate System Report\n   6. Check for Expired Medication\n   7. List Prescriptions from a Doctor\n   8. List Prescriptions for a Patient\n   9. Restock a Medication\n   10. Current Doctors\n   11. Current Patients\n   12. Current Medications\n   13. Current Prescriptions\n   14. Exit\n------------------------------\n");
            final int userChoice = userInput.nextInt();

            switch (userChoice) {
                case 1:
                    final String pID = String.format("%d", patientCount);
                    patientCount++;

                    System.out.print("\n\n   Enter Patient Name: ");
                    final String pName = userInput.next();

                    System.out.print("\n   Enter Patient Age: ");
                    final int pAge = userInput.nextInt();

                    System.out.print("\n   Enter Patient Phone Number: ");
                    final String pPhoneNumber = userInput.next();

                    final Patient newPatient = new Patient(pID, pName, pAge, pPhoneNumber);

                    MedicationTrackingSystem.addToPatientList(newPatient);

                    System.out.println("\n\n   Patient Successfully Added.\n\n");
                    break;
                case 2:
                    final String dID = String.format("%d", doctorCount);
                    doctorCount++;

                    System.out.print("\n\n   Enter Doctor Name: ");
                    final String dName = userInput.next();

                    System.out.print("\n   Enter Doctor Age: ");
                    final int dAge = userInput.nextInt();

                    System.out.print("\n   Enter Doctor Phone Number: ");
                    final String dPhoneNumber = userInput.next();

                    System.out.print("\n   Enter Doctor Specialization: ");
                    final String dSpecialization = userInput.next();

                    final Doctor newDoctor = new Doctor(dID, dName, dAge, dPhoneNumber, dSpecialization);

                    MedicationTrackingSystem.addToDoctorList(newDoctor);

                    System.out.println("\n\n   Doctor Successfully Added.\n\n");
                    break;
                case 3:
                    System.out.print("\n\n   Enter Medication Name: ");
                    final String mName = userInput.next();

                    System.out.print("\n   Enter Medication Dose: ");
                    final String mDose = userInput.next();

                    System.out.print("\n   Enter Medication Quantity in Stock: ");
                    final int mQuantityInStock = userInput.nextInt();

                    System.out.print("\n   Enter Medication Expiry Date (YYYY-MM-DD): ");
                    final LocalDate mExpiryDate = LocalDate.parse(userInput.next());

                    final Medication newMedication = new Medication(mName, mDose, mQuantityInStock, mExpiryDate);

                    MedicationTrackingSystem.addToMedicationInventory(newMedication);

                    System.out.println("\n\n   Medication Successfully Added.\n\n");
                    break;
                case 4:
                    final Doctor doctorForMenuExample = new Doctor(String.format("%d", doctorCount), "Joel", 20, "(123) 456-7890", "Jocology");
                    doctorCount++;
                    MedicationTrackingSystem.addToDoctorList(doctorForMenuExample);

                    final Patient patientForMenuExample = new Patient(String.format("%d", patientCount), "Jotient", 19, "(098) 765-4321");
                    patientCount++;
                    MedicationTrackingSystem.addToPatientList(patientForMenuExample);

                    final Medication medicationForMenuExample = new Medication("Jolone", "50mg", 12, LocalDate.parse("2025-12-05"));
                    MedicationTrackingSystem.addToMedicationInventory(medicationForMenuExample);

                    final Prescription menuExample = new Prescription(String.format("%d", prescriptionCount), doctorForMenuExample, patientForMenuExample, medicationForMenuExample);
                    prescriptionCount++;

                    System.out.printf("\n\n   Prescription: %s", menuExample);

                    System.out.print("\n   Link? (y/n): ");
                    final String linkChoice = userInput.next().toLowerCase();

                    if (linkChoice.equals("y")) {
                        MedicationTrackingSystem.linkPrescription(menuExample);

                        System.out.println("\n   Prescription Successfully Linked.\n\n");
                    }
                    break;
                case 5:
                    MedicationTrackingSystem.generateReport();
                    break;
                case 6:
                    MedicationTrackingSystem.expiredCheck();
                    break;
                case 7:
                    System.out.print("\n\n   Enter a Doctor's Name: ");

                    final Doctor userChosenDoctor = MedicationTrackingSystem.searchDoctors(userInput.next());

                    MedicationTrackingSystem.doctorListIssuedPrescriptions(userChosenDoctor);
                    break;
                case 8:
                    System.out.print("\n\n   Enter a Patient's Name: ");

                    final Patient userChosenPatient = MedicationTrackingSystem.searchPatients(userInput.next());

                    userChosenPatient.getPrescriptions();
                    break;
                case 9:
                    System.out.print("\n\n   Enter a Medication's Name: ");

                    final Medication userChosenMedication = MedicationTrackingSystem.searchDrugs(userInput.next());

                    System.out.print("\n   Enter Restock Amount: ");
                    MedicationTrackingSystem.restock(userInput.nextInt());
                    break;
                case 10:
                    MedicationTrackingSystem.getDoctorList();
                    break;
                case 11:
                    MedicationTrackingSystem.getPatientList();
                    break;
                case 12:
                    MedicationTrackingSystem.getMedicationInventory();
                    break;
                case 13:
                    MedicationTrackingSystem.getPrescriptionList();
            }

            if (userInput.nextInt() == 14) {
                break;
            }
        }
    }
}