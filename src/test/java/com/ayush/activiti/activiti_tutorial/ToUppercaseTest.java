package com.ayush.activiti.activiti_tutorial;

import junit.framework.Assert;

import org.activiti.engine.delegate.DelegateExecution;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ToUppercaseTest {
	
	Logger LOGGER = LoggerFactory.getLogger(ToUppercaseTest.class);
	
	SaveStringsToTranslator testObj;
	
	@Mock
	DelegateExecution delegateExecution;
	
	@Before
	public void setup() {
		testObj = new SaveStringsToTranslator();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void deploy() throws Exception {
		Mockito.when(delegateExecution.getVariable("campusName")).thenReturn("Purdue");
		Mockito.when(delegateExecution.getVariable("campusID")).thenReturn("CAMPUS_PUR");
		Mockito.when(delegateExecution.getVariable("campusType")).thenReturn("onCampus");
		testObj.execute(delegateExecution);
		Mockito.verify(delegateExecution, Mockito.times(1)).setVariable("campusData","Purdue:CAMPUS_PUR:onCampus");
	}

}
