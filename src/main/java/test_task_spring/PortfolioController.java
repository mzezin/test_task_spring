package test_task_spring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PortfolioController {

    @RequestMapping("/quote")
    public StockQuote stockQuote (@RequestParam(value="name", defaultValue="aapl") String name) {
        RestTemplate restTemplate = new RestTemplate();
        StockQuote quote = restTemplate.getForObject(String.format("https://api.iextrading.com/1.0/stock/%s/quote", name), StockQuote.class);
        return quote;
    }
}