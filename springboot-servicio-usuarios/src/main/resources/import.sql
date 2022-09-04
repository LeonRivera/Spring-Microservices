INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('leon', '$2a$10$aRMrPfaHIYTpA7o3SGs.kuQlwVtqPeGdbsfHHI88ARBj4yPVLCuRi',true,'leon', 'sadasd', 'leon@bolsaideas.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('admin', '$2a$10$SXgrv3Ya.mmnYBOmexlbgu5mc2q/WLuLHSaOKReUPX8hgocldCo8C',true, 'Jhon', 'Doe', 'jhon.doe@bolsaideas.com');

INSERT INTO roles (nombre) VALUES('ROLE_USER');
INSERT INTO roles (nombre) VALUES('ROLE_ADMIN');
 
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES(1,1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES(2,2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES(2,1);