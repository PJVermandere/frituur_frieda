package be.vdab.frituur_frieda.restclients;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@PropertySource("application.properties")
@Import(EcbKoersClient.class)
class EcbKoersClientTest {
    private final EcbKoersClient client;

    EcbKoersClientTest(EcbKoersClient client) {
        this.client = client;
    }


    @Test
    void getDollarKoers() {
        assertThat(client.getDollarKoers()).isPositive();
    }
}