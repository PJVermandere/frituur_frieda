package be.vdab.frituur_frieda.restclients;

import be.vdab.frituur_frieda.exceptions.KoersClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.regex.Pattern;

@Component
public class FixerKoersClient implements KoersClient {
    private static final Pattern pattern = Pattern.compile(".*\"USD\":(\\d*\\.\\d*).*");
    private final URL url;

    FixerKoersClient(@Value("${fixerKoersURL}") URL url) {
        this.url = url;
    }

    @Override
    public BigDecimal getDollarKoers(){
        try(var stream = url.openStream()){
            var matcher = pattern.matcher(new String(stream.readAllBytes()));
            if(!matcher.matches()){
                throw new KoersClientException("Geen Dollar beschikbaar");
            }

             return new BigDecimal(matcher.group(1));
        } catch (IOException e) {
            throw new KoersClientException("Kan geen koers lezen via fixer", e);
        }
    }
}
