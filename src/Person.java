public class Person {
    
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private int height;
    private String country;

    public Person(String firstName, String lastName, String gender, int age, int height, String country){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
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

    public int getAge(){
        return age;
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
