package kg.City.practice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "")
    @SequenceGenerator(name = "teacher_generator",
            sequenceName = "teacher_sequence",
            allocationSize = 1)
    private long teacherId;
    @Column(name = "teacher_first_name")
    private  String teacherFirstName;
    @Column(name = "teacher_email")
    private String teacherEmail;
    @Column(name = "teacher_last_name")
    private String teacherLastName;

    @OneToOne
    @JoinColumn(name = "course")
    private Course cours;


    public Teacher(){
    }

    public Teacher(String teacherFirstName, String teacherEmail, String teacherLastName) {
        this.teacherFirstName = teacherFirstName;
        this.teacherEmail = teacherEmail;
        this.teacherLastName = teacherLastName;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public Course getCours() {
        return cours;
    }

    public void setCours(Course cours) {
        this.cours = cours;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherEmail='" + teacherEmail + '\'' +
                ", teacherLastName='" + teacherLastName + '\'' +
                '}';
    }
}
