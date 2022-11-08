package case_study.controller;

import case_study.dto.ContractDTO;
import case_study.model.contract.AttachFacility;
import case_study.model.contract.Contract;
import case_study.model.contract.ContractDetail;
import case_study.model.customer.Customer;
import case_study.model.employee.Employee;
import case_study.model.facility.Facility;
import case_study.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.function.Function;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService contractService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IContractDetailService contractDetailService;


    @ModelAttribute("employess")
    public List<Employee> listEmployee() {
        return employeeService.findAll();
    }

    @ModelAttribute("customers")
    public List<Customer> listCustomer() {
        return customerService.findAll();
    }

    @ModelAttribute("facilities")
    public List<Facility> listFacility() {
        return facilityService.findAll();
    }

    @ModelAttribute("contractDetails")
    public List<ContractDetail> listContractDetail() {
        return contractDetailService.listContractDetail();
    }

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> listAttachFacility() {
        return contractService.listAttachFacility();
    }

    @GetMapping("")
    public String list(Model model,
                       @PageableDefault(value = 3) Pageable pageable) {
        Page<Contract> contractPage = contractService.listContract(pageable);

        Page<ContractDTO> contractDTOPage = contractPage.map(new Function<Contract, ContractDTO>() {
            @Override
            public ContractDTO apply(Contract contract) {
                ContractDTO contractDTO = new ContractDTO();
                BeanUtils.copyProperties(contract, contractDTO);
                contractDTO.getTotalCost();
                return contractDTO;
            }

        });

        model.addAttribute("contractList", contractDTOPage);
        return "contract/list";

    }

    @PostMapping("/create-attach")
    public String createAttach(@RequestParam(value = "attachId") int attachId,
                               @RequestParam(value = "quantity") int quantity,
                               @RequestParam(value = "contractId") int contractId, RedirectAttributes redirectAttributes) {

        Contract contract = contractService.findByIdToCreateAttach(attachId);
        AttachFacility attachFacility = contractService.findAttachFacility(attachId);
        ContractDetail contractDetailExit = contractService.findContractDetail(attachId, contractId);
        if (contractDetailExit != null) {
            contractDetailExit.setQuantity(contractDetailExit.getQuantity() + quantity);
            contractService.saveContractDetail(contractDetailExit);
        } else {
            ContractDetail contractDetail = new ContractDetail();
            contractDetail.setContract(contract);
            contractDetail.setQuantity(quantity);
            contractDetail.setAttachFacility(attachFacility);
            contractService.saveContractDetail(contractDetail);
        }
        redirectAttributes.addFlashAttribute("message", "Add Attach Facility successfully!");
        return "redirect:/contract";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDTO",new ContractDTO());
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute @Validated ContractDTO contractDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            ModelAndView modelAndView = new ModelAndView("contract/create");
            modelAndView.addObject("contractDTO", contractDTO);
            modelAndView.addObject("message", "Add new not success!");
            return modelAndView;
        }
        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDTO, contract);
        contractService.save(contract);
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("contractDTO", contractDTO);
        modelAndView.addObject("message", "Add new Successful!");
        return modelAndView;
    }
}


