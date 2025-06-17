package PharmacySystem;

import java.time.LocalDate;

public class Medication {
    private String id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;
}

public Medication (String id, String name, String dose, int quantityInStock){
    this.id = id;
    this.name = name;
    this.dose = dose;
    this.quantityInStock = quantityInStock;
    this.expiryDate = ;
}