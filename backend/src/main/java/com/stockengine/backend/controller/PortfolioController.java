package com.stockengine.backend.controller;

import com.stockengine.backend.dto.PortfolioItem;
import com.stockengine.backend.entity.Order;
import com.stockengine.backend.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/portfolio")
@CrossOrigin(origins = "http://localhost:5173")
public class PortfolioController {

    private final OrderRepository orderRepository;

    public PortfolioController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/{username}")
    public Map<String, Object> getPortfolio(@PathVariable String username) {

        List<Order> orders = orderRepository.findByUsername(username);

        Map<String, PortfolioItem> portfolioMap = new HashMap<>();

        for (Order order : orders) {
            String stock = order.getStock();

            int qty = order.getType().equals("BUY")
                    ? order.getQuantity()
                    : -order.getQuantity();

            double amount = order.getType().equals("BUY")
                    ? order.getQuantity() * order.getPrice()
                    : -order.getQuantity() * order.getPrice();

            portfolioMap.putIfAbsent(
                    stock,
                    new PortfolioItem(stock, 0, 0)
            );

            PortfolioItem item = portfolioMap.get(stock);

            portfolioMap.put(
                    stock,
                    new PortfolioItem(
                            stock,
                            item.getQuantity() + qty,
                            item.getInvested() + amount
                    )
            );
        }

        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("portfolio", portfolioMap.values());

        return response;
    }
}
