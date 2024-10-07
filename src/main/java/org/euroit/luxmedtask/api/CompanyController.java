package org.euroit.luxmedtask.api;

import lombok.RequiredArgsConstructor;
import org.euroit.luxmedtask.db.entity.CompanyEntity;
import org.euroit.luxmedtask.db.repository.CompanyRepository;
import org.euroit.luxmedtask.mapper.CompanyMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping(CompanyController.REQUEST_URL)
@RequiredArgsConstructor
public class CompanyController {
    public static final String REQUEST_URL = "/api/v1/companies";

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;


    @GetMapping("/{id}")
    ReadCompanyResponse readCompany(@PathVariable("id") UUID id) {
        return companyMapper.from(companyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND)));
    }

    @PostMapping
    @ResponseStatus(CREATED)
    void createCompany(@RequestBody CreateCompanyRequest request) {
        companyRepository.save(new CompanyEntity().setId(UUID.randomUUID()).setName(request.name));
    }

    @PutMapping
    void updateCompany() {
        //TODO
    }

    @DeleteMapping
    void deleteCompany() {
        //TODO
    }

    public record ReadCompanyResponse(
            String id,
            String name
    ) {
    }

    public record CreateCompanyRequest(
            String name
    ) {
    }
}
