package com.fitness.demo.listing;

import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static net.bytebuddy.matcher.ElementMatchers.nameContains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;


@AutoConfigureMockMvc
@SpringBootTest
class ListingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ListingService service;

    /**
     * test that controller rest api for get listing by page behaves properly with mocked service.
     * @throws Exception
     */
    @Test
    void getListingByPage() throws Exception {
        List<Listing> listingsFromRepo = new ArrayList<>();
        listingsFromRepo.add(new Listing("skis", 100, "Anna" ));
        listingsFromRepo.add(new Listing("skis", 200, "Anna" ));
        when(service.getListingsByPage(1,2)).thenReturn(listingsFromRepo);

        this.mockMvc.perform(get("/api/v1/listing/1/2").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"objectId\":null,\"description\":\"skis\",\"price\":100.0,\"seller\":\"Anna\"},{\"objectId\":null,\"description\":\"skis\",\"price\":200.0,\"seller\":\"Anna\"}]"));
    }

    @Test
    void getListingByKeyword() {
    }
}