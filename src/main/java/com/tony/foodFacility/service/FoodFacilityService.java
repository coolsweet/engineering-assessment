package com.tony.foodFacility.service;

import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.tony.foodFacility.component.CsvFileParser;
import com.tony.foodFacility.entity.FoodFacilityType;
import com.tony.foodFacility.exception.CommonException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Tony
 */
@Component
@Slf4j
public class FoodFacilityService {
	@Autowired
	private CsvFileParser csvFileParser;
	public final LoadingCache<String, List<FoodFacilityType>> foodFacilityCache = CacheBuilder.newBuilder()
			.initialCapacity(1_000_000).expireAfterWrite(1, TimeUnit.HOURS)
			.build(new CacheLoader<String, List<FoodFacilityType>>() {
				@Override
				public List<FoodFacilityType> load(String filePath) {
					return csvFileParser.readCsvData(filePath);
				}
			});

	public List<FoodFacilityType> getAll() {
		URL filePath = CsvFileParser.class.getClassLoader().getResource("Mobile_Food_Facility_Permit.csv");
		List<FoodFacilityType> foodFacilityList = null;
		try {
			foodFacilityList = foodFacilityCache.get(filePath.getPath());
		} catch (ExecutionException e) {
			log.error("Read Food Facility File Data Failed. " + e.getMessage());
			throw new CommonException("Read Food Facility File Data Failed. " + e.getMessage());
		}
		return foodFacilityList;
	}

	public List<FoodFacilityType> getByApplicant(String applicantName) throws ExecutionException {
		URL filePath = CsvFileParser.class.getClassLoader().getResource("Mobile_Food_Facility_Permit.csv");
		List<FoodFacilityType> foodFacilityList = foodFacilityCache.get(filePath.getPath());
		return foodFacilityList.stream().filter(foodTruck -> applicantName.equals(foodTruck.getApplicant()))
				.collect(Collectors.toList());

	}
}
