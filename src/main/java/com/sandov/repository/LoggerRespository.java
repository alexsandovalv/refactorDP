package com.sandov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sandov.domain.LoggerDomain;

@Repository
public interface LoggerRespository extends JpaRepository<LoggerDomain, Long> {

}
