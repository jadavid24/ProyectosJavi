insert into "Tiendas".vex.propietario SELECT  5,'25253030','planet@correo.com','Javier David'
    WHERE
    NOT EXISTS (
        SELECT id_propietario FROM "Tiendas".vex.propietario WHERE id_propietario = 5
    );

insert into "Tiendas".vex.tienda
    SELECT 1,'Bogota','Calle130B#59C-24','Planet Crepe',5
    WHERE
    NOT EXISTS (
        SELECT id_tienda FROM "Tiendas".vex.tienda WHERE id_tienda = 1
    );

insert into "Tiendas".vex.empleados SELECT 15,'Cocinero','Maria Julia',2000000,1
    WHERE
    NOT EXISTS (
        SELECT id_empleado FROM "Tiendas".vex.empleados WHERE id_empleado = 15
    );

insert into "Tiendas".vex.menu SELECT 223,1,'Crepre Italiano',15.000,1
    WHERE
    NOT EXISTS (
        SELECT id_menu FROM "Tiendas".vex.menu WHERE id_menu = 223
    );
insert into "Tiendas".vex.productos SELECT 56,'2022-04-18','2022-05-25','Tomates',1
    WHERE
    NOT EXISTS (
        SELECT id_producto FROM "Tiendas".vex.productos WHERE id_producto = 56
    );