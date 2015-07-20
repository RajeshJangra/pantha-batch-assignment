package com.pantha.service;

import com.pantha.Application;
import com.pantha.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * RestItemWriter Tester.
 *
 * @author Rajesh Kumar
 * @version 1.0
 * @since <pre>Jul 20, 2015</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RestItemWriterTest {

    /**
     * Method: write(List<? extends T> items)
     */
    @Test
    public void testWrite() throws Exception {
        Customer customer = new Customer();
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);
        RestTemplate restTemplate = mock(RestTemplate.class);
        final String url = "http://localhost:8080/customers";
        RestItemWriter restItemWriter = new RestItemWriter(restTemplate, url);
        restItemWriter.write(customerList);
        verify(restTemplate).put(url, customer);
    }
}
