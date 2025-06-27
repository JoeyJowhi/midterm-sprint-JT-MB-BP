package PharmacySystem;

public class Person {
    private String id;
    private String name;
    private int age;
    private String phoneNumber;

    //Constructor
    public Person(String id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
    //setters and getters
    /**
     * A quick getter for the purpose of supplying the Person's ID as a String.
     *
     * @return The ID of the Person as a String.
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    /**
     * A quick getter for the purpose of supplying the Person's Name as a String.
     *
     * @return The Name of the Person as a String.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /**
     * A quick getter for the purpose of supplying the Person's Age as an integer.
     *
     * @return The Person's Age as an integer.
     */
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    /**
     * A quick getter for the purpose of supplying the Person's Phone number as a String.
     *
     * @return The persons Phone Number as a string.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}