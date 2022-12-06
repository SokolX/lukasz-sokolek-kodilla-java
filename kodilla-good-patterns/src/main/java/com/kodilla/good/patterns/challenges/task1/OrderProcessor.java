package com.kodilla.good.patterns.challenges.task1;

import com.kodilla.good.patterns.challenges.example1.InformationService;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private PaymentRepository paymentRepository;

    public OrderProcessor(final InformationService informationService,
                          final OrderService orderService,
                          final PaymentRepository paymentRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.paymentRepository = paymentRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isPaid = orderService.payment(orderRequest.user(),
                orderRequest.orderDate(),
                orderRequest.product());

        if (isPaid) {
            informationService.inform(orderRequest.user());
            paymentRepository.createPayment(orderRequest.user(), orderRequest.orderDate(), orderRequest.product().price());
            return new OrderDto(orderRequest.user(), true);
        } else {
            return new OrderDto(orderRequest.user(), false);
        }
    }
}
