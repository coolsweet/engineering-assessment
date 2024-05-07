package com.tony.foodFacility.entity;

import com.opencsv.bean.CsvBindByName;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tony
 */

@Data
@NoArgsConstructor
public class BlocklotInfo {

	@CsvBindByName(column = "blocklot")
	private String blocklot;

	@CsvBindByName(column = "block")
	private String block;

	@CsvBindByName(column = "lot")
	private String lot;

}