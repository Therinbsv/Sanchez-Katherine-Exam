-- database: ../DataBase/KSAQQ.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
|----------------------------------------|
Autor : Katherine Sanchez 
Fecha : 
Script: Insertar datos
*/


INSERT INTO SKCatalogoUb
(SKNrCategoria,     SKLugar                             ) VALUES
('1',               'Ecuador'                           ), --Pais

('2',               'Insular'                           ), --Region
('2',               'Costa'                             ), 
('2',               'Sierra'                            ), 
('2',               'Amazonia'                          ), 

('3',               'Galápagos'                         ), --Privincia Insular
('3',               'Esmeraldas'                        ), --Privincia Costa
('3',               'Manabí'                            ), 
('3',               'Santo Domingo de los Tsáchilas:'   ), 
('3',               'Los Ríos'                          ), 
('3',               'Guayas'                            ), 
('3',               'Santa Elena'                       ), 
('3',               'El Oro'                            ), 
('3',               'Carchi'                            ), --Privincia Sierra
('3',               'Imbabura'                          ), 
('3',               'Pichincha'                         ), 
('3',               'Cotopaxi'                          ), 
('3',               'Tungurahua'                        ), 
('3',               'Bolívar'                           ), 
('3',               'Chimborazo'                        ), 
('3',               'Cañar'                             ), 
('3',               'Azuay'                             ), 
('3',               'Loja'                              ), 
('3',               'Sucumbíos'                         ), --Privincia Amazonia
('3',               'Napo'                              ), 
('3',               'Orellana'                          ), 
('3',               'Pastaza'                           ), 
('3',               'Morona Santiago'                   ), 
('3',               'Zamora Chinchipe'                  );

INSERT INTO SKIngestaNativa
(SKClasificacion,       SKDescripcion                           ) VALUES
('Carnívoro',           'Animal se alimenta de carne'           ), --1
('Herbívoro',           'Animal se alimenta de plantas'         ), --2
('Omnívoro',            'Animal se alimenta de plantas y carne' ), --3
('Insectívoros',        'Animal se alimenta de insectos'        ); --4

INSERT INTO SKSexoHormiga
(SKSexo     ) VALUES
('Macho'    ), --1
('Hembra'   ), --2
('Asexual'  ); --3

INSERT INTO SKGenoAlimento
(SKGenoAlimento     ) VALUES
('AX'               ), --1
('AXX'              ), --2
('AXY'              ); --3

INSERT INTO SKHormiguero
(SKTipoHormiga, idSKSexoHormiga, idSKIngestaNativa, idSKGenoAlimento, idSKCatalogoUb) VALUES
('Larva', '3', '2', '1', '6');
