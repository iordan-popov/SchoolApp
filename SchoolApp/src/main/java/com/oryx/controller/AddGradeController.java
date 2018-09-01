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
import com.oryx.service.SubjectService;
import com.oryx.service.UserService;

@Controller
@SessionAttributes("key")
public class AddGradeController {

	@Autowired
	UserService userService;

	@Autowired
	SubjectService subjectService;

	@RequestMapping(value = "/AddGradePanel", method = RequestMethod.GET)
	public ModelAndView getMarkView(HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		session.setAttribute("action", "add");

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

	@RequestMapping(value = "/addGrade", method = RequestMethod.POST)
	public ModelAndView addMark(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam("Student") String studentName, @RequestParam("Subject") String subject,
			@RequestParam("grade") String gradeStr) {

		int grade = Integer.valueOf(gradeStr);

		/*
		 * System.out.printf("%s, %s, %d ",studentName, subject, grade);
		 * 
		 * System.out.println();
		 */

		int subjectID = subjectService.getSubjectID(subject);
		System.out.println(subject + " SubjectID: " + subjectID);

		int studentID = userService.getUserID(studentName);
		System.out.println(studentName + " This is studentID: " + studentID);

		userService.insertUserMark(grade, subjectID, studentID);

		List list = userService.listNameGradeSubjectOfUsers();
		List listUsers = userService.listUsersOnly();
		List listSubjects = subjectService.listSubjects();
		String consoleMessage = "Admin Console";

		ModelAndView mv = new ModelAndView("showMarks");
		mv.addObject("name", session.getAttribute("name"));
		mv.addObject("consoleMessage", consoleMessage);
		mv.addObject("listUserGradeObjects", list);
		mv.addObject("listSubjects", listSubjects);
		mv.addObject("listUsers", listUsers);

		return mv;
	}
}
