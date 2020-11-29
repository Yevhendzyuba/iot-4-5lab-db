package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.NoozleDAO;
import db.lab4.model.implementation.Noozle;

public class NoozleService extends GeneralService<Noozle> {
    public GeneralDAOInterface<Noozle, Integer> noozleDAO = new NoozleDAO();

    @Override
    public GeneralDAOInterface<Noozle, Integer> getDAO() {
        return noozleDAO;
    }
}
