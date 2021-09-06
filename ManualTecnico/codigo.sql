DROP USER IF EXISTS 'admin'@'localhost';
CREATE USER 'admin'@'localhost' identified by 'Admin';
GRANT ALL PRIVILEGES ON Practica1.* TO admin@localhost;
FLUSH PRIVILEGES;

CREATE SCHEMA `Practica1` ;
USE `Practica1` ;

CREATE TABLE IF NOT EXISTS `Practica1`.`Usuario` (
  `Nombre_Usuario` VARCHAR(90) NOT NULL,
  `Password` VARCHAR(45) NULL,
  `Area` INT NULL,
  PRIMARY KEY (`Nombre_Usuario`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`Mueble` (
  `Nombre_Mueble` VARCHAR(45) NOT NULL,
  `Costo_Mueble` DOUBLE NULL,
  PRIMARY KEY (`Nombre_Mueble`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`Pieza` (
  `Nombre_Pieza` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Nombre_Pieza`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`Cliente` (
  `NIT` VARCHAR(20) NOT NULL,
  `Nombre_Cliente` VARCHAR(100) NULL,
  `Direccion` VARCHAR(45) NULL,
  `Municipio` VARCHAR(45) NULL,
  `Departamento` VARCHAR(45) NULL,
  PRIMARY KEY (`NIT`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`Factura` (
  `Codigo` INT NOT NULL AUTO_INCREMENT,
  `Fecha_Factura` DATE NULL,
  `Monto_Total` DOUBLE NULL,
  `Usuario_Nombre_Usuario` VARCHAR(90) NOT NULL,
  `Cliente_NIT` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`Codigo`),
  INDEX `fk_Factura_Usuario1_idx` (`Usuario_Nombre_Usuario` ASC) VISIBLE,
  INDEX `fk_Factura_Cliente1_idx` (`Cliente_NIT` ASC) VISIBLE,
  CONSTRAINT `fk_Factura_Usuario1`
    FOREIGN KEY (`Usuario_Nombre_Usuario`)
    REFERENCES `Practica1`.`Usuario` (`Nombre_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Factura_Cliente1`
    FOREIGN KEY (`Cliente_NIT`)
    REFERENCES `Practica1`.`Cliente` (`NIT`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`Mueble_Tienda` (
  `idEnTienda` INT NOT NULL AUTO_INCREMENT,
  `Mueble_Nombre_Mueble` VARCHAR(45) NOT NULL,
  `Cantidad` INT NULL,
  `precion` DOUBLE NULL,
  PRIMARY KEY (`idEnTienda`),
  INDEX `fk_EnTienda_Mueble1_idx` (`Mueble_Nombre_Mueble` ASC) VISIBLE,
  CONSTRAINT `fk_EnTienda_Mueble1`
    FOREIGN KEY (`Mueble_Nombre_Mueble`)
    REFERENCES `Practica1`.`Mueble` (`Nombre_Mueble`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`Detalle_Factura` (
  `Codigo_Detalle` INT NOT NULL AUTO_INCREMENT,
  `Factura_Codigo` INT NOT NULL,
  `Cantidad_Muebles` INT NULL,
  `Mueble_Tienda_idEnTienda` INT NOT NULL,
  PRIMARY KEY (`Codigo_Detalle`),
  INDEX `fk_Detalle_Factura_Factura1_idx` (`Factura_Codigo` ASC) VISIBLE,
  INDEX `fk_Detalle_Factura_Mueble_Tienda1_idx` (`Mueble_Tienda_idEnTienda` ASC) VISIBLE,
  CONSTRAINT `fk_Detalle_Factura_Factura1`
    FOREIGN KEY (`Factura_Codigo`)
    REFERENCES `Practica1`.`Factura` (`Codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Detalle_Factura_Mueble_Tienda1`
    FOREIGN KEY (`Mueble_Tienda_idEnTienda`)
    REFERENCES `Practica1`.`Mueble_Tienda` (`idEnTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`Ensamble_Pieza` (
  `idEnsamble_Pieza` INT NOT NULL AUTO_INCREMENT,
  `Mueble_Nombre_Mueble` VARCHAR(45) NULL,
  `Pieza_Nombre_Pieza` VARCHAR(45) NOT NULL,
  `cantidad` VARCHAR(45) NULL,
  PRIMARY KEY (`idEnsamble_Pieza`),
  INDEX `fk_Ensamble_Pieza_Mueble1_idx` (`Mueble_Nombre_Mueble` ASC) VISIBLE,
  INDEX `fk_Ensamble_Pieza_Pieza1_idx` (`Pieza_Nombre_Pieza` ASC) VISIBLE,
  CONSTRAINT `fk_Ensamble_Pieza_Mueble1`
    FOREIGN KEY (`Mueble_Nombre_Mueble`)
    REFERENCES `Practica1`.`Mueble` (`Nombre_Mueble`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ensamble_Pieza_Pieza1`
    FOREIGN KEY (`Pieza_Nombre_Pieza`)
    REFERENCES `Practica1`.`Pieza` (`Nombre_Pieza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`Ensamble_Mueble` (
  `idEnsamble_Mueble` INT NOT NULL AUTO_INCREMENT,
  `Usuario_Nombre_Usuario` VARCHAR(90) NOT NULL,
  `Mueble_Nombre_Mueble` VARCHAR(45) NOT NULL,
  `Fecha_Ensamble` DATE NULL,
  `Estado` TINYINT NULL,
  `costoEnsamble` DOUBLE NULL,
  PRIMARY KEY (`idEnsamble_Mueble`),
  INDEX `fk_Ensamble_Mueble_Mueble1_idx` (`Mueble_Nombre_Mueble` ASC) VISIBLE,
  INDEX `fk_Ensamble_Mueble_Usuario1_idx` (`Usuario_Nombre_Usuario` ASC) VISIBLE,
  CONSTRAINT `fk_Ensamble_Mueble_Mueble1`
    FOREIGN KEY (`Mueble_Nombre_Mueble`)
    REFERENCES `Practica1`.`Mueble` (`Nombre_Mueble`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ensamble_Mueble_Usuario1`
    FOREIGN KEY (`Usuario_Nombre_Usuario`)
    REFERENCES `Practica1`.`Usuario` (`Nombre_Usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `Practica1`.`CostoPieza` (
  `idCosto` INT NOT NULL AUTO_INCREMENT,
  `Pieza_Nombre_Pieza` VARCHAR(45) NOT NULL,
  `Costo` DOUBLE NULL,
  `Cantidad` INT NULL,
  PRIMARY KEY (`idCosto`),
  INDEX `fk_CostoPieza_Pieza1_idx` (`Pieza_Nombre_Pieza` ASC) VISIBLE,
  CONSTRAINT `fk_CostoPieza_Pieza1`
    FOREIGN KEY (`Pieza_Nombre_Pieza`)
    REFERENCES `Practica1`.`Pieza` (`Nombre_Pieza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO Usuario (Nombre_Usuario, Password, Area) VALUES ('admin','admin',3);
