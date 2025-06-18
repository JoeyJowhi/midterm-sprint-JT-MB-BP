package PharmacySystem;
import java.time.LocalDate;

public class TestPharmacySystem {
    public static void main(String[] args) {
    //Medication Class Tests
        //Constructor Tests (Also tests toString() by proxy)
        Medication joeynnol = new Medication();
        System.out.println("Medication Class Tests\n   Constructor Tests\n" + joeynnol + "\n");

        Medication joeymine = new Medication("Joeymine", "13mg", 16, LocalDate.parse("2025-06-17"));
        System.out.println(joeymine + "\n\n   Getter Method Tests\n");
        
        
        //Getter Method Tests
        System.out.println("getID(): " + joeymine.getId() + "\ngetName(): " + joeymine.getName() + "\ngetDose(): " + joeymine.getDose() + "\ngetQuantityInStock(): " + joeymine.getQuantityInStock() + "\ngetExpiryDate(): " + joeymine.getExpiryDate() + "\n\n   Setter Method Tests\n");
        
        
        //Setter Method Tests
        joeymine.setName("Joeycyline");
        joeymine.setDose("10mg");
        joeymine.setQuantityInStock(12);
        joeymine.setExpiryDate(LocalDate.parse("2025-06-14"));

        System.out.println("--After Setters--\n" + joeymine);


    //MedicationTrackingSystem Tests
        //List Manipulation Method Tests
        MedicationTrackingSystem.addToMedicationInventory(joeynnol);
        MedicationTrackingSystem.addToMedicationInventory(joeymine);

        //Search Method Tests
        System.out.println(MedicationTrackingSystem.searchDrugs("Joeycyline"));
    }
}
