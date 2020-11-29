package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.OnOffTimeDAO;
import db.lab4.model.implementation.OnOffTime;

public class OnOffTimeService extends GeneralService<OnOffTime> {
    public GeneralDAOInterface<OnOffTime, Integer> onOffTimeDAO = new OnOffTimeDAO();

    @Override
    public GeneralDAOInterface<OnOffTime, Integer> getDAO() {
        return onOffTimeDAO;
    }
}
