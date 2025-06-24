package PharmacySystem;
import java.time.LocalDate;

public class Medication {
    private final int id;
    private int quantityInStock;
    private String name, dose;
    private LocalDate expiryDate;

    static int count = 1;


    //Constructors
    public Medication() {
        this.id = count;
        this.name = null;
        this.dose = null;
        this.quantityInStock = 0;
        this.expiryDate = LocalDate.now();

        count++;
    }

    public Medication(String name, String dose, int quantityInStock, LocalDate expiryDate) {
        this.id = count;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = expiryDate;

        count++;
    }


    //Instance Methods
    public String toString() {
        return String.format("Medication[\n   ID: %d\n   Name: %s\n   Dose: %s\n   Quantity in Stock: %d\n   Expiry Date: %s\n]", this.id, this.name, this.dose, this.quantityInStock, this.expiryDate.toString());
    }


    //Getter Methods
    /**
     * A quick getter for the purpose of supplying the Medication's ID as an integer.
     *
     * @return The ID of the Medication as an integer.
     */
    public int getId() {
        return this.id;
    }

    /**
     * A quick getter for the purpose of supplying the Medication's name as a String.
     *
     * @return The name of the Medication as a String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * A quick getter for the purpose of supplying the Medication's dose as a String.
     *
     * @return The dose of the Medication as a String.
     */
    public String getDose() {
        return this.dose;
    }

    /**
     * A quick getter for the purpose of supplying the Medication's quantity in stock as an integer.
     *
     * @return The quantity in stock of the Medication as an integer.
     */
    public int getQuantityInStock() {
        return this.quantityInStock;
    }

    /**
     * A quick getter for the purpose of supplying the Medication's expiry date as a LocalDate object.
     *
     * @return The expiry date of the Medication as a LocalDate object.
     */
    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }


    //Setter Methods
    /**
     * A quick setter for the purpose of changing the Medication's name to the given String.
     *
     * @param name The new name to be applied to the Medication.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A quick setter for the purpose of changing the Medication's dose to the given String.
     *
     * @param dose The new dose to be applied to the Medication.
     */
    public void setDose(String dose) {
        this.dose = dose;
    }

    /**
     * A quick setter for the purpose of changing the Medication's quantity in stock to the given integer.
     *
     * @param quantityInStock The new quantity in stock to be applied to the Medication.
     */
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    /**
     * A quick setter for the purpose of changing the Medication's expiry date to the given LocalDate.
     *
     * @param expiryDate The new expiry date to be applied to the Medication.
     */
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}