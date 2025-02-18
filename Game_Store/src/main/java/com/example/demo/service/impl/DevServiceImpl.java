package com.example.demo.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.example.demo.model.Dev;
import com.example.demo.repository.DevRepository;
import com.example.demo.service.DevService;

@Service
public class DevServiceImpl implements DevService {

	@Autowired
	private DevRepository devRepository;

	@Override
	public Dev saveDev(Dev dev) {
		return devRepository.save(dev);
	}
	@Override
	public Dev getDevById(Integer id) {
		Dev dev = devRepository.findById(id).orElse(null);
		return dev;
	}
	
	@Override
	public List<Dev> getAllDev() {
		return devRepository.findAll();
	}

	@Override
	public Boolean existDev(String name) {
		return devRepository.existsByName(name);
	}

	@Override
	public Boolean deleteDev(int id) {
		Dev dev = devRepository.findById(id).orElse(null);

		if (!ObjectUtils.isEmpty(dev)) {
			devRepository.delete(dev);
			return true;
		}
		return false;
	}


//
//	@Override
//	public List<Category> getAllActiveCategory() {
//		List<Category> categories = categoryRepository.findByIsActiveTrue();
//		return categories;
//	}
//
	@Override
	public Page<Dev> getAllDevPagination(Integer pageNo, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return devRepository.findAll(pageable);
	}
}
