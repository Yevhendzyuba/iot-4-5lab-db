package db.lab4.service.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.DAO.implementation.DateDAO;
import db.lab4.model.implementation.Date;

public class DateService extends GeneralService<Date>{
    public GeneralDAOInterface<Date,Integer> dateDAO = new DateDAO();

    @Override
    public GeneralDAOInterface<Date,Integer> getDAO(){
        return dateDAO;
    }
}
