package db.lab4.controller.implementation;

import db.lab4.model.implementation.Pumps;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.PumpsService;

public class PumpsController extends GeneralController<Pumps> {
    public static final PumpsService pumpsService = new PumpsService();

    @Override
    public GeneralService<Pumps> getService(){
        return pumpsService;
    }
}
