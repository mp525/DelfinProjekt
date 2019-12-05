CREATE DATABASE  IF NOT EXISTS `delfinen` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `delfinen`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: delfinen
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `konkurrence`
--

DROP TABLE IF EXISTS `konkurrence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `konkurrence` (
  `KonkurrenceNavn` varchar(255) DEFAULT NULL,
  `Placering` int(11) DEFAULT NULL,
  `Tid` double DEFAULT NULL,
  `Navn` varchar(255) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Disciplin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konkurrence`
--

LOCK TABLES `konkurrence` WRITE;
/*!40000 ALTER TABLE `konkurrence` DISABLE KEYS */;
INSERT INTO `konkurrence` VALUES ('NSJ Cup',1,35.13,'Ole',3,'Rygcrawl'),('NSJ Cup',2,43.1,'Uimmy',4,'Butterfly'),('NSJ Cup',3,45.66,'John2',5,'Crawl'),('NSJ Cup',3,12.3,'Matti',6,'Rygcrawl'),('NSJ Cup',2,15.6,'Mimmy',7,'Brystsvoemning'),('NSJ Cup',1,135.6,'Kimmy',8,'Crawl');
/*!40000 ALTER TABLE `konkurrence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medlemmer`
--

DROP TABLE IF EXISTS `medlemmer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medlemmer` (
  `Alder` int(11) DEFAULT NULL,
  `AktivitetsForm` varchar(255) DEFAULT NULL,
  `kontingentBetaling` int(11) DEFAULT NULL,
  `Aktiv` tinyint(4) DEFAULT NULL,
  `Navn` varchar(255) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Restance` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medlemmer`
--

LOCK TABLES `medlemmer` WRITE;
/*!40000 ALTER TABLE `medlemmer` DISABLE KEYS */;
INSERT INTO `medlemmer` VALUES (17,'Passiv svømning',500,0,'Jonas',4,1),(18,'Crawl',1600,1,'John2',5,1),(20,'Rygcrawl',1600,1,'Matti',7,1),(55,'Rygcrawl',1600,1,'Ole',8,NULL),(11,'Rygcrawl',1000,1,'Bimmy',9,NULL),(11,'Rygcrawl',1000,1,'Kimmy',10,NULL),(11,'Crawl',1000,1,'Simmy',12,NULL),(11,'Crawl',1000,1,'Yimmy',13,NULL),(65,'Crawl',1000,1,'Limmy',14,NULL),(11,'Brystsvoemning',1000,1,'Himmy',19,NULL),(11,'Brystsvoemning',1000,1,'Oimmy',20,NULL),(20,'Brystsvoemning',1000,1,'Pimmy',21,NULL),(21,'Brystsvoemning',1000,1,'Mimmy',22,1),(11,'Butterfly',1000,1,'Aimmy',23,NULL),(11,'Butterfly',1000,1,'Rimmy',24,NULL),(20,'Butterfly',1000,1,'Wimmy',25,NULL),(21,'Butterfly',1000,1,'Uimmy',26,NULL),(26,'Butterfly',1600,1,'Tarzan',27,NULL);
/*!40000 ALTER TABLE `medlemmer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultater`
--

DROP TABLE IF EXISTS `resultater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultater` (
  `Navn` varchar(255) DEFAULT NULL,
  `Tid` double DEFAULT NULL,
  `Dato` varchar(255) DEFAULT NULL,
  `Disciplin` varchar(255) DEFAULT NULL,
  `Længde` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultater`
--

LOCK TABLES `resultater` WRITE;
/*!40000 ALTER TABLE `resultater` DISABLE KEYS */;
INSERT INTO `resultater` VALUES ('John2',13.2,'29-11-2019','Crawl',100,12),('Limmy',13.23,'29-11-2019','Crawl',100,13),('Yimmy',10.42,'29-11-2019','Crawl',100,14),('Simmy',5.2,'29-11-2019','Crawl',100,15),('Matti',6.54,'29-11-2019','Rygcrawl',100,16),('Ole',15.66,'29-11-2019','Rygcrawl',100,17),('Bimmy',56.7,'29-11-2019','Rygcrawl',100,18),('Kimmy',11.55,'29-11-2019','Rygcrawl',100,19),('Himmy',77.5,'29-11-2019','Brystsvoemning',100,20),('Oimmy',15.55,'29-11-2019','Brystsvoemning',100,21),('Pimmy',16.77,'29-11-2019','Brystsvoemning',100,22),('Mimmy',123.4,'29-11-2019','Brystsvoemning',100,23),('Aimmy',16.88,'29-11-2019','Butterfly',100,24),('Rimmy',5.1,'29-11-2019','Butterfly',100,25),('Wimmy',4.5,'29-11-2019','Butterfly',100,26),('Uimmy',88.7,'29-11-2019','Butterfly',100,27),('Uimmy',65.4,'28-11-2019','Crawl',100,29),('Tarzan',15.6,'29-11-2019','Butterfly',100,30);
/*!40000 ALTER TABLE `resultater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'delfinen'
--

--
-- Dumping routines for database 'delfinen'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-29 11:06:18
