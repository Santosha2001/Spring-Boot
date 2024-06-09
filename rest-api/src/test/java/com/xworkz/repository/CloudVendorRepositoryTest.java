package com.xworkz.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.xworkz.model.CloudVendor;

/**
 * lets the application know it should using in-memory database for data related
 * operations.
 */

@DataJpaTest
public class CloudVendorRepositoryTest {

	@Autowired
	private CloudVendorRepository cloudVendorRepository;

	CloudVendor cloudVendorAPIService;

	/**
	 * Whenever this class executed, first this method called and execution takes
	 * place.
	 */
	
	@BeforeEach
	void setUp() {

		cloudVendorAPIService = new CloudVendor("105", "Blinkit", "Chennai", "7022587654");
		cloudVendorRepository.save(cloudVendorAPIService);
	}

	/**
	 * After all the execution of this class all the resources should be tear down.
	 */
	@AfterEach
	void tearDown() {

		cloudVendorAPIService = null;
		cloudVendorRepository.deleteAll();
	}

	// Test Case SUCCESS
	/**@Test -> indicated that method mentioned below treated as a case. 
	 * 
	 */
	@Test
	void findByName_Found() {
		List<CloudVendor>  vendorList = cloudVendorRepository.findByName("Blinkit");
		
		// check what it returns.
		assertThat(vendorList.get(0).getId()).isEqualTo(cloudVendorAPIService.getId());
		assertThat(vendorList.get(0).getAddress()).isEqualTo(cloudVendorAPIService.getAddress());
	}
	
	// Test Case FAILURE
	/**
	 * 
	 */
	@Test
	void findByName_Not_Found() {
		List<CloudVendor>  vendorList = cloudVendorRepository.findByName("GCP");
		
		// check what it returns.
		assertThat(vendorList.isEmpty()).isTrue();
	}
}
