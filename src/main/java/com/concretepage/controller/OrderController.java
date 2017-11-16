package com.concretepage.controller;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.concretepage.entity.Order;
import com.concretepage.service.IOrderService;

@Controller
@RequestMapping("user")
public class OrderController {
	@Autowired
	private IOrderService articleService;
	@GetMapping("order/{title}")
	public ResponseEntity<Order> getOrderByTitle(@PathVariable("title") String title) {
		Order article = articleService.getOrderByTitle(title);
		return new ResponseEntity<Order>(article, HttpStatus.OK);
	}

	@GetMapping("order/left/{title}")
	public ResponseEntity<String> getOrderLefiTime(@PathVariable("title") String title) {
		String left = articleService.getOrderLeftTime(title);
		return new ResponseEntity<String>(left, HttpStatus.OK);
	}


	@GetMapping("orders/unfinished")
	public ResponseEntity<List<Order>> getUnfinishedOrders() {
		List<Order> list = articleService.getUnfinishedOrders();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	@GetMapping("orders")
	public ResponseEntity<List<Order>> getAllOrders() {
		List<Order> list = articleService.getAllOrders();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
	@PostMapping("order")
	public ResponseEntity<Void> addOrder(@RequestBody Order order, UriComponentsBuilder builder) {
        boolean flag = articleService.addOrder(order);
        if (flag == false) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/order/{title}").buildAndExpand(order.getTitle()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("order")
	public ResponseEntity<Order> updateArticle(@RequestBody Order order) {
		articleService.updateOrder(order);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
	@DeleteMapping("order/{title}")
	public ResponseEntity<Void> deleteOrder(@PathVariable("title") String title) {
		articleService.deleteOrder(title);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 