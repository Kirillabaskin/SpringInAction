package tacos.web.api.model;

import lombok.Getter;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import tacos.Taco;

import java.util.Date;

@Relation(value = "taco", collectionRelation = "tacos")
public class TacoEntity extends RepresentationModel<TacoEntity> {

    @Getter
    private final String name;

    @Getter
    private final Date createdAt;

    @Getter
    private final CollectionModel<IngredientEntity> ingredients;

    public TacoEntity(Taco taco){
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = new IngredientEntityAssembler().toCollectionModel(taco.getIngredients());
    }
}
