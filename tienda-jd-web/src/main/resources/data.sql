INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Vinilos', 'Discos de vinilo de todos los géneros musicales, ediciones limitadas y clásicos.', 0, 'vinilos.jpg');
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Reproductores', 'Tocadiscos, amplificadores y equipos de sonido de alta fidelidad.', 0, 'reproductores.jpg');
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Mantenimiento', 'Kits de limpieza, cepillos antiestáticos y líquidos para el cuidado de tus discos.', 0, 'mantenimiento.jpg');
INSERT INTO categorias (nombre, descripcion, minimo, imagen) VALUES ('Accesorios', 'Fundas interiores, carcasas personalizadas y agujas de repuesto.', 0, null);

-- ---------------------------------------------------------
-- PRODUCTOS: Vinilos (ID Categoría 1)
-- ---------------------------------------------------------
-- Con marca e imagen (Descripción larga)
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233301', 'Pink Floyd - The Dark Side of the Moon (Edición 50 Aniversario)', 'Sony Music', 'Revive el clásico atemporal del rock progresivo en esta edición remasterizada por el 50 aniversario. El vinilo de 180 gramos ofrece una fidelidad de audio inigualable, capturando cada matiz de los sintetizadores, las guitarras de Gilmour y las icónicas transiciones experimentales. Incluye pósters y pegatinas originales en una cubierta gatefold de lujo.', 35.90, 10, 50, 'pink_floyd_dark_side.jpg', 1);

-- Sin marca, con imagen
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233302', 'Daft Punk - Random Access Memories', 'El último gran hito de la música electrónica. Un viaje analógico y orgánico que redefinió el género con colaboraciones legendarias como Giorgio Moroder y Pharrell Williams. Doble vinilo de alta calidad para disfrutar de la calidez de sus bajos.', 28.50, 0, 30, 'daft_punk_ram.jpg', 1);

-- Con marca, sin imagen (Descripción larga)
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, categoria_id)
VALUES ('8411122233303', 'Miles Davis - Kind of Blue', 'Columbia Records', 'Considerado por muchos como el mejor álbum de jazz de todos los tiempos. Esta obra maestra del jazz modal, grabada en 1959, reúne a gigantes como John Coltrane y Bill Evans. La pureza del sonido en esta reedición analógica te transportará directamente al estudio de grabación. Indispensable en cualquier colección seria.', 25.00, 15, 20, 1);

-- Sin marca, sin imagen
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, categoria_id)
VALUES ('8411122233304', 'Fleetwood Mac - Rumours', 'Uno de los álbumes más vendidos de la historia, lleno de himnos pop-rock nacidos de la tensión y el talento desbordante de la banda. Canciones inolvidables en un prensaje de calidad.', 22.90, 0, 40, 1);

-- Más vinilos variados...
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233305', 'Rosalía - Motomami', 'Columbia', 'El álbum que rompió esquemas en 2022. Una fusión audaz de géneros en un vinilo rojo transparente exclusivo.', 32.00, 5, 15, 'rosalia_motomami.jpg', 1);

INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233306', 'Michael Jackson - Thriller', 'Epic', 'El rey del pop en su máxima expresión. Edición en vinilo estándar con el tracklist original que definió la década de los 80.', 20.00, 0, 60, 'mj_thriller.jpg', 1);


-- ---------------------------------------------------------
-- PRODUCTOS: Reproductores (ID Categoría 2)
-- ---------------------------------------------------------
-- Con marca e imagen (Descripción larga)
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233307', 'Tocadiscos Audio-Technica AT-LP120XUSB', 'Audio-Technica', 'Tocadiscos profesional de tracción directa totalmente manual. Diseñado para ofrecer una calidad de sonido excepcional tanto para audiófilos como para DJs. Cuenta con un motor de alto par, control de pitch ajustable, preamplificador fono incorporado y salida USB para digitalizar tus vinilos directamente al ordenador. Su robusta base minimiza las vibraciones no deseadas.', 299.00, 20, 10, 'audio_technica_lp120.jpg', 2);

-- Con marca, sin imagen
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, categoria_id)
VALUES ('8411122233308', 'Tocadiscos Sony PS-LX310BT', 'Sony', 'Tocadiscos automático con conectividad Bluetooth. Escucha tus vinilos de forma inalámbrica en tus altavoces o auriculares favoritos con la máxima comodidad. Diseño elegante y minimalista.', 249.00, 0, 15, 2);

-- Sin marca, con imagen
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233309', 'Amplificador Estéreo Vintage 100W', 'Potente amplificador de diseño retro con carcasa de madera. Ofrece 100W de potencia pura, ecualizador analógico de 3 bandas y entrada Phono dedicada para sacar el máximo partido a tu tocadiscos.', 180.00, 5, 5, 'amplificador_vintage.jpg', 2);

-- Con marca e imagen
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233310', 'Altavoces Activos Edifier R1280T', 'Edifier', 'Pareja de altavoces de estantería autoamplificados. Con su acabado en madera y sonido equilibrado, son el complemento perfecto y económico para cualquier tocadiscos con salida de línea.', 110.00, 10, 25, 'edifier_r1280t.jpg', 2);


-- ---------------------------------------------------------
-- PRODUCTOS: Mantenimiento (ID Categoría 3)
-- ---------------------------------------------------------
-- Con marca e imagen (Descripción larga)
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233311', 'Kit de Limpieza Profesional AM Record Cleaner', 'AM Clean Sound', 'El kit definitivo para el cuidado de tu colección. Incluye una solución limpiadora sin alcohol que disuelve la grasa y la suciedad incrustada sin dañar los surcos, un paño de microfibra ultrasuave para el secado y un cepillo de terciopelo para la limpieza profunda en húmedo. Mantener tus discos limpios prolonga la vida de tu aguja y mejora drásticamente la calidad del sonido.', 24.50, 0, 40, 'am_clean_kit.jpg', 3);

-- Sin marca, sin imagen
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, categoria_id)
VALUES ('8411122233312', 'Cepillo Antiestático de Fibra de Carbono', 'Cepillo básico e indispensable. Sus millones de fibras de carbono descargan la electricidad estática del vinilo antes de la reproducción, atrayendo el polvo superficial y evitando crujidos.', 12.00, 0, 100, 3);

-- Con marca e imagen
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233313', 'Líquido Limpiador de Agujas Audio-Technica AT607a', 'Audio-Technica', 'Solución limpiadora específica para agujas de tocadiscos. Incluye un pincel aplicador en la tapa para eliminar de forma segura el polvo y los residuos adheridos al diamante.', 15.90, 0, 30, 'at607a_cleaner.jpg', 3);

-- Con marca, sin imagen
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, categoria_id)
VALUES ('8411122233314', 'Rodillo Limpiador de Gel Reutilizable', 'Nagaoka', 'Rodillo de gel adhesivo que atrapa el polvo de la superficie del vinilo con solo pasarlo suavemente. Lavable y reutilizable durante años.', 22.00, 15, 20, 3);


-- ---------------------------------------------------------
-- PRODUCTOS: Accesorios (ID Categoría 4)
-- ---------------------------------------------------------
-- Con marca e imagen (Descripción larga)
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233315', 'Aguja de Repuesto Ortofon 2M Red', 'Ortofon', 'La aguja de repuesto para la cápsula de imán móvil (MM) más popular del mercado. La 2M Red ofrece un sonido abierto, dinámico y con un ligero toque de calidez que hace que cualquier género musical brille. Su punta de diamante elíptico garantiza un seguimiento preciso del surco, reduciendo el desgaste del disco y proporcionando una excelente separación de canales.', 55.00, 5, 15, 'ortofon_2mred.jpg', 4);

-- Sin marca, con imagen
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233316', 'Pack 50 Fundas Interiores Antiestáticas', 'Protege tus discos del polvo y los arañazos con estas fundas interiores de papel con revestimiento plástico antiestático. Superiores a las fundas de papel estándar.', 18.50, 0, 50, 'fundas_interiores.jpg', 4);

-- Sin marca, sin imagen (Descripción larga)
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, categoria_id)
VALUES ('8411122233317', 'Pack 50 Fundas Exteriores Transparentes de Alta Densidad', 'Mantén las portadas de tus vinilos como el primer día. Fabricadas en polietileno de alta densidad (3 milímetros de grosor), estas fundas exteriores previenen el desgaste de los bordes, la decoloración por rayos UV y protegen contra la humedad y el polvo ambiental.', 20.00, 10, 60, 4);

-- Con marca, con imagen
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233318', 'Peso Estabilizador de Discos Record Weight', 'Pro-Ject', 'Estabilizador de aluminio de 400 gramos. Reduce las resonancias, mejora el acoplamiento del disco al plato y ayuda a reproducir vinilos ligeramente deformados con mayor precisión.', 45.00, 0, 10, 'project_weight.jpg', 4);

-- Con marca, sin imagen
INSERT INTO productos (codigo, nombre, marca, descripcion, precio, descuento, stock, categoria_id)
VALUES ('8411122233319', 'Mueble Estantería para 100 Vinilos', 'Kallax Design', 'Mueble de madera resistente diseñado específicamente para soportar el peso de hasta 100 discos de vinilo. Diseño modular ampliable.', 49.90, 20, 8, 4);

-- Sin marca, con imagen
INSERT INTO productos (codigo, nombre, descripcion, precio, descuento, stock, imagen, categoria_id)
VALUES ('8411122233320', 'Caja de Almacenamiento Estilo Flight Case', 'Maleta de transporte robusta con esquinas reforzadas de aluminio y acolchado interior. Capacidad para 50 vinilos. Ideal para DJs o para proteger tus joyas más preciadas.', 65.00, 0, 5, 'flight_case_vinilos.jpg', 4);