package com.ci.datalayer.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * The Class TestSuiteEntity.
 */
@Entity
@Table(name="test_suites")
public class TestSuite {
	
	/** The suite name. */
	//@Id
	private String suiteName;
	
	/** The description. */
	private String description;
	
	/** The status. */
	private String status;
	
	/** Test Cases of this Test Suite **/
	//@OneToMany
	//@JoinColumn(name="test_suite_name")
	//@OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL)
	private List<TestCaseEntity> testCases;
	
	/**
	 * Default Constructor
	 */
	public TestSuite(){
		
	}
	
	/**
	 * Instantiates a new test suite entity.
	 *
	 * @param suiteName the suite name
	 * @param description the description
	 * @param status the status
	 */
	public TestSuite(String suiteName, String description, String status) {
		super();
		this.suiteName = suiteName;
		this.description = description;
		this.status = status;
	}


	/**
	 * Gets the suite name.
	 *
	 * @return the suite name
	 */
	@Id
	public String getSuiteName() {
		return suiteName;
	}

	/**
	 * Sets the suite name.
	 *
	 * @param suiteName the new suite name
	 */
	public void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
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
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(mappedBy = "testSuite", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public List<TestCaseEntity> getTestCases() {
		return testCases;
	}

	
	public void setTestCases(List<TestCaseEntity> testCases) {
		this.testCases = testCases;
	}
}
