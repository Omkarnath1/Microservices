package com.example.orderservice.Service;

import com.example.orderservice.DTO.InventoryResponse;
import com.example.orderservice.DTO.OrderLineItemsDto;
import com.example.orderservice.DTO.OrderRequest;
import com.example.orderservice.Model.Order;
import com.example.orderservice.Model.OrderLineItems;
import com.example.orderservice.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final WebClient.Builder webClientBuilder;

    public String placeOrder(OrderRequest orderRequest) throws IllegalAccessException {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList().stream()
                .map(this::mapToDto)
                    .toList();

            order.setOrderLineItemsList(orderLineItemsList);



          List<String> skuCodes = order.getOrderLineItemsList().stream()
                    .map(OrderLineItems::getSkuCode)
                    .toList();

        System.out.println(skuCodes);

        InventoryResponse[] inventoryResponseArray =  webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();


        System.out.println(Arrays.toString(inventoryResponseArray));
        boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
                .allMatch(InventoryResponse::isInStock);

        System.out.println(allProductsInStock);
        if(allProductsInStock) {
             orderRepository.save(order);
             return "Order placed Successfully";
        }else{
            throw new IllegalAccessException("Product not in stock !! try again later");
        }




    }

    public OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto){
        OrderLineItems lineItems = new OrderLineItems();
       lineItems.setPrice(orderLineItemsDto.getPrice());
       lineItems.setQuantity(orderLineItemsDto.getQuantity());
        System.out.println(orderLineItemsDto.getSkuCode());
       lineItems.setSkuCode(orderLineItemsDto.getSkuCode());
       return lineItems;
    }

}
