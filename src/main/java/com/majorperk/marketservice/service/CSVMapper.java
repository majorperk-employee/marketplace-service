package com.majorperk.marketservice.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.majorperk.marketservice.model.SandPMetrics;

import org.springframework.stereotype.Service;

@Service
public class CSVMapper {

    public List<SandPMetrics> readDefaultCSV() {
		try {
			File csvToRead = new File("./src/main/resources/S&P-Sample-Data-employees.csv");
			MappingIterator<SandPMetrics> personIter;
			personIter = new CsvMapper().readerWithTypedSchemaFor(SandPMetrics.class).readValues(csvToRead);
			return personIter.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<SandPMetrics>();
		}		
    }
}