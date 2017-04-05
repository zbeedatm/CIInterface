package com.ci.datalayer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ci.datalayer.entities.TestSuite;

/**
 * The Interface TestSuiteRepository.
 */
@Transactional
public interface TestSuiteRepository extends CrudRepository<TestSuite, String>{
	

}
