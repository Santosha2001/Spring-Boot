package com.xworkz.service;

import java.util.List;

import com.xworkz.model.CloudVendor;

public interface CloudVendorService {

	String createCloudVendor(CloudVendor cloudVendorAPIService);

	String updateCloudVendor(CloudVendor cloudVendorAPIService);

	String deleteCloudVendor(String id);

	CloudVendor getVendors(String id);

	List<CloudVendor> getAllVendors();
}
