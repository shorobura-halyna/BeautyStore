Create database beauty_store;

use beauty_store;

-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: beauty_store
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `basket`
--

DROP TABLE IF EXISTS `basket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfp7yinn3dh4sy1ia364xp3d9g` (`user_id`),
  CONSTRAINT `FKfp7yinn3dh4sy1ia364xp3d9g` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basket`
--

LOCK TABLES `basket` WRITE;
/*!40000 ALTER TABLE `basket` DISABLE KEYS */;
INSERT INTO `basket` VALUES (13,0,16),(14,0,17);
/*!40000 ALTER TABLE `basket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `basket_commodity`
--

DROP TABLE IF EXISTS `basket_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `basket_commodity` (
  `id_basket` int(11) NOT NULL,
  `id_commodity` int(11) NOT NULL,
  KEY `FKn88uamkno3lp30rg2154wj5sd` (`id_commodity`),
  KEY `FKrlat0fjgbk15vtwxw86yokxfm` (`id_basket`),
  CONSTRAINT `FKn88uamkno3lp30rg2154wj5sd` FOREIGN KEY (`id_commodity`) REFERENCES `commodity` (`id`),
  CONSTRAINT `FKrlat0fjgbk15vtwxw86yokxfm` FOREIGN KEY (`id_basket`) REFERENCES `basket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `basket_commodity`
--

LOCK TABLES `basket_commodity` WRITE;
/*!40000 ALTER TABLE `basket_commodity` DISABLE KEYS */;
/*!40000 ALTER TABLE `basket_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rdxh7tq2xs66r485cc8dkxt77` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES (5,'Anastasia Beverly Hills'),(9,'Chanel'),(15,'CHI'),(6,'Collistar'),(11,'Declare'),(18,'Dove'),(16,'Garnier'),(3,'Givenchy'),(12,'Loreal Paris'),(10,'La Roche-Posay'),(4,'Lancome'),(19,'Nivea'),(14,'Schwarzkopf '),(13,'Vichy'),(17,'Weleda'),(1,'Yves Saint Laurent');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (7,'Body'),(2,'Care'),(3,'Hair'),(1,'Makeup');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `url_to_picture` varchar(255) DEFAULT NULL,
  `brand_id` int(11) DEFAULT NULL,
  `subcategory_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_oo1k686tdqhs875wjekqckprv` (`name`),
  KEY `FKf62jk23wnfsp6hgs9sxmtv819` (`brand_id`),
  KEY `FKd7yvjf0x3ftl54wt9vf77t6s7` (`subcategory_id`),
  CONSTRAINT `FKd7yvjf0x3ftl54wt9vf77t6s7` FOREIGN KEY (`subcategory_id`) REFERENCES `subcategory` (`id`),
  CONSTRAINT `FKf62jk23wnfsp6hgs9sxmtv819` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (1,'Volupte Plump-In-Colour',707,'Volupte Plump-In-Colour.jpg',1,1),(7,'Oil ',230,'Oil .jpg',17,14),(8,'Body Milk',130,'Body Milk.jpg',19,14),(9,'Hydra Aloe',230,'Hydra Aloe.jpg',16,8),(10,'Keratin shampoo ',490,'Keratin shampoo .jpg',15,8),(11,'bb cream',555,'bb cream.jpg',6,2),(12,'Refining Toner',553,'Refining Toner.jpeg',17,14),(13,'Matifying Hydro Cream',765,'Matifying Hydro Cream.jpg',11,5),(14,'Chanel Rouge Allure Velvet',1230,'Chanel Rouge Allure Velvet.jpeg',9,1),(15,'Repair Rescue Deep Nourishing Micellar Shampoo',245,'Repair Rescue Deep Nourishing Micellar Shampoo.jpg',14,8),(16,'Normaderm',360,'Normaderm.png',13,7),(17,'Toleriane',540,'Toleriane.jpg',10,15),(21,'Toner',590,'Toner.jpg',10,7),(22,'Dipbrow Pomade',543,'Dipbrow Pomade.jpg',5,4),(23,'Body Care',124,'Body Care.jpeg',18,13),(24,'A\'Pieu True Velvet Lipstick',3470,'A\'Pieu True Velvet Lipstick.jpeg',3,1),(25,'Hydration',980,'Hydration.jpg',13,5),(26,' Givenchy Couture Atelier Palette',2900,NULL,3,4),(27,'Mask',323,'Mask.jpg',16,10),(28,'Million Lashes So Couture',320,'Million Lashes So Couture.jpg',9,2);
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_purchase`
--

DROP TABLE IF EXISTS `commodity_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commodity_purchase` (
  `id_purchase` int(11) NOT NULL,
  `id_commodity` int(11) NOT NULL,
  KEY `FK9m8njj44gmkffptpx3jt9k6e2` (`id_commodity`),
  KEY `FK1yjj2gfwh3umt1a2l3c2w9gff` (`id_purchase`),
  CONSTRAINT `FK1yjj2gfwh3umt1a2l3c2w9gff` FOREIGN KEY (`id_purchase`) REFERENCES `purchase` (`id`),
  CONSTRAINT `FK9m8njj44gmkffptpx3jt9k6e2` FOREIGN KEY (`id_commodity`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_purchase`
--

LOCK TABLES `commodity_purchase` WRITE;
/*!40000 ALTER TABLE `commodity_purchase` DISABLE KEYS */;
INSERT INTO `commodity_purchase` VALUES (2,1),(2,8),(2,13),(2,13),(2,7),(2,8),(2,8),(2,9),(2,12),(2,12),(3,1),(3,7),(3,9);
/*!40000 ALTER TABLE `commodity_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `total_amount` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK86i0stm7cqsglqptdvjij1k3m` (`user_id`),
  CONSTRAINT `FK86i0stm7cqsglqptdvjij1k3m` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
INSERT INTO `purchase` VALUES (2,NULL,0,16),(3,'2019-11-15 17:01:17',1167,16);
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e060alu3238gwu0mvhgh6xkhd` (`name`),
  KEY `FKe4hdbsmrx9bs9gpj1fh4mg0ku` (`category_id`),
  CONSTRAINT `FKe4hdbsmrx9bs9gpj1fh4mg0ku` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subcategory`
--

LOCK TABLES `subcategory` WRITE;
/*!40000 ALTER TABLE `subcategory` DISABLE KEYS */;
INSERT INTO `subcategory` VALUES (1,'Lipstick',1),(2,'Mascara',1),(4,'Makeup palette',1),(5,'Cream',2),(6,'Mask',2),(7,'Cleaning',2),(8,'Shampoo',3),(9,'Hair conditioner',3),(10,'Hair mask',3),(11,'Styling',3),(12,'Body scrub',7),(13,'Shower Gel',7),(14,'body cream',7),(15,'BB-cream',1);
/*!40000 ALTER TABLE `subcategory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `login` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_ew1hvam8uwaknuaellwhqchhb` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'shorobura-halyna@gmail.com','shorobura-halyna','qwerty123',1),(3,'','admin','admin',0),(16,'test@test','test','test',1),(17,'test2@test','test2','test2',1);
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

-- Dump completed on 2019-11-15 17:20:18
