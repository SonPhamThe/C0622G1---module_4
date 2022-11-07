package case_study.controller;

import case_study.dto.FacilityDTO;
import case_study.model.facility.Facility;
import case_study.model.facility.FacilityType;
import case_study.model.facility.RentType;
import case_study.service.IFacilityService;
import case_study.service.IFacilityTypeService;
import case_study.service.IRentTypeService;
import case_study.service.impl.FacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @ModelAttribute("rentTypeList")
    public List<RentType> listRentType() {
        return rentTypeService.listRentType();
    }

    @ModelAttribute("facilityTypeService")
    public List<FacilityType> listFacilityType() {
        return facilityTypeService.listFacilityType();
    }

    @GetMapping("")
    public String displayAllFacility(@PageableDefault(value = 4) Pageable pageable, Model model) {
        model.addAttribute("facilities", facilityService.displayFacility(pageable));
        return "facility/list";
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
}
