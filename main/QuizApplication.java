import java.util.Scanner;

public class QuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        Scanner scanner = new Scanner(System.in);

        // Sample questions
        quiz.addQuestion(new Question("What is the capital of India?", new String[]{"New Delhi", "Mumbai", "Kolkata", "Chennai"}, 0));
        quiz.addQuestion(new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 1));
        quiz.addQuestion(new Question("What is the largest ocean on Earth?", new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 3));
        quiz.addQuestion(new Question("Who is the current Prime Minister of India?", new String[]{"Narendra Modi", "Rahul Gandhi", "Amit Shah", "Manmohan Singh"}, 0));
        quiz.addQuestion(new Question("What is the chemical symbol for water?", new String[]{"H2O", "O2", "CO2", "NaCl"}, 0));
        quiz.addQuestion(new Question("What is the smallest prime number?", new String[]{"0", "1", "2", "3"}, 2));
        quiz.addQuestion(new Question("What is the tallest mountain in the world?", new String[]{"K2", "Kangchenjunga", "Mount Everest", "Lhotse"}, 2));
        quiz.addQuestion(new Question("Who was the first president of the United States?", new String[]{"George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams"}, 0));
        quiz.addQuestion(new Question("What is the speed of light?", new String[]{"300,000 km/s", "150,000 km/s", "450,000 km/s", "600,000 km/s"}, 0));
        quiz.addQuestion(new Question("Who developed the Java programming language?", new String[]{"James Gosling", "Bjarne Stroustrup", "Guido van Rossum", "Dennis Ritchie"}, 0));
        quiz.addQuestion(new Question("What is the capital of Uttar Pradesh?", new String[]{"Lucknow", "Kanpur", "Varanasi", "Agra"}, 0));

        int score = 0;

        for (Question question : quiz.getQuestions()) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int userAnswer = getUserInput(scanner, options.length);
            if (question.isCorrect(userAnswer - 1)) {
                score++;
            }
        }

        System.out.println("Your score: " + score + "/" + quiz.getQuestions().size());
        scanner.close();
    }

    private static int getUserInput(Scanner scanner, int numOptions) {
        int userAnswer = -1;
        while (userAnswer < 1 || userAnswer > numOptions) {
            System.out.print("Enter your answer (1-" + numOptions + "): ");
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();
                if (userAnswer < 1 || userAnswer > numOptions) {
                    System.out.println("Invalid input. Please enter a number between 1 and " + numOptions + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return userAnswer;
    }
}


