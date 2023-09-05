package com.item.demo.models.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.item.demo.models.Item;
import com.item.demo.models.Product;

@Service("serviceRestTemplate")
public class ItemServiceImp implements ItemService {

    @Autowired
    private RestTemplate clientRest;

    @Override
    public List<Item> findAll() {
        List<Product> products = Arrays.asList(clientRest.getForObject("http://localhost:8001/list", Product[].class));
        // Hay que transformar la lista de productos, en una lista de Items
        // Usamos jdk 8 (api stream para convertir la lista en un flujo)
        // Map para convertir cada objeto producto en un objeto item
        // Funcion de flecha para convertir cada el objeto producto en Item
        // Convertir el Stream en objeto list con el metodo collect
        return products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer amount) {
        Map<String, String> pathVariables = new HashMap<String, String>();
        pathVariables.put("id", id.toString());
        Product product = clientRest.getForObject("http://localhost:8001/{id}", Product.class, pathVariables);

        return new Item(product, amount);
    }

}
