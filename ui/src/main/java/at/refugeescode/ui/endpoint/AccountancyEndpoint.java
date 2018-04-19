package at.refugeescode.ui.endpoint;

import at.refugeescode.ui.model.FinalizedPatient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class AccountancyEndpoint {

    private final RestTemplate restTemplate;

    @Value("${accountancy.url}")
    private String accountancyURL;

    @ModelAttribute("allInvoices")
    public List<FinalizedPatient> getAllInvoices() {
        return Arrays.asList(restTemplate.getForObject(accountancyURL, FinalizedPatient[].class));
    }

    @GetMapping
    private String viewAllInvoices() {
        return "invoices";
    }

}
