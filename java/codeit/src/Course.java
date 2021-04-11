public class Course {

    public static final int CREDIT_MAJOR = 3;
    public static final int CREDIT_GENERAL = 2;

    private String course;
    private int credit;
    private String grade;

    Course(String course, int credit, String grade) {
        this.course = course;
        this.credit = credit;
        this.grade = grade;
    }

    public String getCourse() {
        return course;
    }

    public int getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }

    public double getGradeNum() {
        double gradeNum = 0.0;
        switch (getGrade()) {
            case "A+":
                gradeNum = 4.5;
                break;
            case "A":
                gradeNum = 4.0;
                break;
            case "B+":
                gradeNum = 3.5;
                break;
            case "B":
                gradeNum = 3.0;
                break;
            case "C+":
                gradeNum = 2.5;
                break;
            case "C":
                gradeNum = 2.0;
                break;
            case "D+":
                gradeNum = 1.5;
                break;
            case "D":
                gradeNum = 1.0;
                break;
        }
        return gradeNum;
    }

    public double getScore() {
        return getGradeNum() * credit;
    }
}
