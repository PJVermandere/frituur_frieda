package be.vdab.frituur_frieda.repositories;

import be.vdab.frituur_frieda.domain.Snack;
import be.vdab.frituur_frieda.exceptions.NietGevondenException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Repository
public class SnackRepository implements SnackRepositoryInterface{
    private final JdbcTemplate template;
    private final SimpleJdbcInsert insert;
    private final RowMapper<Snack> mapper = ((resultSet, i) -> new Snack(resultSet.getInt("id"), resultSet.getString("naam"), resultSet.getBigDecimal("prijs")));

    public SnackRepository(JdbcTemplate template) {
        this.template = template;
        insert = new SimpleJdbcInsert(template).withTableName("snacks").usingGeneratedKeyColumns("id");
    }

    @Override
    public long addSnack(Snack snack) {
        return insert.executeAndReturnKey(Map.of("naam",snack.getName(),"prijs", snack.getPrice())).longValue();
    }

    @Override
    public long updateSnack(Snack snack) {
        var output = template.update("update snacks set naam= ?, prijs=? where id=?", snack.getName(),snack.getPrice(), snack.getId());
        if (output == 0) throw new NietGevondenException();
        else return output;
    }

    @Override
    public long deleteSnack(long id) {
        return template.update("delete from snacks where id=?", id);
    }

    @Override
    public List<Snack> getAllSnacks() {
        return template.query("select * from snacks", mapper);
    }

    @Override
    public Optional<Snack> getOneSnack(long id) {
        try {
            return Optional.of(template.queryForObject("select * from snacks where id=?", mapper, id));
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public long getSnackCount() {
        return template.queryForObject("select count(*) from snacks", Long.class);
    }

    @Override
    public List<BigDecimal> getUniquePrices() {
        RowMapper<BigDecimal> mapper = (((resultSet, i) -> resultSet.getBigDecimal("prijs")));
        return template.query("select distinct prijs from snacks order by prijs", mapper);
    }

    @Override
    public List<Snack> getSnacksWithPrice(BigDecimal price) {

        return template.query("select * from snacks where prijs=?", mapper, price);
    }

    @Override
    public List<Snack> getSnacksById(Set<Long> ids) {
        String args = "?,".repeat(ids.size()-1)+"?";
        return template.query("select * from snacks where id in ("+args+") order by id", mapper, ids.toArray());
    }
}
