package io.github.matheuscard;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//Precisei colocar o pacote io.github.matheuscard, pois coloquei a anotacao @ComponentScan
//que me obriga deixar explicitado por meio do array basePackges os pacotes que serao
//gerenciados pelo IOC.(Apenas a titulo didatico, pois essa forma nao e produtiva, uma vez que
// o IOC gerencia todas as classes com as anotacoes apartir do pacote em que contem a classe anotada
// com SpringBootApplication.)
@ComponentScan(basePackages = {"com.umaoutrabiblioteca.projeto","io.github.matheuscard"})
@RestController
public class VendasApplication {

    @Value("${application.name}")
    private String applicationName;
//    @Qualifier("applicationName")
//    private String applicationName;
//    public VendasApplication(String applicationName) {
//        this.applicationName = applicationName;
//    }

    @Gato
    private Animal animal;

    @Bean
    public CommandLineRunner executar(){
        return args -> {
            this.animal.fazerBarulho();
        };
    }

    @GetMapping("/hello")
    public String helloWorld(){
        return applicationName;
    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
