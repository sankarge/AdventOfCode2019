package de.tillmannheigel.adventofcode9.AdventOfCode_2019_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class AdventOfCode {

    private static final String ADVENTOFCODE_COM = "https://adventofcode.com";

    @Autowired
    private ResourceLoader resourceLoader;

    public List<Long> getInput(String day) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:day" + day + "/input");
        InputStream inputStream = resource.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayList<Long> result = new ArrayList<>();
        String line;
        while ((line=bufferedReader.readLine()) != null) {
            result.add(Long.valueOf(line));
        }
        return result;
    }

    public static Mono<String> getInputFromWebForDay(String day) {

        return getWebClient()
                .get()
                .uri("/2019/day/" + day + "/input")
                .exchange()
                .flatMap(AdventOfCode::getResponseEntityMono)
                .map(HttpEntity::getBody);
    }

    private static Mono<ResponseEntity<String>> getResponseEntityMono(final ClientResponse clientResponse) {
        return clientResponse.toEntity(String.class);
    }

    private static WebClient getWebClient() {
        return WebClient.create(ADVENTOFCODE_COM);
    }
}
