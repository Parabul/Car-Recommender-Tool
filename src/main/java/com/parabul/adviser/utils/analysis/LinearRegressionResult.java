package com.parabul.adviser.utils.analysis;

public class LinearRegressionResult {

	private Double intercept;
	private Double slope;

	public LinearRegressionResult(Double intercept, Double slope) {		
		this.intercept = intercept;
		this.slope = slope;
	}

	public Double getIntercept() {
		return intercept;
	}

	public void setIntercept(Double intercept) {
		this.intercept = intercept;
	}

	public Double getSlope() {
		return slope;
	}

	public void setSlope(Double slope) {
		this.slope = slope;
	}

	@Override
	public String toString() {
		return String.format("LinearRegressionResult [intercept=%s, slope=%s]",
				intercept, slope);
	}

	
}
