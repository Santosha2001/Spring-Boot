/**
 * 
 */
package com.xworkz.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.xworkz.model.CloudVendor;
import com.xworkz.repository.CloudVendorRepository;

/**
 * 
 */

class CloudVendorServiceImplTset {

	/**
	 * The @Mock annotation is used to create mock objects in Mockito. Mockito is a
	 * mocking framework for unit testing in Java. It allows you to create mock
	 * objects of classes and interfaces, which can then be used to test your code
	 * without having to rely on real objects.
	 * 
	 * Mock testing is a software testing technique that involves replacing a real
	 * object with a mock object to simulate its behavior.
	 */
	@Mock
	private CloudVendorRepository cloudVendorRepository;

	/**
	 * The Service class for which writing a test cases.
	 */
	private CloudVendorService cloudVendorService;
	
	CloudVendor cloudVendor;

	/**
	 * The AutoCloseable interface to close all resources that are used after the
	 * execution done.
	 */
	AutoCloseable autoCloseable;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		autoCloseable = MockitoAnnotations.openMocks(this);
		cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
		cloudVendor = new CloudVendor("106", "Amazon", "Bangalore", "AAAA");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}

	/**
	 * Test method for
	 * {@link com.xworkz.service.CloudVendorServiceImpl#createCloudVendor(com.xworkz.model.CloudVendor)}.
	 */
	@Test
	void testCreateCloudVendor() {
		
//		mock(CloudVendor.class);
//		mock(CloudVendorRepository.class);
//		
//		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
//		assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");
		
	}

	/**
	 * Test method for
	 * {@link com.xworkz.service.CloudVendorServiceImpl#updateCloudVendor(com.xworkz.model.CloudVendor)}.
	 */
	@Test
	void testUpdateCloudVendor() {
	}

	/**
	 * Test method for
	 * {@link com.xworkz.service.CloudVendorServiceImpl#deleteCloudVendor(java.lang.String)}.
	 */
	@Test
	void testDeleteCloudVendor() {
	}

	/**
	 * Test method for
	 * {@link com.xworkz.service.CloudVendorServiceImpl#getVendors(java.lang.String)}.
	 */
	@Test
	void testGetVendors() {
	}

	/**
	 * Test method for
	 * {@link com.xworkz.service.CloudVendorServiceImpl#getAllVendors()}.
	 */
	@Test
	void testGetAllVendors() {
	}

}
