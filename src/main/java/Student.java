import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 05.01.2017.
 */
@Entity
@Table(name = "STUDENT")
public class Student {
    private long studentId;
    private String studentName;
    private Set<Course> courses = new HashSet<Course>(0);

    public Student(String studentName, Set<Course> courses) {
        this.studentName = studentName;
        this.courses = courses;
    }

    public Student() {
    }

    @Id
    @GeneratedValue
    @Column(name = "STUDENT_ID")
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    @Column(name = "STUDENT_NAME", nullable = false, length = 300)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE", joinColumns = {@JoinColumn(name = "STUDENT_ID")}, inverseJoinColumns = {@JoinColumn(name = "COURSE_ID")})
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
