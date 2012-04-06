USE khanstg;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `isAdmin` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `topic` (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  englishName varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  sort int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE `subtopic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `englishName` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `topic_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8531F6EF722C1EB6` (`topic_id`),
  CONSTRAINT `FK8531F6EF722C1EB6` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`)
);


CREATE TABLE `lesson` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `hebrewName` varchar(255) DEFAULT NULL,
  `linkless` bit(1) NOT NULL,
  `originalName` varchar(255) DEFAULT NULL,
  `serialNumber` int(11) NOT NULL,
  `url` varchar(255) DEFAULT NULL,
  `subtopic_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKBE10AD38305A6A5E` (`subtopic_id`),
  CONSTRAINT `FKBE10AD38305A6A5E` FOREIGN KEY (`subtopic_id`) REFERENCES `subtopic` (`id`)
);





