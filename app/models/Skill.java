package models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq_gen")
    @SequenceGenerator(name = "skill_seq_gen", sequenceName = "skill_seq_gen", allocationSize = 1)
    @Column(name = "id_skill")
    public int idSkill;

    @Column(nullable = false, unique = true)
    public String name;

    @Column(nullable = false)
    public String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_category", nullable = false)
    public SkillCategory category;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "skill_employee",
                joinColumns = {@JoinColumn(name = "id_skill", nullable = false)},
                inverseJoinColumns = {@JoinColumn(name = "id_employee", nullable = false)})
    public List<Employee> employees;
}
