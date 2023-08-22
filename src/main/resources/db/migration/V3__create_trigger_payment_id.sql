CREATE OR REPLACE TRIGGER trg_payments_id
    BEFORE INSERT ON payments
    FOR EACH ROW
BEGIN
    :new.payment_id := seq_isnack_payment.NEXTVAL;
END;