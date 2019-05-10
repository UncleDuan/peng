package pattern.observer;

public class ObserverTest {
    public static void main(String[] args) {
        WeatherData wd=new WeatherData(21,10,10000);
        CurrentConditionDisplay cd=new CurrentConditionDisplay();
        ForcastDisplay fd=new ForcastDisplay();
        wd.addObserver(cd);
        wd.addObserver(fd);
        wd.notifyObservers();
        cd.display();
        fd.display();
    }
}
