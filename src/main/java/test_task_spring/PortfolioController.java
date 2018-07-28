package test_task_spring;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class PortfolioController {


    @RequestMapping(
            value = "/{symbol}",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    @ResponseBody
    public StockQuote stockQuote (
            @PathVariable("symbol") String symbol) {
        RestTemplate restTemplate = new RestTemplate();
        StockQuote quote = restTemplate.getForObject(String.format("https://api.iextrading.com/1.0/stock/%s/quote", symbol), StockQuote.class);
        return quote;
    }


    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            produces = "application/json",
            consumes = "application/json"
    )
    @ResponseBody
    public Allocations calculatePortfolio(@RequestBody Portfolio portfolio) throws Exception {
        return portfolio.CalculatePortfolio();
    }
}