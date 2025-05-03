/**
 * Represents a person with personal details such as name, gender, birth year,
 * height, and country of origin.
 * 
 * Meant to be parent for swimmer. Has getters for all values
 * 
 * @author Justin M
 */
public class Person {
    
    private String firstName;
    private String lastName;
    private String gender;
    private int birthYear;
    private int height;
    private String country;

    /**
     * Constructs a Person object with the specified attributes.
     *
     * @param firstName the person's first name
     * @param lastName the person's last name
     * @param gender the person's gender
     * @param birthYear the year the person was born
     * @param height the person's height in centimeters
     * @param country the country the person represents or is from
     */
    public Person(String firstName, String lastName, String gender, int birthYear, int height, String country){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthYear = birthYear;
        this.height = height;
        this.country = country;
    }

    /**
     * Returns the person's first name.
     *
     * @return the first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * Returns the person's last name.
     *
     * @return the last name
     */
    public String getLastName(){
        return lastName;
    }

    /**
     * Returns the person's gender.
     *
     * @return the gender
     */
    public String getGender(){
        return gender;
    }

    /**
     * Returns the year the person was born.
     *
     * @return the birth year
     */
    public int getBirthYear(){
        return birthYear;
    }

    /**
     * Calculates and returns the person's age based on the current year (2025).
     *
     * @return the calculated age
     */
    public int getAge(){
        return 2025 - birthYear;
    }

    /**
     * Returns the person's height in centimeters.
     *
     * @return the height
     */
    public int getHeight(){
        return height;
    }

    /**
     * Returns the country the person is from or represents.
     *
     * @return the country
     */
    public String getCountry(){
        return country;
    }

    /**
     * Returns the full name of the person.
     *
     * @return full name in the format "FirstName LastName"
     */
    public String getName(){
        return firstName + " " + lastName;
    }
}