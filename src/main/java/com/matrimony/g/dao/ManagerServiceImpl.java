package com.matrimony.g.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.g.dto.ManagerDTO;
import com.matrimony.g.entity.Manager;
import com.matrimony.g.exception.SubNotFoundException;
import com.matrimony.g.repository.ManagerRepository;
import com.matrimony.g.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerRepository repository;
	@Override
	public ManagerDTO saveManager(ManagerDTO managerDTO) {
		
		Manager manager = new Manager();
		BeanUtils.copyProperties(managerDTO, manager);
		repository.save(manager);
		return managerDTO;
	}

	@Override
	public ManagerDTO getById(int subId) {
		Optional<Manager> manager =repository.findById(subId);
		if(manager.isPresent()) {
			ManagerDTO dto=new ManagerDTO();
			BeanUtils.copyProperties(manager.get(), dto);
			return dto;
		}
		return null;
	}

	@Override
	public List<ManagerDTO> findAll() {
		Iterable<Manager> list=repository.findAll();
		List<ManagerDTO> dtos=new ArrayList<>();
		for(Manager sub:list) {
			ManagerDTO dto=new ManagerDTO();
			BeanUtils.copyProperties(sub, dto);
			dtos.add(dto);
	}
		return dtos;

	}

	@Override
	public String deleteManagerById(int subId) {
		Optional<Manager> manager = repository.findById(subId);
		if (manager.isEmpty()) {
			return "There is No subscription pack with Id:" + subId;
		}
		//delete subscription/manager
		repository.deleteById(subId);
		return "subscription with Id: " +subId + " Delete Successfully";
		
	}

	@Override
	public String updateManager(Manager manager) throws SubNotFoundException {
		Optional<Manager> subpack = repository.findById(manager.getSubId());
		if (subpack.isEmpty()) {
			throw new SubNotFoundException("There is no subscription existed with id: " + manager.getSubId());
		}
	
	repository.save(manager);
		return "Updated Successfully";
	}

	@Override
	public ManagerDTO getBysubMonth(int subMonth) {
		Optional<Manager> manager =repository.findBysubMonth(subMonth);
		if(manager.isPresent()) {
			ManagerDTO dto=new ManagerDTO();
			BeanUtils.copyProperties(manager.get(), dto);
			return dto;
		}
		return null;
	}
	
	@Override
	public ManagerDTO getBysubYear(int subYear) {
		Optional<Manager> manager =repository.findBysubYear(subYear);
		if(manager.isPresent()) {
			ManagerDTO dto=new ManagerDTO();
			BeanUtils.copyProperties(manager.get(), dto);
			return dto;
		}
		return null;
	}

	


	

}
