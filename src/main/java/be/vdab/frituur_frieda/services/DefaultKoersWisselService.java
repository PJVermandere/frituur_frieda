package be.vdab.frituur_frieda.services;

import be.vdab.frituur_frieda.restclients.KoersClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DefaultKoersWisselService implements KoersWisselService {
    private final KoersClient koersClient;

    public DefaultKoersWisselService(KoersClient koersClient) {
        this.koersClient = koersClient;
    }

    @Override
    public BigDecimal naarDollar(BigDecimal euro) {
        return euro.multiply(koersClient.getDollarKoers()).setScale(2, RoundingMode.HALF_UP);
    }
}
