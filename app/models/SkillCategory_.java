package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SkillCategory.class)
public abstract class SkillCategory_ {

	public static volatile SetAttribute<SkillCategory, Skill> skills;
	public static volatile SingularAttribute<SkillCategory, Integer> idSkillCategory;
	public static volatile SingularAttribute<SkillCategory, String> name;

}

