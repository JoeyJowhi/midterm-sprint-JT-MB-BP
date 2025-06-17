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
        this.expiryDate = null;

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


    //Getter Methods
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDose() {
        return this.dose;
    }

    public int getQuantityInStock() {
        return this.quantityInStock;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }


    //Setter Methods
    public void setName(String name) {
        this.name = name;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
}