package kg.City.practice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "")
    @SequenceGenerator(name = "course_generator",
            sequenceName = "course_sequence",
            allocationSize = 1)
    @Column(name = "id")
    private long groupId;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "start_of_date")
    private String startOfDate;
    @Column(name = "finish_of_date")
    private String finishOfDate;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinTable(name = "groups_courses", joinColumns = @JoinColumn(name = "groups_id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id"))
    private List<Course> courses;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.REMOVE,CascadeType.REFRESH}, mappedBy = "groups")
    private List<Student> students;

    @Transient
    private Long courseId;
}
