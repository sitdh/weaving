package com.sitdh.thesis.weaving.db.entity;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserInformationTest {
	
	private static Validator validator;
	
	@BeforeClass
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void userIdIsNull() {
		UserInformation userInfo = new UserInformation(null, anyString(), anyString(), anyString(), anyString(), anyString(), null);
		Set<ConstraintViolation<UserInformation>> constraintViolations = validator.validate(userInfo);
		assertEquals(1, constraintViolations.size());
		assertEquals("User Id could not be null", constraintViolations.iterator().next().getMessage());
	}
	
	@Test
	public void emailIsNull() {
		UserInformation userInfo = new UserInformation(anyString(), null, anyString(), anyString(), anyString(), anyString(), null);
		Set<ConstraintViolation<UserInformation>> constraintViolations = validator.validate(userInfo);
		assertEquals(1, constraintViolations.size());
		assertEquals("Email could not be null", constraintViolations.iterator().next().getMessage());
	}

}
