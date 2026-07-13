package com.sbi.yono.JointAccountMS.Dao;

import org.springframework.stereotype.Service;

@Service
public class PaymentImpl implements PaymentDao {
	
	public int add(int a, int b) {
		return (a+b);
	}
}
