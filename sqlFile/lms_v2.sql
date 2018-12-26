-- MySQL dump 10.16  Distrib 10.1.37-MariaDB, for Linux (x86_64)
--
-- Host: localhost    Database: lms_db
-- ------------------------------------------------------
-- Server version	10.1.37-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `title` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `author` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `location` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bid` int(11) NOT NULL,
  PRIMARY KEY (`bid`),
  UNIQUE KEY `book_PK` (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_curr`
--

DROP TABLE IF EXISTS `borrow_curr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow_curr` (
  `borrow_crr_id` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `borrow_time` datetime NOT NULL,
  `should_return_time` datetime NOT NULL,
  PRIMARY KEY (`borrow_crr_id`),
  KEY `FK_borrow_bid` (`bid`),
  KEY `FK_borrow_userid` (`userid`),
  CONSTRAINT `FK_borrow_bid` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`),
  CONSTRAINT `FK_borrow_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_curr`
--

LOCK TABLES `borrow_curr` WRITE;
/*!40000 ALTER TABLE `borrow_curr` DISABLE KEYS */;
/*!40000 ALTER TABLE `borrow_curr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL,
  `category_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailed_book`
--

DROP TABLE IF EXISTS `detailed_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailed_book` (
  `bid` int(11) NOT NULL,
  `status` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '在馆',
  `publishing_house` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `series` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ISBN` varchar(13) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `borrow_times` int(11) NOT NULL DEFAULT '0',
  `category_number` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `author` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `second_author` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `introduction` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `summary` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `author_notes` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `reader_notes` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `book_specification` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `douban_introduce` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`bid`),
  CONSTRAINT `FK_relationship_book` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailed_book`
--

LOCK TABLES `detailed_book` WRITE;
/*!40000 ALTER TABLE `detailed_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailed_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detailed_user`
--

DROP TABLE IF EXISTS `detailed_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailed_user` (
  `userid` int(11) NOT NULL,
  `ID_number` char(9) COLLATE utf8mb4_unicode_ci NOT NULL,
  `departement` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `sex` char(1) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `identify` char(18) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `company` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `degree` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `borrow_max` int(11) NOT NULL DEFAULT '20',
  `appionent_max` int(11) NOT NULL DEFAULT '20',
  `entrust_max` int(11) NOT NULL DEFAULT '20',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `postcode` char(6) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cash_pledge` float DEFAULT NULL,
  `position` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `borrow_account` int(11) NOT NULL DEFAULT '0',
  `break_rules_account` int(11) NOT NULL DEFAULT '0',
  `handing_charge` float DEFAULT NULL,
  `borrow_grade` int(11) NOT NULL DEFAULT '0',
  `address` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `FK_relation_user` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailed_user`
--

LOCK TABLES `detailed_user` WRITE;
/*!40000 ALTER TABLE `detailed_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailed_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `penalty`
--

DROP TABLE IF EXISTS `penalty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `penalty` (
  `penalty_id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `return_time` datetime NOT NULL,
  `should_return_time` datetime NOT NULL,
  `assessment` float NOT NULL,
  `paid` float NOT NULL,
  PRIMARY KEY (`penalty_id`),
  KEY `FK_penalty_bid` (`bid`),
  KEY `FK_penalty_userid` (`userid`),
  CONSTRAINT `FK_penalty_bid` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`),
  CONSTRAINT `FK_penalty_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `penalty`
--

LOCK TABLES `penalty` WRITE;
/*!40000 ALTER TABLE `penalty` DISABLE KEYS */;
/*!40000 ALTER TABLE `penalty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `record`
--

DROP TABLE IF EXISTS `record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `record` (
  `record_id` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `borrow_time` datetime NOT NULL,
  `return_time` datetime NOT NULL,
  PRIMARY KEY (`record_id`),
  KEY `FK_record_bid` (`bid`),
  KEY `FK_record_userid` (`userid`),
  CONSTRAINT `FK_record_bid` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`),
  CONSTRAINT `FK_record_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `record`
--

LOCK TABLES `record` WRITE;
/*!40000 ALTER TABLE `record` DISABLE KEYS */;
/*!40000 ALTER TABLE `record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `relation_book`
--

DROP TABLE IF EXISTS `relation_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `relation_book` (
  `bid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  PRIMARY KEY (`bid`,`cid`),
  KEY `FK_relation_book2` (`cid`),
  CONSTRAINT `FK_relation_book` FOREIGN KEY (`bid`) REFERENCES `book` (`bid`),
  CONSTRAINT `FK_relation_book2` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `relation_book`
--

LOCK TABLES `relation_book` WRITE;
/*!40000 ALTER TABLE `relation_book` DISABLE KEYS */;
/*!40000 ALTER TABLE `relation_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `effective_date` date NOT NULL,
  `expiry_date` date NOT NULL,
  `type` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `profession` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `student_PK` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-26 10:51:22
