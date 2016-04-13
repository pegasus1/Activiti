package com.ayush.activiti.activiti_tutorial;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class SaveStringsToTranslator implements JavaDelegate {
	public void execute(DelegateExecution execution) throws Exception {
		String campusName = (String) execution.getVariable("campusName");
		String campusID = (String) execution.getVariable("campusID");
		String campusType = (String) execution.getVariable("campusType");
        //store the campusName, campusID, campusType in the external database
		String campusData = campusName + ":" + campusID + ":" + campusType;
		execution.setVariable("campusData", campusData);
	}
}