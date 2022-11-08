package case_study.controller;

import case_study.dto.FacilityDTO;
import case_study.model.customer.Customer;
import case_study.model.facility.Facility;
import case_study.model.facility.FacilityType;
import case_study.model.facility.RentType;
import case_study.service.IFacilityService;
import case_study.service.IFacilityTypeService;
import case_study.service.IRentTypeService;
import case_study.service.impl.FacilityService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @ModelAttribute("rentTypes")
    public List<RentType> listRentType() {
        return rentTypeService.listRentType();
    }

    @ModelAttribute("facilityTypes")
    public List<FacilityType> listFacilityType() {
        return facilityTypeService.listFacilityType();
    }

    @GetMapping("")
    public String searchFacility(@RequestParam(value = "searchName", defaultValue = "") String searchName,
                                 @RequestParam(value = "searchFacilityType", defaultValue = "") String searchFacilityType,
                                 @PageableDefault(value = 4) Pageable pageable,
                                 Model model,
                                 RedirectAttributes redirectAttributes) {
        Page<Facility> facilities = facilityService.findByNameAndFacilityType(searchName, searchFacilityType, pageable);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchFacilityType", searchFacilityType);
        model.addAttribute("facilitySearch", facilities);
        return "/facility/list";
    }

    @GetMapping("/create")
    public String showCreateFacility(Model model) {
        model.addAttribute("facilityDto", new FacilityDTO());
        return "/facility/create";
    }

    @PostMapping("/save")
    public String saveFacility(@Validated @ModelAttribute FacilityDTO facilityDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        if (bindingResult.hasFieldErrors()) {
            return "/facility/create";
        } else {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDTO, facility);
            facilityService.save(facility);
            redirectAttributes.addFlashAttribute("message", "Add New Facility successfully!");
            return "redirect:/facility";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        facilityService.remove(id);
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Facility> facility = facilityService.findById(id);
        if (!facility.isPresent()) {
            redirectAttributes.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facility";
        }
        FacilityDTO facilityDto = new FacilityDTO();
        BeanUtils.copyProperties(facility.get(), facilityDto);
        model.addAttribute("facilityDto", facilityDto);
        return "/facility/edit";
    }

    @PostMapping("/edit")
    public String update(@Validated @ModelAttribute(value = "facilityDto") FacilityDTO facilityDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(facilityDto.getId());
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facility";
        }
        if (!bindingResult.hasErrors()) {
            Facility facility = new Facility();
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.save(facility);
            redirect.addFlashAttribute("message", "Facility saved successfully");
            return "redirect:/facility";
        } else {
            redirect.addFlashAttribute("message", "Facility saved failed");
            return "redirect:/facility";
        }
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable(value = "id") int id, Model model, RedirectAttributes redirect) {
        Optional<Facility> optionalFacility = facilityService.findById(id);
        if (!optionalFacility.isPresent()) {
            redirect.addFlashAttribute("message", "Facility not found!");
            return "redirect:/facility";
        }
        model.addAttribute("facility", optionalFacility.get());
        return "redirect:/facility";
    }
}
