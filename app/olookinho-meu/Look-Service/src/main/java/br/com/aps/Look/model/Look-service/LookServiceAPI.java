package br.com.aps.olookinhomeu.model.Look;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;


public class LookServiceAPI {
     @Value("${look_service_url}")
    private String lookServiceUrl;

    private WebClient client() {
        return WebClient.builder().baseUrl(lookServiceUrl).build();
    }

    @Override
    public boolean enoughBalance(Long lookId, Long valueToBeDecreased) {
        return (boolean)
                client().get()
                        .uri("/{id}/enoughBalance/{value}", lookId, valueToBeDecreased)
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block()
                        .get("enoughBalance");
    }

    @Override
    public void updateBalance(Long lookId, Long valueToBeAppended) {
        client().put()
                .uri("/{id}/balance", lookId)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(valueToBeAppended))
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}
}
