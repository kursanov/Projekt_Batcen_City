package kg.City.practice.model;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companies")
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "")
    private Long companyId;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;
    
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE,CascadeType.REFRESH}, mappedBy = "company")
    private List<Course> course;
}
