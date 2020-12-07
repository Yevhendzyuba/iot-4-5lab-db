CREATE DATABASE IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8;
USE `mydb`;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS `mydb`.`data_of_sensors`;
DROP TABLE IF EXISTS `mydb`.`sensor_data`;
DROP TABLE IF EXISTS `mydb`.`location`;
DROP TABLE IF EXISTS `mydb`.`noozle`;
DROP TABLE IF EXISTS `mydb`.`max_water_consumption`;
SET FOREIGN_KEY_CHECKS = 1;


-- -----------------------------------------------------
-- Table `mydb`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`location`
(
    `id`           INT         NOT NULL AUTO_INCREMENT,
    `section`      VARCHAR(45) NOT NULL,
    `number`       VARCHAR(45) NOT NULL,
    `subscription` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`sensor_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`sensor_data`
(
    `id`          INT         NOT NULL AUTO_INCREMENT,
    `time`        VARCHAR(10) NOT NULL,
    `lightning`   VARCHAR(10) NOT NULL,
    `temperature` VARCHAR(10) NOT NULL,
    `humidity`    VARCHAR(10) NOT NULL,
    `location_id` INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_sensor_data_location1_idx` (`location_id` ASC),
    CONSTRAINT `fk_sensor_data_location1`
        FOREIGN KEY (`location_id`)
            REFERENCES `mydb`.`location` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`max_water_consumption`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`max_water_consumption`
(
    `id`     INT         NOT NULL AUTO_INCREMENT,
    `time`   VARCHAR(15) NOT NULL,
    `power`  VARCHAR(10) NOT NULL,
    `litres` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`noozle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`noozle`
(
    `id`                       INT          NOT NULL AUTO_INCREMENT,
    `cordinates`               VARCHAR(100) NOT NULL,
    `diametr`                  VARCHAR(10)  NOT NULL,
    `max_water_consumption_id` INT          NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_noozle_max_water_consumption1_idx` (`max_water_consumption_id` ASC),
    CONSTRAINT `fk_noozle_max_water_consumption1`
        FOREIGN KEY (`max_water_consumption_id`)
            REFERENCES `mydb`.`max_water_consumption` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`data_of_sensors`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`data_of_sensors`
(
    `id`             INT         NOT NULL AUTO_INCREMENT,
    `time`           VARCHAR(15) NOT NULL,
    `sensor_data_id` INT         NOT NULL,
    `noozle_id`      INT         NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_data_of_sensors_sensor_data_idx` (`sensor_data_id` ASC),
    INDEX `fk_data_of_sensors_noozle1_idx` (`noozle_id` ASC),
    CONSTRAINT `fk_data_of_sensors_sensor_data`
        FOREIGN KEY (`sensor_data_id`)
            REFERENCES `mydb`.`sensor_data` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_data_of_sensors_noozle1`
        FOREIGN KEY (`noozle_id`)
            REFERENCES `mydb`.`noozle` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;

INSERT INTO `mydb`.`location` (`section`, `number`, `subscription`)
VALUES ('1a', '34', 'near tree'),
       ('2a', '23', 'near tree'),
       ('3a', '12', 'near tree'),
       ('4a', '13', 'near tree'),
       ('5a', '89', 'near tree'),
       ('6a', '90', 'near tree'),
       ('7a', '56', 'near tree'),
       ('8a', '11', 'near tree'),
       ('9a', '15', 'near tree'),
       ('10a', '90', 'near tree');

INSERT INTO `mydb`.`sensor_data` (`time`, `lightning`, `temperature`, `humidity`, `location_id`)
VALUES ('16:12', '30%', '19/C', '30%', '1'),
       ('17:21', '20%', '19/C', '32%', '2'),
       ('18:12', '40%', '19/C', '35%', '3'),
       ('19:16', '50%', '21/C', '38%', '4'),
       ('20:19', '60%', '21/C', '39%', '5'),
       ('21:21', '40%', '21/C', '60%', '6'),
       ('22:25', '50%', '22/C', '60%', '7'),
       ('23:26', '40%', '23/C', '60%', '8'),
       ('23:27', '30%', '17/C', '70%', '9'),
       ('23:59', '40%', '15/C', '40%', '10');

INSERT INTO `mydb`.`max_water_consumption` (`time`, `power`, `litres`)
VALUES ('09:11', '360V', '1560l'),
       ('09:23', '360V', '1760l'),
       ('09:45', '360V', '1360l'),
       ('09:59', '360V', '1350l'),
       ('10:11', '360V', '1234l'),
       ('11:41', '360V', '1467l'),
       ('12:56', '360V', '1683l'),
       ('14:23', '360V', '1678l'),
       ('15:56', '360V', '1168l'),
       ('16:34', '360V', '1643l');

INSERT INTO `mydb`.`noozle` (`cordinates`, `diametr`, `max_water_consumption_id`)
VALUES ('123.145.634', '5cm', 1),
       ('345.234.567', '5cm', 2),
       ('234.657.125', '5cm', 3),
       ('579.112.623', '5cm', 4),
       ('678.141.579', '5cm', 5),
       ('145.179.630', '5cm', 6),
       ('170.145.634', '5cm', 7),
       ('142.452.980', '5cm', 8),
       ('138.199.228', '5cm', 9),
       ('163.190.143', '5cm', 10);


INSERT INTO `mydb`.`data_of_sensors` (`time`, `sensor_data_id`, `noozle_id`)
VALUES ('14:23', '1', '1'),
       ('15:23', '2', '2'),
       ('16:23', '3', '3'),
       ('17:23', '4', '4'),
       ('18:23', '5', '5'),
       ('19:23', '6', '6'),
       ('20:23', '7', '7'),
       ('21:23', '8', '8'),
       ('22:23', '9', '9'),
       ('23:23', '10', '10');






