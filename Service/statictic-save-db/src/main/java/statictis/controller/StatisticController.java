package statictis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import statictis.dto.MessageJsonDto;
import statictis.repo.MessageJsonRepo;

import java.util.List;

@RestController
@RequestMapping("/account")
public class StatisticController {
    @Autowired
    private MessageJsonRepo messageJsonRepo;
    @GetMapping("/messageJson")
    public List<MessageJsonDto> getMessagejson(){
        return messageJsonRepo.findAll();
    }
}
