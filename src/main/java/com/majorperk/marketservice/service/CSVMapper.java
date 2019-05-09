package com.majorperk.marketservice.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.majorperk.marketservice.model.AccountSandP;

import org.springframework.stereotype.Service;

@Service
public class CSVMapper {

    public List<AccountSandP> readDefaultCSV() {
		try {
			File csvToRead = new File("./src/main/resources/S&P-Sample-Data-employees.csv");
			MappingIterator<AccountSandP> personIter;
			personIter = new CsvMapper().readerWithTypedSchemaFor(AccountSandP.class).readValues(csvToRead);
			return personIter.readAll();
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<AccountSandP>();
		}		
    }
}