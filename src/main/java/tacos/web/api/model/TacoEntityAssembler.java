package tacos.web.api.model;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import tacos.Taco;
import tacos.web.api.RestApiDesignTacoController;

public class TacoEntityAssembler extends RepresentationModelAssemblerSupport<Taco, TacoEntity> {

    public TacoEntityAssembler(){
        super(RestApiDesignTacoController.class, TacoEntity.class);
    }

    @Override
    protected TacoEntity instantiateModel(Taco taco) {
        return new TacoEntity(taco);
    }

    @Override
    public TacoEntity toModel(Taco taco) {
        return createModelWithId(taco.getId(), taco);
    }
}
