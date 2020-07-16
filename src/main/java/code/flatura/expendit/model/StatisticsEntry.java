package code.flatura.expendit.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StatisticsEntry {

    @Id
    private Integer id;
    private String name;
    private Long count;
    private Double dcount;

    public StatisticsEntry(Integer id, String name, Long count, Double dcount) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.dcount = dcount;
    }

    public StatisticsEntry(Integer id, String name, Long count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public StatisticsEntry(Integer id, String name, Double dcount) {
        this.id = id;
        this.name = name;
        this.dcount = dcount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Double getDcount() {
        return dcount;
    }

    public void setDcount(Double dcount) {
        this.dcount = dcount;
    }
}
