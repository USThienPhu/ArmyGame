// DeathNotifierObserver.java
public class DeathNotifierObserver implements DeathObserver {
    private static final DeathNotifierObserver instance = new DeathNotifierObserver();

    private DeathNotifierObserver() {}

    public static DeathNotifierObserver getInstance() {
        return instance;
    }

    @Override
    public void onSoldierDeath(String name) {
        System.out.println("[DeathNotifier] ALERT: Unit '" + name + "' has died.");
        sendMail(name);
    }

    private void sendMail(String name) {
        System.out.println(">> SENDING EMAIL: 'Dear friends of " + name + ", we deeply regret to inform you of their heroic passing.'");
    }
}