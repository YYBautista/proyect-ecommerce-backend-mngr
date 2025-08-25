package com.seiryu.ecommerce.backend_ecommerce.infrastructure.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.DataPayment;
import com.seiryu.ecommerce.backend_ecommerce.domain.model.UrlPaypalResponse;
import com.seiryu.ecommerce.backend_ecommerce.infrastructure.service.PaypalService;

@RestController
@RequestMapping("/api/v1/payments")
public class PaypalController {

    private final PaypalService paypalService;
    private final String SUCCESS_URL = "http://localhost:5000/api/v1/payments/success";
    private final String CANCEL_URL = "http://localhost:5000/api/v1/payments/cancel";

    public PaypalController(PaypalService paypalService) {
        this.paypalService = paypalService;
    }

    @PostMapping
    public UrlPaypalResponse createPayment(@RequestBody DataPayment dataPayment) {

        try {
            Payment payment = paypalService.createPayment(Double.valueOf(dataPayment.getAmount()),
                    dataPayment.getCurrency(), dataPayment.getMethod(), "sale", dataPayment.getDescription(),
                    CANCEL_URL, SUCCESS_URL);

            for (Links links : payment.getLinks()) {

                if (links.getRel().equals("approval_url")) {
                    return new UrlPaypalResponse(links.getHref());
                }

            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return new UrlPaypalResponse("http://localhost:4200");
    }

    @GetMapping("/success")
    public RedirectView paymentSuccess(@RequestParam("paymentId") String paymentId,
            @RequestParam("PayerID") String payerId) {

        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);

            if (payment.getState().equals("approved")) {
                return new RedirectView("http://localhost:4200/payment/success");
                // return new RedirectView("http://localhost:4200");
            }
        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }

        return new RedirectView("http://localhost:4200");
    }

    @GetMapping("/cancel")
    public RedirectView paymentCancel() {

        return new RedirectView("http://localhost:4200");
    }

}
