cart-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`menu_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`menu_item` (
  `me_id` INT NOT NULL AUTO_INCREMENT,
  `me_name` VARCHAR(100) NULL,
  `me_price` DECIMAL(8,2) NULL,
  `me_active` VARCHAR(3) NULL,
  `me_date_of_launch` DATE NULL,
  `me_category` VARCHAR(45) NULL,
  `me_free_delivery` VARCHAR(3) CHARACTER SET 'armscii8' NULL,
  PRIMARY KEY (`me_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cart` (
  `ct_id` INT NOT NULL AUTO_INCREMENT,
  `ct_us_id` INT NULL,
  `ct_pr_id` INT NULL,
  PRIMARY KEY (`ct_id`),
  INDEX `ct_us_id_idx` (`ct_us_id` ASC),
  INDEX `ct_pr_id_idx` (`ct_pr_id` ASC),
  CONSTRAINT `ct_us_id`
    FOREIGN KEY (`ct_us_id`)
    REFERENCES `mydb`.`user` (`us_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ct_pr_id`
    FOREIGN KEY (`ct_pr_id`)
    REFERENCES `mydb`.`menu_item` (`me_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
