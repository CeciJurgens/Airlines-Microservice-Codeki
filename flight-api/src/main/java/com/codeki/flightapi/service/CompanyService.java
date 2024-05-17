package com.codeki.flightapi.service;

import com.codeki.flightapi.exceptions.ResourceNotFoundException;
import com.codeki.flightapi.model.Company;
import com.codeki.flightapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public void createCompany(Company company){
        companyRepository.save(company);
    }

    public List<Company> findAll(){
        return companyRepository.findAll();
    }

    public Company findById(Long id){
        return companyRepository.findById(id).orElse(null);
    }

    public Company updateCompany(Company company){
        companyRepository.save(company);
        return  companyRepository.findById((company.getId())).orElse(null);
    }

    public void deleteById(Long id){
        Company company = companyRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("company", "id", id));
        companyRepository.deleteById(company.getId());
    }
}
