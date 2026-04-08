package com.example.ecommerce.my_email_system.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* This class maps emailtypes to the suitable bean that renders the email
 * Used to quickly select which emailRenderingStrategy to use for the email type
* */
@Component
public class StrategyResolver {

   Map<EmailType,EmailRenderingStrategy> strategies ;

   @Autowired
   public StrategyResolver(List<EmailRenderingStrategy> renderers) {
       strategies = renderers.stream()
               .collect(Collectors.toMap(
                       EmailRenderingStrategy::getType,
                       r -> r
               ));
   }

   //returns the strategy bean for the EmailType selected
    public  EmailRenderingStrategy resolve(EmailType type) {
       return strategies.get(type);
    }
}
