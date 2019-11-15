DROP database if exists `beauty_store`;
CREATE DATABASE  IF NOT EXISTS `beauty_store` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `beauty_store`;
SET SQL_SAFE_UPDATES = 0;

-- MySQL dump 10.13  Distrib 8.0.16, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: beauty_store
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `brand` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_rdxh7tq2xs66r485cc8dkxt77` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-15 18:49:31

--
-- Table structure for table `basket`
--

DROP TABLE IF EXISTS `basket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_46ccwnsi9409t36lurvtyljak` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
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
-- Table structure for table `commodity_purchase`
--

--
-- Table structure for table `basket_commodity`
--

DROP TABLE IF EXISTS `basket_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `basket_commodity` (
  `id_basket` int(11) NOT NULL,
  `id_commodity` int(11) NOT NULL,
  KEY `FKn88uamkno3lp30rg2154wj5sd` (`id_commodity`),
  KEY `FKrlat0fjgbk15vtwxw86yokxfm` (`id_basket`),
  CONSTRAINT `FKn88uamkno3lp30rg2154wj5sd` FOREIGN KEY (`id_commodity`) REFERENCES `commodity` (`id`),
  CONSTRAINT `FKrlat0fjgbk15vtwxw86yokxfm` FOREIGN KEY (`id_basket`) REFERENCES `basket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



DROP TABLE IF EXISTS `commodity_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `commodity_purchase` (
  `id_purchase` int(11) NOT NULL,
  `id_commodity` int(11) NOT NULL,
  KEY `FK9m8njj44gmkffptpx3jt9k6e2` (`id_commodity`),
  KEY `FK1yjj2gfwh3umt1a2l3c2w9gff` (`id_purchase`),
  CONSTRAINT `FK1yjj2gfwh3umt1a2l3c2w9gff` FOREIGN KEY (`id_purchase`) REFERENCES `purchase` (`id`),
  CONSTRAINT `FK9m8njj44gmkffptpx3jt9k6e2` FOREIGN KEY (`id_commodity`) REFERENCES `commodity` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;



