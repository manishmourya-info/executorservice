package com.idm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idm.model.Lead;

@Repository
public interface ILeadDAO extends JpaRepository<Lead, Integer>{

}
