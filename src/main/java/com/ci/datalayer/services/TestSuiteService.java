package com.ci.datalayer.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.datalayer.entities.TestSuite;
import com.ci.datalayer.repositories.TestSuiteRepository;

/**
 * The Class TestSuiteService.
 */
@Service
public class TestSuiteService {
	
	/** The test suite repository. */
	@Autowired
	private TestSuiteRepository	testSuiteRepository;
	
	/**
	 * Gets the all test suites.
	 *
	 * @return the all test suites
	 */
	public List<TestSuite>	getAllTestSuites(){
		List<TestSuite>	testSuites = new ArrayList<>();
		
		testSuiteRepository.findAll().forEach(testSuites::add);
		return testSuites;
	}
	
	/**
	 * Gets the suite.
	 *
	 * @param name the name
	 * @return the suite
	 */
	public TestSuite getSuite(String name){
		return testSuiteRepository.findOne(name);
	}
	
	/**
	 * Adds the suite.
	 *
	 * @param suite the suite
	 */
	public void addSuite(TestSuite suite){
		testSuiteRepository.save(suite);
	}
	
	/**
	 * Update suite.
	 *
	 * @param tsName the ts name
	 */
	public void updateSuite(String tsName) {
		TestSuite suite = testSuiteRepository.findOne(tsName);
		testSuiteRepository.save(suite);
	}
	
	/**
	 * Delete suite.
	 *
	 * @param suite the suite
	 */
	public void deleteSuite(TestSuite suite){
		testSuiteRepository.delete(suite);
	}
	
	/**
	 * Delete suite by name.
	 *
	 * @param name the name
	 */
	public void deleteSuiteByName(String name){
		testSuiteRepository.delete(name);
	}


}
