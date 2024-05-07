package com.tony.foodFacility.entity.converter;

import com.tony.foodFacility.entity.enums.PermitStatus;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
/**
 * @author tony
 * 
 */
public class PermitStatusTypeConverter extends AbstractBeanField<PermitStatus,String> {
    @Override
    protected PermitStatus convert(String value) throws CsvDataTypeMismatchException {
        try {
            return PermitStatus.getByValue(value);
        } catch (IllegalArgumentException e) {
            throw new CsvDataTypeMismatchException("Invalid value: " + value);
        }
    }
}