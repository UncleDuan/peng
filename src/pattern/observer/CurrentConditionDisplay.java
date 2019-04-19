package pattern.observer;

public class CurrentConditionDisplay implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public boolean update(Observable obs) {
        if (obs instanceof WeatherData){
            WeatherData wd=(WeatherData)obs;
            temperature=wd.getTemperature();
            humidity=wd.getHumidity();
            pressure=wd.getPressure();
            return true;
        }
        return false;
    }

    @Override
    public void display(){
        System.out.println(this.getClass().getName()+"temperature:"+temperature+"  humidity:"+humidity+"  pressure"+pressure);
    }
}
