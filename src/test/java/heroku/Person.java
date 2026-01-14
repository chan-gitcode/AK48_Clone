package heroku;

public class Person {
    private String firstName, lastName;
    private double due;

    public Person(String firstName, String lastName, double due) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.due = due;
    }

    public void info() {
        System.out.printf("First name: %s, Last name: %s, due: %.2f%n", firstName, lastName, due);
    }

    public double getDue(){
        return due;
    }
    public String getFullname(){
        return String.format("%s %s",firstName,lastName);
    }
}
