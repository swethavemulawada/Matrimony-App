package com.matrimony.g.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.g.dto.ManagerDTO;
import com.matrimony.g.entity.Manager;
import com.matrimony.g.exception.SubNotFoundException;
import com.matrimony.g.service.ManagerService;

@RestController
@RequestMapping("/api/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/addManager")
	public ManagerDTO saveManager(@RequestBody ManagerDTO managerDTO) {
		managerService.saveManager(managerDTO);
		return managerDTO;
	}
	//http://localhost:9091/swagger-ui/index.html#/
	//http://localhost:9091/api/manager/1
		@GetMapping("/getById/{subId}")
		public ManagerDTO getById(@PathVariable int subId) {
			ManagerDTO dto=managerService.getById(subId);
			return dto;
		}
	
		//http://localhost:9091/api/manager
		@GetMapping("subscriptions")
		public List<ManagerDTO> getAllSubscription() {
			List<ManagerDTO> list=managerService.findAll();
			return list;
		}
		
		@PutMapping("/updateManager/{subId}")
		public ResponseEntity<String> updateManager( @RequestBody Manager manager) throws SubNotFoundException {
			String response = managerService.updateManager(manager);
			ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			return responseEntity;
		}
		
		@DeleteMapping("/deleteManager/{subId}")
		public ResponseEntity<String> deletevegetable(@PathVariable("subId") int subId) {
			String response = managerService.deleteManagerById(subId);
			ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
			return responseEntity;
			
	       
	}
		@GetMapping("/getBysubMonth/{subMonth}")
		public ManagerDTO getBysubMonth(@PathVariable("subMonth") int subMonth) {
			ManagerDTO dto=managerService.getBysubMonth(subMonth);
			return dto;
		}
		
		@GetMapping("/getBysubYear/{subYear}")
		public ManagerDTO getBysubYear(@PathVariable("subYear") int subYear) {
			ManagerDTO dto=managerService.getBysubYear(subYear);
			return dto;
		}
}
		