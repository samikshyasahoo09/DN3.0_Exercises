//  Define Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

//  Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with Credit Card. Card Number: " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with PayPal. Email: " + email);
    }
}

//  Implement Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}

//  Test the Strategy Implementation
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("1234-9876-9078-7896");
        PaymentStrategy payPal = new PayPalPayment("arpita@behera.com");

        PaymentContext paymentContext = new PaymentContext(creditCard);
        paymentContext.executePayment(150.00);

        paymentContext = new PaymentContext(payPal);
        paymentContext.executePayment(200.00);
    }
}

