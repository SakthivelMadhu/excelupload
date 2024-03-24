CREATE TABLE IF NOT EXISTS market_data (
    id INT AUTO_INCREMENT PRIMARY KEY,
    market VARCHAR(255),
    country VARCHAR(255),
    product VARCHAR(255),
    discount_band VARCHAR(255),
    units_sold DECIMAL(10,2),
    manufacturing_cost DECIMAL(10,2)
);
