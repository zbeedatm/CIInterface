package com.ci.datalayer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ci.datalayer.entities.TestCaseEntity;
import com.ci.datalayer.services.TestCaseService;


/**
 * The Class TestCaseController.
 */
@Controller
@RestController
public class TestCaseController {

	/** The test case service. */
	@Autowired
	private TestCaseService testCaseService;
	
	/**
	 * Adds the test case.
	 *
	 * @param testCase the test case
	 * @param tsName the ts name
	 */
	@RequestMapping(method=RequestMethod.POST, value="/suites/{tsName}/test-cases")
	public void addTestCase(@RequestBody TestCaseEntity testCase, @PathVariable String tsName){
		testCaseService.saveTestCase(testCase, tsName);
	}
	
}
