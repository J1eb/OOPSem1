// src/payment/PaymentInstance.java
package payment;

import java.time.LocalDateTime;

public class PaymentInstance {
    private final LocalDateTime paymentTime;
    private final int paymentAmount;

    public PaymentInstance(LocalDateTime paymentTime, int paymentAmount) {
        if (paymentTime == null) {
            throw new IllegalArgumentException("Payment time cannot be null");
        }
        if (paymentAmount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive");
        }
        this.paymentTime = paymentTime;
        this.paymentAmount = paymentAmount;
    }

    public LocalDateTime getPaymentTime() { return paymentTime; }
    public int getPaymentAmount() { return paymentAmount; }
}