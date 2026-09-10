package com.sbi.yono.JointAccountMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sbi.yono.JointAccountMS.Model.CustomerOnboarding;

public interface CustomerOnboardingRepo extends JpaRepository<CustomerOnboarding, String> {

}
