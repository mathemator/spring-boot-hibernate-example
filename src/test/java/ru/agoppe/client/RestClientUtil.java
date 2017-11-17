package ru.agoppe.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ru.agoppe.entity.Order;

import java.net.URI;
import java.util.Date;

public class RestClientUtil {

    public void getOrderByTitleDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/roga/order/title_1";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Order> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Order.class, 1);
        Order order = responseEntity.getBody();
        System.out.println("Id:" + order.getId() + ", Title:" + order.getTitle()
                + ", Master: " + order.getMaster() + ", Type: " + order.getType() + ", StartDate: " + order.getStartDate()
                + ", EndDate: " + order.getEndDate());
    }

    public void getOrderLeftTimeDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/roga/order/title_4/left";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class, 1);
        String string = responseEntity.getBody();
        System.out.println(string);
    }

    public void getOrdersByDepartamentDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/roga/orders/departament/soft";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Order[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Order[].class);
        Order[] orders = responseEntity.getBody();
        for(Order order : orders) {
            System.out.println("Id:" + order.getId() + ", Title:" + order.getTitle()
                    + ", Master: " + order.getMaster() + ", Type: " + order.getType() + ", StartDate: " + order.getStartDate()
                    + ", EndDate: " + order.getEndDate());
        }
    }

    public void getOrdersByMasterDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/roga/orders/master/Paul McCartney";
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
        String url = "http://localhost:8080/roga/orders";
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
        String url = "http://localhost:8080/roga/orders/unfinished";
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
        String url = "http://localhost:8080/roga/order";
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
    //	    String url = "http://localhost:8080/roga/order";
    //	    Order objArticle = new Order();
    //	    objArticle.setArticleId(1);
    //	    objArticle.setFullName("Update:Java Concurrency");
    //	    objArticle.setCategory("Java");
    //        HttpEntity<Order> requestEntity = new HttpEntity<Order>(objArticle, headers);
    //        restTemplate.put(url, requestEntity);
    //    }
    public void deleteOrderDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/roga/order/title_new";
        HttpEntity<Order> requestEntity = new HttpEntity<Order>(headers);
        ResponseEntity<Void> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
        System.out.println(responseEntity.getStatusCode());
    }

    public void updateOrderDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/roga/order";
        Order order = new Order();
        order.setTitle("title_new");
        order.setMaster("George Harrison");
        order.setType("soft");

        HttpEntity<Order> requestEntity = new HttpEntity<Order>(order, headers);
        restTemplate.put(url, requestEntity);
    }

    public static void main(String args[]) {
        RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
        //        util.getAllOrdersDemo();
        //        util.getUnfinishedOrdersDemo();
//        util.getOrderLeftTimeDemo();
//        util.deleteOrderDemo();
//                util.addOrderDemo();
        util.updateOrderDemo();
        //        util.getOrdersByDepartamentDemo();
        //        util.getOrdersByMasterDemo();
        //util.updateArticleDemo();
        //util.deleteArticleDemo();
    }
}
