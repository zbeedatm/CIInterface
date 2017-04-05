package com.ci.datalayer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * The Class TestCaseEntity.
 */
@Entity
@Table(name="test_cases")
public class TestCaseEntity {
	
	/** The test case name. */
//	@Id
	private String testCaseName;
	
	/** The description. */
	private String description;
	
//	@ManyToOne(targetEntity = TestSuite.class)
//	@JoinColumn(name="suite_name")
//	private String testSuiteName;
	
//	@ManyToOne
//  @JoinColumn(name = "suite_name")
	/** The test suite. */
	private TestSuite testSuite;
	
	
	/**
	 * Instantiates a new test case entity.
	 */
	public TestCaseEntity(){
		
	}

	
	/**
	 * Instantiates a new test case entity.
	 *
	 * @param tcName the tc name
	 * @param description the description
	 * @param testSuite the test suite
	 */
	public TestCaseEntity(String tcName, String description, TestSuite testSuite) {
		super();
		this.testCaseName = tcName;
		this.description = description;
		//this.testSuiteName = tsName;
		
		this.testSuite = testSuite;
		//this.testSuite = testSuiteService.getSuite(tsName);
		//if (testSuite==null){
		//	this.testSuite = new TestSuite(tsName,"Initial Description", "Initial Status");
		//}
	}


	/**
	 * Instantiates a new test case entity.
	 *
	 * @param tcName the tc name
	 * @param description the description
	 */
	public TestCaseEntity(String tcName, String description) {
		super();
		this.testCaseName = tcName;
		this.description = description;
	}


	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the test case name.
	 *
	 * @return the test case name
	 */
	@Id
	public String getTestCaseName() {
		return testCaseName;
	}


	/**
	 * Sets the test case name.
	 *
	 * @param testCaseName the new test case name
	 */
	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}


//	public String getTestSuiteName() {
//		return testSuiteName;
//	}
//
//
//	public void setTestSuiteName(String testSuiteName) {
//		this.testSuiteName = testSuiteName;
//	}


	/**
	 * Gets the test suite.
	 *
	 * @return the test suite
	 */
	@ManyToOne
    @JoinColumn(name = "test_suites_suite_name")
	@JsonBackReference
	public TestSuite getTestSuite() {
		return testSuite;
	}


	/**
	 * Sets the test suite.
	 *
	 * @param testSuite the new test suite
	 */
	public void setTestSuite(TestSuite testSuite) {
		this.testSuite = testSuite;
	}

	
}
