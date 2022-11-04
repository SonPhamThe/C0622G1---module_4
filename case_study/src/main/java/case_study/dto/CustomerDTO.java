package case_study.dto;

import case_study.model.contract.Contract;
import case_study.model.customer.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

public class CustomerDTO implements Validator {
    private int id;

    @NotEmpty
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    private int gender;

    @NotEmpty
    private String idCard;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String email;

    @NotEmpty
    private String address;

    private CustomerType customerType;

    private Set<Contract> contracts;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, Date dateOfBirth, int gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;

        if (!customerDTO.getName().matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
            errors.rejectValue("name", "name", "Name must be not have number and first word must be capitalized");
        }

        if (!(customerDTO.getPhoneNumber().matches("[0][9][0]\\d{7}") ||
                customerDTO.getPhoneNumber().matches("[0][9][1]\\d{7}") ||
                customerDTO.getPhoneNumber().matches("[(][8][4][)][+][9][0]\\d{7}") ||
                customerDTO.getPhoneNumber().matches("[(][8][4][)][+][9][1]\\d{7}"))) {
            errors.rejectValue("phoneNumber", "phone-number", "Phone number must be valid (090xxxxxxx) hoặc (091xxxxxxx) hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx");
        }

        if (!(customerDTO.getIdCard().matches("\\d{9}") ||
                customerDTO.getIdCard().matches("\\d{12}"))) {
            errors.rejectValue("idCard", "id-card", "ID card must be valid (XXXXXXXXX) hoặc (XXXXXXXXXXXX)");
        }

        if (!customerDTO.getEmail().matches("\\w+[@]\\w+[.]\\w+")) {
            errors.rejectValue("email", "email", "Email must be valid");
        }
    }
}
