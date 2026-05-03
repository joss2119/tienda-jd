-- ---------------------------------------------------------
-- 1. MARCAS (Nueva entidad obligatoria)[cite: 3]
-- ---------------------------------------------------------
INSERT INTO marcas (nombre) VALUES ('Sony Music');       -- ID 1
INSERT INTO marcas (nombre) VALUES ('Columbia Records'); -- ID 2
INSERT INTO marcas (nombre) VALUES ('Columbia');         -- ID 3
INSERT INTO marcas (nombre) VALUES ('Epic');             -- ID 4
INSERT INTO marcas (nombre) VALUES ('Audio-Technica');   -- ID 5
INSERT INTO marcas (nombre) VALUES ('Sony');             -- ID 6
INSERT INTO marcas (nombre) VALUES ('Edifier');          -- ID 7
INSERT INTO marcas (nombre) VALUES ('AM Clean Sound');   -- ID 8
INSERT INTO marcas (nombre) VALUES ('Nagaoka');          -- ID 9
INSERT INTO marcas (nombre) VALUES ('Ortofon');          -- ID 10
INSERT INTO marcas (nombre) VALUES ('Pro-Ject');         -- ID 11
INSERT INTO marcas (nombre) VALUES ('Kallax Design');    -- ID 12
INSERT INTO marcas (nombre) VALUES ('Genérica');         -- ID 13 (Para los productos que no tenían marca)
INSERT INTO marcas (nombre) VALUES ('Marca Fantasma');   -- ID 14 (Cumple: Marca sin productos)[cite: 3]

-- ---------------------------------------------------------
-- 2. CATEGORÍAS
-- ---------------------------------------------------------
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Vinilos', 'Discos de vinilo de todos los géneros musicales, ediciones limitadas y clásicos.', 0, 'categorias/vinilos.avif'); -- ID 1
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Reproductores', 'Tocadiscos, amplificadores y equipos de sonido de alta fidelidad.', 0, 'categorias/tocadiscos.webp'); -- ID 2
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Mantenimiento', 'Kits de limpieza, cepillos antiestáticos y líquidos para el cuidado de tus discos.', 0, 'categorias/mantenimiento.jpg'); -- ID 3
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Accesorios', 'Fundas interiores, carcasas personalizadas y agujas de repuesto.', 0, 'categorias/accesorios.webp'); -- ID 4
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Merchandising', 'Camisetas y tazas (Próximamente)', 0, 'categorias/Imagen_Generica.webp'); -- ID 5 (Cumple: Categorías sin productos)[cite: 3]
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Ediciones de Coleccionista', 'Joyas raras y caras', 0, 'categorias/Imagen_Generica.webp'); -- ID 6 (Cumple: Categorías con un solo producto)[cite: 3]

-- ---------------------------------------------------------
-- 3. PRODUCTOS (Con 'marca_id' y sin 'categoria_id')[cite: 3]
-- ---------------------------------------------------------
-- VINILOS
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233301', 'Pink Floyd - The Dark Side of the Moon', 'Revive el clásico atemporal del rock progresivo... Incluye pósters y pegatinas.', 35.90, 10, 50, 'pink_floyd_dark_side.jpg', 1);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233302', 'Daft Punk - Random Access Memories', 'El último gran hito de la música electrónica... Doble vinilo de alta calidad.', 28.50, 0, 30, 'daft_punk_ram.jpg', 13);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233303', 'Miles Davis - Kind of Blue', 'Considerado por muchos como el mejor álbum de jazz de todos los tiempos...', 25.00, 15, 20, null, 2);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233304', 'Fleetwood Mac - Rumours', 'Uno de los álbumes más vendidos de la historia... Prensaje de calidad.', 22.90, 0, 40, null, 13);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233305', 'Rosalía - Motomami', 'El álbum que rompió esquemas en 2022. Una fusión audaz de géneros.', 32.00, 5, 15, 'rosalia_motomami.jpg', 3);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233306', 'Michael Jackson - Thriller', 'El rey del pop en su máxima expresión. Edición en vinilo estándar.', 20.00, 0, 60, 'mj_thriller.jpg', 4);

-- REPRODUCTORES
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233307', 'Tocadiscos Audio-Technica AT-LP120XUSB', 'Tocadiscos profesional de tracción directa totalmente manual...', 299.00, 20, 10, 'audio_technica_lp120.jpg', 5);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233308', 'Tocadiscos Sony PS-LX310BT', 'Tocadiscos automático con conectividad Bluetooth...', 249.00, 0, 15, null, 6);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233309', 'Amplificador Estéreo Vintage 100W', 'Potente amplificador de diseño retro con carcasa de madera...', 180.00, 5, 5, 'amplificador_vintage.jpg', 13);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233310', 'Altavoces Activos Edifier R1280T', 'Pareja de altavoces de estantería autoamplificados...', 110.00, 10, 25, 'edifier_r1280t.jpg', 7);

-- MANTENIMIENTO
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233311', 'Kit de Limpieza Profesional AM Record Cleaner', 'El kit definitivo para el cuidado de tu colección...', 24.50, 0, 40, 'am_clean_kit.jpg', 8);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233312', 'Cepillo Antiestático de Fibra de Carbono', 'Cepillo básico e indispensable. Sus millones de fibras de carbono...', 12.00, 0, 100, null, 13);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233313', 'Líquido Limpiador de Agujas Audio-Technica AT607a', 'Solución limpiadora específica para agujas de tocadiscos...', 15.90, 0, 30, 'at607a_cleaner.jpg', 5);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233314', 'Rodillo Limpiador de Gel Reutilizable', 'Rodillo de gel adhesivo que atrapa el polvo... Lavable y reutilizable.', 22.00, 15, 20, null, 9);

-- ACCESORIOS
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233315', 'Aguja de Repuesto Ortofon 2M Red', 'La aguja de repuesto para la cápsula de imán móvil más popular...', 55.00, 5, 15, 'ortofon_2mred.jpg', 10);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233316', 'Pack 50 Fundas Interiores Antiestáticas', 'Protege tus discos del polvo y los arañazos con estas fundas interiores...', 18.50, 0, 50, 'fundas_interiores.jpg', 13);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233317', 'Pack 50 Fundas Exteriores Transparentes', 'Mantén las portadas de tus vinilos como el primer día...', 20.00, 10, 60, null, 13);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233318', 'Peso Estabilizador de Discos Record Weight', 'Estabilizador de aluminio de 400 gramos. Reduce las resonancias...', 45.00, 0, 10, 'project_weight.jpg', 11);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233319', 'Mueble Estantería para 100 Vinilos', 'Mueble de madera resistente diseñado específicamente para soportar el peso...', 49.90, 20, 8, null, 12);

INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, marca_id)
VALUES ('8411122233320', 'Caja de Almacenamiento Estilo Flight Case', 'Maleta de transporte robusta con esquinas reforzadas... Capacidad 50 vinilos.', 65.00, 0, 5, 'flight_case_vinilos.jpg', 13);

-- ---------------------------------------------------------
-- 4. RELACIÓN PRODUCTOS-CATEGORÍAS (Tabla N:M)[cite: 3]
-- ---------------------------------------------------------

-- Producto 1 (Pink Floyd) está en Vinilos (1) y Coleccionista (6) -> Cumple: Productos en varias categorías y Categoría con un solo producto[cite: 3]
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (1, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (1, 6);

-- Resto de Vinilos (ID 2 al 6) solo en Categoría 1
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (2, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (3, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (4, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (5, 1);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (6, 1);

-- Reproductores (ID 7 al 10) solo en Categoría 2
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (7, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (8, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (9, 2);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (10, 2);

-- Mantenimiento (ID 11 al 14) solo en Categoría 3
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (11, 3);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (12, 3);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (13, 3);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (14, 3);

-- Accesorios (ID 15 al 19) solo en Categoría 4
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (15, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (16, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (17, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (18, 4);
INSERT INTO producto_categoria (producto_id, categoria_id) VALUES (19, 4);

-- IMPORTANTE: El Producto 20 (Caja Flight Case) NO se inserta en ninguna categoría -> Cumple: Productos en ninguna categoría[cite: 3].