package com.sbi.yono.JointAccountMS.Service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.sbi.yono.JointAccountMS.Dao.PaymentDao;

@SpringBootTest
public class PaymentServiceImplTest {
	
	@Test
	void getPaymentDaoTest() {

	    PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
	    PaymentDao paymentDao = mock(PaymentDao.class);

	    paymentServiceImpl.setPaymentDao(paymentDao);

	    assertSame(paymentDao, paymentServiceImpl.getPaymentDao());
	}

}
