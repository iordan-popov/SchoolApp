package com.oryx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.oryx.model.Login;
import com.oryx.model.User;
import com.oryx.service.SubjectService;
import com.oryx.service.UserService;

@Controller
@SessionAttributes("key")
public class LoginController {

	@Autowired // makes the object search by itself. Removes the need of parameters in xml.
				// Creates object and gives it to us.
	// works only over interfaces !!!
	UserService userService;
	
	@Autowired
	SubjectService subjectService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView showlogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("index");

		return mv;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST) // vruzva s formata
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@ModelAttribute("login") Login login) { // I assume @modelAttribute gets the data from login Process and
													
		
		session = request.getSession();
		
		
		ModelAndView mv = null;

		User user = userService.validateUser(login); //

		List<User> list;
		List listUsers = userService.listUsersOnly();
		List listSubjects = subjectService.listSubjects();
		String consoleMessage = "";
		if (user != null) {
			if (user.getAdmin() == 1) {
				list = userService.listNameGradeSubjectOfUsers();
				consoleMessage = "Admin Console";
			} else {
				list = userService.listUser(login);
				consoleMessage = "Student Page";
			}

			mv = new ModelAndView("showMarks");
			mv.addObject("consoleMessage", consoleMessage);
			mv.addObject("listUserGradeObjects", list);
			mv.addObject("listUsers", listUsers);
			mv.addObject("listSubjects", listSubjects);
			mv.addObject("name", user.getName());
			
			session.setAttribute("key", user.getId());
			session.setAttribute("name", user.getName());
			session.setAttribute("isAdmin", user.getAdmin());
			session.setAttribute("action", "default");
		} else {
			mv = new ModelAndView("index");

			mv.addObject("message", "Username or Password is wrong, Please try again.");
		}

		return mv;
	}

	/*public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User validateUser(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

	public void register(User user) {
		// TODO Auto-generated method stub

	}*/

}
