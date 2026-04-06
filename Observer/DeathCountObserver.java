// DeathCountObserver.java
public class DeathCountObserver implements DeathObserver {
    private int totalDeaths = 0;

    @Override
    public void onSoldierDeath(String name) {
        totalDeaths++;
        System.out.println("[DeathCount] Total fallen soldiers in this battle: " + totalDeaths);
    }
}

