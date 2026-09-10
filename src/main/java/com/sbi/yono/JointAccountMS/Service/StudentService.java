package com.sbi.yono.JointAccountMS.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.sbi.yono.JointAccountMS.Controller.StudentController;
import com.sbi.yono.JointAccountMS.Dao.StudentDao;
import com.sbi.yono.JointAccountMS.Model.AccountOnboarding;
import com.sbi.yono.JointAccountMS.Model.CustomerOnboarding;
import com.sbi.yono.JointAccountMS.Model.Student;
import com.sbi.yono.JointAccountMS.Repository.AccountOnboardingRepo;
import com.sbi.yono.JointAccountMS.Repository.CustomerOnboardingRepo;

import DTO.DebtRequestBody;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class StudentService {

	private StudentDao studentDao;

	private AccountOnboarding accountOnboarding;
	private CustomerOnboarding customerOnboarding;
	private AccountOnboardingRepo accountOnboardingRepo;
	private CustomerOnboardingRepo customerOnboardingRepo;

	private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

	public StudentService(StudentDao studentDao, CustomerOnboardingRepo customerOnboardingRepo,
			AccountOnboardingRepo accountOnboardingRepo) {
		this.studentDao = studentDao;
//		this.accountOnboarding = accountOnboarding;
		this.customerOnboarding = customerOnboarding;
		this.accountOnboardingRepo = accountOnboardingRepo;
		this.customerOnboardingRepo = customerOnboardingRepo;
	}

	@Cacheable(value = "studentCache", key = "#Id")
	public Student getStudentData(Long Id) {
		String methodName = "getStudentData";
		LOGGER.info("Method Started " + methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.getStudentData(Id);
	}

	@Caching(put = { @CachePut(value = "studentCache", key = "#result.id") }, evict = {
			@CacheEvict(value = "allStudents", allEntries = true) })
	public Student saveStudentData(Student requestBody) {
		String methodName = "saveStudentData";
		LOGGER.info("Method Started " + methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.saveStudentData(requestBody);
	}

	@Cacheable(value = "allStudents")
	public Optional<List<Student>> getAllData() {
		String methodName = "getAllData";
		LOGGER.info("Method Started " + methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.getAllData();
	}

	@Caching(evict = { @CacheEvict(value = "studentCache", key = "#Id"),
			@CacheEvict(value = "allStudents", allEntries = true) })
	public String deleteData(Long Id) {
		String methodName = "deleteData";
		LOGGER.info("Method Started " + methodName);
		LOGGER.info("Method Ended " + methodName);
		return studentDao.deleteData(Id);
	}

	public Map<String, Object> saveDebtDetails(Map<String, Object> requestBody) {
		Map<String, Object> res = new HashMap<String, Object>();

		if (null != requestBody && !requestBody.isEmpty()) {
			System.out.println(checkRequest(requestBody));
			if (checkRequest(requestBody)) {
				ObjectMapper objectMapper = new ObjectMapper();
				DebtRequestBody DebtRequestBody = objectMapper.convertValue(requestBody, DebtRequestBody.class);
				Optional<CustomerOnboarding> customerData = customerOnboardingRepo
						.findById(DebtRequestBody.getLeadId());
				if (null != customerData && null != customerData.get().getPan_dtls()
						&& !customerData.get().getPan_dtls().isEmpty()) {

					ObjectMapper map = new ObjectMapper();
					JsonNode json = map.readTree(customerData.get().getPan_dtls());
					String dob = json.get("dob").toString();
					dob = dob.replace("\"", "").trim();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd-MM-yyyy][dd/MM/yyyy]");

					LocalDate birthDate = LocalDate.parse(dob, formatter);

					int age = Period.between(birthDate, LocalDate.now()).getYears();

					if ((age >= 18 && age <= 29) && !"RUP"
							.equals(DebtRequestBody.getDebitCardDetails().getPhysicalDebitCard().getCardType())) {
						System.out.println("error 1");
					} else {
						System.out.print("hurry...............");
					}

				}
			} else {
				LOGGER.info("No Details Present");
			}
		} else {
			System.out.println("error 2");
		}

		return res;

	}

	public boolean checkRequest(Map<String, Object> requestBody) {
		Object debitCardObj = requestBody.get("debitCardDetails");

	    if (!(debitCardObj instanceof Map))
	        return false;

	    Map<String, Object> debitCardDetails =
	            (Map<String, Object>) debitCardObj;

	    LOGGER.info("debitCardDetails Details Present");

	    Object physicalDebitObj = debitCardDetails.get("physicalDebitCard");

	    if (!(physicalDebitObj instanceof Map))
	        return false;

	    Map<String, Object> physicalDebitCard =
	            (Map<String, Object>) physicalDebitObj;

	    LOGGER.info("physicalDebitCard Details Present");

	    return physicalDebitCard.get("CardType") != null
	            && physicalDebitCard.get("NameonCard") != null;
	}

}
