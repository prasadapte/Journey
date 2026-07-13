package com.sbi.yono.JointAccountMS.Dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentImplTest {

	PaymentImpl paymentImpl = new PaymentImpl();
	
	@Test
	void addTest() {
		assertEquals(5,paymentImpl.add(2,3));		
	}
	
}
