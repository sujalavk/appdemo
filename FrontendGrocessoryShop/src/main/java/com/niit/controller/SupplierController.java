package com.niit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.SupplierDao;
import com.niit.Model.Category;
import com.niit.Model.Supplier;

@Controller

public class SupplierController {
	@Autowired
	private SupplierDao supplierDao;
	@Autowired
	private Supplier supplier;

	// Storing supplier data
	@RequestMapping(value = "/supplier", method = RequestMethod.POST)
	public String insertSupplier(@Valid @ModelAttribute("supplier") Supplier msupplier, BindingResult result,
			Model model) {

		if (supplierDao.insertSupp(msupplier) == true) {

			model.addAttribute("msg", "Successfully created/updated the caetgory");
		} else {
			model.addAttribute("msg", "not able created/updated the caetgory");
		}

		model.addAttribute("supplier", msupplier);

		return "redirect:Admin";

	}

}
