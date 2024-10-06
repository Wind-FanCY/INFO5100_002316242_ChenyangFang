public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++){

            if (i > 11) {
                int[] quizScores = {4, 6, 12, 9, 10, 12, 11, 7, 9, 10, 17, 15, 6, 18, 13};
                students[i] = new PartTimeStudent("John", quizScores);
            }
            else {
                int[] quizScores = {7, 8, 12, 10, 10, 14, 11, 8, 9, 10, 17, 15, 8, 20, 14};
                int[] examScores = {97, 87};
                students[i] = new FullTimeStudent("Alice", quizScores, examScores);
            }
        }

        Session classes = new Session(students);

        classes.calAverQuizScore();
        classes.listQuizScores();
        classes.getPartTimeName();
        classes.getFullExamScores();
    }
}
