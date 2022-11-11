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
@Table(name = "students" )
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "")
    @SequenceGenerator(name = "student_generator",
            sequenceName = "student_sequence",
            allocationSize = 1)
    private Long studentId;
    @Column(name = "student_first_name")
    private String studentFirstName;
    @Column(name = "student_email")
    private String studentEmail;
    @Column(name = "student_last_name")
    private String studentLastName;
    @Enumerated
    private FormatStudy formatStudy;
    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.REMOVE,CascadeType.REFRESH})
    @JoinColumn(name = "groups_id")
    private  Group groups;



    @Transient
    private Long groupId;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentFirstName='" + studentFirstName + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", studentLastName='" + studentLastName + '\'' +
                ", formatStudy=" + formatStudy +
                ", groupId=" + groupId +
                '}';
    }

    public enum FormatStudy {

        ONLINE,
        OFFLINE
    }
}
