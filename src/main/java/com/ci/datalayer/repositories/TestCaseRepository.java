package com.ci.datalayer.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ci.datalayer.entities.TestCaseEntity;

/**
 * The Interface TestCaseRepository.
 */
@Transactional
public interface TestCaseRepository extends CrudRepository<TestCaseEntity, String>{

}
