package code.flatura.expendit.service;

import code.flatura.expendit.model.ConsumableStatus;
import code.flatura.expendit.model.StatisticsEntry;
import code.flatura.expendit.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class StatisticsService {
    private StatisticsRepository statisticsRepository;

    public StatisticsService() {
    }

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Autowired
    public void setStatisticsRepository(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Transactional
    public List<StatisticsEntry> getConsumeStatsBetweenDates(LocalDate startDate, LocalDate endDate) {
        if (startDate == null) {
            startDate = LocalDate.of(2019, 1, 1);
        }
        if (endDate == null) {
            endDate = LocalDate.now();
        }
        double months = ChronoUnit.MONTHS.between(startDate, endDate);
        List<StatisticsEntry> result =
                statisticsRepository.countGroupedByModelIdAndBetweenDates(startDate,endDate);
        for (StatisticsEntry e : result) {
            e.setDcount(e.getCount() / months);
        }
        //System.out.println(months);
        return result;
    }

    public StatisticsEntry getAmountOfConsumables(Integer id, ConsumableStatus status) {
        return statisticsRepository.getAmountOfConsumable(id, status);
    }

    public List<StatisticsEntry> getAvailableAmountOfAllConsumables() {
            return statisticsRepository.getAllAvailableAmountOfConsumables();
    }
}
