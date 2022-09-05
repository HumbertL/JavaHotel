-- MySQL Script generated by MySQL Workbench
-- Sun Sep  4 20:30:26 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hoteldb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hoteldb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hoteldb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hoteldb` ;

-- -----------------------------------------------------
-- Table `hoteldb`.`empleados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`empleados` (
  `empleadoID` INT NOT NULL AUTO_INCREMENT,
  `Nombre_empleado` VARCHAR(45) NOT NULL,
  `Area_de_trabajo` VARCHAR(45) NOT NULL,
  `salario` DOUBLE NOT NULL,
  `Estatus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`empleadoID`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hoteldb`.`hosts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`hosts` (
  `HostName` VARCHAR(55) NOT NULL,
  `MemberType` VARCHAR(45) NOT NULL,
  `Room` INT UNSIGNED NOT NULL,
  `Entrada` DATE NOT NULL,
  `Salida` DATE NOT NULL,
  `ID_Compra` INT NOT NULL,
  `ID_INSTANCIA` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID_INSTANCIA`))
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hoteldb`.`reservations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`reservations` (
  `ReservationID` INT UNSIGNED NOT NULL,
  `ReservationName` VARCHAR(255) NOT NULL,
  `Invitados` INT UNSIGNED NOT NULL,
  `RoomNumber` INT UNSIGNED NOT NULL,
  `EntryDate` DATE NOT NULL,
  `ExitDate` DATE NOT NULL,
  `ActiveStatus` TINYINT(1) NOT NULL,
  `capacityAvailable` INT UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`ReservationID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hoteldb`.`rooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hoteldb`.`rooms` (
  `idRooms` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `RoomStatus` VARCHAR(45) NULL DEFAULT NULL,
  `Tipo` VARCHAR(45) NOT NULL,
  `Capacidad` INT UNSIGNED NOT NULL,
  `Status_USO` VARCHAR(45) NOT NULL DEFAULT 'VACIO',
  `Huesped` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idRooms`))
ENGINE = InnoDB
AUTO_INCREMENT = 28
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;