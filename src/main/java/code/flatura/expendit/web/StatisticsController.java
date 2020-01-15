package code.flatura.expendit.web;

import code.flatura.expendit.model.StatisticsEntry;
import code.flatura.expendit.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/stats", produces = MediaType.APPLICATION_JSON_VALUE)
public class StatisticsController {
    private StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public StatisticsController() {
    }

    @Autowired
    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/summary")
    public ResponseEntity<List<StatisticsEntry>> getConsumeStatsByDate(@Valid @RequestParam(name = "startDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                                       @Valid @RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return new ResponseEntity<>(statisticsService.getConsumeStatsBetweenDates(startDate, endDate), HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<StatisticsEntry>> getAvailableAmountOfConsumables(@RequestParam(name = "id", required = false) Integer id) {
        return new ResponseEntity<>(statisticsService.getAvailableAmountOfConsumables(id), HttpStatus.OK);
    }
}
