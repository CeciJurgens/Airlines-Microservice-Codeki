package com.codeki.flightapi.controller;

import com.codeki.flightapi.exceptions.ResourceNotFoundException;
import com.codeki.flightapi.model.Company;
import com.codeki.flightapi.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("")
    public List<Company> getAllCompanies(){
        return companyService.findAll();
    }

    @GetMapping("/{id}")
    public Company searchCompanyId(@PathVariable Long id){
        return companyService.findById(id);
    }

    @PostMapping("/add")
    public void createCompany(@RequestBody Company company){
        companyService.createCompany(company);
    }

    @PutMapping("/update")
    public Company updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id){
        try{
            companyService.deleteById(id);
            return "Compania eliminada exitosamente";
        } catch(ResourceNotFoundException e){
            e.printStackTrace();
            return "No existe esa compañia";
        }

    }
}
