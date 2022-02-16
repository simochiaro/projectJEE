package it.unifi.dinfo.stdlab.projectJEE1.mapper;



import javax.inject.Inject;

import it.unifi.dinfo.stdlab.projectJEE1.model.User;
import it.unifi.dinfo.stdlab.projectJEE1.dao.UserDao;
import it.unifi.dinfo.stdlab.projectJEE1.dto.UserDto;

public class UserMapper {
	@Inject
	private UserDao dao;
	
	
	public UserDto convert(User u) {
		if(u==null) 
			System.out.println("User is NULL");
		
		UserDto dto =new UserDto();
		dto.setId(u.getId());
		dto.setUsername(u.getUsername());
		dto.setArbitro(u.getArbitro());
		dto.setDesignatore(u.getDesignatore());
		return dto;
	}

	public void transfer(UserDto dto, User u) {
		if(dto==null)
			System.out.println("The User Dto is NULL");
		if(u==null)
			System.out.println("The User Entity is NULL");
		
		u.setUsername(dto.getUsername());
		u.setArbitro(dto.getArbitro());
		u.setDesignatore(dto.getDesignatore());
	}

	



	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	
	
}
