package kg.City.practice.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "")
    @SequenceGenerator(name = "group_generator",
            sequenceName = "group_sequence",
            allocationSize = 1)
    private long groupId;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "date_of_Start")
    private String dateOfStart;
    @Column(name = "date_of_finish")
    private  String dataOfFinish;



    @OneToMany(fetch = FetchType.EAGER,
    cascade = {CascadeType.MERGE,CascadeType.REMOVE},
    mappedBy = "group")
    private List<Student> student;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_group",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Course>courses;

    @ManyToOne
    @JoinColumn(name = "group")
    private Group group;

    public Group(){
    }

    public Group(String groupName, String dateOfStart, String dataOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dataOfFinish = dataOfFinish;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getDataOfFinish() {
        return dataOfFinish;
    }

    public void setDataOfFinish(String dataOfFinish) {
        this.dataOfFinish = dataOfFinish;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", dateOfStart='" + dateOfStart + '\'' +
                ", dataOfFinish='" + dataOfFinish + '\'' +
                '}';
    }
}
