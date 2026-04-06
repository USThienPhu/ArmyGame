public class DeathNotifierObserver implements DeathObserver {
    @Override
    public void onSoldierDeath(String name) {
        System.out.println("[DeathNotifier] ALERT: Unit '" + name + "' has died.");
        sendMail(name);
    }

    private void sendMail(String name) {
        // As requested: Just a print statement to terminal
        System.out.println(">> SENDING EMAIL: 'Dear friends of " + name + ", we deeply regret to inform you of their heroic passing.'");
    }
}