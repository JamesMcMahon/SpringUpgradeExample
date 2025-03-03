package sh.jfm.upgradeexample;

import org.springframework.data.repository.CrudRepository;

public interface DBMessageRepository extends CrudRepository<DBMessage, Long> {
    DBMessage getDBMessageById(Long id);
}
