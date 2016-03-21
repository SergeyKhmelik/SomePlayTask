package services;

import com.google.inject.ImplementedBy;
import models.Employee;
import models.Skill;
import models.SkillCategory;

import java.util.List;

@ImplementedBy(SkillExpertSearchServiceImpl.class)
public interface SkillExpertSearchService {

    List<SkillCategory> getCategories();

    SkillCategory getCategory(String categoryName);

    List<Skill> getSkills(String categoryName);

    Skill getSkill(String skillName, String categoryName);

    List<Employee> getEmployees(String skillName, String categoryName);
}
