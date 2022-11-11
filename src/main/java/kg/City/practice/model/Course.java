package kg.City.practice.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "")
    @SequenceGenerator(name = "course_generator",
            sequenceName = "course_sequence",
            allocationSize = 1)
    @Column(name = "id")
    private long courseId;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "course_duration")
    private String duration;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "company_id")
    private Company company;
    @Transient
    private Long companyId;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(name = "groups_courses", joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "groups_id"))
    private List<Group> groups;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(name = "teachers_courses", joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "teachers_id"))
    private Teacher teacher;

}
