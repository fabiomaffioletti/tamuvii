SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `tamuvii` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `tamuvii`;

-- -----------------------------------------------------
-- Table `tamuvii`.`director`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`director` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`director` (
  `director` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `surname` VARCHAR(100) NOT NULL ,
  `aka` VARCHAR(100) NULL ,
  PRIMARY KEY (`director`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `tamuvii`.`director`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `director` (`director`, `name`, `surname`, `aka`) VALUES (-1, 'Federico', 'Fellini', '');
INSERT INTO `director` (`director`, `name`, `surname`, `aka`) VALUES (-2, 'Ridley', 'Scott', '');

COMMIT;

-- -----------------------------------------------------
-- Table `tamuvii`.`movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`movie` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`movie` (
  `movie` INT NOT NULL AUTO_INCREMENT ,
  `duration` VARCHAR(45) NULL ,
  `original_title` VARCHAR(200) NULL ,
  `director` INT NULL ,
  `release_date` DATETIME NULL ,
  PRIMARY KEY (`movie`) ,
  CONSTRAINT `fk_director`
    FOREIGN KEY (`director` )
    REFERENCES `tamuvii`.`director` (`director` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_director ON `tamuvii`.`movie` (`director` ASC) ;


-- -----------------------------------------------------
-- Data for table `tamuvii`.`movie`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `movie` (`movie`, `duration`, `original_title`, `director`, `release_date`) VALUES (-1, '107', 'La vita è bella', -1, '2009/01/22 00:00:00');
INSERT INTO `movie` (`movie`, `duration`, `original_title`, `director`, `release_date`) VALUES (-2, '90', 'Vita da cani', -2, '2009/01/22 00:00:00');
INSERT INTO `movie` (`movie`, `duration`, `original_title`, `director`, `release_date`) VALUES (-3, '102', 'Il mostro', -1, '2009/01/22 00:00:00');

COMMIT;

-- -----------------------------------------------------
-- Table `tamuvii`.`genre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`genre` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`genre` (
  `genre` INT NOT NULL AUTO_INCREMENT ,
  `locale` VARCHAR(4) NOT NULL ,
  `localized_genre` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`genre`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tamuvii`.`actor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`actor` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`actor` (
  `actor` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NOT NULL ,
  `surname` VARCHAR(100) NOT NULL ,
  `aka` VARCHAR(100) NULL ,
  PRIMARY KEY (`actor`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tamuvii`.`movie_to_actor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`movie_to_actor` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`movie_to_actor` (
  `movie` INT NOT NULL ,
  `actor` INT NOT NULL ,
  PRIMARY KEY (`movie`, `actor`) ,
  CONSTRAINT `fk_movie_actor`
    FOREIGN KEY (`movie` )
    REFERENCES `tamuvii`.`movie` (`movie` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_actor_movie`
    FOREIGN KEY (`actor` )
    REFERENCES `tamuvii`.`actor` (`actor` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_movie_actor ON `tamuvii`.`movie_to_actor` (`movie` ASC) ;

CREATE INDEX fk_actor_movie ON `tamuvii`.`movie_to_actor` (`actor` ASC) ;


-- -----------------------------------------------------
-- Table `tamuvii`.`localized_data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`localized_data` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`localized_data` (
  `localized_data` INT NOT NULL AUTO_INCREMENT ,
  `locale` VARCHAR(4) NOT NULL ,
  `localized_title` VARCHAR(200) NOT NULL ,
  `localized_plot` TEXT NULL ,
  PRIMARY KEY (`localized_data`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tamuvii`.`movie_to_localized_data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`movie_to_localized_data` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`movie_to_localized_data` (
  `movie` INT NOT NULL ,
  `localized_data` INT NOT NULL ,
  PRIMARY KEY (`movie`, `localized_data`) ,
  CONSTRAINT `fk_movie_data`
    FOREIGN KEY (`movie` )
    REFERENCES `tamuvii`.`movie` (`movie` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_data_movie`
    FOREIGN KEY (`localized_data` )
    REFERENCES `tamuvii`.`localized_data` (`localized_data` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_movie_data ON `tamuvii`.`movie_to_localized_data` (`movie` ASC) ;

CREATE INDEX fk_data_movie ON `tamuvii`.`movie_to_localized_data` (`localized_data` ASC) ;


-- -----------------------------------------------------
-- Table `tamuvii`.`app_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`app_user` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`app_user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(20) NOT NULL ,
  `version` INT NOT NULL ,
  `password` VARCHAR(50) NULL ,
  `first_name` VARCHAR(50) NULL ,
  `last_name` VARCHAR(50) NULL ,
  `address` VARCHAR(150) NULL ,
  `city` VARCHAR(50) NULL ,
  `province` VARCHAR(50) NULL ,
  `country` VARCHAR(100) NULL ,
  `postal_code` VARCHAR(15) NULL ,
  `email` VARCHAR(50) NULL ,
  `phone_number` VARCHAR(20) NULL ,
  `website` VARCHAR(255) NULL ,
  `password_hint` VARCHAR(100) NULL ,
  `account_enabled` CHAR(1) NULL ,
  `account_expired` CHAR(1) NULL ,
  `account_locked` CHAR(1) NULL ,
  `credentials_expired` CHAR(1) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;

CREATE UNIQUE INDEX username ON `tamuvii`.`app_user` (`username` ASC) ;

CREATE UNIQUE INDEX email ON `tamuvii`.`app_user` (`email` ASC) ;


-- -----------------------------------------------------
-- Data for table `tamuvii`.`app_user`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `app_user` (`id`, `username`, `version`, `password`, `first_name`, `last_name`, `address`, `city`, `province`, `country`, `postal_code`, `email`, `phone_number`, `website`, `password_hint`, `account_enabled`, `account_expired`, `account_locked`, `credentials_expired`) VALUES (-1, 'user', 1, '12dea96fec20593566ab75692c9949596833adc9', 'tomcat', 'user', '', 'denver', 'CO', 'US', '80210', 'fabio.maffioletti@gmail.com', '', 'http://www.google.it', 'A male kitty', '1', '0', '0', '0');
INSERT INTO `app_user` (`id`, `username`, `version`, `password`, `first_name`, `last_name`, `address`, `city`, `province`, `country`, `postal_code`, `email`, `phone_number`, `website`, `password_hint`, `account_enabled`, `account_expired`, `account_locked`, `credentials_expired`) VALUES (-2, 'admin', 1, 'd033e22ae348aeb5660fc2140aec35850c4da997', 'matt', 'riable', '', 'denver', 'CO', 'US', '80210', 'fabio.maffioletti+1@gmail.com', '', 'http://www.google.it', 'Not a female kitty', '1', '0', '0', '0');

COMMIT;

-- -----------------------------------------------------
-- Table `tamuvii`.`user_to_movie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`user_to_movie` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`user_to_movie` (
  `movie` INT NOT NULL ,
  `user` INT NOT NULL ,
  `date_added` DATETIME NOT NULL ,
  `date_viewed` DATETIME NULL ,
  `mark` INT NULL ,
  PRIMARY KEY (`movie`, `user`) ,
  CONSTRAINT `fk_movie_user`
    FOREIGN KEY (`movie` )
    REFERENCES `tamuvii`.`movie` (`movie` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_movie`
    FOREIGN KEY (`user` )
    REFERENCES `tamuvii`.`app_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_movie_user ON `tamuvii`.`user_to_movie` (`movie` ASC) ;

CREATE INDEX fk_user_movie ON `tamuvii`.`user_to_movie` (`user` ASC) ;


-- -----------------------------------------------------
-- Data for table `tamuvii`.`user_to_movie`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `user_to_movie` (`movie`, `user`, `date_added`, `date_viewed`, `mark`) VALUES (-1, -1, '2009/01/22 00:00:00', NULL, 0);
INSERT INTO `user_to_movie` (`movie`, `user`, `date_added`, `date_viewed`, `mark`) VALUES (-3, -1, '2009/01/22 00:00:00', NULL, 0);

COMMIT;

-- -----------------------------------------------------
-- Table `tamuvii`.`review`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`review` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`review` (
  `review` INT NOT NULL AUTO_INCREMENT ,
  `user` INT NOT NULL ,
  `movie` INT NOT NULL ,
  `title` VARCHAR(100) NULL ,
  `review_text` TEXT NOT NULL ,
  `date_inserted` DATETIME NOT NULL ,
  PRIMARY KEY (`review`) ,
  CONSTRAINT `fk_review_user`
    FOREIGN KEY (`user` )
    REFERENCES `tamuvii`.`app_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_review_movie`
    FOREIGN KEY (`movie` )
    REFERENCES `tamuvii`.`movie` (`movie` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_review_user ON `tamuvii`.`review` (`user` ASC) ;

CREATE INDEX fk_review_movie ON `tamuvii`.`review` (`movie` ASC) ;


-- -----------------------------------------------------
-- Table `tamuvii`.`opinion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`opinion` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`opinion` (
  `opinion` INT NOT NULL ,
  `review` INT NOT NULL ,
  `user` INT NOT NULL ,
  `opinion_text` TEXT NOT NULL ,
  `date_inserted` DATETIME NOT NULL ,
  PRIMARY KEY (`opinion`) ,
  CONSTRAINT `fk_review`
    FOREIGN KEY (`review` )
    REFERENCES `tamuvii`.`review` (`review` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_opinion_user`
    FOREIGN KEY (`user` )
    REFERENCES `tamuvii`.`app_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_review ON `tamuvii`.`opinion` (`review` ASC) ;

CREATE INDEX fk_opinion_user ON `tamuvii`.`opinion` (`user` ASC) ;


-- -----------------------------------------------------
-- Table `tamuvii`.`movie_to_genre`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`movie_to_genre` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`movie_to_genre` (
  `movie` INT NOT NULL ,
  `genre` INT NOT NULL ,
  PRIMARY KEY (`movie`, `genre`) ,
  CONSTRAINT `fk_movie_genre`
    FOREIGN KEY (`movie` )
    REFERENCES `tamuvii`.`movie` (`movie` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_genre_movie`
    FOREIGN KEY (`genre` )
    REFERENCES `tamuvii`.`genre` (`genre` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_movie_genre ON `tamuvii`.`movie_to_genre` (`movie` ASC) ;

CREATE INDEX fk_genre_movie ON `tamuvii`.`movie_to_genre` (`genre` ASC) ;


-- -----------------------------------------------------
-- Table `tamuvii`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`role` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(20) NOT NULL ,
  `description` VARCHAR(64) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `tamuvii`.`role`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `role` (`id`, `name`, `description`) VALUES (-1, 'ROLE_ADMIN', 'Administrator role (can edit Users)');
INSERT INTO `role` (`id`, `name`, `description`) VALUES (-2, 'ROLE_USER', 'Default role for all Users');

COMMIT;

-- -----------------------------------------------------
-- Table `tamuvii`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tamuvii`.`user_role` ;

CREATE  TABLE IF NOT EXISTS `tamuvii`.`user_role` (
  `user_id` INT NOT NULL ,
  `role_id` INT NOT NULL ,
  PRIMARY KEY (`user_id`, `role_id`) ,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`user_id` )
    REFERENCES `tamuvii`.`app_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_user`
    FOREIGN KEY (`role_id` )
    REFERENCES `tamuvii`.`role` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX fk_user_role ON `tamuvii`.`user_role` (`user_id` ASC) ;

CREATE INDEX fk_role_user ON `tamuvii`.`user_role` (`role_id` ASC) ;


-- -----------------------------------------------------
-- Data for table `tamuvii`.`user_role`
-- -----------------------------------------------------
SET AUTOCOMMIT=0;
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (-1, -2);
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES (-2, -1);

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
