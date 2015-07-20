package com.pantha.service;

import com.pantha.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Customer, Customer> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Customer process(final Customer person) throws Exception {
        final String firstName = person.getFirstName();
        final String lastName = person.getLastName();

        final Customer transformedPerson = new Customer(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
