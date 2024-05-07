package com.tony.foodFacility.entity.enums;

/**
 * @author Tony
 */
public enum FacilityType {
	TRUCK("Truck"),

	PUSHCART("Push Cart"),

	UNKNOWN("Unknown");

	final String value;

	FacilityType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static FacilityType getByValue(String value) {
		for (FacilityType type : FacilityType.values()) {
			if (type.getValue().contains(value)) {
				return type;
			}
		}
		return UNKNOWN;
	}
}
