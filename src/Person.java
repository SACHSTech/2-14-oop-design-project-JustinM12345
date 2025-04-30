public class Person {
    
    private String firstName;
    private String lastName;
    private String gender;
    private int birthYear;
    private int height;
    private String country;

    public Person(String firstName, String lastName, String gender, int birthYear, int height, String country){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthYear = birthYear;
        this.height = height;
        this.country = country;

    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getGender(){
        return gender;
    }

    public int getBirthYear(){
        return birthYear;
    }

    public int getAge(){
        return 2025 - birthYear;
    }

    public int getHeight(){
        return height;
    }

    public String getCountry(){
        return country;
    }

    public String getName(){
        return firstName + " " + lastName;
    }
}
