USE `springboot`;

DROP TABLE IF EXISTS `record`;

CREATE TABLE `record` (
                          `id` INT(11) NOT NULL AUTO_INCREMENT,
                          `user_id` INT(11) NOT NULL,
                          `song_id` INT(11) NOT NULL,
                          `fav` INT(11) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `user_song_id_uindex` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT  INTO `record`(`id`,`user_id`,`song_id`,`fav`) VALUES (1,1,1,0),(2,1,2,0),(3,1,3,1),(4,2,1,0),(5,2,2,0),(6,2,3,1);
