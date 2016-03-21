package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Skill.class)
public abstract class Skill_ {

	public static volatile SingularAttribute<Skill, Integer> idSkill;
	public static volatile SingularAttribute<Skill, String> name;
	public static volatile SingularAttribute<Skill, String> description;
	public static volatile SingularAttribute<Skill, SkillCategory> category;
	public static volatile ListAttribute<Skill, Employee> employees;

}

