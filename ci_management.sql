-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema ci_interface
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ci_interface
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ci_interface` DEFAULT CHARACTER SET utf8 ;
USE `ci_interface` ;

-- -----------------------------------------------------
-- Table `ci_interface`.`ci_tool`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ci_interface`.`ci_tool` (
  `id` INT(11) NOT NULL,
  `url` VARCHAR(45) NULL DEFAULT NULL,
  `type` ENUM('Jenkins', 'TeamCity') NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ci_interface`.`jobs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ci_interface`.`jobs` (
  `date` DATETIME NULL DEFAULT NULL,
  `suite_name` VARCHAR(45) NULL DEFAULT NULL,
  `tc_name` VARCHAR(45) NULL DEFAULT NULL,
  `user` VARCHAR(45) NULL DEFAULT NULL,
  `build_number` VARCHAR(45) NULL DEFAULT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `message` VARCHAR(255) NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ci_interface`.`test_suites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ci_interface`.`test_suites` (
  `suite_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `status` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`suite_name`),
  UNIQUE INDEX `suite_name_UNIQUE` (`suite_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ci_interface`.`test_cases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ci_interface`.`test_cases` (
  `test_case_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `test_suites_suite_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`test_case_name`, `test_suites_suite_name`),
  INDEX `fk_test_cases_test_suites1_idx` (`test_suites_suite_name` ASC),
  CONSTRAINT `fk_test_cases_test_suites1`
    FOREIGN KEY (`test_suites_suite_name`)
    REFERENCES `ci_interface`.`test_suites` (`suite_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ci_interface`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ci_interface`.`users` (
  `fname` VARCHAR(45) NULL DEFAULT NULL,
  `lname` VARCHAR(45) NULL DEFAULT NULL,
  `user` VARCHAR(45) NOT NULL,
  `password` VARCHAR(15) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user`, `email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `ci_interface`.`test_suites_has_test_cases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ci_interface`.`test_suites_has_test_cases` (
  `test_suites_suite_name` VARCHAR(45) NOT NULL,
  `test_cases_suite_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`test_suites_suite_name`, `test_cases_suite_name`),
  INDEX `fk_test_suites_has_test_cases_test_cases1_idx` (`test_cases_suite_name` ASC),
  INDEX `fk_test_suites_has_test_cases_test_suites_idx` (`test_suites_suite_name` ASC),
  CONSTRAINT `fk_test_suites_has_test_cases_test_suites`
    FOREIGN KEY (`test_suites_suite_name`)
    REFERENCES `ci_interface`.`test_suites` (`suite_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_test_suites_has_test_cases_test_cases1`
    FOREIGN KEY (`test_cases_suite_name`)
    REFERENCES `ci_interface`.`test_cases` (`test_case_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
