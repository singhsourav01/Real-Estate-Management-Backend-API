package com.example.ExcleRBackEndCode;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class user_statusService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private BrokerRepository brokerRepository;

    // Method to persist a Property entity with its associated Broker
    public void savePropertyWithBroker(Long brokerId, Property property) {
        // Retrieve or create the associated Broker
        Optional<Broker> optionalBroker = brokerRepository.findById(brokerId);
        Broker broker = optionalBroker.orElseThrow(() -> new RuntimeException("Broker not found"));

        // Set the associated Broker to the Property entity
        property.setBrokerId(brokerId);

        // Persist the Property entity
        propertyRepository.save(property);
    }
}