package db.lab4.view;

import db.lab4.controller.implementation.*;

import java.sql.SQLException;

import db.lab4.model.implementation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private final DataOfSensorsController dataOfSensorsController = new DataOfSensorsController();
    private final DataOfSensorsHasPersonInformationController dataOfSensorsHasPersonInformationController = new DataOfSensorsHasPersonInformationController();
    private final DateController dateController = new DateController();
    private final LocationController locationController = new LocationController();
    private final MaxWaterConsumptionController maxWaterConsumptionController = new MaxWaterConsumptionController();
    private final NoozleController noozleController = new NoozleController();
    private final OnOffTimeController onOffTimeController = new OnOffTimeController();
    private final PersonInformationController personInformationController = new PersonInformationController();
    private final PumpsController pumpsController = new PumpsController();
    private final SensorDataController sensorDataController = new SensorDataController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    public static final Scanner INPUT = new Scanner(System.in, "UTF-8");

    public MainView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();


        menu.put("11", "11 - Get all dataOfSensors");
        menu.put("12", "12 - Get dataOfSensor by ID");
        menu.put("13", "13 - Create dataOfSensor");
        menu.put("14", "14 - Delete dataOfSensor by ID");
        menu.put("15", "15 - Update dataOfSensor by ID");

        menu.put("21", "21 - Get all dataOfSensorsHasPersonInformations");
        menu.put("22", "22 - Get dataOfSensorsHasPersonInformation by ID");
        menu.put("23", "23 - Create dataOfSensorsHasPersonInformation");
        menu.put("24", "24 - Delete dataOfSensorsHasPersonInformation by ID");
        menu.put("25", "25 - Update dataOfSensorsHasPersonInformation by ID");

        menu.put("31", "31 - Get all dates");
        menu.put("32", "32 - Get date by id");
        menu.put("33", "33 - Create date");
        menu.put("34", "34 - Delete date by ID");
        menu.put("35", "35 - Update date");

        menu.put("41", "41 - Get all locations");
        menu.put("42", "42 - Get location by ID");
        menu.put("43", "43 - Create location");
        menu.put("44", "44 - Delete location by ID");
        menu.put("45", "45 - Update location by ID");

        menu.put("51", "51 - Get all maxWaterConsumptions");
        menu.put("52", "52 - Get maxWaterConsumption by ID");
        menu.put("53", "53 - Create maxWaterConsumption");
        menu.put("54", "54 - Delete maxWaterConsumption by ID");
        menu.put("55", "55 - Update maxWaterConsumption by ID");

        menu.put("61", "61 - Get all noozles");
        menu.put("62", "62 - Get noozle by ID");
        menu.put("63", "63 - Create noozle");
        menu.put("64", "64 - Delete noozle by ID");
        menu.put("65", "65 - Update noozle by ID");

        menu.put("71", "71 - Get all onOffTimes");
        menu.put("72", "72 - Get onOffTime by ID");
        menu.put("73", "73 - Create onOffTime");
        menu.put("74", "74 - Delete onOffTime by ID");
        menu.put("75", "75 - Update onOffTime by ID");

        menu.put("81", "81 - Get all personInformations");
        menu.put("82", "82 - Get personInformation by ID");
        menu.put("83", "83 - Create personInformation");
        menu.put("84", "84 - Delete personInformation by ID");
        menu.put("85", "85 - Update personInformation by ID");

        menu.put("91", "91 - Get all pumps");
        menu.put("92", "92 - Get pumps by ID");
        menu.put("93", "93 - Create pumps");
        menu.put("94", "94 - Delete pumps by ID");
        menu.put("95", "95 - Update pumps by ID");

        menu.put("101", "101 - Get all sensorDatas");
        menu.put("102", "102 - Get sensorData by ID");
        menu.put("103", "103 - Create sensorData");
        menu.put("104", "104 - Delete sensorData by ID");
        menu.put("105", "105 - Update sensorData by ID");

        methodsMenu.put("11", this::getAllDataOfSensors);
        methodsMenu.put("12", this::getDataOfSensorById);
        methodsMenu.put("13", this::createDataOfSensor);
        methodsMenu.put("14", this::deleteDataOfSensorById);
        methodsMenu.put("15", this::updateDataOfSensorById);

        methodsMenu.put("21", this::getAllDataOfSensorsHasPersonInformations);
        methodsMenu.put("22", this::getDataOfSensorsHasPersonInformationById);
        methodsMenu.put("23", this::createDataOfSensorsHasPersonInformation);
        methodsMenu.put("24", this::deleteDataOfSensorsHasPersonInformationById);
        methodsMenu.put("25", this::updateDataOfSensorsHasPersonInformationById);

        methodsMenu.put("31", this::getAllDates);
        methodsMenu.put("32", this::getDateById);
        methodsMenu.put("33", this::createDate);
        methodsMenu.put("34", this::deleteDateById);
        methodsMenu.put("35", this::updateDateById);

        methodsMenu.put("41", this::getAllLocations);
        methodsMenu.put("42", this::getLocationById);
        methodsMenu.put("43", this::createLocation);
        methodsMenu.put("44", this::deleteLocationById);
        methodsMenu.put("45", this::updateLocationById);

        methodsMenu.put("51", this::getAllMaxWaterConsumptions);
        methodsMenu.put("52", this::getMaxWaterConsumptionId);
        methodsMenu.put("53", this::createMaxWaterConsumption);
        methodsMenu.put("54", this::deleteMaxWaterConsumptionId);
        methodsMenu.put("55", this::updateMaxWaterConsumptionById);

        methodsMenu.put("61", this::getAllNoozles);
        methodsMenu.put("62", this::getNoozleById);
        methodsMenu.put("63", this::createNoozle);
        methodsMenu.put("64", this::deleteNoozleById);
        methodsMenu.put("65", this::updateNoozleById);

        methodsMenu.put("71", this::getAllOnOffTimes);
        methodsMenu.put("72", this::getOnOffTimeById);
        methodsMenu.put("73", this::createOnOffTime);
        methodsMenu.put("74", this::deleteOnOffTimeById);
        methodsMenu.put("75", this::updateOnOffTimeById);

        methodsMenu.put("81", this::getAllPersonInformations);
        methodsMenu.put("82", this::getPersonInformationById);
        methodsMenu.put("83", this::createPersonInformation);
        methodsMenu.put("84", this::deletePersonInformationById);
        methodsMenu.put("85", this::updatePersonInformationById);

        methodsMenu.put("91", this::getAllPumps);
        methodsMenu.put("92", this::getPumpsById);
        methodsMenu.put("93", this::createPumps);
        methodsMenu.put("94", this::deletePumpsById);
        methodsMenu.put("95", this::updatePumpsById);

        methodsMenu.put("101", this::getAllSensorDatas);
        methodsMenu.put("102", this::getSensorDataById);
        methodsMenu.put("103", this::createSensorData);
        methodsMenu.put("104", this::deleteSensorDataById);
        methodsMenu.put("105", this::updateSensorDataById);

    }

    private void getAllDataOfSensors() throws SQLException {
        System.out.println("\nTable: DataOfSensors");
        dataOfSensorsController.getAll();
    }

    private void getDataOfSensorById() throws SQLException {
        System.out.println("Enter ID for DataOfSensors: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        dataOfSensorsController.getById(id);
    }

    private void createDataOfSensor() throws SQLException {
        System.out.println("Enter new DataOfSensors time: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new DataOfSensors sensorDataId: ");
        int sensorDataId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new DataOfSensors pumpsId: ");
        int pumpsId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new DataOfSensors noozleId: ");
        int noozleId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new DataOfSensors dateId: ");
        int dateId = INPUT.nextInt();
        INPUT.nextLine();
        DataOfSensors entity = new DataOfSensors(0, time, sensorDataId, pumpsId, noozleId, dateId);
        dataOfSensorsController.create(entity);
    }

    private void deleteDataOfSensorById() throws SQLException {
        System.out.println("Enter ID to delete DataOfSensors: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        dataOfSensorsController.delete(id);
    }

    private void updateDataOfSensorById() throws SQLException {
        System.out.println("Enter DataOfSensors id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        DataOfSensors oldDataOfSensors = dataOfSensorsController.getService().getById(id);
        System.out.println("Enter new time for DataOfSensors: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new sensorDataId for DataOfSensors: ");
        int sensorDataId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new pumpsId for DataOfSensors: ");
        int pumpsId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new noozleId for DataOfSensors: ");
        int noozleId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new dateId for DataOfSensors: ");
        int dateId = INPUT.nextInt();
        INPUT.nextLine();

        String newTime = time;
        Integer newSensorDataId = sensorDataId;
        Integer newPumpsId = pumpsId;
        Integer newNoozleId = noozleId;
        Integer newDateId = dateId;


        if (time.equals("")) newTime = oldDataOfSensors.getTime();
        if (sensorDataId < 0) newSensorDataId = oldDataOfSensors.getSensorDataId();
        if (pumpsId < 0) newPumpsId = oldDataOfSensors.getPumpsId();
        if (noozleId < 0) newNoozleId = oldDataOfSensors.getNoozleId();
        if (dateId < 0) newDateId = oldDataOfSensors.getDateId();

        DataOfSensors entity = new DataOfSensors(id, newTime, newSensorDataId, newPumpsId, newNoozleId, newDateId);
        dataOfSensorsController.update(entity);
    }

    private void getAllDataOfSensorsHasPersonInformations() throws SQLException {
        System.out.println("\nTable: DataOfSensorsHasPersonInformation");
        dataOfSensorsController.getAll();
    }

    private void getDataOfSensorsHasPersonInformationById() throws SQLException {
        System.out.println("Enter dataOfSensorsID for DataOfSensorsHasPersonInformations: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        dataOfSensorsHasPersonInformationController.getById(id);
    }

    private void createDataOfSensorsHasPersonInformation() throws SQLException {

        System.out.println("Enter new DataOfSensorsHasPersonInformations dataOfSensorsId: ");
        int dataOfSensorsId = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Enter new DataOfSensorsHasPersonInformations personInformationId: ");
        int personInformationId = INPUT.nextInt();
        INPUT.nextLine();

        DataOfSensorsHasPersonInformation entity = new DataOfSensorsHasPersonInformation(dataOfSensorsId, personInformationId);
        dataOfSensorsHasPersonInformationController.create(entity);
    }

    private void deleteDataOfSensorsHasPersonInformationById() throws SQLException {
        System.out.println("Enter ID to delete DataOfSensorsHasPersonInformations: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        dataOfSensorsHasPersonInformationController.delete(id);
    }

    private void updateDataOfSensorsHasPersonInformationById() throws SQLException {

        System.out.println("Enter DataOfSensorsHasPersonInformations id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        DataOfSensorsHasPersonInformation oldCrewAcceptedHasRescuerOfCrew = dataOfSensorsHasPersonInformationController.getService().getById(id);


        System.out.println("Enter new DataOfSensorsHasPersonInformations dataOfSensorsId: ");
        int dataOfSensorsId = INPUT.nextInt();
        INPUT.nextLine();

        System.out.println("Enter new DataOfSensorsHasPersonInformations personInformationId: ");
        int personInformationId = INPUT.nextInt();
        INPUT.nextLine();

        Integer newDataOfSensorsId = dataOfSensorsId;
        Integer newPersonInformationId = personInformationId;


        if (dataOfSensorsId < 0) newDataOfSensorsId = oldCrewAcceptedHasRescuerOfCrew.getDataOfSensorsId();
        if (personInformationId < 0) newPersonInformationId = oldCrewAcceptedHasRescuerOfCrew.getPersonInformationId();


        DataOfSensorsHasPersonInformation entity = new DataOfSensorsHasPersonInformation(newDataOfSensorsId, newPersonInformationId);
        dataOfSensorsHasPersonInformationController.update(entity);
    }

    private void getAllDates() throws SQLException {
        System.out.println("\nTable: Date");
        dateController.getAll();
    }

    private void getDateById() throws SQLException {
        System.out.println("Enter ID for Date: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        dateController.getById(id);
    }

    private void createDate() throws SQLException {
        System.out.println("Enter new Date from: ");
        String from = INPUT.nextLine();
        System.out.println("Enter new Date to : ");
        String to = INPUT.nextLine();
        Date entity = new Date(0, from, to);
        dateController.create(entity);
    }

    private void deleteDateById() throws SQLException {
        System.out.println("Enter ID to delete Date: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        dateController.delete(id);
    }

    private void updateDateById() throws SQLException {
        System.out.println("Enter Date id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Date oldDate = dateController.getService().getById(id);
        System.out.println("Enter new from date for Date: ");
        String from = INPUT.nextLine();
        System.out.println("Enter new to date for Date: ");
        String to = INPUT.nextLine();


        String newfrom = from;
        String newTo = to;


        if (from.equals("")) newfrom = oldDate.getFrom();
        if (to.equals("")) newTo = oldDate.getTo();


        Date entity = new Date(id, newfrom, newTo);
        dateController.update(entity);
    }

    private void getAllLocations() throws SQLException {
        System.out.println("\nTable: InjuryOnCall");
        locationController.getAll();
    }

    private void getLocationById() throws SQLException {
        System.out.println("Enter ID for InjuryOnCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        locationController.getById(id);
    }

    private void createLocation() throws SQLException {
        System.out.println("Enter new InjuryOnCall name of injury: ");
        String section = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall description of injury: ");
        String number = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall number of hospital: ");
        String subscription = INPUT.nextLine();
        Location entity = new Location(0, section, number, subscription);
        locationController.create(entity);
    }

    private void deleteLocationById() throws SQLException {
        System.out.println("Enter ID to delete InjuryOnCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        locationController.delete(id);
    }

    private void updateLocationById() throws SQLException {
        System.out.println("Enter InjuryOnCall id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Location oldLocation = locationController.getService().getById(id);
        System.out.println("Enter new name of injury for InjuryOnCall: ");
        String section = INPUT.nextLine();
        System.out.println("Enter new description of injury for InjuryOnCall: ");
        String number = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall number of hospital: ");
        String subscription = INPUT.nextLine();


        String newSection = section;
        String newNumber = number;
        String newSubscription = subscription;


        if (section.equals("")) newSection = oldLocation.getSection();
        if (number.equals("")) newNumber = oldLocation.getNumber();
        if (subscription.equals("")) newSubscription = oldLocation.getSubscription();


        Location entity = new Location(id, newSection, newNumber, newSubscription);
        locationController.update(entity);
    }

    private void getAllMaxWaterConsumptions() throws SQLException {
        System.out.println("\nTable: MaxWaterConsumption");
        maxWaterConsumptionController.getAll();
    }

    private void getMaxWaterConsumptionId() throws SQLException {
        System.out.println("Enter ID for MaxWaterConsumption: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        maxWaterConsumptionController.getById(id);
    }

    private void createMaxWaterConsumption() throws SQLException {
        System.out.println("Enter new MaxWaterConsumption time: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new MaxWaterConsumption power: ");
        String power = INPUT.nextLine();
        System.out.println("Enter new MaxWaterConsumption litres: ");
        String litres = INPUT.nextLine();
        MaxWaterConsumption entity = new MaxWaterConsumption(0, time, power, litres);
        maxWaterConsumptionController.create(entity);
    }

    private void deleteMaxWaterConsumptionId() throws SQLException {
        System.out.println("Enter ID to delete MaxWaterConsumption: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        maxWaterConsumptionController.delete(id);
    }

    private void updateMaxWaterConsumptionById() throws SQLException {
        System.out.println("Enter MaxWaterConsumption id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        MaxWaterConsumption oldMaxWaterConsumption = maxWaterConsumptionController.getService().getById(id);
        System.out.println("Enter new time for MaxWaterConsumption: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new power MaxWaterConsumption: ");
        String power = INPUT.nextLine();
        System.out.println("Enter new litres for MaxWaterConsumption: ");
        String litres = INPUT.nextLine();

        String newTime = time;
        String newPower = power;
        String newLitres = litres;


        if (time.equals("")) newTime = oldMaxWaterConsumption.getTime();
        if (power.equals("")) newPower = oldMaxWaterConsumption.getPower();
        if (litres.equals("")) newLitres = oldMaxWaterConsumption.getLitres();

        MaxWaterConsumption entity = new MaxWaterConsumption(id, newTime, newPower, newLitres);
        maxWaterConsumptionController.update(entity);
    }

    private void getAllNoozles() throws SQLException {
        System.out.println("\nTable: Noozle");
        noozleController.getAll();
    }

    private void getNoozleById() throws SQLException {
        System.out.println("Enter ID for Noozle: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        noozleController.getById(id);
    }

    private void createNoozle() throws SQLException {
        System.out.println("Enter new Noozle cordinates of injury: ");
        String cordinates = INPUT.nextLine();
        System.out.println("Enter new Noozle diametr of injury: ");
        String diametr = INPUT.nextLine();
        System.out.println("Enter new Noozle maxWaterConsumptionId: ");
        int maxWaterConsumptionId = INPUT.nextInt();
        INPUT.nextLine();
        Noozle entity = new Noozle(0, cordinates, diametr, maxWaterConsumptionId);
        noozleController.create(entity);
    }

    private void deleteNoozleById() throws SQLException {
        System.out.println("Enter ID to delete Noozle: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        noozleController.delete(id);
    }

    private void updateNoozleById() throws SQLException {
        System.out.println("Enter Noozle id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Noozle oldNoozle = noozleController.getService().getById(id);
        System.out.println("Enter new cordinates for Noozle: ");
        String cordinates = INPUT.nextLine();
        System.out.println("Enter new diametr for Noozle: ");
        String diametr = INPUT.nextLine();
        System.out.println("Enter new maxWaterConsumptionId for Noozle: ");
        int maxWaterConsumptionId = INPUT.nextInt();
        INPUT.nextLine();

        String newCordinates = cordinates;
        String newDiametr = diametr;
        Integer newMaxWaterConsumptionId = maxWaterConsumptionId;


        if (cordinates.equals("")) newCordinates = oldNoozle.getCordinates();
        if (diametr.equals("")) newDiametr = oldNoozle.getDiametr();
        if (maxWaterConsumptionId < 0) newMaxWaterConsumptionId = oldNoozle.getMaxWaterConsumptionId();

        Noozle entity = new Noozle(id, newCordinates, newDiametr, newMaxWaterConsumptionId);
        noozleController.update(entity);
    }

    private void getAllOnOffTimes() throws SQLException {
        System.out.println("\nTable: OnOffTime");
        onOffTimeController.getAll();
    }

    private void getOnOffTimeById() throws SQLException {
        System.out.println("Enter ID for OnOffTime: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        onOffTimeController.getById(id);
    }

    private void createOnOffTime() throws SQLException {
        System.out.println("Enter new OnOffTime onTime: ");
        String onTime = INPUT.nextLine();
        System.out.println("Enter new OnOffTime offTime: ");
        String offTime = INPUT.nextLine();
        OnOffTime entity = new OnOffTime(0, onTime, offTime);
        onOffTimeController.create(entity);
    }

    private void deleteOnOffTimeById() throws SQLException {
        System.out.println("Enter ID to delete OnOffTime: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        onOffTimeController.delete(id);
    }

    private void updateOnOffTimeById() throws SQLException {
        System.out.println("Enter OnOffTime id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        OnOffTime oldOnOffTime = onOffTimeController.getService().getById(id);
        System.out.println("Enter onTime for OnOffTime: ");
        String onTime = INPUT.nextLine();
        System.out.println("Enter offTime for OnOffTime: ");
        String offTime = INPUT.nextLine();

        String newOnTime = onTime;
        String newOffTime = offTime;

        if (onTime.equals("")) newOnTime = oldOnOffTime.getOnTime();
        if (offTime.equals("")) newOffTime = oldOnOffTime.getOffTime();


        OnOffTime entity = new OnOffTime(id, newOnTime, newOffTime);
        onOffTimeController.update(entity);
    }

    private void getAllPersonInformations() throws SQLException {
        System.out.println("\nTable: PersonInformation");
        personInformationController.getAll();
    }

    private void getPersonInformationById() throws SQLException {
        System.out.println("Enter ID for PersonInformation: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        personInformationController.getById(id);
    }

    private void createPersonInformation() throws SQLException {
        System.out.println("Enter new PersonInformation name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new PersonInformation surname: ");
        String surname = INPUT.nextLine();
        System.out.println("Enter new PersonInformation lastname: ");
        String lastname = INPUT.nextLine();
        PersonInformation entity = new PersonInformation(0, name, surname, lastname);
        personInformationController.create(entity);
    }

    private void deletePersonInformationById() throws SQLException {
        System.out.println("Enter ID to delete PersonInformation: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        personInformationController.delete(id);
    }

    private void updatePersonInformationById() throws SQLException {
        System.out.println("Enter PersonInformation id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PersonInformation oldPersonInformation = personInformationController.getService().getById(id);
        System.out.println("Enter new name for PersonInformation: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new surname for PersonInformation: ");
        String surname = INPUT.nextLine();
        System.out.println("Enter new lastname PersonInformation: ");
        String lastname = INPUT.nextLine();


        String newName = name;
        String newSurname = surname;
        String newLastname = lastname;


        if (name.equals("")) newName = oldPersonInformation.getName();
        if (surname.equals("")) newSurname = oldPersonInformation.getSurname();
        if (lastname.equals("")) newLastname = oldPersonInformation.getSurname();

        PersonInformation entity = new PersonInformation(id, newName, newSurname, newLastname);
        personInformationController.update(entity);
    }

    private void getAllPumps() throws SQLException {
        System.out.println("\nTable: Pumps");
        pumpsController.getAll();
    }

    private void getPumpsById() throws SQLException {
        System.out.println("Enter ID for Pumps: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        pumpsController.getById(id);
    }

    private void createPumps() throws SQLException {
        System.out.println("Enter new Pumps area: ");
        String area = INPUT.nextLine();
        System.out.println("Enter new Pumps amount of water: ");
        String amountOfWater = INPUT.nextLine();
        System.out.println("Enter new Pumps on off time id  : ");
        int onOffTimeId = INPUT.nextInt();
        INPUT.nextLine();

        Pumps entity = new Pumps(0, area, amountOfWater, onOffTimeId);
        pumpsController.create(entity);
    }

    private void deletePumpsById() throws SQLException {
        System.out.println("Enter ID to delete Pumps: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        pumpsController.delete(id);
    }

    private void updatePumpsById() throws SQLException {
        System.out.println("Enter Pumps id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Pumps oldPumps = pumpsController.getService().getById(id);
        System.out.println("Enter new area for Pumps: ");
        String area = INPUT.nextLine();
        System.out.println("Enter new amount of water for Pumps: ");
        String amountOfWater = INPUT.nextLine();
        System.out.println("Enter new onOffTimeId Pumps : ");
        int onOffTimeId = INPUT.nextInt();


        String newArea = area;
        String newAmountOfWater = amountOfWater;
        Integer newOnOffTimeId = onOffTimeId;


        if (area.equals("")) newArea = oldPumps.getArea();
        if (amountOfWater.equals("")) newAmountOfWater = oldPumps.getAmountOfWater();
        if (onOffTimeId < 0) newOnOffTimeId = oldPumps.getOnOffTimeId();

        Pumps entity = new Pumps(id, newArea, newAmountOfWater, newOnOffTimeId);
        pumpsController.update(entity);
    }

    private void getAllSensorDatas() throws SQLException {
        System.out.println("\nTable: SensorData");
        sensorDataController.getAll();
    }

    private void getSensorDataById() throws SQLException {
        System.out.println("Enter ID for SensorData: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorDataController.getById(id);
    }

    private void createSensorData() throws SQLException {
        System.out.println("Enter new SensorData name of injury: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new SensorData lightning: ");
        String lightning = INPUT.nextLine();
        System.out.println("Enter new SensorData temperature: ");
        String temperature = INPUT.nextLine();
        System.out.println("Enter new SensorData humidity: ");
        String humidity = INPUT.nextLine();
        System.out.println("Enter new SensorData locationId: ");
        int locationId = INPUT.nextInt();
        INPUT.nextLine();
        SensorData entity = new SensorData(0, time, lightning, temperature, humidity, locationId);
        sensorDataController.create(entity);
    }

    private void deleteSensorDataById() throws SQLException {
        System.out.println("Enter ID to delete SensorData: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorDataController.delete(id);
    }

    private void updateSensorDataById() throws SQLException {
        System.out.println("Enter SensorData id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        SensorData oldSensorData = sensorDataController.getService().getById(id);
        System.out.println("Enter new SensorData time: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new SensorData lightning : ");
        String lightning = INPUT.nextLine();
        System.out.println("Enter new SensorData number temperature: ");
        String temperature = INPUT.nextLine();
        System.out.println("Enter new SensorData humidity: ");
        String humidity = INPUT.nextLine();
        System.out.println("Enter new SensorData locationId: ");
        int locationId = INPUT.nextInt();
        INPUT.nextLine();

        String newTime = time;
        String newLightning = lightning;
        String newTemperature = temperature;
        String newHumidity = humidity;
        Integer newLocationId = locationId;


        if (time.equals("")) newTime = oldSensorData.getTime();
        if (lightning.equals("")) newLightning = oldSensorData.getLightning();
        if (temperature.equals("")) newTemperature = oldSensorData.getTemperature();
        if (humidity.equals("")) newHumidity = oldSensorData.getHumidity();
        if (locationId < 0) newLocationId = oldSensorData.getLocationId();


        SensorData entity = new SensorData(id, newTime, newLightning, newTemperature, newHumidity, newLocationId);
        sensorDataController.update(entity);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = INPUT.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) {
            }
        } while (!keyMenu.equals("Q"));


    }

}
