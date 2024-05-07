package com.tony.foodFacility.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.opencsv.bean.CsvToBeanBuilder;
import com.tony.foodFacility.entity.FoodFacilityType;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Tony
 */
@Slf4j
@Component
public class CsvFileParser {
	public List<FoodFacilityType> readCsvData(String filePath) {
		try (java.io.FileReader fileReader = new java.io.FileReader(filePath)) {
			return new CsvToBeanBuilder<FoodFacilityType>(fileReader).withType(FoodFacilityType.class)
					.withIgnoreEmptyLine(true).build().parse();
		} catch (IOException e) {
			log.error("IOException while read Csv File Data:" + e.getMessage());
		} catch (Exception e) {
			log.error("Exception while read Csv File Data:" + e.getMessage());
		}
		return new ArrayList<>();
	}

}
