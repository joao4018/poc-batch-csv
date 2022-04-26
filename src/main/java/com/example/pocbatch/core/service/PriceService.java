package com.example.pocbatch.core.service;

import com.example.pocbatch.core.model.Price;
import com.example.pocbatch.core.repository.PriceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PriceService {

    private PriceRepository priceRepository;

    /**
     * Reponsavel por buscar todos os usuarios da base de dados.
     *
     * @return Todos os usuarios.
     */

    public void deleteAll() {
        priceRepository.deleteAll();
    }

    public List<Price> findByAll() {
        return this.priceRepository.findAll();
    }

    public void save(Price user) {
        this.priceRepository.save(user);
    }
}
