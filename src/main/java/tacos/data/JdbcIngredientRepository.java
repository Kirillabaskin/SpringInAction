package tacos.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tacos.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplate.query("select id, name, type from Ingredient",
                this::mapRowToIngredient);
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet,int rowNum) throws SQLException {
        return new Ingredient(
                resultSet.getString("id"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }

    @Override
    public Ingredient findById(String id) {
        return jdbcTemplate.queryForObject("select id, name, type from Ingredient where id=?",
                this::mapRowToIngredient,
                id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingrediet(id,name,type) ?,?,?",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
