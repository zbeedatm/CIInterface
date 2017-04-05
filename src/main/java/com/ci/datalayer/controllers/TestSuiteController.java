package com.ci.datalayer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ci.datalayer.entities.TestSuite;
import com.ci.datalayer.services.TestSuiteService;

/**
 * The Class TestSuiteController.
 */
@Controller
@RestController
public class TestSuiteController {

	/** The test suite service. */
	@Autowired
	private TestSuiteService testSuiteService;

	/**
	 * Creates the.
	 *
	 * @param name the name
	 * @param description the description
	 * @param status the status
	 * @return the string
	 */
	@RequestMapping("/create")
	@ResponseBody
	public String create(String name, String description, String status) {
		try {
			TestSuite suite = new TestSuite(name, description, status);
			testSuiteService.addSuite(suite);
		}
		catch (Exception ex) {
			return "Error creating the entity: " + ex.toString();
		}
		return "Entity succesfully created";
	}
	
	/**
	 * Gets the all test suites.
	 *
	 * @return the all test suites
	 */
	@RequestMapping("/suites")
	public List<TestSuite> getAllTestSuites(){
		return testSuiteService.getAllTestSuites();
	}
	
	/**
	 * Gets the suite byname.
	 *
	 * @param name the name
	 * @return the suite byname
	 */
	@RequestMapping("/suites/{name}")
	public TestSuite getSuiteByname(@PathVariable String name){
		return testSuiteService.getSuite(name);
	}
	
	/**
	 * Adds the suite.
	 *
	 * @param suite the suite
	 */
	@RequestMapping(method=RequestMethod.POST, value="suites")
	public void addSuite(@RequestBody TestSuite suite){
		testSuiteService.addSuite(suite);
	}
	
	/**
	 * Update suite.
	 *
	 * @param suite the suite
	 * @param tsName the ts name
	 */
	@RequestMapping(method=RequestMethod.PUT, value="suites/{tsName}")
	public void updateSuite(@RequestBody TestSuite suite, @PathVariable String tsName){
		testSuiteService.updateSuite(tsName);
	}
	
	/**
	 * Delete suite.
	 *
	 * @param suite the suite
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="suites")
	public void deleteSuite(@RequestBody TestSuite suite){
		testSuiteService.deleteSuite(suite);
	}
	
	/**
	 * Delete suite by name.
	 *
	 * @param suite the suite
	 * @param tsName the ts name
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="suites/{tsName}")
	public void deleteSuiteByName(@RequestBody TestSuite suite, @PathVariable String tsName){
		testSuiteService.deleteSuiteByName(tsName);
	}
	
}
