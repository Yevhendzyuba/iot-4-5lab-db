package db.lab4.controller.implementation;

import db.lab4.model.implementation.Date;
import db.lab4.service.implementation.DateService;
import db.lab4.service.implementation.GeneralService;

public class DateController extends GeneralController<Date> {
    public static final DateService dateService = new DateService();

    @Override
    public GeneralService<Date> getService() {
        return dateService;
    }
}
