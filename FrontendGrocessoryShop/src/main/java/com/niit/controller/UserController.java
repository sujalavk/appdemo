package com.niit.controller;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.Dao.ProductDao;
import com.niit.Dao.UserDao;
import com.niit.Model.User;


@Controller
public class UserController 
{
	@Autowired
	private ProductDao productDAO;
	@Autowired
	private UserDao userDAO;
	
	@RequestMapping(value="/register")
	public String showRegister(Model m)
	{
		m.addAttribute("addUser", new User());
		return "register";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("addUser")@Valid User user, BindingResult result, Model m)
	{
		if(result.hasErrors())
		{
			return "register";
		}
		else
		{
			user.setEnabled(true);
			user.setRole("ROLE_USER");
			try 
			{
				userDAO.save(user);
			} 
			catch (DataIntegrityViolationException e) 
			{
				System.out.println("in catch");
				result.addError(new FieldError("usernameField", "username", "Username exists"));
				return "register";
			}
		}
		m.addAttribute("registerSuccess",true);
		return "login";
	}
}
