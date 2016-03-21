package services;

import models.*;

import java.util.List;

import play.db.jpa.JPA;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class SkillExpertSearchServiceImpl implements SkillExpertSearchService {

    @Override
    public List<SkillCategory> getCategories() {
        CriteriaBuilder builder = JPA.em().getCriteriaBuilder();

        CriteriaQuery<SkillCategory> criteria = builder.createQuery(SkillCategory.class);
        Root<SkillCategory> categoryRoot = criteria.from(SkillCategory.class);
        criteria.select(categoryRoot);

        return JPA.em().createQuery(criteria).getResultList();
    }

    @Override
    public SkillCategory getCategory(String categoryName) {
        CriteriaBuilder builder = JPA.em().getCriteriaBuilder();

        CriteriaQuery<SkillCategory> criteria = builder.createQuery(SkillCategory.class);
        Root<SkillCategory> categoryRoot = criteria.from(SkillCategory.class);
        criteria
                .select(categoryRoot)
                .where(builder.equal(categoryRoot.get(SkillCategory_.name), categoryName));

        List<SkillCategory> categories = JPA.em().createQuery(criteria).getResultList();
        return categories.isEmpty() ? null : categories.get(0);
    }

    @Override
    public List<Skill> getSkills(String categoryName) {
        CriteriaBuilder builder = JPA.em().getCriteriaBuilder();

        CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
        Root<Skill> skillRoot = criteria.from(Skill.class);
        Join<Skill, SkillCategory> categoryJoin = skillRoot.join(Skill_.category);
        criteria
                .select(skillRoot)
                .where(builder.equal(categoryJoin.get(SkillCategory_.name), categoryName));

        List<Skill> skills = JPA.em().createQuery(criteria).getResultList();
        return skills.isEmpty() ? null : skills;
    }

    @Override
    public Skill getSkill(String skillName, String categoryName) {
        CriteriaBuilder builder = JPA.em().getCriteriaBuilder();

        CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
        Root<Skill> skillRoot = criteria.from(Skill.class);
        Join<Skill, SkillCategory> categoryJoin = skillRoot.join(Skill_.category);
        criteria
                .select(skillRoot)
                .where(builder.equal(skillRoot.get(Skill_.name), skillName))
                .where(builder.equal(categoryJoin.get(SkillCategory_.name), categoryName));

        List<Skill> skills = JPA.em().createQuery(criteria).getResultList();
        return skills.isEmpty() ? null : skills.get(0);
    }

    @Override
    public List<Employee> getEmployees(String skillName, String categoryName) {
        CriteriaBuilder builder = JPA.em().getCriteriaBuilder();

        CriteriaQuery<Skill> criteria = builder.createQuery(Skill.class);
        Root<Skill> skillRoot = criteria.from(Skill.class);
        Join<Skill, SkillCategory> categoryJoin = skillRoot.join(Skill_.category);
        criteria
                .select(skillRoot)
                .where(builder.equal(skillRoot.get(Skill_.name), skillName))
                .where(builder.equal(categoryJoin.get(SkillCategory_.name), categoryName));

        List<Skill> skills = JPA.em().createQuery(criteria).getResultList();
        return skills.isEmpty() ? null : skills.get(0).employees;
    }
}