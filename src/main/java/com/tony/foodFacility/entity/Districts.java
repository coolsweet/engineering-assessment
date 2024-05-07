package com.tony.foodFacility.entity;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tony
 */
@Data
@NoArgsConstructor
public class Districts {
	@CsvBindByName(column = "Fire Prevention Districts")
	private String firePreventionDistricts;
	@CsvBindByName(column = "Police Districts")
	private String policeDistricts;
	@CsvBindByName(column = "Supervisor Districts")
	private String supervisorDistracts;
}
