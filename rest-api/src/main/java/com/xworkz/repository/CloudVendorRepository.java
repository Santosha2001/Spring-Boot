package com.xworkz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.model.CloudVendorAPIService;

public interface CloudVendorRepository extends JpaRepository<CloudVendorAPIService, String> {

	
}
