-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               PostgreSQL 15.6, compiled by Visual C++ build 1937, 64-bit
-- Server OS:                    
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table public.posts
CREATE TABLE IF NOT EXISTS "posts" (
	"post_id" SERIAL PRIMARY KEY,
	"title" VARCHAR(100) NULL DEFAULT NULL,
	"author_name" VARCHAR(10) NULL DEFAULT NULL,
	"content" VARCHAR(512) NULL DEFAULT NULL,
	"password_hash" VARCHAR(255) NULL DEFAULT NULL,
	"views" INTEGER NULL DEFAULT '0',
	"created_at" DATE NULL DEFAULT NULL,
	"updated_at" DATE NULL DEFAULT NULL,
	"is_deleted" BOOLEAN NULL DEFAULT 'false'
);

-- Dumping data for table public.posts: 4 rows
/*!40000 ALTER TABLE "posts" DISABLE KEYS */;
INSERT INTO "posts" ("post_id", "title", "author_name", "content", "password_hash", "views", "created_at", "updated_at", "is_deleted") VALUES
	(9, 'testestes', 'testes', 'testests', '$2a$10$t5yeytZLIfykHNNfVPR1R.acv9EMEpDOWvxzq3Xf2EatONfABTM6i', 1, '2024-12-06', '2024-12-06', 'true'),
	(3, 'selamat malamm', 'budiiii', 'selamat malam semuanya, selamat datang di tutorial java', 'tes123', 22, '2024-12-06', '2024-12-06', 'false'),
	(10, 'tes', 'mawar', 'testestes', '$2a$10$YFR.eVlvcX8HisAZaTJMk.zemAQfrluWgl82rp6uTBt7w7LIQoJa6', 0, '2024-12-06', '2024-12-06', 'false'),
	(8, 'tws', 'tes', 'tes', 'tes', 11, '2024-12-06', '2024-12-06', 'false');
/*!40000 ALTER TABLE "posts" ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
