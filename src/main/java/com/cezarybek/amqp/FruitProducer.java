package com.cezarybek.amqp;

import com.cezarybek.model.Fruit;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class FruitProducer {
    @Inject
    Logger logger;

    @Inject
    @Channel("fruits-input")
    Emitter<Fruit> emitter;

    public void postToQueue(Fruit fruit){
        logger.infof("Adding to queue %s", fruit.name);
        emitter.send(fruit);
    }
}
