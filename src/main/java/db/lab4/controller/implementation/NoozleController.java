package db.lab4.controller.implementation;

import db.lab4.model.implementation.Noozle;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.NoozleService;

public class NoozleController extends GeneralController<Noozle> {
    public static final NoozleService noozleService = new NoozleService();

    @Override
    public GeneralService<Noozle> getService() {
        return noozleService;
    }
}
