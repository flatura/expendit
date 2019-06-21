package code.flatura.expendit.service;

import code.flatura.expendit.repository.ConsumeFactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumeFactService {

    private ConsumeFactRepository consumeFactRepository;

    public ConsumeFactService(ConsumeFactRepository consumeFactRepository) {
        this.consumeFactRepository = consumeFactRepository;
    }

    public ConsumeFactService() {
    }

    @Autowired
    public void setConsumeFactRepository(ConsumeFactRepository consumeFactRepository) {
        this.consumeFactRepository = consumeFactRepository;
    }
}
