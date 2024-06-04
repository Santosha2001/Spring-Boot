package com.xworkz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.exception.CloudVendorNotFoundException;
import com.xworkz.model.CloudVendorAPIService;
import com.xworkz.repository.CloudVendorRepository;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	@Autowired
	private CloudVendorRepository repository;

	@Override
	public String createCloudVendor(CloudVendorAPIService cloudVendorAPIService) {

		repository.save(cloudVendorAPIService);
		return "Save Success.";
	}

	@Override
	public String updateCloudVendor(CloudVendorAPIService cloudVendorAPIService) {
		repository.save(cloudVendorAPIService);
		return "Update Success.";
	}

	@Override
	public String deleteCloudVendor(String id) {
		repository.deleteById(id);
		return "Delete Success.";
	}

	@Override
	public CloudVendorAPIService getVendors(String id) {
		
		if (repository.findById(id).isEmpty()) {
			throw new CloudVendorNotFoundException("Cloud Vendor not exist");
		}
		return repository.findById(id).get();
	}

	@Override
	public List<CloudVendorAPIService> getAllVendors() {

		return repository.findAll();
	}

}
