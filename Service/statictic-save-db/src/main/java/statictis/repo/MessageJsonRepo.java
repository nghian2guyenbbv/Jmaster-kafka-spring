package statictis.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import statictis.dto.MessageJsonDto;

@Repository
public interface MessageJsonRepo extends JpaRepository<MessageJsonDto, Integer> {
}
