package com.xworkz.service;

import java.util.List;

import com.xworkz.model.CloudVendorAPIService;

public interface CloudVendorService {

	String createCloudVendor(CloudVendorAPIService cloudVendorAPIService);

	String updateCloudVendor(CloudVendorAPIService cloudVendorAPIService);

	String deleteCloudVendor(String id);

	CloudVendorAPIService getVendors(String id);

	List<CloudVendorAPIService> getAllVendors();
}
