package com.ayush.activiti.activiti_tutorial;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.test.Deployment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		ProcessEngine processEngine = null;
		RepositoryService repositoryService;
		RuntimeService runtimeService;
		org.activiti.engine.repository.Deployment deployment;
		TaskService taskService;

		Logger LOGGER = LoggerFactory.getLogger(App.class);
		
		// This looks for activiti.cfg.xml in the classpath.
		System.out.println(processEngine);

		processEngine = ProcessEngines.getDefaultProcessEngine();
		
		System.out.println(processEngine);
		
		// Get Activiti services
		repositoryService = processEngine.getRepositoryService();
		runtimeService = processEngine.getRuntimeService();

		// Deploy the process definition
		String deploymentId = repositoryService.createDeployment()
				.addClasspathResource("campus-creation.bpmn20.xml").deploy().getId();

	}
}
