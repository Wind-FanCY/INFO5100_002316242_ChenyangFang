public class FullTimeStudent extends Student{
    private int[] examScores;

    public FullTimeStudent(String name, int[] quizScores, int[] examScores ) {
        super(name, quizScores);
        this.examScores = examScores;
    }

    public int[] getExamScores() {
        return examScores;
    }
}
