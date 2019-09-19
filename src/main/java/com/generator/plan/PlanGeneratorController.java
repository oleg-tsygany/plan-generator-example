package com.generator.plan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generator.plan.model.GeneratedPlan;
import com.generator.plan.model.PlanGenerationTask;


@RestController
public class PlanGeneratorController {
	private static final Logger log = LoggerFactory.getLogger(PlanGeneratorController.class);
	
	@Autowired
	private PlanGeneratorService service;
	
	@PostMapping("/generate-plan")
	public ResponseEntity<GeneratedPlan> generate(@RequestBody PlanGenerationTask task) {
		log.info(task.toString());
		GeneratedPlan plan = service.generate(task);
		return ResponseEntity.ok().body(plan);
	}

}
