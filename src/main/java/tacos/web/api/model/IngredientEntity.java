package tacos.web.api.model;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import tacos.Ingredient;
import tacos.Ingredient.Type;

@Relation(value = "ingredient", collectionRelation = "ingredients")
public class IngredientEntity extends RepresentationModel<IngredientEntity> {

    @Getter
    private final String name;

    @Getter
    private final Type type;

    public IngredientEntity(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
