-- Insertar datos en la tabla rol
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_DIRECTOR');
INSERT INTO roles (name) VALUES ('ROLE_AUXILIAR');

INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$nnOycCfiQLNxIfiCQxQXsO3M0rqSwdcXVsNWhwwKqyHFkJfoYlnoK', true);
INSERT INTO users (username, password, enabled) VALUES ('director', '$2a$10$Js9RxyNCIJncEfMlrL2Efu0IyQAtSIjZJ2jB2FytDb.q/w9EcUjQ2', true);
INSERT INTO users (username, password, enabled) VALUES ('auxiliar', '$2a$10$SxmmQXaWhtOp2jQdMpiEX.r7IRbu66KyEYmmgtFse1fJUmURNZHCe', true);

INSERT INTO users_roles (role_id, user_id) VALUES (1, 1);
INSERT INTO users_roles (role_id, user_id) VALUES (2, 2);
INSERT INTO users_roles (role_id, user_id) VALUES (3, 3);
