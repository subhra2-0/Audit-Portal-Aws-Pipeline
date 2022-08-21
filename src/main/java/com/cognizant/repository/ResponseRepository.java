package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.AuditResponseModel;
/**
 * 
 *
 */
@Repository
public interface ResponseRepository extends JpaRepository<AuditResponseModel, Integer> {

}
