package com.cezarybek.controller;

import com.cezarybek.amqp.FruitProducer;
import com.cezarybek.model.Fruit;
import com.cezarybek.repository.FruitRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/fruits")
public class FruitController {

    @Inject
    FruitRepository fruitRepository;
    @Inject
    FruitProducer fruitProducer;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Fruit> readFruits() {
        return fruitRepository.listAll();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Fruit enqueueFruits(Fruit fruit){
       fruitProducer.postToQueue(fruit);
       return fruit;
    }
}