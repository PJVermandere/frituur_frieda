package be.vdab.frituur_frieda.repositories;

import be.vdab.frituur_frieda.domain.Snack;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface SnackRepositoryInterface {
    long addSnack(Snack snack);
    long updateSnack(Snack snack);
    long deleteSnack(long id);
    List<Snack> getAllSnacks();
    Optional<Snack> getOneSnack(long id);
    long getSnackCount();
    List<BigDecimal> getUniquePrices();
    List<Snack> getSnacksWithPrice(BigDecimal price);
    List<Snack> getSnacksById(Set<Long> ids);
}
