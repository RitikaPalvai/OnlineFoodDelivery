package com.cg.fds.service;

import com.cg.fds.entities.Login;
import com.cg.fds.exception.RecordNotFound;

public interface ILoginService {
	
	public Login signIn(Login login) throws RecordNotFound;
	public Login signOut(Login login) throws RecordNotFound;
}
