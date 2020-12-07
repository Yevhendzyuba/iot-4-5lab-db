package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.NoozleDAO;
import db.lab4.model.implementation.Noozle;

public class NoozleService extends GeneralService<Noozle> {
    private final GeneralDAOInterface<Noozle> NOOZLE_DAO = new NoozleDAO();

    @Override
    public GeneralDAOInterface<Noozle> getDAO() {
        return NOOZLE_DAO;
    }
}
