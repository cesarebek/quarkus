package com.cezarybek.service;

import com.cezarybek.model.Fruit;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class FruitService {
    @Inject
    Logger logger;

    @Transactional
    public void persistFruit(Fruit fruit){
        fruit.persist();
        logger.infof("%s saved to db!", fruit.name);
    }

}
