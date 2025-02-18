package com.example.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Dev;


public interface DevService {
	
	public Dev getDevById(Integer id);
	public Boolean existDev(String name);
	public Dev saveDev(Dev dev);
	public List<Dev> getAllDev();
	public Boolean deleteDev(int id);
	public Page<Dev> getAllDevPagination(Integer pageNo,Integer pageSize);
}
