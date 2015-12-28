package com.parabul.adviser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.parabul.adviser.dao.entities.CarInfo;
import com.parabul.adviser.dao.reposiroties.CarInfoRepository;
import com.parabul.adviser.utils.analysis.AnalysisInfo;
import com.parabul.adviser.utils.analysis.LinearRegressionEvaluator;
import com.parabul.adviser.web.beans.FilterBean;

@Service
public class CarAdviserService {

	@Autowired
	private CarInfoRepository carInfoRepository;
	@Autowired
	private LinearRegressionEvaluator linearRegressionEvaluator;

	@Value("${max.size}")
	private Integer maxSize; 
	
	public CarInfo findOne(Long id) {
		return carInfoRepository.findOne(id);
	}

	public AnalysisInfo getAdviceInfo(FilterBean filterBean) {
		Pageable page = new PageRequest(0,maxSize );
		Page<CarInfo> result = carInfoRepository.findAll(
				filterBean.toPredicate(), page);
		Iterable<CarInfo> infos = result.getContent();
		AnalysisInfo analysisInfo = new AnalysisInfo();
		analysisInfo.setCarInfos(infos);
		analysisInfo.setFilterBean(filterBean);
		analysisInfo.setYearRegressionResult(linearRegressionEvaluator
				.getYearRegressionResult(infos));
		analysisInfo.setMileageRegressionResult(linearRegressionEvaluator
				.getMileageRegressionResult(infos));
		linearRegressionEvaluator.fillAvg(infos, analysisInfo);

		return analysisInfo;

	}

	public List<String> getTransmissionTypes() {
		return carInfoRepository.getTransmissiontype();
	}

	public List<String> getTitles() {
		return carInfoRepository.getTitles();
	}
}
