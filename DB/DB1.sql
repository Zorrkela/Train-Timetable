-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.25-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for train_timetable_app
CREATE DATABASE IF NOT EXISTS `train_timetable_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `train_timetable_app`;

-- Dumping structure for table train_timetable_app.composition
CREATE TABLE IF NOT EXISTS `composition` (
  `composition_id` int(11) NOT NULL AUTO_INCREMENT,
  `locomotive_id` int(11) NOT NULL,
  `wagon_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`composition_id`),
  KEY `FK__locomotive` (`locomotive_id`),
  KEY `FK__wagon` (`wagon_id`),
  CONSTRAINT `FK__locomotive` FOREIGN KEY (`locomotive_id`) REFERENCES `locomotive` (`locomotive_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__wagon` FOREIGN KEY (`wagon_id`) REFERENCES `wagon` (`wagon_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table train_timetable_app.composition: ~2 rows (approximately)
INSERT INTO `composition` (`composition_id`, `locomotive_id`, `wagon_id`) VALUES
	(1, 1, 1),
	(2, 3, 2);

-- Dumping structure for table train_timetable_app.last_station
CREATE TABLE IF NOT EXISTS `last_station` (
  `last_station_id` int(11) NOT NULL AUTO_INCREMENT,
  `station_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`last_station_id`),
  KEY `FK__stations_ls` (`station_id`),
  CONSTRAINT `FK__stations_ls` FOREIGN KEY (`station_id`) REFERENCES `stations` (`station_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table train_timetable_app.last_station: ~4 rows (approximately)
INSERT INTO `last_station` (`last_station_id`, `station_id`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4);

-- Dumping structure for table train_timetable_app.locomotive
CREATE TABLE IF NOT EXISTS `locomotive` (
  `locomotive_id` int(11) NOT NULL AUTO_INCREMENT,
  `series` int(11) NOT NULL DEFAULT 0,
  `number` int(11) NOT NULL DEFAULT 0,
  `power` int(11) NOT NULL DEFAULT 0,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`locomotive_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table train_timetable_app.locomotive: ~5 rows (approximately)
INSERT INTO `locomotive` (`locomotive_id`, `series`, `number`, `power`, `status`) VALUES
	(1, 193, 913, 5200, 'RTG'),
	(2, 193, 907, 5200, 'REV'),
	(3, 193, 903, 5200, 'RTG'),
	(4, 444, 1, 0, 'OUT'),
	(5, 666, 3, 1680, 'MAI');

-- Dumping structure for table train_timetable_app.start_station
CREATE TABLE IF NOT EXISTS `start_station` (
  `start_station_id` int(11) NOT NULL AUTO_INCREMENT,
  `station_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`start_station_id`),
  KEY `FK__stations_ss` (`station_id`),
  CONSTRAINT `FK__stations_ss` FOREIGN KEY (`station_id`) REFERENCES `stations` (`station_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table train_timetable_app.start_station: ~4 rows (approximately)
INSERT INTO `start_station` (`start_station_id`, `station_id`) VALUES
	(2, 2),
	(1, 3),
	(3, 3),
	(4, 4);

-- Dumping structure for table train_timetable_app.stations
CREATE TABLE IF NOT EXISTS `stations` (
  `station_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `location` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`station_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table train_timetable_app.stations: ~4 rows (approximately)
INSERT INTO `stations` (`station_id`, `name`, `location`) VALUES
	(1, 'Belgrade Center', 'Belgrade'),
	(2, 'New Belgrade', 'Belgrade'),
	(3, 'Novi Sad', 'Novi Sad'),
	(4, 'Prahovo Pristaniste', 'Prahovo');

-- Dumping structure for table train_timetable_app.train
CREATE TABLE IF NOT EXISTS `train` (
  `train_number` int(11) NOT NULL AUTO_INCREMENT,
  `time_of_departure` time NOT NULL DEFAULT '00:00:00',
  `weight` int(11) NOT NULL DEFAULT 0,
  `composition_id` int(11) NOT NULL DEFAULT 0,
  `start_station_id` int(11) NOT NULL DEFAULT 0,
  `last_station_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`train_number`),
  KEY `FK__start_station` (`start_station_id`),
  KEY `FK__last_station` (`last_station_id`),
  KEY `FK_train_composition` (`composition_id`),
  CONSTRAINT `FK__last_station` FOREIGN KEY (`last_station_id`) REFERENCES `last_station` (`last_station_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK__start_station` FOREIGN KEY (`start_station_id`) REFERENCES `start_station` (`start_station_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_train_composition` FOREIGN KEY (`composition_id`) REFERENCES `composition` (`composition_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table train_timetable_app.train: ~1 rows (approximately)
INSERT INTO `train` (`train_number`, `time_of_departure`, `weight`, `composition_id`, `start_station_id`, `last_station_id`) VALUES
	(4, '20:50:00', 2000, 1, 1, 3);

-- Dumping structure for table train_timetable_app.train_driver
CREATE TABLE IF NOT EXISTS `train_driver` (
  `train_driver_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `surname` varchar(50) NOT NULL DEFAULT '0',
  `personal_number` varchar(50) NOT NULL DEFAULT '0',
  `origin_station_id` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`train_driver_id`),
  KEY `FK__stations` (`origin_station_id`),
  CONSTRAINT `FK__stations` FOREIGN KEY (`origin_station_id`) REFERENCES `stations` (`station_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table train_timetable_app.train_driver: ~1 rows (approximately)
INSERT INTO `train_driver` (`train_driver_id`, `name`, `surname`, `personal_number`, `origin_station_id`) VALUES
	(2, 'Petar', 'Pertrovic', '0001', 1),
	(3, 'Nebojsa', 'Jovic', '0002', 1);

-- Dumping structure for table train_timetable_app.wagon
CREATE TABLE IF NOT EXISTS `wagon` (
  `wagon_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_of_wagon` varchar(50) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT '0',
  `weight` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`wagon_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table train_timetable_app.wagon: ~3 rows (approximately)
INSERT INTO `wagon` (`wagon_id`, `type_of_wagon`, `status`, `weight`) VALUES
	(1, 'Eanoss', 'RTG', '25'),
	(2, 'Eanoss', 'RTG', '25'),
	(3, 'Eanoss', 'OUT', '25');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
