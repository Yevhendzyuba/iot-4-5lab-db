package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.PersonInformationDAO;
import db.lab4.model.implementation.PersonInformation;

public class PersonInformationService extends GeneralService<PersonInformation> {
    public GeneralDAOInterface<PersonInformation, Integer> personInformationDAO = new PersonInformationDAO();

    @Override
    public GeneralDAOInterface<PersonInformation, Integer> getDAO() {
        return personInformationDAO;
    }
}
