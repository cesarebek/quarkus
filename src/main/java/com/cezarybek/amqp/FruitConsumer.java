package com.cezarybek.amqp;

import com.cezarybek.model.Fruit;
import com.cezarybek.repository.FruitRepository;
import com.cezarybek.service.FruitService;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class FruitConsumer {
    @Inject
    Logger logger;
    @Inject
    FruitRepository fruitRepository;
    @Inject
    FruitService fruitService;

    @Incoming("fruits-input")
    public Fruit receiveFruit(Fruit fruit){
        logger.infof("Received %s %s!", fruit.quantity, fruit.name);
        fruitService.persistFruit(fruit);
        return fruit;
    }
}
