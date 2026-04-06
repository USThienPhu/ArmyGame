import java.util.*;

public class BattleSubject {
    private List<DeathObserver> observers = new ArrayList<>();

    public void addObserver(DeathObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String name) {
        for (DeathObserver observer : observers) {
            observer.onSoldierDeath(name);
        }
    }
}