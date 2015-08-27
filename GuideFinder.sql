CREATE DATABASE  IF NOT EXISTS `findyourguide` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `findyourguide`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: findyourguide
-- ------------------------------------------------------
-- Server version	5.6.19

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
-- Table structure for table `gps_info`
--

DROP TABLE IF EXISTS `gps_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gps_info` (
  `user_ID` int(11) NOT NULL,
  `longtitude` double DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gps_info`
--

LOCK TABLES `gps_info` WRITE;
/*!40000 ALTER TABLE `gps_info` DISABLE KEYS */;
INSERT INTO `gps_info` VALUES (22,-6.2465895,53.3436234,'2015-03-23 19:25:59'),(23,-6.2471801,53.3436157,'2015-03-23 19:26:00');
/*!40000 ALTER TABLE `gps_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guide`
--

DROP TABLE IF EXISTS `guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guide` (
  `guide_ID` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `nation` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `hometown` varchar(45) DEFAULT NULL,
  `exp` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `car` varchar(45) DEFAULT NULL,
  `cartype` varchar(45) DEFAULT NULL,
  `tips` varchar(45) DEFAULT NULL,
  `headicon` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`guide_ID`),
  CONSTRAINT `User_ID` FOREIGN KEY (`guide_ID`) REFERENCES `user` (`User_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guide`
--

LOCK TABLES `guide` WRITE;
/*!40000 ALTER TABLE `guide` DISABLE KEYS */;
/*!40000 ALTER TABLE `guide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guide_info`
--

DROP TABLE IF EXISTS `guide_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guide_info` (
  `guide_ID` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `exp` varchar(45) DEFAULT NULL,
  `headicon` varchar(45) DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `car` varchar(45) DEFAULT NULL,
  `cartype` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `tips` varchar(45) DEFAULT NULL,
  `occupation` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `nation` varchar(45) DEFAULT NULL,
  `hometown` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`guide_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guide_info`
--

LOCK TABLES `guide_info` WRITE;
/*!40000 ALTER TABLE `guide_info` DISABLE KEYS */;
INSERT INTO `guide_info` VALUES (20,21,'Yunyi Zhu','no','zhuyu.jpg','2 years','Galway','yes','BMW X6','English, Chinese','no','student','male','China','Jiujiang'),(21,28,'Haonian Li','no','liha.jpg','1 years','Dublin','yes','Ford Focus','English, Chinese, Japanese','no','student','male','China','Chongqing'),(22,22,'Yamin Xue','no','yami.jpg','2 years','Galway','no','no','English, Chinese','no','student','female','China','Changzhou'),(23,22,'Chenghao Yu','no','yuch.jpg','1 years','Dublin','no','no','English, Chinese','no','student','male','China','Changsha');
/*!40000 ALTER TABLE `guide_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_info`
--

DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_info` (
  `order_ID` int(11) NOT NULL AUTO_INCREMENT,
  `startTime` varchar(45) NOT NULL,
  `endTime` varchar(45) NOT NULL,
  `number` int(11) NOT NULL,
  `city` varchar(45) NOT NULL,
  `comment` varchar(45) NOT NULL,
  `traveler_ID` int(11) NOT NULL,
  `guide_ID` int(11) NOT NULL,
  PRIMARY KEY (`order_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_info`
--

LOCK TABLES `order_info` WRITE;
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
INSERT INTO `order_info` VALUES (5,'2015-03-13','2015-04-28',4,'Galway','helo',23,22);
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `pwd` varchar(45) NOT NULL,
  PRIMARY KEY (`User_ID`,`email`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (20,'zhuyu@tcd.ie','Yunyi','Zhu','123456'),(21,'liha@tcd.ie','Haonian','Li','123123'),(22,'xuey@tcd.ie','Yamin','Xue','123123'),(23,'yuch@tcd.ie','Chenghao','Yu','123123');
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

-- Dump completed on 2015-03-24 13:29:03
