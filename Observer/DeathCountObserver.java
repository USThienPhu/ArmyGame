// DeathCountObserver.java
public class DeathCountObserver implements DeathObserver {
    private static final DeathCountObserver instance = new DeathCountObserver();
    private int totalDeaths = 0;
    private DeathCountObserver() {}
    public static DeathCountObserver getInstance() {
        return instance;
    }
    @Override
    public void onSoldierDeath(String name) {
        totalDeaths++;
        System.out.println("[DeathCount] Total fallen soldiers in this battle: " + totalDeaths);
    }
}

