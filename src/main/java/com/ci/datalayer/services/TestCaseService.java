package com.ci.datalayer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ci.datalayer.entities.TestCaseEntity;
import com.ci.datalayer.entities.TestSuite;
import com.ci.datalayer.repositories.TestCaseRepository;
import com.ci.datalayer.repositories.TestSuiteRepository;


/**
 * The Class TestCaseService.
 */
@Service
public class TestCaseService {
	
	/** The test case repository. */
	@Autowired
	private TestCaseRepository	testCaseRepository;
	
	/** The test suite repository. */
	@Autowired 
	private TestSuiteRepository testSuiteRepository;
	
//	public List<TestCaseEntity>	getAllTestCases(String suiteName){
//		List<TestCaseEntity>	testCases = new ArrayList<>();
//		
//		//testCaseRepository.findAll().forEach(testCases::add);
//		testCaseRepository.findByTestSuiteSuiteName(suiteName).forEach(testCases::add);
//		return testCases;
//	}
	
	/**
 * Gets the test case.
 *
 * @param name the name
 * @return the test case
 */
public TestCaseEntity getTestCase(String name){
		return testCaseRepository.findOne(name);
	}
	
	/**
	 * Save test case.
	 *
	 * @param testCase the test case
	 * @param testSuiteName the test suite name
	 */
	public void saveTestCase(TestCaseEntity testCase, String testSuiteName){
		//testCase.setTestSuiteName(testSuiteName);
		TestSuite testSuite = testSuiteRepository.findOne(testSuiteName);
		testCase.setTestSuite(testSuite);
		testCaseRepository.save(testCase);
	}
	
	/**
	 * Delete test case.
	 *
	 * @param testCase the test case
	 */
	public void deleteTestCase(TestCaseEntity testCase){
		testCaseRepository.delete(testCase);
	}
	
	/**
	 * Delete test case by name.
	 *
	 * @param testCase the test case
	 */
	public void deleteTestCaseByName(String testCase){
		testCaseRepository.delete(getTestCase(testCase));
	}

}
