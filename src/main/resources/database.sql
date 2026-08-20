CREATE TYPE account_type AS ENUM ('STANDARD', 'PREMIUM', 'GOLD');
CREATE TYPE transaction_type AS ENUM ('IN', 'OUT');

CREATE TABLE accounts (
                          id VARCHAR(100) PRIMARY KEY,
                          account_type account_type
);

CREATE TABLE transactions (
                              id VARCHAR(100) PRIMARY KEY,
                              account_id VARCHAR(100),
                              created_at TIMESTAMPTZ,
                              transaction_type transaction_type,
                              amount NUMERIC(19,2),
                              reason VARCHAR(255),
                              CONSTRAINT fk_transaction_account
                                  FOREIGN KEY (account_id)
                                      REFERENCES account(id)
                                      ON DELETE RESTRICT
);