CREATE TABLE payments (
                          payment_id INTEGER PRIMARY KEY NOT NULL,
                          payment_value NUMBER(19,2) NOT NULL,
                          payment_name NVARCHAR2(100) DEFAULT NULL,
                          payment_number NVARCHAR2(19) DEFAULT NULL,
                          expiration NVARCHAR2(7) DEFAULT NULL,
                          code CHAR(3) DEFAULT NULL,
                          status NVARCHAR2(255) NOT NULL,
                          payment_method_id INTEGER NOT NULL,
                          order_id INTEGER NOT NULL );