-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-07-2019 a las 21:54:46
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `storypetbasededatos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `correo`
--

CREATE TABLE `correo` (
  `IdCorreo` int(11) NOT NULL,
  `Destinatario` varchar(100) NOT NULL,
  `Asunto` varchar(100) NOT NULL,
  `Mensaje` text NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `correo`
--

INSERT INTO `correo` (`IdCorreo`, `Destinatario`, `Asunto`, `Mensaje`, `Fecha`) VALUES
(2, 'eicalderon@misena.edu.co', 'pruebaSabado', '123', '2019-06-29 23:46:15'),
(3, 'eicalderon@misena.edu.co', 'pruebaDomingo', '456', '2019-07-01 00:41:17'),
(4, 'eicalderon@misena.edu.co', 'PruebaLunes', '2do formulario', '2019-07-01 18:38:04');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especies`
--

CREATE TABLE `especies` (
  `Especie` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `especies`
--

INSERT INTO `especies` (`Especie`, `Nombre`) VALUES
(1, 'Canino'),
(2, 'Felino'),
(3, 'Ave');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historialclinico`
--

CREATE TABLE `historialclinico` (
  `IdHistorialClinico` int(11) NOT NULL,
  `Fecha` date DEFAULT NULL,
  `Novedad` varchar(150) NOT NULL,
  `FKServicio` int(11) NOT NULL,
  `FKMascota` int(11) NOT NULL,
  `FKUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `historialclinico`
--

INSERT INTO `historialclinico` (`IdHistorialClinico`, `Fecha`, `Novedad`, `FKServicio`, `FKMascota`, `FKUsuario`) VALUES
(1, '2019-06-25', 'Se realizo una consulta a la mascota max', 2, 11, 1019123857),
(4, '2019-07-01', 'Consulta sobre sintomas', 2, 9, 1019123857),
(5, '2019-07-01', 'Corte de pelo', 1, 1, 1019123857);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mascotas`
--

CREATE TABLE `mascotas` (
  `IdMascota` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `Sexo` char(1) NOT NULL,
  `fkEspecies` int(11) NOT NULL,
  `FKRaza` int(11) NOT NULL,
  `FKUsuario` int(11) NOT NULL,
  `Estado` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `mascotas`
--

INSERT INTO `mascotas` (`IdMascota`, `Nombre`, `FechaNacimiento`, `Sexo`, `fkEspecies`, `FKRaza`, `FKUsuario`, `Estado`) VALUES
(1, 'Luna', '2019-01-08', 'H', 1, 1, 1001270449, 1),
(7, 'Kira', '2019-02-07', 'H', 1, 2, 1001270449, 1),
(8, 'Jordan', '2019-01-10', 'M', 1, 7, 1001270449, 1),
(9, 'Junior', '2019-02-02', 'M', 1, 8, 1001270449, 1),
(11, 'Max', '2019-03-08', 'M', 1, 2, 1001270449, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `razas`
--

CREATE TABLE `razas` (
  `Id` int(11) NOT NULL,
  `Raza` varchar(45) NOT NULL,
  `Especie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `razas`
--

INSERT INTO `razas` (`Id`, `Raza`, `Especie`) VALUES
(1, 'Labrador', 1),
(2, 'Pitbull', 1),
(3, 'Siamés', 2),
(4, 'Persa', 2),
(5, 'Canario', 3),
(6, 'Perico', 3),
(7, 'Bulldog', 1),
(8, 'Pastor alemán', 1),
(9, 'Azul Ruso', 2),
(10, 'RagDoll', 2),
(13, 'Cotorra ', 3),
(14, 'Loro', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `IdServicio` int(11) NOT NULL,
  `Servicio` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`IdServicio`, `Servicio`) VALUES
(1, 'Estetico'),
(2, 'Consulta'),
(3, 'Control '),
(4, 'Diagnostico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `IdUsuario` int(11) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Contraseña` varchar(45) NOT NULL,
  `Nombres` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Telefono` varchar(11) NOT NULL,
  `Correo` varchar(45) NOT NULL,
  `Rol` enum('admin','veterinario','cliente') NOT NULL,
  `Estado` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`IdUsuario`, `Usuario`, `Contraseña`, `Nombres`, `Apellidos`, `Telefono`, `Correo`, `Rol`, `Estado`) VALUES
(101008353, 'Juan', '123456', 'Juan Manuel', 'Isaza', '302546464', 'juan@hotmail.com', 'cliente', 1),
(1001270449, 'cliente gene', '123', ' gene', ' gene', '7725234', 'gene@general.com', 'cliente', 1),
(1001270769, 'Admin Brayan', '85438132', 'Brayan David', 'Zúñiga Arrieta', '3053666564', 'bri@hotmail.com', 'admin', 1),
(1001270799, 'prueba', '123456', 'prueba', 'prueba', '4252347', 'prueba@gmail.com', 'cliente', 1),
(1001290766, 'Vet Johan Nico', '123456', 'Johan Nicolas', 'molina escobar', '4252324', 'jhoan@gmail.com', 'veterinario', 0),
(1019113647, 'ClienteIvan', 'I24204', 'Ivan', 'Gutierrez', '3103146486', 'eicalderon@misena.edu.co', 'cliente', 1),
(1019113648, 'Cliente Daniel', '123', 'Francisco', 'Cely', '31054564', 'fdcely8@misena.edu.co', 'cliente', 0),
(1019123857, 'Veterinario Ivan1', '123456789', 'Edwin Ivan', 'Calderon', '1234567', 'ei@ei.com', 'veterinario', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `correo`
--
ALTER TABLE `correo`
  ADD PRIMARY KEY (`IdCorreo`);

--
-- Indices de la tabla `especies`
--
ALTER TABLE `especies`
  ADD PRIMARY KEY (`Especie`);

--
-- Indices de la tabla `historialclinico`
--
ALTER TABLE `historialclinico`
  ADD PRIMARY KEY (`IdHistorialClinico`),
  ADD KEY `FKServicio` (`FKServicio`),
  ADD KEY `FKMascota` (`FKMascota`),
  ADD KEY `FKUsuario` (`FKUsuario`);

--
-- Indices de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD PRIMARY KEY (`IdMascota`),
  ADD KEY `FKRaza` (`FKRaza`),
  ADD KEY `FKUsuario` (`FKUsuario`),
  ADD KEY `fkEspecies` (`fkEspecies`);

--
-- Indices de la tabla `razas`
--
ALTER TABLE `razas`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FKEspecie` (`Especie`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`IdServicio`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`IdUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `correo`
--
ALTER TABLE `correo`
  MODIFY `IdCorreo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `especies`
--
ALTER TABLE `especies`
  MODIFY `Especie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `historialclinico`
--
ALTER TABLE `historialclinico`
  MODIFY `IdHistorialClinico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `mascotas`
--
ALTER TABLE `mascotas`
  MODIFY `IdMascota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `razas`
--
ALTER TABLE `razas`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `IdServicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `historialclinico`
--
ALTER TABLE `historialclinico`
  ADD CONSTRAINT `historialclinico_ibfk_1` FOREIGN KEY (`FKServicio`) REFERENCES `servicios` (`IdServicio`),
  ADD CONSTRAINT `historialclinico_ibfk_2` FOREIGN KEY (`FKMascota`) REFERENCES `mascotas` (`IdMascota`),
  ADD CONSTRAINT `historialclinico_ibfk_3` FOREIGN KEY (`FKUsuario`) REFERENCES `usuarios` (`IdUsuario`);

--
-- Filtros para la tabla `mascotas`
--
ALTER TABLE `mascotas`
  ADD CONSTRAINT `mascotas_ibfk_1` FOREIGN KEY (`FKRaza`) REFERENCES `razas` (`Id`),
  ADD CONSTRAINT `mascotas_ibfk_2` FOREIGN KEY (`FKUsuario`) REFERENCES `usuarios` (`IdUsuario`),
  ADD CONSTRAINT `mascotas_ibfk_3` FOREIGN KEY (`fkEspecies`) REFERENCES `especies` (`Especie`);

--
-- Filtros para la tabla `razas`
--
ALTER TABLE `razas`
  ADD CONSTRAINT `razas_ibfk_1` FOREIGN KEY (`Especie`) REFERENCES `especies` (`Especie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
