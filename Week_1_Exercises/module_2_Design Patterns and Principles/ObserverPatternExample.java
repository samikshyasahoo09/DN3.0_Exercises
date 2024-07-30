import java.util.ArrayList;
import java.util.List;

// Define Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

//Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

//  Define Observer Interface
interface Observer {
    void update(String stockName, double price);
}

//  Implement Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp: Stock " + stockName + " price updated to $" + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp: Stock " + stockName + " price updated to $" + price);
    }
}

//  Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket("AAPL", 150.00);

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        // Simulate a price change
        stockMarket.setPrice(155.00);

        // Deregister one observer and simulate another price change
        stockMarket.deregisterObserver(mobileApp);
        stockMarket.setPrice(160.00);
    }
}

