package db.lab4.controller.implementation;

import db.lab4.model.implementation.MaxWaterConsumption;
import db.lab4.service.GeneralServiceInterface;
import db.lab4.service.implementation.GeneralService;
import db.lab4.service.implementation.MaxWaterConsumptionService;

public class MaxWaterConsumptionController extends GeneralController<MaxWaterConsumption> {

    private final GeneralService<MaxWaterConsumption> maxWaterConsumptionService = new MaxWaterConsumptionService();

    @Override
    public final GeneralServiceInterface<MaxWaterConsumption> getService() {
        return maxWaterConsumptionService;
    }
}
