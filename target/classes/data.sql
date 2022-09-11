insert into public.category (id, name)
values (1, 'parent');

insert into public.product (id, name, price, rating, category_id)
values (1, 'product-1', 50, 5.0, 1);
insert into public.product (id, name, price, rating, category_id)
values (2, 'product-2', 20, 5.0, 1);
insert into public.product (id, name, price, rating, category_id)
values (3, 'product-3', 20, 5.0, 1);
