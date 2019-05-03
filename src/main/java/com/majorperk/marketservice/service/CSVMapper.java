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

    public List<AccountSandP> readCSV(File csvFile) {    	
		try {
			MappingIterator<AccountSandP> personIter;
			personIter = new CsvMapper().readerWithTypedSchemaFor(AccountSandP.class).readValues(csvFile);
			return personIter.readAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<AccountSandP>();
		}		
    }
}