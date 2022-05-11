import java.util.Scanner;
public class User {
    private String name;
    private int score;

    public User(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public User() {
        //EMPTY
    }

    public String getName() {
        return name;
    }

    public void setName(int userNumber) {
        Scanner userName = new Scanner(System.in);
        System.out.print("Enter user " + userNumber + " name: ");
        this.name = userName.next();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
