package be.vdab.frituur_frieda.services;

import be.vdab.frituur_frieda.restclients.KoersClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KoersWisselServiceTest {
    @Mock
    private KoersClient client;
    private KoersWisselService service;

    @BeforeEach
    void setUp() {
        service = new DefaultKoersWisselService(client);
    }

    @Test
    void naarDollar() {
        when(client.getDollarKoers()).thenReturn(BigDecimal.valueOf(2));
        assertThat(service.naarDollar(BigDecimal.valueOf(1.5))).isEqualByComparingTo("3");
        verify(client).getDollarKoers();
    }
}