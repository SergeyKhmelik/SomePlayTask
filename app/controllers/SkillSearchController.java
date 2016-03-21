package controllers;

import com.google.inject.Inject;
import io.swagger.annotations.*;
import models.Employee;
import models.Skill;
import models.SkillCategory;
import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;
import services.SkillExpertSearchService;

import java.util.List;

import static play.libs.Json.setObjectMapper;
import static play.libs.Json.toJson;

@Api(value = "/", description = "The search of experts.")
public class SkillSearchController extends Controller {

    @Inject
    SkillExpertSearchService searchService;


    @ApiOperation(
            nickname = "getAllCategories",
            value = "Find all skill categories",
            notes = "Returns all skill categories as a list.",
            response = SkillCategory.class,
            responseContainer = "List",
            httpMethod = "GET")
    @Transactional
    public Result getAllCategories() {
        List<SkillCategory> categories = searchService.getCategories();
        return ok(toJson(categories));
    }

    @Transactional
    public Result yetAnotherController() {
        System.out.println("Nothing to be typed");
        return badRequest();
    }

    @ApiOperation(
            nickname = "getCategory",
            value = "Find skill category info by name",
            notes = "Returns skill category information.",
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = SkillCategory.class),
            @ApiResponse(code = 404, message = "No category with such param name found.")})
    @Transactional
    public Result getCategory(
            @ApiParam(value = "Category name.") String categoryName) {
        SkillCategory category = searchService.getCategory(categoryName);
        if (category == null) return notFound();
        return ok(toJson(category));
    }


    @ApiOperation(
            nickname = "getSkillsByCategory",
            value = "Find all skills of a category.",
            notes = "Returns all skills, where category name is equal to path param name.",
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Skill.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "No category with such param name found.")})
    @Transactional
    public Result getSkills(
            @ApiParam(value = "Category name.") String categoryName) {
        List<Skill> skills = searchService.getSkills(categoryName);
        if (skills == null) return notFound();
        return ok(toJson(skills));
    }


    @ApiOperation(
            nickname = "getSkillsByCategory",
            value = "Find all skills of a category.",
            notes = "Returns all skills, where category name is equal to path param name.",
            response = Skill.class,
            responseContainer = "List",
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Skill.class),
            @ApiResponse(code = 404, message = "No category or skill with such param names found.")})
    @Transactional
    public Result getSkill(
            @ApiParam(value = "Category name.") String categoryName,
            @ApiParam(value = "Skill name.") String skillName) {
        Skill skill = searchService.getSkill(skillName, categoryName);
        if (skill == null) return notFound();
        return ok(toJson(skill));
    }


    @ApiOperation(
            nickname = "getEmployeesBySkill",
            value = "Find all employees by skill.",
            notes = "Returns all employees, where category name is equal to path category param" +
                    " and skill is equal to path skill param.",
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = Employee.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "No category or skill with such param names found.")})
    @Transactional
    public Result getEmployees(
            @ApiParam(value = "Category name.") String categoryName,
            @ApiParam(value = "Skill name.") String skillName) {
        List<Employee> employees = searchService.getEmployees(skillName, categoryName);
        if (employees == null) return notFound();
        return ok(toJson(employees));
    }
}