package sh.jfm.upgradeexample;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@SuppressWarnings("SpringDataJdbcAssociatedDbElementsInspection")
@Table("MESSAGES")
public class DBMessage {
    @Id
    private Long id;
    private final String message;

    public DBMessage(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
