package com.xworkz.controller;

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

import com.xworkz.model.CloudVendorAPIService;
import com.xworkz.service.CloudVendorService;

@RestController
@RequestMapping("/vendor")
public class CloudVendorAPIController {

	@Autowired
	private CloudVendorService service;

	public CloudVendorAPIController() {
		// TODO Auto-generated constructor stub
	}

	// get specific vendor
	@GetMapping("{id}")
	public CloudVendorAPIService getCloudVendorAPIService(@PathVariable("id") String id) {
		return service.getVendors(id);
	}

	// get all vendors
	@GetMapping
	public List<CloudVendorAPIService> getAllCloudVendorAPIService() {
		return service.getAllVendors();
	}

	@PostMapping
	public String creaVendor(@RequestBody CloudVendorAPIService cloudVendorAPIService) {

		service.createCloudVendor(cloudVendorAPIService);
		return "Vendor Saved Successfully";
	}

	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendorAPIService cloudVendorAPIService) {
		service.updateCloudVendor(cloudVendorAPIService);
		return "Cloud Vendor Updated Successfly.";

	}

	@DeleteMapping("{id}")
	public String deleteCloudVendor(@PathVariable("id") String id) {
		service.deleteCloudVendor(id);
		return new String("Vendor deleted.");
	}

}
