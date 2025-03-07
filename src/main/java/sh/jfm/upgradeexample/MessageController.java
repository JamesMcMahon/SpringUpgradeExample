package sh.jfm.upgradeexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

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

    @GetMapping("/db-messages")
    public Collection<String> getMessageFromDB() {
        return dbMessageRepository.findAll()
                .stream()
                .map(DBMessage::getMessage)
                .collect(Collectors.toList());
    }

    @GetMapping("/secure-message")
    public String getSecureMessage() {
        return "Hello Secure World!";
    }
}
