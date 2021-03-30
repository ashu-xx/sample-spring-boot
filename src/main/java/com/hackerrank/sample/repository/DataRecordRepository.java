package com.hackerrank.sample.repository;

import com.hackerrank.sample.repository.entity.DataRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRecordRepository extends JpaRepository<DataRecordEntity, String> {}
