package com.xworkz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.exception.CloudVendorNotFoundException;
import com.xworkz.model.CloudVendor;
import com.xworkz.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	@Autowired
	private CloudVendorRepository repository;

	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendorAPIService) {

		repository.save(cloudVendorAPIService);
		return "Success.";
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendorAPIService) {
		repository.save(cloudVendorAPIService);
		return "Update Success.";
	}

	@Override
	public String deleteCloudVendor(String id) {
		repository.deleteById(id);
		return "Delete Success.";
	}

	@Override
	public CloudVendor getVendors(String id) {
		
		if (repository.findById(id).isEmpty()) {
			throw new CloudVendorNotFoundException("Cloud Vendor not exist");
		}
		return repository.findById(id).get();
	}

	@Override
	public List<CloudVendor> getAllVendors() {

		return repository.findAll();
	}

}
