package com.example.excelupload.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.excelupload.model.ExcelData;

@Repository
public interface ExcelDataRepository extends JpaRepository<ExcelData, Long> {

    
    Page<ExcelData> findByField1Containing(String filter, java.awt.print.Pageable pageable);

	Page<ExcelData> findAll(java.awt.print.Pageable pageable);


}
