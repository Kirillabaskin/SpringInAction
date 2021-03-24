package tacos.web.api.model;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import tacos.Ingredient;
import tacos.web.api.RestApiDesignTacoController;

public class IngredientEntityAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientEntity> {

    public IngredientEntityAssembler() {
        super(RestApiDesignTacoController.class, IngredientEntity.class);
    }

    @Override
    protected IngredientEntity instantiateModel(Ingredient ingredient) {
        return new IngredientEntity(ingredient);
    }

    @Override
    public IngredientEntity toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }
}
