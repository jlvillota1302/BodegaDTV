-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 23-11-2015 a las 21:30:50
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `directv`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `clientes`
-- 

CREATE TABLE `clientes` (
  `ibs` varchar(10) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `municipio` varchar(30) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `celular` varchar(15) NOT NULL,
  PRIMARY KEY  (`ibs`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `clientes`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `datos_orden_de_servcio`
-- 

CREATE TABLE `datos_orden_de_servcio` (
  `workorder` varchar(10) NOT NULL,
  `shipingorder` varchar(10) NOT NULL,
  `ibs` varchar(10) NOT NULL,
  `codigoservicio` varchar(10) NOT NULL,
  `Serial` varchar(12) NOT NULL,
  `documento` varchar(12) NOT NULL,
  `numero_orden` varchar(10) NOT NULL,
  PRIMARY KEY  (`workorder`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `datos_orden_de_servcio`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `dispositivos`
-- 

CREATE TABLE `dispositivos` (
  `Serial` varchar(12) NOT NULL,
  `Smartcard` varchar(20) NOT NULL,
  `codigomodelo` varchar(15) NOT NULL,
  PRIMARY KEY  (`Serial`),
  UNIQUE KEY `Smartcard` (`Smartcard`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `dispositivos`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `modelos`
-- 

CREATE TABLE `modelos` (
  `codigomodelo` varchar(15) NOT NULL,
  `ModeloIRD` varchar(15) NOT NULL,
  PRIMARY KEY  (`codigomodelo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `modelos`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `orden_de_servicio`
-- 

CREATE TABLE `orden_de_servicio` (
  `numero_orden` varchar(10) NOT NULL,
  `ibs` varchar(10) NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `documento` varchar(12) NOT NULL,
  PRIMARY KEY  (`numero_orden`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `orden_de_servicio`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `tecnicos`
-- 

CREATE TABLE `tecnicos` (
  `documento` varchar(12) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY  (`documento`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `tecnicos`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `tipos_de_servicio`
-- 

CREATE TABLE `tipos_de_servicio` (
  `codigoservicio` varchar(10) NOT NULL,
  `nombreservicio` varchar(50) NOT NULL,
  PRIMARY KEY  (`codigoservicio`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `tipos_de_servicio`
-- 

