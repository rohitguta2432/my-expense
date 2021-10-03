package com.delte.api.service;

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.enums.Environment;
import com.adyen.model.Amount;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.checkout.PaymentsRequest;
import com.adyen.model.checkout.PaymentsResponse;
import com.adyen.service.Checkout;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 13/09/21
 **/

@Slf4j
@Service
public class PaymentService {

    public String create() {
        PaymentsResponse paymentsResponse = null;
        try {

            Config config = new Config();
            config.setApiKey("AQEqhmfuXNWTK0Qc+iSAvlEfiMGOWoRdCLRHWk3WN8+7Lu7xbt1KXM5/VUOdEMFdWw2+5HzctViMSCJMYAc=-5uJzYLf1wQKfhmSTWzc1atMgNxmFimz+pR3+y+JNelg=-fUXP9PN3BvyJ_Z+e");
            Client client = new Client(config);

            Checkout checkout = new Checkout(client);
            PaymentsRequest paymentsRequest = new PaymentsRequest();
            Amount amount = new Amount();
            amount.setCurrency("USD");
            amount.setValue(0L);
            paymentsRequest.setAmount(amount);
            paymentsRequest.setReference(UUID.randomUUID().toString());
            //paymentsRequest.setPaymentMethod(new HashMap<String, String>());
            paymentsRequest.addCardData("37000000000002", "03", "2030", "7373", "Simon Hopper", true);
            paymentsRequest.setShopperReference(UUID.randomUUID().toString());
            paymentsRequest.setReturnUrl("https://465a-106-51-141-96.ngrok.io/payment/callback");
            paymentsRequest.setMerchantAccount("PLUGOEuropeGmbHECOM");
            paymentsRequest.setShopperInteraction(PaymentsRequest.ShopperInteractionEnum.valueOf("Ecommerce"));
            paymentsRequest.setRecurringProcessingModel(PaymentsRequest.RecurringProcessingModelEnum.valueOf("CardOnFile"));
            PaymentsResponse response = checkout.payments(paymentsRequest);
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentsResponse.toString();
    }

    public PaymentMethodsResponse getPaymentMethod() {
        PaymentMethodsResponse paymentMethodsResponse = null;
        try {
            String xApiKey = "AQEqhmfuXNWTK0Qc+iSAvlEfiMGOWoRdCLRHWk3WN8+7Lu7xbt1KXM5/VUOdEMFdWw2+5HzctViMSCJMYAc=-5uJzYLf1wQKfhmSTWzc1atMgNxmFimz+pR3+y+JNelg=-fUXP9PN3BvyJ_Z+e";
            Client client = new Client(xApiKey, Environment.TEST);
            Checkout checkout = new Checkout(client);
            PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
            paymentMethodsRequest.setMerchantAccount("PLUGOEuropeGmbHECOM");
            paymentMethodsRequest.setCountryCode("NL");
            paymentMethodsRequest.setShopperLocale("nl-NL");
            Amount amount = new Amount();
            amount.setCurrency("EUR");
            amount.setValue(1000L);
            paymentMethodsRequest.setAmount(amount);
            paymentMethodsRequest.setChannel(PaymentMethodsRequest.ChannelEnum.IOS);
            paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
            log.info("payment mthos response { {} ", paymentMethodsRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paymentMethodsResponse;
    }
}

