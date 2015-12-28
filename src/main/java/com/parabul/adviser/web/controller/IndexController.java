package com.parabul.adviser.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.parabul.adviser.service.CarAdviserService;
import com.parabul.adviser.utils.analysis.AnalysisInfo;
import com.parabul.adviser.web.beans.FilterBean;

@Controller
public class IndexController {

	@Autowired
	private CarAdviserService carAdviserService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.addAttribute("titles", carAdviserService.getTitles());
		model.addAttribute("transmissionTypes",
				carAdviserService.getTransmissionTypes());
		model.addAttribute("years", getYears());
		return "index";
	}

	@RequestMapping(value = "/advise", method = RequestMethod.POST)
	@ResponseBody
	public AnalysisInfo advise(ModelMap model, FilterBean filterBean) {
		return carAdviserService.getAdviceInfo(filterBean);

	}

	private List<Integer> getYears() {
		List<Integer> years = new ArrayList<Integer>();
		for (int i = 1990; i < 2017; i++) {
			years.add(i);
		}
		return years;
	}
}