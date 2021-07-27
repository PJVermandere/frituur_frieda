package be.vdab.frituur_frieda.restclients;

import be.vdab.frituur_frieda.exceptions.KoersClientException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;

@Component
public class EcbKoersClient implements KoersClient {
    private final URL url;
    private final XMLInputFactory factory = XMLInputFactory.newInstance();
    public EcbKoersClient(@Value("${ecbKoersURL}") URL url) {
        this.url = url;
    }

    @Override
    public BigDecimal getDollarKoers() {
        try(var stream = url.openStream()){
            var reader = factory.createXMLStreamReader(stream);
            while(reader.hasNext()){
                reader.next();
                if (reader.isStartElement()){
                    if ("USD".equals(reader.getAttributeValue(0))){
                        return new BigDecimal(reader.getAttributeValue(1));
                    }
                }
            }
        } catch (IOException | XMLStreamException e) {
           throw new KoersClientException("oops",e);
        }
        return null;
    }
}
