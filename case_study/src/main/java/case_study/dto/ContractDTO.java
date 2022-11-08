package case_study.dto;

import case_study.model.contract.Contract;
import case_study.model.contract.ContractDetail;
import case_study.model.customer.Customer;
import case_study.model.employee.Employee;
import case_study.model.facility.Facility;

import java.util.Date;
import java.util.Set;

public class ContractDTO {
    private int id;
    private Date startDate;
    private Date endDate;
    private double deposit;
    private int status = 1;
    private Set<ContractDetail> contractDetails;
    private Employee employee;
    private Customer customer;
    private Facility facility;

    private double total;

    public ContractDTO() {
    }

    public ContractDTO(int id, Date startDate, Date endDate, double deposit, int status, Set<ContractDetail> contractDetails, Employee employee, Customer customer, Facility facility, double total) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.status = status;
        this.contractDetails = contractDetails;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void getTotalCost() {
        this.total = this.facility.getCost();
        if (this.contractDetails != null) {
            for (ContractDetail contractDetail : this.contractDetails) {
                this.total += contractDetail.getQuantity() * contractDetail.getAttachFacility().getCost();
            }
        }
    }
}
