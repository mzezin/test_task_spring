
package test_task_spring;


public class SectorAllocation {

    public String sector;
    public Double assetValue;
    public Double proportion;

    public SectorAllocation(String sector, Double assetValue, Double proportion) {
        this.sector = sector;
        this.assetValue = assetValue;
        this.proportion = proportion;
    }
}