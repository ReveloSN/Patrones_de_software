import java.util.ArrayList;
import java.util.List;

/* ============================
PROTOTYPE INTERFACE
============================ */
interface Prototype<T> {
    T clonePrototype();
}

/* ============================
SmartAnimalProfile (Prototype)
============================ */
class SmartAnimalProfile implements Prototype<SmartAnimalProfile> {

    private String animalId;
    private String type;
    private boolean temperatureSensor;
    private boolean ruminationSensor;
    private boolean gps;
    private String alertLevel;

    public SmartAnimalProfile(String animalId, String type,
                            boolean temperatureSensor,
                            boolean ruminationSensor,
                            boolean gps,
                            String alertLevel) {
        this.animalId = animalId;
        this.type = type;
        this.temperatureSensor = temperatureSensor;
        this.ruminationSensor = ruminationSensor;
        this.gps = gps;
        this.alertLevel = alertLevel;
    }

    // Copy constructor
    public SmartAnimalProfile(SmartAnimalProfile other) {
        this.animalId = other.animalId;
        this.type = other.type;
        this.temperatureSensor = other.temperatureSensor;
        this.ruminationSensor = other.ruminationSensor;
        this.gps = other.gps;
        this.alertLevel = other.alertLevel;
    }

    @Override
    public SmartAnimalProfile clonePrototype() {
        return new SmartAnimalProfile(this);
    }

    public void setAnimalId(String animalId) {
        this.animalId = animalId;
    }

    @Override
    public String toString() {
        return "Animal ID: " + animalId +
                ", Type: " + type +
                ", TempSensor: " + temperatureSensor +
                ", RuminationSensor: " + ruminationSensor +
                ", GPS: " + gps +
                ", AlertLevel: " + alertLevel;
    }
}

/* ============================
PRODUCT: SmartLivestockKit
============================ */
class SmartLivestockKit {

    private String farmName;
    private List<String> technologies;
    private boolean predictiveAnalytics;

    public SmartLivestockKit() {
        technologies = new ArrayList<>();
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public void addTechnology(String tech) {
        technologies.add(tech);
    }

    public void setPredictiveAnalytics(boolean predictiveAnalytics) {
        this.predictiveAnalytics = predictiveAnalytics;
    }

    @Override
    public String toString() {
        return "\nFarm: " + farmName +
                "\nTechnologies: " + technologies +
                "\nPredictive Analytics: " + predictiveAnalytics;
    }
}

/* ============================
BUILDER INTERFACE
============================ */
interface LivestockKitBuilder {

    LivestockKitBuilder setFarmName(String name);
    LivestockKitBuilder addTemperatureSystem();
    LivestockKitBuilder addGPSSystem();
    LivestockKitBuilder addRuminationSystem();
    LivestockKitBuilder enablePredictiveAnalytics();
    SmartLivestockKit build();
}

/* ============================
CONCRETE BUILDER
============================ */
class ConcreteLivestockKitBuilder implements LivestockKitBuilder {

    private SmartLivestockKit kit;

    public ConcreteLivestockKitBuilder() {
        kit = new SmartLivestockKit();
    }

    @Override
    public LivestockKitBuilder setFarmName(String name) {
        kit.setFarmName(name);
        return this;
    }

    @Override
    public LivestockKitBuilder addTemperatureSystem() {
        kit.addTechnology("Temperature Monitoring");
        return this;
    }

    @Override
    public LivestockKitBuilder addGPSSystem() {
        kit.addTechnology("GPS Tracking");
        return this;
    }

    @Override
    public LivestockKitBuilder addRuminationSystem() {
        kit.addTechnology("Rumination Monitoring");
        return this;
    }

    @Override
    public LivestockKitBuilder enablePredictiveAnalytics() {
        kit.setPredictiveAnalytics(true);
        return this;
    }

    @Override
    public SmartLivestockKit build() {
        SmartLivestockKit builtKit = kit;
        kit = new SmartLivestockKit(); // reset
        return builtKit;
    }
}

/* ============================
MAIN
============================ */
public class Ganaderia40System {

    public static void main(String[] args) {

        // ===== PROTOTYPE USAGE =====
        SmartAnimalProfile baseCowProfile =
                new SmartAnimalProfile(
                        "BASE-001",
                        "Dairy Cow",
                        true,
                        true,
                        true,
                        "Medium");

        SmartAnimalProfile clonedCow1 = baseCowProfile.clonePrototype();
        clonedCow1.setAnimalId("COW-101");

        SmartAnimalProfile clonedCow2 = baseCowProfile.clonePrototype();
        clonedCow2.setAnimalId("COW-102");

        System.out.println("=== Cloned Animal Profiles ===");
        System.out.println(clonedCow1);
        System.out.println(clonedCow2);

        // ===== BUILDER USAGE =====
        ConcreteLivestockKitBuilder builder = new ConcreteLivestockKitBuilder();

        SmartLivestockKit advancedFarmKit = builder
                .setFarmName("El Futuro Farm")
                .addTemperatureSystem()
                .addGPSSystem()
                .addRuminationSystem()
                .enablePredictiveAnalytics()
                .build();

        System.out.println("\n ___Built Livestock Kit___");
        System.out.println(advancedFarmKit);
    }
}