package com.tony.foodFacility.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.opencsv.bean.CsvRecurse;
import com.tony.foodFacility.entity.converter.FacilityTypeConverter;
import com.tony.foodFacility.entity.converter.PermitStatusTypeConverter;
import com.tony.foodFacility.entity.enums.FacilityType;
import com.tony.foodFacility.entity.enums.PermitStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodFacilityType {
	@CsvBindByName(column = "locationId")
	private Long locationId;

	@NonNull
	@CsvBindByName(column = "Applicant")
	private String applicant;

	@CsvCustomBindByName(column = "FacilityType", converter = FacilityTypeConverter.class)
	private FacilityType facilityType;

	@CsvBindByName(column = "cnn")
	private String cnn;

	@CsvBindByName(column = "LocationDescription")
	private String locationDescription;

	@CsvBindByName(column = "Address")
	private String address;

	@CsvRecurse
	private BlocklotInfo blocklotInfo;

	@CsvBindByName(column = "permit")
	private String permitLicense;
	@CsvCustomBindByName(column = "Status", converter = PermitStatusTypeConverter.class)
	private PermitStatus permitStatus;

	/**
	 * the provided food items
	 */
	@CsvBindByName(column = "FoodItems")
	private String foodItems;

	@CsvRecurse
	private GeoInfo geoInfo;

	@CsvBindByName(column = "Schedule")
	private String permitScheduleLink;

	@CsvBindByName(column = "dayshours")
	private String permitDaysHours;

	@CsvBindByName(column = "NOISent")
	private String nioSent;

	@CsvBindByName(column = "Approved")
	private String permitApprovedDate;
	@CsvBindByName(column = "Received")
	private String permitReceivedDate;
	@CsvBindByName(column = "ExpirationDate")
	private String permitExpirationDate;

	@CsvRecurse
	private Districts districts;
	@CsvBindByName(column = "Zip Codes")
	private String zipCodes;
	@CsvBindByName(column = "Neighborhoods (old)")
	private String neighborhoods;
}
