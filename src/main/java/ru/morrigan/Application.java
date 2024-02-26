package ru.morrigan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.alexeykedr.SpringApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
        openHomePage();
    }
    private static void openHomePage() throws IOException {
        Runtime rt = Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8083/");
    }
}
