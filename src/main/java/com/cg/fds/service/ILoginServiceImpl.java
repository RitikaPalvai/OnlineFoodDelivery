package com.cg.fds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.fds.entities.Login;
import com.cg.fds.entities.Restaurant;
import com.cg.fds.exception.RecordNotFound;
import com.cg.fds.repository.ILoginRepository;

@Service("ILoginService")
public class ILoginServiceImpl implements ILoginService{
	
	@Autowired
	ILoginRepository iLoginRepository;

	
	public Login signIn(Login login) throws RecordNotFound {
		iLoginRepository.saveAndFlush(login);
		return null;
	}


	public Login signOut(Login login) throws RecordNotFound {
		Login bean = null;
		try {
			bean = iLoginRepository.findById(login.getUserid()).get();
		}
		catch(Exception e) {
			throw new RecordNotFound("Login details not found!");
		}
		iLoginRepository.deleteById(login.getUserid());
		return login;
	}

}
