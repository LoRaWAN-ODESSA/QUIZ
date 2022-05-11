import java.util.ArrayList;
import java.util.Collections;

public class Question {
    public static final int NUM_QUESTIONS = 12;

    public static final String[] QUESTIONS = {"What is the name of the main antagonist in the Shakespeare play Othello?",
    "What element is denoted by the chemical symbol Sn in the periodic table?",
    "What is the name of the 1976 film about the Watergate scandal, starring Robert Redford and Dustin Hoffman?",
    "What was the most popular girls name in the UK in 2019?", "What is the currency of Denmark?",
    "How many films have Al Pacino and Robert De Niro appeared in together?", "What is the smallest planet in our solar system?",
    "What was the Turkish city of Istanbul called before 1930?", "Name the Coffee shop in US sitcom Friends?",
    "What is the capital of New Zealand?", "Which Disney Princess called Gus and Jaq friends?",
    "The Simpsons was the spin-off show of which American sketch series?", "Gillian Anderson plays a therapist in which hit Netflix show?",
    "Name the first actor to play Dumbledore in the Harry Potter films.", "Which colour pill does Neo swallow in The Matrix?",
    "Name the composer behind the soundtracks of The Lion King, Inception and Pirates of the Caribbean."};

    public static final String[] ANSWERS = {"Othello", "Iago", "Cassio", "Roderigo", "Tin", "Silver", "Gold", "Samarium", "Titanic", "All the President's Men",
    "Marathon Man", "Hero", "Angela", "Sara", "Tetiana", "Olivia", "Krone", "Euro", "Lira", "Rubble", "0", "5", "4", "1", "Mars", "Pluto", "Earth",
    "Mercury", "Las Vegas", "Ankara", "Constantinople", "No name", "Central Perk", "Central Park", "Zozo bar", "Park", "Auckland", "Wellington",
    "Hamilton", "Christchurch", "Cinderella", "Pocahontas", "Lilo & Stitch", "Ice Princess", "Beavis and Butt-head", "The Critic",
    "The Tracey Ullman Show", "King of the Hill", "The Sunlit Night", "Crooked House", "The Pale Blue Eye", "Sex Education",
    "Richard Harris", "Michael Gambon", "Jude Law", "Hubert Fielden", "Red", "Blue", "Black", "White", "John Williams", "Jani Rantanen",
    "Hanz Zimmer", "Robert Pattinson"};

    public static final int[] RIGHT_ANSWERS = {2, 1, 2, 4, 1, 3, 4, 3, 1, 2, 1, 3, 4, 1, 1, 3};
    private int numQuestion;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int rightAnswer;
    private Question[] questionsList;

    public Question(int numQuestion, String question, String answer1, String answer2, String answer3, String answer4, int rightAnswer) {
        this.numQuestion = numQuestion;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.rightAnswer = rightAnswer;
    }

    public Question() {
        //EMPTY
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Question[] getQuestionsList() {
        questionsList = createQuestionList();
        return questionsList;
    }

    public void setQuestionsList(Question[] questionsList) {
        this.questionsList = questionsList;
    }

    public int getNumQuestion() {
        return numQuestion;
    }

    public void setNumQuestion(int numQuestion) {
        this.numQuestion = numQuestion;
    }

    private int[] generateNumList (int maxQuestions) {
        int[] numList = new int[NUM_QUESTIONS];
        ArrayList numbers = new ArrayList<>();
        for(int i = 0; i < maxQuestions; i++)
        {
            numbers.add(i+1);
        }
        Collections.shuffle(numbers);
        for(int j =0; j < NUM_QUESTIONS; j++)
        {
            numList[j] = (int) numbers.get(j);
        }
        return numList;
    }

    private Question[] createQuestionList() {
        int temp = 0;
        int[] numList = generateNumList(NUM_QUESTIONS);
        Question[] fullQuestionList = new Question[QUESTIONS.length];
        for (int i = 0; i < QUESTIONS.length; i++) {
            Question question = new Question(i, QUESTIONS[i], ANSWERS[i + temp], ANSWERS[i + 1 + temp],
                    ANSWERS[i + 2 + temp], ANSWERS[i + 3 + temp], RIGHT_ANSWERS[i]);
             fullQuestionList[i] = question;
             temp += 3;
        }
        questionsList = new Question[NUM_QUESTIONS];
        for (int i = 0; i < NUM_QUESTIONS; i++) {
            questionsList[i] = fullQuestionList[numList[i]];
        }
        return questionsList;
    }
}
