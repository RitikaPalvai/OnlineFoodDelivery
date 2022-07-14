package com.cg.fds.controller;

import com.cg.fds.entities.Login;
import com.cg.fds.exception.RecordNotFound;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fds.entities.Bill;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.service.IBillService;
import com.cg.fds.service.ILoginService;

@RestController
@RequestMapping("/ofs-login")
public class ILoginController {
	
	@Autowired
	ILoginService iLoginService;
	
	@PostMapping("/signIn")
	public Login signIn(@RequestBody Login login) throws RecordNotFound{
		return iLoginService.signIn(login);
	}

	@DeleteMapping("/signOut")
	public Login signOut(@RequestBody Login login) throws RecordNotFound{
		return iLoginService.signOut(login);
	}

}
