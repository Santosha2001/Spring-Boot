package com.xworkz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xworkz.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {

	List<CloudVendor> findByName(String name);
}
