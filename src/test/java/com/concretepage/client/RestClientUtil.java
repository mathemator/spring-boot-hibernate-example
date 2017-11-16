package com.concretepage.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.concretepage.entity.Order;

import java.net.URI;
import java.util.Date;

public class RestClientUtil {
    //    public void getArticleByIdDemo() {
    //    	HttpHeaders headers = new HttpHeaders();
    //    	headers.setContentType(MediaType.APPLICATION_JSON);
    //        RestTemplate restTemplate = new RestTemplate();
    //	    String url = "http://localhost:8080/user/article/{id}";
    //        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
    //        ResponseEntity<Order> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Order.class, 1);
    //        Order order = responseEntity.getBody();
    //        System.out.println("Id:"+order.getArticleId()+", Title:"+order.getTitle()
    //                 +", Category:"+order.getCategory());
    //    }

    public void getOrdersByDepartament() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/orders";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Order[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Order[].class);
        Order[] orders = responseEntity.getBody();
        for(Order order : orders) {
            System.out.println("Id:" + order.getId() + ", Title:" + order.getTitle()
                    + ", Master: " + order.getMaster() + ", Type: " + order.getType() + ", StartDate: " + order.getStartDate()
                    + ", EndDate: " + order.getEndDate());
        }
    }

    public void getAllOrdersDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/orders";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Order[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Order[].class);
        Order[] orders = responseEntity.getBody();
        for(Order order : orders) {
            System.out.println("Id:" + order.getId() + ", Title:" + order.getTitle()
                    + ", Master: " + order.getMaster() + ", Type: " + order.getType() + ", StartDate: " + order.getStartDate()
                    + ", EndDate: " + order.getEndDate());
        }
    }

    public void getUnfinishedOrdersDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/orders/unfinished";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Order[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Order[].class);
        Order[] orders = responseEntity.getBody();
        for(Order order : orders) {
            System.out.println("Id:" + order.getId() + ", Title:" + order.getTitle()
                    + ", Master: " + order.getMaster() + ", Type: " + order.getType() + ", StartDate: " + order.getStartDate()
                    + ", EndDate: " + order.getEndDate());
        }
    }

        public void addOrderDemo() {
        	HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.APPLICATION_JSON);
            RestTemplate restTemplate = new RestTemplate();
    	    String url = "http://localhost:8080/user/order";
    	    Order order = new Order();
    	    order.setTitle("title_new");
    	    order.setMaster("Paul McCartney");
    	    order.setType("storage");
    	    Date now = new Date();
    	    order.setStartDate(now);
            now.setTime(now.getTime() + 7200L);
    	    order.setEndDate(now);

            HttpEntity<Order> requestEntity = new HttpEntity<Order>(order, headers);
            URI uri = restTemplate.postForLocation(url, requestEntity);
            System.out.println(uri.getPath());
        }
    //    public void updateArticleDemo() {
    //    	HttpHeaders headers = new HttpHeaders();
    //    	headers.setContentType(MediaType.APPLICATION_JSON);
    //        RestTemplate restTemplate = new RestTemplate();
    //	    String url = "http://localhost:8080/user/order";
    //	    Order objArticle = new Order();
    //	    objArticle.setArticleId(1);
    //	    objArticle.setTitle("Update:Java Concurrency");
    //	    objArticle.setCategory("Java");
    //        HttpEntity<Order> requestEntity = new HttpEntity<Order>(objArticle, headers);
    //        restTemplate.put(url, requestEntity);
    //    }
    public void deleteArticleDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/order/{title}";
        HttpEntity<Order> requestEntity = new HttpEntity<Order>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
    }

    public static void main(String args[]) {
        RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
//        util.getAllOrdersDemo();
//        util.getUnfinishedOrdersDemo();
        util.addOrderDemo();
        //util.updateArticleDemo();
        //util.deleteArticleDemo();
    }
}
