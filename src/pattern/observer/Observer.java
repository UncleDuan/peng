package pattern.observer;

public interface Observer {
    public boolean update(Observable obs);
    public void display();
}
