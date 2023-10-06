package statictis.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import statictis.dto.MessageDTO;
import statictis.dto.MessageJsonDto;
import statictis.repo.MessageJsonRepo;

@Service
public class StatictisService {
    @Autowired
    private MessageJsonRepo messageJsonRepo;

    @KafkaListener(topics = "statictis3", groupId = "groupStatictis")
    private void getStatisticInfo(MessageDTO messageDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        String messageStr = "DEFAULT_MASSGE";
        try{
            messageStr    = objectMapper.writeValueAsString(messageDTO);
        }catch(Exception ex){
            System.out.println("error convert message :"+ex);

        }
        messageJsonRepo.save(MessageJsonDto.builder().messageJson(messageStr).build());
        System.out.println("sucess save satictis with json");
    }
}
