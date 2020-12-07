package db.lab4.view;

import db.lab4.controller.implementation.*;

import java.sql.SQLException;

import org.hibernate.Session;
import db.lab4.model.implementation.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {

    public static final Scanner INPUT = new Scanner(System.in, "UTF-8");

    private final DataOfSensorsController dataOfSensorsController = new DataOfSensorsController();
    private final LocationController locationController = new LocationController();
    private final MaxWaterConsumptionController maxWaterConsumptionController = new MaxWaterConsumptionController();
    private final NoozleController noozleController = new NoozleController();
    private final SensorDataController sensorDataController = new SensorDataController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;


    public MainView(Session session) {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();


        menu.put("11", "11 - Get all dataOfSensors");
        menu.put("12", "12 - Get dataOfSensor by ID");
        menu.put("13", "13 - Create dataOfSensor");
        menu.put("14", "14 - Delete dataOfSensor by ID");
        menu.put("15", "15 - Update dataOfSensor by ID");

        menu.put("21", "21 - Get all locations");
        menu.put("22", "22 - Get location by ID");
        menu.put("23", "23 - Create location");
        menu.put("24", "24 - Delete location by ID");
        menu.put("25", "25 - Update location by ID");

        menu.put("31", "31 - Get all maxWaterConsumptions");
        menu.put("32", "32 - Get maxWaterConsumption by ID");
        menu.put("33", "33 - Create maxWaterConsumption");
        menu.put("34", "34 - Delete maxWaterConsumption by ID");
        menu.put("35", "35 - Update maxWaterConsumption by ID");

        menu.put("41", "41 - Get all noozles");
        menu.put("42", "42 - Get noozle by ID");
        menu.put("43", "43 - Create noozle");
        menu.put("44", "44 - Delete noozle by ID");
        menu.put("45", "45 - Update noozle by ID");

        menu.put("51", "51 - Get all sensorDatas");
        menu.put("52", "52 - Get sensorData by ID");
        menu.put("53", "53 - Create sensorData");
        menu.put("54", "54 - Delete sensorData by ID");
        menu.put("55", "55 - Update sensorData by ID");

        methodsMenu.put("11", () -> getAllDataOfSensors(session));
        methodsMenu.put("12", () -> getDataOfSensorById(session));
        methodsMenu.put("13", () -> createDataOfSensor(session));
        methodsMenu.put("14", () -> deleteDataOfSensorById(session));
        methodsMenu.put("15", () -> updateDataOfSensorById(session));

        methodsMenu.put("21", () -> getAllLocations(session));
        methodsMenu.put("22", () -> getLocationById(session));
        methodsMenu.put("23", () -> createLocation(session));
        methodsMenu.put("24", () -> deleteLocationById(session));
        methodsMenu.put("25", () -> updateLocationById(session));

        methodsMenu.put("31", () -> getAllMaxWaterConsumptions(session));
        methodsMenu.put("32", () -> getMaxWaterConsumptionId(session));
        methodsMenu.put("33", () -> createMaxWaterConsumption(session));
        methodsMenu.put("34", () -> deleteMaxWaterConsumptionId(session));
        methodsMenu.put("35", () -> updateMaxWaterConsumptionById(session));

        methodsMenu.put("41", () -> getAllNoozles(session));
        methodsMenu.put("42", () -> getNoozleById(session));
        methodsMenu.put("43", () -> createNoozle(session));
        methodsMenu.put("44", () -> deleteNoozleById(session));
        methodsMenu.put("45", () -> updateNoozleById(session));

        methodsMenu.put("51", () -> getAllSensorDatas(session));
        methodsMenu.put("52", () -> getSensorDataById(session));
        methodsMenu.put("53", () -> createSensorData(session));
        methodsMenu.put("54", () -> deleteSensorDataById(session));
        methodsMenu.put("55", () -> updateSensorDataById(session));

    }

    private void getAllDataOfSensors(Session session) throws SQLException {
        System.out.println("\nTable: DataOfSensors");
        dataOfSensorsController.getAll(session);
    }

    private void getDataOfSensorById(Session session) throws SQLException {
        System.out.println("Enter ID for DataOfSensors: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        dataOfSensorsController.getById(id, session);
    }

    private void createDataOfSensor(Session session) throws SQLException {
        System.out.println("Enter new DataOfSensors time: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new DataOfSensors sensorDataId: ");
        int sensorDataId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new DataOfSensors noozleId: ");
        int noozleId = INPUT.nextInt();
        INPUT.nextLine();

        SensorData sensorData = sensorDataController.getService().getById(sensorDataId, session);
        Noozle noozle = noozleController.getService().getById(noozleId, session);


        DataOfSensors entity = new DataOfSensors(0, time, sensorData, noozle);
        dataOfSensorsController.create(entity, session);
    }

    private void deleteDataOfSensorById(Session session) throws SQLException {
        System.out.println("Enter ID to delete DataOfSensors: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        dataOfSensorsController.delete(id, session);
    }

    private void updateDataOfSensorById(Session session) throws SQLException {
        System.out.println("Enter DataOfSensors id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        DataOfSensors oldDataOfSensors = dataOfSensorsController.getService().getById(id, session);
        System.out.println("Enter new time for DataOfSensors: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new sensorDataId for DataOfSensors: ");
        int sensorDataId = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter new noozleId for DataOfSensors: ");
        int noozleId = INPUT.nextInt();
        INPUT.nextLine();

        String newTime = time;
        SensorData newSensorDataId = sensorDataController.getService().getById(sensorDataId, session);
        Noozle newNoozleId = noozleController.getService().getById(noozleId, session);


        if (time.equals("")) newTime = oldDataOfSensors.getTime();

        DataOfSensors entity = new DataOfSensors(id, newTime, newSensorDataId, newNoozleId);
        dataOfSensorsController.update(entity, session);
    }


    private void getAllLocations(Session session) throws SQLException {
        System.out.println("\nTable: InjuryOnCall");
        locationController.getAll(session);
    }

    private void getLocationById(Session session) throws SQLException {
        System.out.println("Enter ID for InjuryOnCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        locationController.getById(id, session);
    }

    private void createLocation(Session session) throws SQLException {
        System.out.println("Enter new InjuryOnCall name of injury: ");
        String section = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall description of injury: ");
        String number = INPUT.nextLine();
        System.out.println("Enter new InjuryOnCall number of hospital: ");
        String subscription = INPUT.nextLine();
        Location entity = new Location(0, section, number, subscription);
        locationController.create(entity, session);
    }

    private void deleteLocationById(Session session) throws SQLException {
        System.out.println("Enter ID to delete InjuryOnCall: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        locationController.delete(id, session);
    }

    private void updateLocationById(Session session) throws SQLException {
        System.out.println("Enter InjuryOnCall id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Location oldLocation = locationController.getService().getById(id, session);
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
        locationController.update(entity, session);
    }

    private void getAllMaxWaterConsumptions(Session session) throws SQLException {
        System.out.println("\nTable: MaxWaterConsumption");
        maxWaterConsumptionController.getAll(session);
    }

    private void getMaxWaterConsumptionId(Session session) throws SQLException {
        System.out.println("Enter ID for MaxWaterConsumption: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        maxWaterConsumptionController.getById(id, session);
    }

    private void createMaxWaterConsumption(Session session) throws SQLException {
        System.out.println("Enter new MaxWaterConsumption time: ");
        String time = INPUT.nextLine();
        System.out.println("Enter new MaxWaterConsumption power: ");
        String power = INPUT.nextLine();
        System.out.println("Enter new MaxWaterConsumption litres: ");
        String litres = INPUT.nextLine();
        MaxWaterConsumption entity = new MaxWaterConsumption(0, time, power, litres);
        maxWaterConsumptionController.create(entity, session);
    }

    private void deleteMaxWaterConsumptionId(Session session) throws SQLException {
        System.out.println("Enter ID to delete MaxWaterConsumption: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        maxWaterConsumptionController.delete(id, session);
    }

    private void updateMaxWaterConsumptionById(Session session) throws SQLException {
        System.out.println("Enter MaxWaterConsumption id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        MaxWaterConsumption oldMaxWaterConsumption = maxWaterConsumptionController.getService().getById(id, session);
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
        maxWaterConsumptionController.update(entity, session);
    }

    private void getAllNoozles(Session session) throws SQLException {
        System.out.println("\nTable: Noozle");
        noozleController.getAll(session);
    }

    private void getNoozleById(Session session) throws SQLException {
        System.out.println("Enter ID for Noozle: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        noozleController.getById(id, session);
    }

    private void createNoozle(Session session) throws SQLException {
        System.out.println("Enter new Noozle cordinates of injury: ");
        String cordinates = INPUT.nextLine();
        System.out.println("Enter new Noozle diametr of injury: ");
        String diametr = INPUT.nextLine();
        System.out.println("Enter new Noozle maxWaterConsumptionId: ");
        int maxWaterConsumptionId = INPUT.nextInt();
        INPUT.nextLine();

        MaxWaterConsumption maxWaterConsumption = maxWaterConsumptionController.getService().getById(maxWaterConsumptionId, session);

        Noozle entity = new Noozle(0, cordinates, diametr, maxWaterConsumption);
        noozleController.create(entity, session);
    }

    private void deleteNoozleById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Noozle: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        noozleController.delete(id, session);
    }

    private void updateNoozleById(Session session) throws SQLException {
        System.out.println("Enter Noozle id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();

        Noozle oldNoozle = noozleController.getService().getById(id, session);

        System.out.println("Enter new cordinates for Noozle: ");
        String cordinates = INPUT.nextLine();
        System.out.println("Enter new diametr for Noozle: ");
        String diametr = INPUT.nextLine();
        System.out.println("Enter new maxWaterConsumptionId for Noozle: ");
        int maxWaterConsumptionId = INPUT.nextInt();
        INPUT.nextLine();

        String newCordinates = cordinates;
        String newDiametr = diametr;
        MaxWaterConsumption newMaxWaterConsumption = maxWaterConsumptionController.getService().getById(maxWaterConsumptionId, session);

        if (cordinates.equals("")) newCordinates = oldNoozle.getCordinates();
        if (diametr.equals("")) newDiametr = oldNoozle.getDiametr();


        Noozle entity = new Noozle(id, newCordinates, newDiametr, newMaxWaterConsumption);
        noozleController.update(entity, session);
    }


    private void getAllSensorDatas(Session session) throws SQLException {
        System.out.println("\nTable: SensorData");
        sensorDataController.getAll(session);
    }

    private void getSensorDataById(Session session) throws SQLException {
        System.out.println("Enter ID for SensorData: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorDataController.getById(id, session);
    }

    private void createSensorData(Session session) throws SQLException {
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

        Location location = locationController.getService().getById(locationId, session);

        SensorData entity = new SensorData(0, time, lightning, temperature, humidity, location);
        sensorDataController.create(entity, session);
    }

    private void deleteSensorDataById(Session session) throws SQLException {
        System.out.println("Enter ID to delete SensorData: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        sensorDataController.delete(id, session);
    }

    private void updateSensorDataById(Session session) throws SQLException {
        System.out.println("Enter SensorData id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        SensorData oldSensorData = sensorDataController.getService().getById(id, session);
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
        Location newLocation = locationController.getService().getById(locationId, session);


        if (time.equals("")) newTime = oldSensorData.getTime();
        if (lightning.equals("")) newLightning = oldSensorData.getLightning();
        if (temperature.equals("")) newTemperature = oldSensorData.getTemperature();
        if (humidity.equals("")) newHumidity = oldSensorData.getHumidity();


        SensorData entity = new SensorData(id, newTime, newLightning, newTemperature, newHumidity, newLocation);
        sensorDataController.update(entity, session);
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
