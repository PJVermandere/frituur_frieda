package be.vdab.frituur_frieda.services;

import be.vdab.frituur_frieda.exceptions.KoersClientException;
import be.vdab.frituur_frieda.restclients.KoersClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DefaultKoersWisselService implements KoersWisselService {
    private final KoersClient[] clients;

    public DefaultKoersWisselService(KoersClient[] clients) {
        this.clients = clients;
    }

    @Override
    public BigDecimal naarDollar(BigDecimal euro) {
        Exception laatste = null;
        for(var client: clients){
            try{
                System.out.println(client);
                return euro.multiply(client.getDollarKoers()).setScale(2, RoundingMode.HALF_UP);

            } catch (KoersClientException e) {
                laatste = e;
            }

        }
        throw new KoersClientException("Geen succes", laatste);
    }
}
