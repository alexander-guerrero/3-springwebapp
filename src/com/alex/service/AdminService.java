package com.alex.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.dao.AdminDao;
import com.alex.pojo.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public boolean save(Admin admin) {
		// Setear fecha de creación
		admin.setFechaCreacion(new Timestamp(new Date().getTime()));
		return adminDao.save(admin);
	}

}
