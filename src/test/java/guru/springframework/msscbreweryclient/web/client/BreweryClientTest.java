package guru.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {
        BeerDto beer = client.getBeerById(UUID.randomUUID());

        assertNotNull(beer);
        System.out.println("Beer found: " + beer);
    }

    @Test
    void saveNewBeer() {
        //given
        BeerDto newBeer = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(newBeer);

        assertNotNull("URI: " + uri);
        System.out.println(uri.toString());
    }

    @Test
    void updateBeer() {
        //given
        BeerDto beer = BeerDto.builder().beerName("Updated Beer").build();

        client.updateBeer(UUID.randomUUID(), beer);
    }

    @Test
    void deleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {

        CustomerDto customer = client.getCustomerById(UUID.randomUUID());

        assertNotNull(customer);
        System.out.println("Customer found: " + customer);

    }

    @Test
    void saveNewCustomer() {
        CustomerDto newCustomer = CustomerDto.builder().name("New User").build();

        URI uri = client.saveNewCustomer(newCustomer);

        assertNotNull(uri);
        System.out.println("new Customer URI: " + uri);
    }

    @Test
    void updateCustomer() {
        CustomerDto customer = CustomerDto.builder().name("Updated User").build();

        client.updateCustomer(UUID.randomUUID(), customer);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}
