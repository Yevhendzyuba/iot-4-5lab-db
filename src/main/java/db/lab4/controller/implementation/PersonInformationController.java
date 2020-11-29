package db.lab4.controller.implementation;

import db.lab4.model.implementation.PersonInformation;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.PersonInformationService;

public class PersonInformationController extends GeneralController<PersonInformation> {
    public static final PersonInformationService personInformationService = new PersonInformationService();

    @Override
    public GeneralService<PersonInformation> getService() {
        return personInformationService;
    }
}
