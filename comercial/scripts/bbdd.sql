CREATE TABLE `clientes` (
	`idCliente` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NULL,
	`apellidos` VARCHAR(100) NULL,
	`poblacion` VARCHAR(50) NULL,
	`telefono` VARCHAR(50) NULL,
	`mail` VARCHAR(50) NULL,
	`descripcion` VARCHAR(200) NULL,
	`esPrescriptor` CHAR(1) NULL,
	`fechaAlta` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`idCliente`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;


CREATE TABLE `propiedades` (
	`idPropiedad` INT NOT NULL AUTO_INCREMENT,
	`propiedad` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`idPropiedad`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB;



