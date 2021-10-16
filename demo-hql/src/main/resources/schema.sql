CREATE TABLE `food_sales`
(
    `id`          int(11)      NOT NULL AUTO_INCREMENT,
    `region`      varchar(128) NOT NULL,
    `order_date`  timestamp    NOT NULL,
    `city`        varchar(128) NOT NULL,
    `category`    varchar(128) NOT NULL,
    `product`     varchar(128) NOT NULL,
    `quantity`    int(11)      NOT NULL,
    `unit_price`  double(11)   NOT NULL,
    `total_price` double(11)   NOT NULL,
    PRIMARY KEY (`id`)
);