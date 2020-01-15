package code.flatura.expendit.service;

import code.flatura.expendit.model.StatisticsEntry;
import code.flatura.expendit.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
        return statisticsRepository.countGroupedByModelIdAndBetweenDates(
                startDate == null ? LocalDate.of(1950, 1, 1) : startDate,
                endDate == null ? LocalDate.of(2100, 12,31) : endDate);
    }

    public List<StatisticsEntry> getAvailableAmountOfConsumables(Integer id) {
        if (id == null) {
            return statisticsRepository.getAllAvailableAmountOfConsumables();
        } else return statisticsRepository.getAvailableAmountOfConsumableByModelId(id);
    }
}
