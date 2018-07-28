package test_task_spring;

import java.util.ArrayList;
import java.util.List;

public class Allocations {

    public Double value;
    public List<SectorAllocation> allocations = null;

    public Allocations(Double value) {
        this.value = value;
        this.allocations=new ArrayList<>();
    }

    public void addSector (SectorAllocation sectorAllocation) {
        this.allocations.add(sectorAllocation);
    }
}