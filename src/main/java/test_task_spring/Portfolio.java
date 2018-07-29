package test_task_spring;
import java.util.List;

public class Portfolio {

    public List<Position> stocks = null;

    private Double calculateTotal() {
        return this.stocks
                .stream()
                .mapToDouble(s->s.getAssetValue())
                .sum();
    }

    private SectorAllocation CalculateSectorAllocation(String sector, Double total){
        Double assetValue;
        Double proportion;
        assetValue =  this.stocks
                .stream()
                .filter(s -> sector.equals(s.getSector()))
                .mapToDouble(s->s.getAssetValue())
                .sum();

        proportion = assetValue/total;
        return new SectorAllocation(sector,assetValue,proportion);
    }

    public Allocations CalculatePortfolio () {
        Double total;
        total = this.calculateTotal();
        Allocations portfolioAllocations = new Allocations(total);
        this.stocks
            .stream()
            .map((s) -> s.getSector())
            .distinct()
            .forEach((s) -> {
            portfolioAllocations.allocations.add(CalculateSectorAllocation(s, total));
        });

        return portfolioAllocations;
    }

}