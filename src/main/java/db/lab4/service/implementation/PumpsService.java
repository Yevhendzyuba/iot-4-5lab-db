package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.PumpsDAO;
import db.lab4.model.implementation.Pumps;

public class PumpsService extends GeneralService<Pumps> {
    public GeneralDAOInterface<Pumps, Integer> pumpsDAO = new PumpsDAO();

    @Override
    public GeneralDAOInterface<Pumps, Integer> getDAO() {
        return pumpsDAO;
    }
}
