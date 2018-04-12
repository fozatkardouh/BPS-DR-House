package at.refugeescode.accountancy.initialise;

import at.refugeescode.accountancy.model.Accountant;
import at.refugeescode.accountancy.model.AccountantImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Starter {

    @Bean
    public Accountant accountant(AccountantImp accountantImp) {
        accountantImp.addToBillRepo("cold medicine", 23.49);
        accountantImp.addToBillRepo("diarrhea medicine", 44.99);
        accountantImp.addToBillRepo("pruritus medicine", 33.12);
        accountantImp.addToBillRepo("lubus medicine", 99.99);
        return accountantImp;
    }

}
