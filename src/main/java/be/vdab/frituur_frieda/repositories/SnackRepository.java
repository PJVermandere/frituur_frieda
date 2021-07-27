package be.vdab.frituur_frieda.repositories;

import be.vdab.frituur_frieda.domain.Snack;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class SnackRepository implements SnackRepositoryInterface{
    @Override
    public long addSnack(Snack snack) {
        return 0;
    }

    @Override
    public long updateSnack(Snack snack) {
        return 0;
    }

    @Override
    public long deleteSnack(long id) {
        return 0;
    }

    @Override
    public List<Snack> getAllSnacks() {
        return null;
    }

    @Override
    public Optional<Snack> getOneSnack(long id) {
        return Optional.empty();
    }

    @Override
    public long getSnackCount() {
        return 0;
    }

    @Override
    public List<BigDecimal> getUniquePrices() {
        return null;
    }

    @Override
    public List<Snack> getSnackWithPrice(BigDecimal price) {
        return null;
    }

    @Override
    public List<Snack> getSnacksWithId(Set<Long> ids) {
        return null;
    }
}
