package com.gm.CustomerService.CustomerDetails.SignupController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gm.CustomerService.CustomerDetails.Model.Customers;
import com.gm.CustomerService.CustomerDetails.Service.CustomerRepository;


@Controller
public class SignupController {
	
	@Autowired
	CustomerRepository repository;
	
	@RequestMapping(value="/Signup",method=RequestMethod.GET)
	public String signupPage(Model model) {
		return "Signup";
	}
	
	@RequestMapping(value="/Signup",method=RequestMethod.POST)
	public String welcomePage(ModelMap model,@ModelAttribute Customers Signup,@ModelAttribute Customers Welcome) {
		repository.save(Signup);
		Optional<Customers> detailsbyId =repository.findById(Welcome.getId());
		model.put("detailsbyId",detailsbyId);
		return "Welcome";
	}
	@RequestMapping(value="/findCustomers",method=RequestMethod.GET)
	public String Showoptions() {
		return "findCustomers";
}
	@RequestMapping(value="/findCustomers",method=RequestMethod.POST)
	public String findCustomerbyId(ModelMap model,@RequestParam int DetailsById) {
		Optional<Customers> detailsbyId =repository.findById(DetailsById);
		model.put("detailsbyId",detailsbyId);
		return "findCustomers";
}
}
