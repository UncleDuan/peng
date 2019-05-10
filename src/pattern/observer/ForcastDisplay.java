package pattern.observer;

public class ForcastDisplay implements Observer {
    private float temperatureHistory;
    private float humidityHistory;
    private float pressureHistory;
    @Override
    public boolean update(Observable obs) {
        if (obs instanceof WeatherData){
            WeatherData wd=(WeatherData) obs;
            temperatureHistory=temperatureHistory/2+wd.getTemperature()/2;
            humidityHistory=humidityHistory/2+wd.getHumidity()/2;
            pressureHistory=pressureHistory/2+wd.getPressure()/2;
            return true;
        }
        return false;
    }

    @Override
    public void display() {
        System.out.println(this.getClass().getName()+":temperature:"+temperatureHistory+"  humidity:"+humidityHistory+"  pressure"+pressureHistory);
    }
}
