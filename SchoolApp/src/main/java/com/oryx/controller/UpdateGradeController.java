package com.oryx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.oryx.model.User;
import com.oryx.service.GradeService;
import com.oryx.service.SubjectService;
import com.oryx.service.UserService;

@SessionAttributes
@Controller
public class UpdateGradeController {

	@Autowired
	UserService userService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	GradeService gradeService;

	@RequestMapping(value = "/updateGradePanel", method = RequestMethod.GET)
	public ModelAndView updateMak(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		session.setAttribute("action", "update");

		System.out.println(session.getAttribute("action"));
		ModelAndView mv = new ModelAndView("showMarks");

		String consoleMessage = "Admin Console";
		List<User> list = userService.listNameGradeSubjectOfUsers();
		List listUsers = userService.listUsersOnly();
		List listSubjects = subjectService.listSubjects();

		mv.addObject("consoleMessage", consoleMessage);
		mv.addObject("listUserGradeObjects", list);
		mv.addObject("listUsers", listUsers);
		mv.addObject("listSubjects", listSubjects);

		return mv;
	}

	@RequestMapping(value = "/updateGrade", method = RequestMethod.POST)
	public ModelAndView updateGrade(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("Student") String studentName, @RequestParam("Subject") String subject,
			@RequestParam("grade") String gradeStr, @RequestParam("newGrade") String newGradeStr) {

		int grade = Integer.valueOf(gradeStr);
		int newGrade = Integer.valueOf(newGradeStr);

		ModelAndView mv = new ModelAndView("showMarks");

		int studentID = userService.getUserID(studentName);
		int subjectID = subjectService.getSubjectID(subject);

		gradeService.updateGrade(grade, subjectID, studentID, newGrade);

		String consoleMessage = "Admin Console";
		List<User> list = userService.listNameGradeSubjectOfUsers();
		List listUsers = userService.listUsersOnly();
		List listSubjects = subjectService.listSubjects();

		mv.addObject("consoleMessage", consoleMessage);
		mv.addObject("listUserGradeObjects", list);
		mv.addObject("listUsers", listUsers);
		mv.addObject("listSubjects", listSubjects);

		return mv;

	}

}
