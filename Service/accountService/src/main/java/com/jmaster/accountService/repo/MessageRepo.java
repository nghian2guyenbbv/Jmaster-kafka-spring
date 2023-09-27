package com.jmaster.accountService.repo;

import com.jmaster.accountService.model.MessageDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<MessageDTO, Integer> {
    List<MessageDTO> findMessageDTOByStatus(boolean status);
}
