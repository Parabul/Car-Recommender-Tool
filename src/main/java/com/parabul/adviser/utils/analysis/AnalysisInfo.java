package com.parabul.adviser.utils.analysis;

import com.parabul.adviser.dao.entities.CarInfo;
import com.parabul.adviser.web.beans.FilterBean;

public class AnalysisInfo {
	private FilterBean filterBean;
	private LinearRegressionResult mileageRegressionResult;
	private LinearRegressionResult yearRegressionResult;

	private double avgAge;
	private double avgPrice;
	private double avgMileage;
	
	private Iterable<CarInfo> carInfos;

	public FilterBean getFilterBean() {
		return filterBean;
	}

	public void setFilterBean(FilterBean filterBean) {
		this.filterBean = filterBean;
	}

	public LinearRegressionResult getMileageRegressionResult() {
		return mileageRegressionResult;
	}

	public void setMileageRegressionResult(
			LinearRegressionResult mileageRegressionResult) {
		this.mileageRegressionResult = mileageRegressionResult;
	}

	public LinearRegressionResult getYearRegressionResult() {
		return yearRegressionResult;
	}

	public void setYearRegressionResult(
			LinearRegressionResult yearRegressionResult) {
		this.yearRegressionResult = yearRegressionResult;
	}

	public double getAvgAge() {
		return avgAge;
	}

	public void setAvgAge(double avgAge) {
		this.avgAge = avgAge;
	}

	public double getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(double avgPrice) {
		this.avgPrice = avgPrice;
	}

	public double getAvgMileage() {
		return avgMileage;
	}

	public void setAvgMileage(double avgMileage) {
		this.avgMileage = avgMileage;
	}

	@Override
	public String toString() {
		return String
				.format("AnalysisInfo [filterBean=%s, mileageRegressionResult=%s, yearRegressionResult=%s, avgAge=%s, avgPrice=%s, avgMileage=%s]",
						filterBean, mileageRegressionResult,
						yearRegressionResult, avgAge, avgPrice, avgMileage);
	}

	public Iterable<CarInfo> getCarInfos() {
		return carInfos;
	}

	public void setCarInfos(Iterable<CarInfo> infos) {
		this.carInfos = infos;
	}

}
