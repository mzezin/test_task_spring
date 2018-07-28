package test_task_spring;
import java.util.List;
import java.util.stream.Collectors;

public class Portfolio {

    public List<Position> stocks = null;

    private Double calculateTotal() {
        return this.stocks
                .stream()
                .mapToDouble(s->s.getAssetValue())
                .sum();
    }

    private SectorAllocation CalculateSectorAllocation(String sector){
        Double assetValue;
        Double proportion;
        assetValue =  this.stocks
                .stream()
                .filter(s -> sector.equals(s.getSector()))
                .mapToDouble(s->s.getAssetValue())
                .sum();

        proportion = assetValue/this.calculateTotal();
        return new SectorAllocation(sector,assetValue,proportion);
    }

    public Allocations CalculatePortfolio () {
        Allocations portfolioAllocations = new Allocations(this.calculateTotal());
        this.stocks
            .stream()
            .map((s) -> s.getSector())
            .distinct()
            .collect(Collectors.toList())
            .forEach((s) -> {
            portfolioAllocations.allocations.add(CalculateSectorAllocation(s));
        });

        return portfolioAllocations;
    }

}