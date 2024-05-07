package com.tony.foodFacility.entity.converter;

import com.tony.foodFacility.entity.enums.FacilityType;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

/**
 * @author Tony
 */
public class FacilityTypeConverter extends AbstractBeanField<FacilityType, String> {
	protected FacilityType convert(String value) throws CsvDataTypeMismatchException {
		try {
			return FacilityType.getByValue(value);
		} catch (IllegalArgumentException e) {
			throw new CsvDataTypeMismatchException("Invalid value: " + value);
		}
	}
}