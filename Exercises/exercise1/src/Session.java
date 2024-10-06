import java.util.*;

public class Session {
    Student[] students;

    public Session(Student[] students) {
        this.students = students;
    }

    public void calAverQuizScore() {
        System.out.println("---------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            System.out.print(students[i].getName());
            if (students[i].getQuizScores() == null || students[i].getQuizScores().length == 0)
                System.out.print(0);

            int sum = 0;
            for (int j = 0; j < students[i].getQuizScores().length; j++) {
                sum += students[i].getQuizScores()[j];
            }

            double average = (double)sum / students[i].getQuizScores().length;
            String averageStr = String.format("%.2f", average);

            System.out.println("Name: " + students[i].getName() + ", Average Quiz Scores: " + averageStr);
        }
    }

    public void listQuizScores() {
        System.out.println("---------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            Arrays.sort(students[i].getQuizScores());
            System.out.println("Name: " + students[i].getName() + ", Quiz Scores: " + Arrays.toString(students[i].getQuizScores()));
        }
    }

    public void getPartTimeName() {
        System.out.println("---------------------------------------------");
        System.out.print("Part time students are: ");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i] instanceof PartTimeStudent && i != students.length - 1) {
                System.out.print(students[i].getName() + ", ");
            }
            else if (students[i] != null && students[i] instanceof PartTimeStudent && i == students.length - 1) {
                System.out.println(students[i].getName());
            }
        }
    }

    public void getFullExamScores() {
        System.out.println("---------------------------------------------");
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i] instanceof FullTimeStudent) {
                System.out.println("Name: " + students[i].getName() + ", Exam Scores: " + ((FullTimeStudent)students[i]).getExamScores()[0] + ", " + ((FullTimeStudent)students[i]).getExamScores()[1]);
            }
        }
    }
}
