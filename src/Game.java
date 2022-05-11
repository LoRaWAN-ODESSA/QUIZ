import java.util.Scanner;

public class Game {
    private User[] users;
    private Question[] questionsList;
    private int numUsers;
    private int[] score;

    public Game(User[] user, Question[] questionsList, int numUsers, int[] score) {
        this.users = user;
        this.questionsList = questionsList;
        this.numUsers = numUsers;
        this.score = score;
    }

    public Game() {
        //EMPTY
    }

    public User[] getUser() {
        return users;
    }

    public void setUser(User[] users) {
        this.users = users;
    }

    public Question[] getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(Question[] questionsList) {
        this.questionsList = questionsList;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void setNumUsers(int numUsers) {
        this.numUsers = numUsers;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public void startGame() {
        System.out.println("New game has been started");
        Scanner numUsers = new Scanner(System.in);
        System.out.print("How many players will play: ");
        this.numUsers = numUsers.nextInt();
        this.users = new User[this.numUsers];
        for (int i = 0; i < this.numUsers; i++) {
            users[i] = new User();
            users[i].setName(i + 1);
            users[i].setScore(0);
        }
        Question question = new Question();
        this.questionsList = question.getQuestionsList();
        this.score = new int[this.numUsers];
        for (int i = 0; i < this.numUsers; i++) {
            score[i] = 0;
        }
    }

    public void beginRound(int roundNum) {
        int temp = getTemp(roundNum);
        System.out.println("\nBegin round " + roundNum + "!");
        for (int i = 0; i < numUsers; i++) {
            timeDelay(1);
            System.out.println("\n" + users[i].getName() + " is answering now!");
            timeDelay(2);
            for (int j = 0; j < 3; j++) {
                System.out.println("\nQuestion " + (j + 1 + temp + roundNum - 1) + "/12:");
                System.out.println(getQuestionsList()[j + temp + roundNum - 1].getQuestion());
                System.out.println("1. " + getQuestionsList()[j + temp + roundNum - 1].getAnswer1());
                System.out.println("2. " + getQuestionsList()[j + temp + roundNum - 1].getAnswer2());
                System.out.println("3. " + getQuestionsList()[j + temp + roundNum - 1].getAnswer3());
                System.out.println("4. " + getQuestionsList()[j + temp + roundNum - 1].getAnswer4());
                Scanner answer = new Scanner(System.in);
                System.out.print("Your answer is: ");
                int newAnswer = answer.nextInt();
                if(newAnswer == getQuestionsList()[j + temp + roundNum - 1].getRightAnswer()) {
                    System.out.println("Congratulations!!! You have chosen right answer: " + newAnswer);
                    this.score[i] = this.score[i] + 1;
                } else {
                    System.out.println("Sorry!!! You have chosen wrong answer. Correct answer is: " +
                            getQuestionsList()[j + temp + roundNum - 1].getRightAnswer());
                }
                timeDelay(3);
            }
        }
    }

    private int getTemp(int roundNum) {
        int temp = 0;
        switch (roundNum) {
            case 1:
                return temp;
            case 2:
                return temp = 2;
            case 3:
                return temp = 4;
            case 4:
                return temp = 6;
            default:
                return temp = 8;
        }
    }

    private void timeDelay(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch(InterruptedException ex) {}
    }
}
