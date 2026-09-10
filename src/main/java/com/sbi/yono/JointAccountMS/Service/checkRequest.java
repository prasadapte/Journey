package com.sbi.yono.JointAccountMS.Service;

import com.sbi.yono.JointAccountMS.Dao.StudentDao;
import com.sbi.yono.JointAccountMS.Model.AccountOnboarding;
import com.sbi.yono.JointAccountMS.Model.CustomerOnboarding;
import com.sbi.yono.JointAccountMS.Repository.AccountOnboardingRepo;
import com.sbi.yono.JointAccountMS.Repository.CustomerOnboardingRepo;

public class checkRequest {
	public StudentDao studentDao;
	public AccountOnboarding accountOnboarding;
	public CustomerOnboarding customerOnboarding;
	public AccountOnboardingRepo accountOnboardingRepo;
	public CustomerOnboardingRepo customerOnboardingRepo;

	public checkRequest() {
	}
}