package test_task_spring;


import org.springframework.web.client.RestTemplate;

public class Position {

    private String symbol;
    private Long volume;
    private String sector;
    private Double latestPrice;
    private Double assetValue;


    public String getSector() {
        return sector;
    }



    public Double getLatestPrice() {
        return latestPrice;
    }



    public Double getAssetValue() {
        return assetValue;
    }



    public Long getVolume() {
        return volume;
    }


    public Position(String symbol, Long volume) {
        this.symbol=symbol;
        this.volume=volume;
        RestTemplate restTemplate = new RestTemplate();
        StockQuote quote = restTemplate.getForObject(String.format("https://api.iextrading.com/1.0/stock/%s/quote", symbol), StockQuote.class);
        this.sector = quote.getSector();
        this.latestPrice = quote.getLatestPrice();
        this.assetValue  =  this.getLatestPrice() * this.getVolume();
    }
}