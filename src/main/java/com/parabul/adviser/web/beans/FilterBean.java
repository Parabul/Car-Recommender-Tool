package com.parabul.adviser.web.beans;

import org.apache.commons.lang3.StringUtils;

import com.mysema.query.BooleanBuilder;
import com.mysema.query.types.Predicate;
import com.parabul.adviser.dao.entities.QCarInfo;

public class FilterBean {

	private String title;
	private String transmissionType;
	private Integer manufactureYearFrom;
	private Integer manufactureYearTo;
	private Integer mileageFrom;
	private Integer mileageTo;

	public Predicate toPredicate() {
		BooleanBuilder builder = new BooleanBuilder();
		if (StringUtils.isNotBlank(title)) {
			builder.and(QCarInfo.carInfo.title.eq(title));
		}
		if (StringUtils.isNotBlank(transmissionType)) {
			builder.and(QCarInfo.carInfo.transmissiontype.eq(transmissionType));
		}
		if (manufactureYearFrom != null && manufactureYearFrom > 0) {
			builder.and(QCarInfo.carInfo.manufactureyear
					.goe(manufactureYearFrom));
		}
		if (manufactureYearTo != null && manufactureYearTo > 0) {
			builder.and(QCarInfo.carInfo.manufactureyear.loe(manufactureYearTo));
		}

		if (mileageFrom != null && mileageFrom > 0) {
			builder.and(QCarInfo.carInfo.mileage.goe(mileageFrom));
		}
		if (mileageTo != null && mileageTo > 0) {
			builder.and(QCarInfo.carInfo.mileage.loe(mileageTo));
		}

		return builder.getValue();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public Integer getManufactureYearFrom() {
		return manufactureYearFrom;
	}

	public void setManufactureYearFrom(Integer manufactureYearFrom) {
		this.manufactureYearFrom = manufactureYearFrom;
	}

	public Integer getManufactureYearTo() {
		return manufactureYearTo;
	}

	public void setManufactureYearTo(Integer manufactureYearTo) {
		this.manufactureYearTo = manufactureYearTo;
	}

	public Integer getMileageFrom() {
		return mileageFrom;
	}

	public void setMileageFrom(Integer mileageFrom) {
		this.mileageFrom = mileageFrom;
	}

	public Integer getMileageTo() {
		return mileageTo;
	}

	public void setMileageTo(Integer mileageTo) {
		this.mileageTo = mileageTo;
	}

}
