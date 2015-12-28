package com.parabul.adviser.utils.analysis;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.springframework.stereotype.Component;

import com.parabul.adviser.dao.entities.CarInfo;

@Component
public class LinearRegressionEvaluator {

	public void fillAvg(Iterable<CarInfo> infos, AnalysisInfo analysisInfo) {
		double age = 0d;
		double price = 0d;
		double mileage = 0d;
		int count = 0;

		for (CarInfo carInfo : infos) {
			age += carInfo.getManufactureyear();
			price += carInfo.getPrice();
			mileage += carInfo.getMileage();
			count++;
		}

		analysisInfo.setAvgAge(age / count);
		analysisInfo.setAvgPrice(price / count);
		analysisInfo.setAvgMileage(mileage / count);

	}

	public LinearRegressionResult getYearRegressionResult(
			Iterable<CarInfo> infos) {
		SimpleRegression regression = new SimpleRegression();
		for (CarInfo carInfo : infos) {
			regression
					.addData(carInfo.getManufactureyear(), carInfo.getPrice());
		}
		return new LinearRegressionResult(regression.getIntercept(),
				regression.getSlope());
	}

	public LinearRegressionResult getMileageRegressionResult(
			Iterable<CarInfo> infos) {
		SimpleRegression regression = new SimpleRegression();
		for (CarInfo carInfo : infos) {
			regression.addData(carInfo.getMileage(), carInfo.getPrice());
		}
		return new LinearRegressionResult(regression.getIntercept(),
				regression.getSlope());
	}

}
