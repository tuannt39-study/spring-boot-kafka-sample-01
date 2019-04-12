package vn.sapo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import vn.sapo.domain.Foo1;

@RestController
@RequestMapping(value = "/api/kafka")
public class KafkaResource {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @PostMapping(path = "/send")
    public void sendFoo(@RequestParam("message") String message) {
        this.template.send("topic1", new Foo1(message));
    }

}
