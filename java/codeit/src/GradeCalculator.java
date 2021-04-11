import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {

    private String name;
    private double avg;
    private int credit;
    private List<Course> courses;

    GradeCalculator(String name, double avg, int credit) {
        this.name = name;
        this.avg = avg;
        this.credit = credit;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void print() {

        int total_credit = 0;
        double total_score = 0;
        for (Course course : courses) {
            total_credit += course.getCredit();
            total_score += course.getScore();
        }

        System.out.println("직전 학기 성적: " + avg + " (총 " + credit + "학점)");
        System.out.println("이번 학기 성적: " + (total_score / total_credit) + " (총 " + total_credit + "학점)");
        System.out.println("전체 예상 학점: " + (((avg * credit) + total_score) / (credit + total_credit)) + " (총 " + (credit + total_credit) + "학점)");
    }
}
