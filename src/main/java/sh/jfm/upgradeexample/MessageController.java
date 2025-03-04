package sh.jfm.upgradeexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final DBMessageRepository dbMessageRepository;

    public MessageController(DBMessageRepository dbMessageRepository) {
        this.dbMessageRepository = dbMessageRepository;
    }

    @GetMapping("/message")
    public String getMessage() {
        return "Hello World!";
    }

    @GetMapping("/db-message")
    public String getMessageFromDB() {
        return dbMessageRepository.getDBMessageById(1L).getMessage();
    }

    @GetMapping("/secure-message")
    public String getSecureMessage() {
        return "Hello Secure World!";
    }
}
