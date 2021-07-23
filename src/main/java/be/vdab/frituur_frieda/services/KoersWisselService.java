package be.vdab.frituur_frieda.services;

import java.math.BigDecimal;

public interface KoersWisselService {
    BigDecimal naarDollar(BigDecimal euro);
}
