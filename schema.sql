----------------------------------------------------------------------------------------------------
-- Tabla: postulantes
----------------------------------------------------------------------------------------------------

CREATE TABLE postulantes (
    idPostulante NUMBER NOT NULL,
    nombre NVARCHAR2(50) DEFAULT NULL,
    apellido NVARCHAR2(59) DEFAULT NULL,
    rut NVARCHAR2(11) DEFAULT NULL,
    email NVARCHAR2(50) DEFAULT NULL,
    resumen CLOB DEFAULT NULL,

    -- Llave primaria
    CONSTRAINT postulantes_PK PRIMARY KEY (idPostulante)
);

----------------------------------------------------------------------------------------------------
-- Tabla: reclutadores
----------------------------------------------------------------------------------------------------

CREATE TABLE reclutadores (
    idReclutador NUMBER NOT NULL,
    nombreFantasia NVARCHAR2(50) DEFAULT NULL,
    razonSocial NVARCHAR2(50) DEFAULT NULL,
    rut NVARCHAR2(11) DEFAULT NULL,
    email NVARCHAR2(50) DEFAULT NULL,

    -- Llave primaria
    CONSTRAINT reclutadores_PK PRIMARY KEY (idReclutador)
);

----------------------------------------------------------------------------------------------------
-- Tabla: ofertas
----------------------------------------------------------------------------------------------------

CREATE TABLE ofertas (
    idOferta NUMBER NOT NULL,
    fecha DATE DEFAULT NULL,
    titulo NVARCHAR2(50) DEFAULT NULL,
    descripcion CLOB DEFAULT NULL,
    salario NUMBER(15, 2) DEFAULT NULL,
    idReclutador NUMBER NOT NULL,

    -- Llave primaria
    CONSTRAINT ofertas_PK PRIMARY KEY (idOferta),

    -- Llave foránea
    CONSTRAINT ofertas_reclutadores_fk FOREIGN KEY (idReclutador) REFERENCES reclutadores (idReclutador)
);

----------------------------------------------------------------------------------------------------
-- Tabla: postulaciones
----------------------------------------------------------------------------------------------------

CREATE TABLE postulaciones (
    idPostulante NUMBER NOT NULL,
    idOferta NUMBER NOT NULL,
    fecha DATE NOT NULL,

    -- Llaves primarias
    CONSTRAINT postulaciones_pk PRIMARY KEY (idPostulante, idOferta),

    -- Llaves foráneas
    CONSTRAINT postulaciones_postulantes_fk FOREIGN KEY (idPostulante) REFERENCES postulantes (idPostulante),
    CONSTRAINT postulaciones_ofertas_fk FOREIGN KEY (idOferta) REFERENCES ofertas (idOferta)
);
