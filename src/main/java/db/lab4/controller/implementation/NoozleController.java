package db.lab4.controller.implementation;

import db.lab4.model.implementation.Noozle;
import db.lab4.service.GeneralServiceInterface;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.NoozleService;

public class NoozleController extends GeneralController<Noozle> {
    private final GeneralService<Noozle> noozleService = new NoozleService();

    @Override
    public final GeneralServiceInterface<Noozle> getService() {
        return noozleService;
    }
}
