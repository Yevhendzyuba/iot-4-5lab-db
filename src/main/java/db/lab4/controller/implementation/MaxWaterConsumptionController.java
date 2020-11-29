package db.lab4.controller.implementation;

import db.lab4.model.implementation.MaxWaterConsumption;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.MaxWaterConsumptionService;

public class MaxWaterConsumptionController extends GeneralController<MaxWaterConsumption> {

    public static final MaxWaterConsumptionService maxWaterConsumptionService = new MaxWaterConsumptionService();

    @Override
    public GeneralService<MaxWaterConsumption> getService() {
        return maxWaterConsumptionService;
    }
}
