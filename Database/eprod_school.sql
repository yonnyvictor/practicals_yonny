-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.12-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table eprod_school.admission_numbers
CREATE TABLE IF NOT EXISTS `admission_numbers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table eprod_school.admission_numbers: ~0 rows (approximately)
/*!40000 ALTER TABLE `admission_numbers` DISABLE KEYS */;
/*!40000 ALTER TABLE `admission_numbers` ENABLE KEYS */;

-- Dumping structure for table eprod_school.level
CREATE TABLE IF NOT EXISTS `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `category` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table eprod_school.level: ~4 rows (approximately)
/*!40000 ALTER TABLE `level` DISABLE KEYS */;
INSERT INTO `level` (`id`, `name`, `category`) VALUES
	(1, 'Form 1', 'High School'),
	(2, 'Form 2', 'High School'),
	(3, 'Form 3', 'High School'),
	(4, 'Form 4', 'High School');
/*!40000 ALTER TABLE `level` ENABLE KEYS */;

-- Dumping structure for table eprod_school.level_streams
CREATE TABLE IF NOT EXISTS `level_streams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level_id` int(11) NOT NULL,
  `stream_id` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;

-- Dumping data for table eprod_school.level_streams: ~12 rows (approximately)
/*!40000 ALTER TABLE `level_streams` DISABLE KEYS */;
INSERT INTO `level_streams` (`id`, `level_id`, `stream_id`, `status`) VALUES
	(1, 1, 1, 'Current'),
	(2, 1, 2, 'Current'),
	(3, 1, 3, 'Current'),
	(4, 2, 1, 'Current'),
	(5, 2, 2, 'Current'),
	(6, 2, 3, 'Current'),
	(7, 3, 1, 'Current'),
	(8, 3, 2, 'Current'),
	(9, 3, 3, 'Current'),
	(10, 4, 1, 'Current'),
	(11, 4, 2, 'Current'),
	(12, 4, 3, 'Current');
/*!40000 ALTER TABLE `level_streams` ENABLE KEYS */;

-- Dumping structure for table eprod_school.registrations
CREATE TABLE IF NOT EXISTS `registrations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` int(11) NOT NULL,
  `level_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `stream_id` int(11) NOT NULL,
  `mode` varchar(50) NOT NULL,
  `date` datetime NOT NULL,
  `created` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `modified` datetime NOT NULL,
  `modified_by` int(11) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `stream_id` (`stream_id`),
  KEY `created_by` (`created_by`),
  KEY `modified_by` (`modified_by`),
  KEY `year` (`year`),
  KEY `level_id` (`level_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table eprod_school.registrations: ~0 rows (approximately)
/*!40000 ALTER TABLE `registrations` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrations` ENABLE KEYS */;

-- Dumping structure for table eprod_school.streams
CREATE TABLE IF NOT EXISTS `streams` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table eprod_school.streams: ~3 rows (approximately)
/*!40000 ALTER TABLE `streams` DISABLE KEYS */;
INSERT INTO `streams` (`id`, `name`) VALUES
	(1, 'A'),
	(2, 'B'),
	(3, 'C');
/*!40000 ALTER TABLE `streams` ENABLE KEYS */;

-- Dumping structure for table eprod_school.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admission_num` varchar(40) DEFAULT NULL,
  `first_name` varchar(80) NOT NULL,
  `middle_name` varchar(80) DEFAULT NULL,
  `other_name` varchar(80) DEFAULT NULL,
  `surname` varchar(80) NOT NULL,
  `gender` varchar(40) NOT NULL,
  `parental_status` varchar(40) DEFAULT NULL,
  `father` varchar(40) DEFAULT NULL,
  `father_contact` varchar(40) DEFAULT NULL,
  `mother` varchar(40) DEFAULT NULL,
  `mother_contact` varchar(40) DEFAULT NULL,
  `address` varchar(40) DEFAULT NULL,
  `district` varchar(40) DEFAULT NULL,
  `constituency` varchar(40) DEFAULT NULL,
  `county` varchar(40) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `siblings` int(11) DEFAULT NULL,
  `dob` datetime DEFAULT NULL,
  `admission_date` datetime NOT NULL,
  `created` datetime NOT NULL,
  `created_by` int(11) NOT NULL,
  `modified` datetime NOT NULL,
  `modified_by` int(11) NOT NULL,
  `status` varchar(40) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `created_by` (`created_by`),
  KEY `modified_by` (`modified_by`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table eprod_school.students: ~0 rows (approximately)
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

-- Dumping structure for table eprod_school.terms
CREATE TABLE IF NOT EXISTS `terms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table eprod_school.terms: ~3 rows (approximately)
/*!40000 ALTER TABLE `terms` DISABLE KEYS */;
INSERT INTO `terms` (`id`, `name`) VALUES
	(1, 'I'),
	(2, 'II'),
	(3, 'III');
/*!40000 ALTER TABLE `terms` ENABLE KEYS */;

-- Dumping structure for table eprod_school.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `names` varchar(255) NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `status` varchar(10) NOT NULL,
  `designation` varchar(100) DEFAULT 'None',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table eprod_school.users: ~1 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `password`, `names`, `last_login`, `status`, `designation`) VALUES
	(1, 'root', 'C80E999BDBA0E8956428491050529392', 'Super User', '2017-11-23 10:34:08', 'Active', 'None');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
