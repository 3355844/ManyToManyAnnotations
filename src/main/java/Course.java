import javax.persistence.*;

/**
 * Created by user on 05.01.2017.
 */
@Entity
@Table(name = "COURSE")
public class Course {

    private long courseId;
    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public Course() {
    }

    @Id
    @GeneratedValue
    @Column(name = "COURSE_ID")
    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Column(name = "COURSE_NAME")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
