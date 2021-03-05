package finaltaskforadvancedjava.quiz;



import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//Skapa en klass som håller reda på frågor och svaralternativ och vilket svarsalternativ som är rätt.
public class Quiz implements Serializable {

    String question;
    String answer1;
    String answer2;
    String answer3;


    public Quiz(String newQuestion, String newAnswer1, String newAnswer2, String newAnswer3) {
        this.question = newQuestion;
        this.answer1 = newAnswer1;
        this.answer2 = newAnswer2;
        this.answer3 = newAnswer3;

    }
static LinkedList<Quiz> testList = new LinkedList();
    //Ska också innehålla en metod som ska läsa in de serialiserade frågeobjekten från en fil.

    public static void startGame() throws Exception{

        
        Quiz q1 = new Quiz("Hur många landskap har Sverige?", "20 stycken.", "25 stycken.", "28 stycken.");
        Quiz q2 = new Quiz("Vilket av dessa flygbolag är tyskt?", "Lufthansa", "SAS", "WizzAir");
        Quiz q3 = new Quiz("Hur gammal var Einstein när han dog?", "56 år gammal.", "66 år gammal.", "76 år gammal.");
        Quiz q4 = new Quiz("Hur många länder ingår i EU?", "26 stycken.", "27 stycken.", "28 stycken.");
        Quiz q5 = new Quiz("Hur gammalt är JAVA?", "20 år gammalt.", "30 år gammalt.", "40 år gammalt.");
        Quiz q6 = new Quiz("Hur stort är Sverige till ytan?", "450 295 km².", "400 295 km².", "445 295 km².");
        
        
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/Users/trong_5qwu0lf/OneDrive/Dokument/EC Javautvecklare/Javakurs/Advancera Java/finaltaskforadvancedjava/quiz/questions.txt"));

        out.writeObject(q1);
        out.writeObject(q2);
        out.writeObject(q3);
        out.writeObject(q4);
        out.writeObject(q5);
        out.writeObject(q6);
        //out.writeObject(testList.get(0));

        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Users/trong_5qwu0lf/OneDrive/Dokument/EC Javautvecklare/Javakurs/Advancera Java/finaltaskforadvancedjava/quiz/questions.txt"));

        Quiz a1 = (Quiz) in.readObject();
        Quiz a2 = (Quiz) in.readObject();
        Quiz a3 = (Quiz) in.readObject();
        Quiz a4 = (Quiz) in.readObject();
        Quiz a5 = (Quiz) in.readObject();
        Quiz a6 = (Quiz) in.readObject();
        //Quiz a7 = (Quiz) in.readObject();
        testList.add(a1);
        testList.add(a2);
        testList.add(a3);
        testList.add(a4);
        testList.add(a5);
        testList.add(a6);

        in.close();


        Scanner input = new Scanner(System.in);
        System.out.println(a1.question);
        System.out.println("1. " + a1.answer1);
        System.out.println("2. " + a1.answer2);
        System.out.println("3. " + a1.answer3);
        System.out.println("Skriv svaret här: ");




        int nr2 = input.nextInt();


        if (nr2 == 2) {
            System.out.println("Rätt svar");


        } else {

            System.out.println("Fel svar ");

        } 
        //System.out.println(a7.question);
        // System.out.println("1. " + a7.answer1);
        // System.out.println("2. " + a7.answer2);
        // System.out.println("3. " + a7.answer3);
        // System.out.println("Skriv svaret här: ");




        // int nr3 = input.nextInt();


        // if (nr3 == 2) {
        //     System.out.println("Rätt svar");


        // } else {

        //     System.out.println("Fel svar ");

        // }

    }
    public static void startMenu() throws IOException, Exception{


        System.out.println("-------------------------------------------");
        System.out.println("Tryck in en siffra för vad du vill göra");
        System.out.println("-------------------------------------------");
        System.out.println(" 1. Spela spelet ");
        System.out.println(" 2. Visa en lista med frågorna ");
        System.out.println(" 3. Lägg till en fråga ");
        System.out.println(" 4. Ta bort en fråga ");
        System.out.println(" 5. Redigera en fråga ");
        System.out.println("-------------------------------------------");

        Scanner input = new Scanner(System.in);
        int nr = input.nextInt();

        switch (nr) {
            case 1:
               Player.createNewPlayer();
                startGame();
                break;
            case 2:
                questionsFile();
                
                break;
            case 3:
                
            addQuestion();

                Scanner sc = new Scanner(System.in);

                System.out.println("Skriv din fråga");
                String question = sc.nextLine();

                System.out.println("Skriv svarsalternativ 1");
                String answer1 = sc.nextLine();

                System.out.println("Skriv svarsalternativ 2");
                String answer2 = sc.nextLine();

                System.out.println("Skriv svarsalternativ 3");
                String answer3 = sc.nextLine();


                // ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Users/trong_5qwu0lf/OneDrive/Dokument/EC Javautvecklare/Javakurs/Advancera Java/finaltaskforadvancedjava/quiz/questions.txt"));

                // Quiz a1 = (Quiz) in.readObject();
                // Quiz a2 = (Quiz) in.readObject();
                // Quiz a3 = (Quiz) in.readObject();
                // Quiz a4 = (Quiz) in.readObject();
                // Quiz a5 = (Quiz) in.readObject();
                // Quiz a6 = (Quiz) in.readObject();

                // in.close();



                testList.add(new Quiz(question, answer1,answer2, answer3));


                System.out.println(testList);


                break;
            case 4:
                // kod block
                break;
            case 5:
                // kod block
                break;
            default:
        }
    }


    public static void questionsFile() throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Users/trong_5qwu0lf/OneDrive/Dokument/EC Javautvecklare/Javakurs/Advancera Java/finaltaskforadvancedjava/quiz/questions.txt"));

        Quiz a1 = (Quiz) in.readObject();
        Quiz a2 = (Quiz) in.readObject();
        Quiz a3 = (Quiz) in.readObject();
        Quiz a4 = (Quiz) in.readObject();
        Quiz a5 = (Quiz) in.readObject();
        Quiz a6 = (Quiz) in.readObject();
        //Quiz a7 = (Quiz) in.readObject();
        testList.add(a1);
        testList.add(a2);
        testList.add(a3);
        testList.add(a4);
        testList.add(a5);
        testList.add(a6);

        in.close();
       // String questionList = "C:/Users/trong_5qwu0lf/OneDrive/Dokument/EC Javautvecklare/Javakurs/Advancera Java/finaltaskforadvancedjava/quiz/questions.txt";

        LinkedList<Quiz> questions = testList;
       /* questions
                .forEach(System.out::println); */
                System.out.println(Quiz.testList);
    }

    @Override
    public String toString() {
        return "Question= " + question  
                ;
    }
    public static void addQuestion(){

        System.out.println("Lägg till fråga och svarsalternativ");
    }




}


