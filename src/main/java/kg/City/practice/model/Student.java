package kg.City.practice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "")
    @SequenceGenerator(name = "student_generator",
            sequenceName = "student_sequence",
            allocationSize = 1)
    private long studentId;
    @Column(name = "student_first_name")
    private String studentFirstName;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_last_name")
    private String studentLastName;
    @Column(name = "student_duration")
    private ForStudent forStudent;

    @ManyToOne
    @JoinColumn(name = "group")
    private Group group;

    public Student(){
    }

    public Student(String studentFirstName, String studentEmail, String studentLastName, ForStudent forStudent) {
        this.studentFirstName = studentFirstName;
        this.studentEmail = studentEmail;
        this.studentLastName = studentLastName;
        this.forStudent = forStudent;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public void setStudentFirstName(String studentFirstName) {
        this.studentFirstName = studentFirstName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setStudentLastName(String studentLastName) {
        this.studentLastName = studentLastName;
    }

    public ForStudent getForStudent() {
        return forStudent;
    }

    public void setForStudent(ForStudent forStudent) {
        this.forStudent = forStudent;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", forStudent=" + forStudent +
                '}';
    }
}
