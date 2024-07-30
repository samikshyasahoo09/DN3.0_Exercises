//  Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Implement Adaptee Classes
class StripePaymentGateway {
    void makePayment(double amount) {
        System.out.println("Processing payment through Stripe: $" + amount);
    }
}

class PayPalPaymentGateway {
    void pay(double amount) {
        System.out.println("Processing payment through PayPal: $" + amount);
    }
}

//  Implement the Adapter Class
class StripeAdapter implements PaymentProcessor {
    private StripePaymentGateway stripe;

    public StripeAdapter(StripePaymentGateway stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private PayPalPaymentGateway paypal;

    public PayPalAdapter(PayPalPaymentGateway paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.pay(amount);
    }
}

// Test the Adapter Implementation
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripePaymentGateway());
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalPaymentGateway());

        stripeProcessor.processPayment(100.0);
        paypalProcessor.processPayment(200.0);
    }
}

