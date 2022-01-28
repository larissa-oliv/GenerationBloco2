-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `tb_temas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_temas` (
  `id_tb_temas` INT NOT NULL,
  `descricao` VARCHAR(255) NULL,
  PRIMARY KEY (`id_tb_temas`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_usuarios` (
  `id_tb_usuarios` INT NOT NULL,
  `nome` VARCHAR(255) NOT NULL,
  `usuario` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(255) NOT NULL,
  `foto` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_tb_usuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tb_postagem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tb_postagem` (
  `id_tb_postagem` INT NOT NULL,
  `titulo` VARCHAR(255) NULL,
  `texto` VARCHAR(255) NULL,
  `data_postagem` DATE NULL,
  `tb_temas_id_tb_temas` INT NOT NULL,
  `tb_usuarios_id_tb_usuarios` INT NOT NULL,
  PRIMARY KEY (`id_tb_postagem`, `tb_temas_id_tb_temas`, `tb_usuarios_id_tb_usuarios`),
  INDEX `fk_tb_postagem_tb_temas_idx` (`tb_temas_id_tb_temas` ASC) VISIBLE,
  INDEX `fk_tb_postagem_tb_usuarios1_idx` (`tb_usuarios_id_tb_usuarios` ASC) VISIBLE,
  CONSTRAINT `fk_tb_postagem_tb_temas`
    FOREIGN KEY (`tb_temas_id_tb_temas`)
    REFERENCES `tb_temas` (`id_tb_temas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tb_postagem_tb_usuarios1`
    FOREIGN KEY (`tb_usuarios_id_tb_usuarios`)
    REFERENCES `tb_usuarios` (`id_tb_usuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
