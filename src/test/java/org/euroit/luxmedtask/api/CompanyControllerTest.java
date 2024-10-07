package org.euroit.luxmedtask.api;

import org.euroit.luxmedtask.TestcontainersConfiguration;
import org.euroit.luxmedtask.api.CompanyController.ReadCompanyResponse;
import org.euroit.luxmedtask.db.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment= RANDOM_PORT)
class CompanyControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private CompanyRepository companyRepository;

    @Test
    void shouldReadACompany() {
        var response = testRestTemplate
                .getForEntity(CompanyController.REQUEST_URL + "/ee1ecde8-f553-4114-ae4b-b63b83f9e9c9", ReadCompanyResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        var payload = response.getBody();
        assertThat(payload)
                .isEqualTo(new ReadCompanyResponse("ee1ecde8-f553-4114-ae4b-b63b83f9e9c9", "Tecla"));
    }

    @Test
    void shouldCreateANewCompany() {
        var response = testRestTemplate.postForEntity(CompanyController.REQUEST_URL,
                new CompanyController.CreateCompanyRequest("My new company"), Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

    }
}