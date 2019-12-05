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
  `KonkurrenceNavn` varchar(200) DEFAULT NULL,
  `Placering` int(11) DEFAULT NULL,
  `Tid` double DEFAULT NULL,
  `Navn` varchar(200) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konkurrence`
--

LOCK TABLES `konkurrence` WRITE;
/*!40000 ALTER TABLE `konkurrence` DISABLE KEYS */;
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
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medlemmer`
--

LOCK TABLES `medlemmer` WRITE;
/*!40000 ALTER TABLE `medlemmer` DISABLE KEYS */;
/*!40000 ALTER TABLE `medlemmer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultater`
--

DROP TABLE IF EXISTS `resultater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultater` (
  `Navn` varchar(200) DEFAULT NULL,
  `Tid` double DEFAULT NULL,
  `Dato` varchar(200) DEFAULT NULL,
  `Disciplin` varchar(200) DEFAULT NULL,
  `Længde` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultater`
--

LOCK TABLES `resultater` WRITE;
/*!40000 ALTER TABLE `resultater` DISABLE KEYS */;
/*!40000 ALTER TABLE `resultater` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-26 14:09:05
