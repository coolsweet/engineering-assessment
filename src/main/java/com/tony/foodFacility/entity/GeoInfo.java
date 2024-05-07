package com.tony.foodFacility.entity;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tony
 */
@Data
@NoArgsConstructor

public class GeoInfo {
	@CsvBindByName(column = "Latitude")
	private String latitude;

	@CsvBindByName(column = "Longitude")
	private String longitude;

	@CsvBindByName(column = "X")
	private String x;

	@CsvBindByName(column = "Y")
	private String y;
}
