public class Student {
    String name;
    int[] quizScores;

    public Student(String name, int[] quizScores) {
        this.name = name;
        this.quizScores = quizScores;
    }

    public String getName() {
        return name;
    }

    public int[] getQuizScores() {
        return quizScores;
    }
}
