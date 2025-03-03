package sh.jfm.upgradeexample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @GetMapping("/message")
    public String getUserById() {
        return "Hello World!";
    }
}
