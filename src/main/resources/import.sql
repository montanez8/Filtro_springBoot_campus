-- Insertar datos en la tabla rol
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_USER');

INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$nnOycCfiQLNxIfiCQxQXsO3M0rqSwdcXVsNWhwwKqyHFkJfoYlnoK', true);
INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$2pOJKfdxhKfdu/EH6MnDHuTG7exLS250US0UAxNV70PgtsYOU.f.C', true);

INSERT INTO users_roles (role_id, user_id) VALUES (1, 1);
INSERT INTO users_roles (role_id, user_id) VALUES (2, 2);

INSERT INTO propietario (id, nombre, telefono) VALUES (1, 'Juan Pérez', '1234567890');
INSERT INTO propietario (id, nombre, telefono) VALUES (2, 'María López', '0987654321');
INSERT INTO propietario (id, nombre, telefono) VALUES (3, 'Pedro Rodríguez', '1112223334');
INSERT INTO propietario (id, nombre, telefono) VALUES (4, 'Sara García', '5556667778');
INSERT INTO propietario (id, nombre, telefono) VALUES (5, 'Javier Martínez', '9990001112');


INSERT INTO cliente ( nombre, numero_documento, telefono, email) VALUES ('Ana', '12345678A', '5555555555', 'ana.garcia@example.com');
INSERT INTO cliente (nombre, numero_documento, telefono, email) VALUES ('Carlos', '23456789B', '4444444444', 'carlos.hernandez@example.com');
INSERT INTO cliente (nombre, numero_documento, telefono, email) VALUES ('Laura', '34567890C', '3333333333', 'laura.martinez@example.com');
INSERT INTO cliente (nombre, numero_documento, telefono, email) VALUES ('Pedro', '45678901D', '2222222222', 'pedro.lopez@example.com');
INSERT INTO cliente (nombre, numero_documento, telefono, email) VALUES ('Sara', '56789012E', '1111111111', 'sara.gonzalez@example.com');
INSERT INTO cliente (nombre, numero_documento, telefono, email) VALUES ('Javier', '67890123F', '9999999999', 'javier.martinez@example.com');
INSERT INTO cliente (nombre, numero_documento, telefono, email) VALUES ('Carmen', '78901234G', '8888888888', 'carmen.rodriguez@example.com');
INSERT INTO cliente (nombre, numero_documento, telefono, email) VALUES ('Luis', '89012345H', '7777777777', 'luis.perez@example.com');


INSERT INTO oficina (nombre, direccion, telefono) VALUES ('Oficina Central', 'Calle Principal 123', '666-555-444');
INSERT INTO oficina (nombre, direccion, telefono) VALUES ('Oficina Norte', 'Avenida Central 456', '555-444-333');
INSERT INTO oficina (nombre, direccion, telefono) VALUES ('Oficina Sur', 'Calle Secundaria 789', '444-333-222');
INSERT INTO oficina (nombre, direccion, telefono) VALUES ('Oficina Este', 'Avenida Secundaria 012', '333-222-111');
INSERT INTO oficina (nombre, direccion, telefono) VALUES ('Oficina Oeste', 'Calle Terciaria 345', '222-111-000');


INSERT INTO inmueble ( referencia, superficie, direccion_completa, zona_ciudad, precio_venta, precio_alquiler, oferta, tipo_inmueble, numero_habitaciones, numero_banos, gas_ciudad, puerta_blindada, parquet, tamano_parcela, urbanizacion, propietario_id, oficina_id)VALUES (1001, 80.0, 'Calle Ejemplo 1', 'Centro', 200000.0, 1200.0, 'Venta', 'Piso', 3, 2, true, true, true, NULL, NULL, 1, 1);
INSERT INTO inmueble ( referencia, superficie, direccion_completa, zona_ciudad, precio_venta, precio_alquiler, oferta, tipo_inmueble, numero_habitaciones, numero_banos, gas_ciudad, puerta_blindada, parquet, tamano_parcela, urbanizacion, propietario_id, oficina_id)VALUES (2001, 150.0, 'Avenida Ejemplo 1', 'Norte', 300000.0, 1500.0, 'Alquiler', 'Casa', 4, 3, true, true, false, NULL, NULL, 2, 1);
INSERT INTO inmueble (referencia, superficie, direccion_completa, zona_ciudad, precio_venta, precio_alquiler, oferta, tipo_inmueble, numero_habitaciones, numero_banos, gas_ciudad, puerta_blindada, parquet, tamano_parcela, urbanizacion, propietario_id, oficina_id)VALUES (3001, 300.0, 'Urbanizacion Ejemplo 1', 'Sur', 500000.0, 2500.0, 'Venta', 'Villa', 5, 4, true, true, true, 1000.0, 'Urbanizacion A', 3, 1);



INSERT INTO llave (inmueble_id, oficina_id, disponible)VALUES (1, 1, true);

INSERT INTO visita (fecha_visita, comentario, inmueble_id, cliente_id)VALUES ('2022-12-01', 'Visita satisfactoria', 1, 1);
