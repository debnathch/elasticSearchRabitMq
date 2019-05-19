SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `heroku_b0de01547793a0c` ;

CREATE SCHEMA `heroku_b0de01547793a0c` ;
-------------------------------
-- user Table
-------------------------------

     DROP TABLE IF EXISTS `heroku_b0de01547793a0c`.`user` ;

     CREATE TABLE IF NOT EXISTS `heroku_b0de01547793a0c`.`user` (
       `user_id`  int(11) NOT NULL ,
       `user_name` varchar(255) NOT NULL,
       `user_pwd` varchar(255) DEFAULT NULL,
       `user_email` varchar(255) ,
       `customer_Phone` varchar(255) DEFAULT NULL,
       PRIMARY KEY (`user_id`))ENGINE=InnoDB DEFAULT CHARSET=latin1;


------------------------------
--- insert user
-------------------------------
INSERT INTO `heroku_b0de01547793a0c`.`user` (`user_id`, `user_name`,`user_pwd`,`user_email`, `customer_Phone`) VALUES
(1, 'Arpan', 'mypassword', 'arpanmuk@gmail.com', '999999999');


-------------------------------
-- post Table
-------------------------------

        DROP TABLE IF EXISTS `heroku_b0de01547793a0c`.`posts` ;

        CREATE TABLE `heroku_b0de01547793a0c`.`posts` (

         `posts_id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
         `user_id` int(11) DEFAULT NULL,
         `title` varchar(255) NOT NULL,
         `body_post` text NOT NULL,
         `created_at` TIMESTAMP NULL ,
         `updated_at` TIMESTAMP NULL ,
          FOREIGN KEY (`user_id`) REFERENCES `heroku_b0de01547793a0c`.`user`(`user_id`))
          ENGINE=InnoDB DEFAULT CHARSET=latin1;

------------------------------
--- insert user
-------------------------------
INSERT INTO `heroku_b0de01547793a0c`.`posts`(`posts_id`, `user_id`,`title`,`body_post`, `created_at`, `updated_at`) VALUES
(1, 1, 'Find Good or Bad boy', 'who is a good or bad boy', '2019-05-19 10:52:58', null);



-------------------------------
-- comment Table
-------------------------------


        DROP TABLE IF EXISTS `heroku_b0de01547793a0c`.`comments` ;

        CREATE TABLE `heroku_b0de01547793a0c`.`comments` (

         `comments_id` int(11) NOT NULL AUTO_INCREMENT ,
         `posts_id` int(11) DEFAULT NULL,
         `user_id` int(11) DEFAULT NULL,
         `body_comment` varchar(255)  NOT NULL,
         `like_count` int(9) DEFAULT NULL,
          `created_at` TIMESTAMP NULL ,
         `updated_at` TIMESTAMP NULL ,
         PRIMARY KEY (`comments_id`),
          FOREIGN KEY (`posts_id`) REFERENCES `heroku_b0de01547793a0c`.`posts`(`posts_id`))
          ENGINE=InnoDB DEFAULT CHARSET=latin1;

delete from `heroku_b0de01547793a0c`.`comments` where `posts_id`=1;



