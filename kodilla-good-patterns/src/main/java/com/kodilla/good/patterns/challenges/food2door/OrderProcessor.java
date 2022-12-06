package com.kodilla.good.patterns.challenges.food2door;

public class OrderProcessor {

    private InformationService informationService;
    private OrderService orderService;
    private ProductRepository productRepository;

    public OrderProcessor(final InformationService informationService,
                          final OrderService orderService,
                          final ProductRepository productRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.productRepository = productRepository;
    }

    public ProducerDto process(final OrderRequest orderRequest) {
        boolean isProducer = orderService.createOrder(orderRequest.producer(),
                orderRequest.orderDate(),
                orderRequest.product(),
                orderRequest.quantity());

        if (isProducer && orderRequest.quantity() < orderRequest.producer().getQuantity()) {
            informationService.inform(orderRequest.producer());
            productRepository.createOrder(orderRequest.producer(), orderRequest.product(), orderRequest.orderDate(), orderRequest.quantity());
            return new ProducerDto(orderRequest.producer(), true);
        } else {
            System.out.println("Producer " + orderRequest.producer().getProducerName() +
                    " has only " + orderRequest.producer().getQuantity() +
                    " " + orderRequest.product().name() +
                    ". Change quantity.  \n");
            return new ProducerDto(orderRequest.producer(), false);
        }
    }
}
