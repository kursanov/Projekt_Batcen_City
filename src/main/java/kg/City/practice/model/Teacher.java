package kg.City.practice.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(name = "teachers_courses", joinColumns = @JoinColumn(name = "teachers_id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private Course course;

    @Transient
    private Long courseId;

}
