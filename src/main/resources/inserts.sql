INSERT INTO accounts (id, account_type) VALUES
                                           ('acc1', 'STANDARD'),
                                           ('acc2', 'PREMIUM'),
                                           ('acc3', 'GOLD');

INSERT INTO transactions (id, account_id, created_at, transaction_type, amount, reason) VALUES
                                                                                           ('txn1', 'acc1', now(), 'IN',  1000.00, 'Initial deposit'),
                                                                                           ('txn2', 'acc1', now(), 'OUT', 150.50,  'Grocery shopping'),
                                                                                           ('txn3', 'acc2', now(), 'IN',  5000.00, 'Salary'),
                                                                                           ('txn4', 'acc2', now(), 'OUT', 200.00,  'Utility bill'),
                                                                                           ('txn5', 'acc3', now(), 'IN',  10000.00, 'Investment payout'),
                                                                                           ('txn6', 'acc3', now(), 'OUT', 750.25,  'Rent');