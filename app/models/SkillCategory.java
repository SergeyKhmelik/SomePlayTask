package models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "skill_category")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "skill_category")
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq_gen")
    @SequenceGenerator(name = "skill_seq_gen", sequenceName = "skill_seq_gen", allocationSize = 1)
    @Column(name = "id_category")
    public int idSkillCategory;

    @Column(nullable = false, unique = true)
    public String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", orphanRemoval = true)
    public Set<Skill> skills;
}
