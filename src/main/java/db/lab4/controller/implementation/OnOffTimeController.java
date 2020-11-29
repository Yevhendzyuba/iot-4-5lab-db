package db.lab4.controller.implementation;

import db.lab4.model.implementation.OnOffTime;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.OnOffTimeService;

public class OnOffTimeController extends GeneralController<OnOffTime> {
    public static final OnOffTimeService onOffTimeService = new OnOffTimeService();

    @Override
    public GeneralService<OnOffTime> getService() {
        return onOffTimeService;
    }
}
