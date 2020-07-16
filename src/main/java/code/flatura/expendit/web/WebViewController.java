package code.flatura.expendit.web;

import code.flatura.expendit.model.Consumable;
import code.flatura.expendit.model.ConsumableStatus;
import code.flatura.expendit.model.StatisticsEntry;
import code.flatura.expendit.model.dto.BaseDto;
import code.flatura.expendit.model.dto.FormIncomingConsumableDto;
import code.flatura.expendit.model.dto.FormInstallConsumableDto;
import code.flatura.expendit.service.ConsumableService;
import code.flatura.expendit.service.ModelService;
import code.flatura.expendit.service.RoomService;
import code.flatura.expendit.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class WebViewController {

    private StatisticsService statisticsService;
    private RoomService roomService;
    private ConsumableService consumableService;
    private ModelService modelService;

    @Autowired
    public WebViewController(StatisticsService statisticsService, RoomService roomService, ConsumableService consumableService, ModelService modelService) {
        this.statisticsService = statisticsService;
        this.roomService = roomService;
        this.consumableService = consumableService;
        this.modelService = modelService;
    }

    @GetMapping("/add/incoming")
    public String consumablesBulkAddingForm(Map<String, Object> model) {
        final List<BaseDto> models = modelService.getAll()
                .stream()
                .map(m -> new BaseDto(m.getId(), m.getName()))
                .sorted(Comparator.comparing(BaseDto::getName))
                .collect(Collectors.toList());
        final List<BaseDto> rooms = roomService.getAll()
                .stream()
                .map(r -> new BaseDto(r.getId(), r.getName()))
                .collect(Collectors.toList());
        FormIncomingConsumableDto resultDto = new FormIncomingConsumableDto(0,null, 0, 0, 0, null);
        model.put("income", resultDto);
        model.put("rooms", rooms);
        model.put("models", models);
        return "income_form";
    }

    // Внесение диничного прихода
    @PostMapping("/add/incoming")
    public String consumablesBulkAddingSubmit(FormIncomingConsumableDto resultDto) {
        System.out.println(resultDto.getName());
        if (resultDto.getIncomeCount() >= 1)
        for (int i = 0; i < resultDto.getIncomeCount(); i++) {
            consumableService.create(new Consumable(
                    resultDto.getName(),
                    resultDto.getContract(),
                    resultDto.getPrice(),
                    resultDto.getModelId(),
                    ConsumableStatus.NEW,
                    resultDto.getRoomId()));
        }
        return "home";
    }

    // Внесение расхода
    @GetMapping("/add/consume")
    public String AddConsumeForm(Map<String, Object> model) {
        final List<StatisticsEntry> models = statisticsService.getAvailableAmountOfAllConsumables();
        final List<BaseDto> rooms = roomService.getAll()
                .stream()
                .map(r -> new BaseDto(r.getId(), r.getName()))
                .collect(Collectors.toList());
        FormInstallConsumableDto resultDto = new FormInstallConsumableDto(0, 0, 0);
        model.put("models", models);
        model.put("rooms", rooms);
        model.put("result_dto", resultDto);
        return "consume_form";
    }

    @PostMapping("/add/consume")
    @Transactional
    public String addConsumeSubmit(FormInstallConsumableDto resultDto) {
        List<Consumable> result = consumableService.installMany(resultDto.getModel_id(), resultDto.getCount_to_install(), resultDto.getRoom_id());
        System.out.println("!!! Установлено " + result.size() + " картриджей модели " + result.get(0).getConsumableModelId());
        return "home";
    }

    //Просмотр статистики расхода по моделям
    @GetMapping("/stats/consume")
    public ModelAndView consumeStatistics(Map<String, Object> model) {
        List<StatisticsEntry> result = statisticsService.getConsumeStatsBetweenDates(null, null);
        model.put("stats_list", result);
        return new ModelAndView("consume");
    }

    //Просмотр баланса
    @GetMapping("/stats/balance")
    public ModelAndView stockBalance(Map<String, Object> model) {
    //public String stockBalance(Map<String, Object> model) {
        List<StatisticsEntry> result = statisticsService.getAvailableAmountOfAllConsumables();
        model.put("balance_list", result);
        return new ModelAndView("balance");
    }
}
