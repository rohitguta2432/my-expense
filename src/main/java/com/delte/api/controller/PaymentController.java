package com.delte.api.controller;

import com.adyen.model.checkout.PaymentMethodsResponse;
import com.delte.api.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author rohit
 * @Date 13/09/21
 **/
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<?> create() {
        return new ResponseEntity<>(paymentService.create(), HttpStatus.OK);
    }

    @GetMapping("callback")
    public ResponseEntity<?> calback() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("payment-method")
    public ResponseEntity<PaymentMethodsResponse> paymentMethod() {
        return new ResponseEntity(paymentService.getPaymentMethod(), HttpStatus.OK);
    }
}
