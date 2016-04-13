package com.ayush.activiti.activiti_tutorial;

import junit.framework.Assert;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest {

	Logger LOGGER = LoggerFactory.getLogger(AppTest.class);

	@Test
	public void deploy() {
		Assert.assertEquals(2, 2);
	}

}
