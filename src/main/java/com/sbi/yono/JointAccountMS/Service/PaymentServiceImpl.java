package com.sbi.yono.JointAccountMS.Service;

import org.springframework.stereotype.Service;

import com.sbi.yono.JointAccountMS.Dao.PaymentDao;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

	private PaymentDao paymentDao;

	public PaymentDao getPaymentDao() {
		return paymentDao;
	}

	public void setPaymentDao(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

}
