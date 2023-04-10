package com.matrimony.g.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matrimony.g.dto.ManagerDTO;
import com.matrimony.g.entity.Manager;
import com.matrimony.g.exception.SubNotFoundException;



@Service
public interface ManagerService {
	
public ManagerDTO saveManager(ManagerDTO managerDTO);
	
    public ManagerDTO getById(int subId);
    public List<ManagerDTO> findAll();
  
	public String deleteManagerById(int subId) ;
	public String updateManager(Manager manager) throws SubNotFoundException;
	
	public ManagerDTO getBysubMonth(int subMonth);

	public ManagerDTO getBysubYear(int subYear);

}
