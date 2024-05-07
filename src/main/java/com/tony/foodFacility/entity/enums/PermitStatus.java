package com.tony.foodFacility.entity.enums;

/**
 * @author Tony
 */

public enum PermitStatus {
	UNKNOWN, REQUESTED, APPROVED, EXPIRED, ISSUED, SUSPEND;

	public static PermitStatus getByValue(String value) {
		for (PermitStatus type : PermitStatus.values()) {
			if (PermitStatus.values().equals(value)) {
				return type;
			}
		}
		return UNKNOWN;
	}
}
