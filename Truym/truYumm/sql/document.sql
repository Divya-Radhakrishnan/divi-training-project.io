/* VIEW MENUITEM LIST ADMIN */
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'sandwich', '300', 'no', '2020-01-22', 'maincourse', 'yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'french fries', '150', 'no', '2020-01-15', 'starters', 'yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'pizza', '200', 'yes', '2020-01-14', 'maincourse', 'no');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'chocolate brownie', '350', 'no', '2020-01-12', 'side dish', 'no');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'ice cream ', '340', 'yes', '2020-01-13', 'dessert', 'yes');

/* VIEW MENUITEM LIST CUSTOMER */
use truyum;
insert into user(us_id,us_name) values (1,'Vijay');
insert into user(us_id,us_name) values(2,'Ajith');

/* VIEW MENUITEM LIST CUSTOMER */
select me_id,me_name,me_price,me_active, me_date_of_lauch,me_category, me_free_delivery from truyum.menu_item
where menu_item.me_date_of_launch>'2020-01-03' and me_active='Yes';

/* EDIT MENUITEM LIST*/
select me_id,me_name,me_price,me_active, me_date_of_lauch,me_category, me_free_delivery from truyum.menu_item where me_id=1;
UPDATE `truyum`.`menu_item` SET `me_id` = '6', `me_name` = 'Ice Cream', `me_price` = '345', `me_active` = 'Yes', `me_date_of_launch` = '2022-10-03', `me_category` = 'Maincourse', `me_free_delivery` = 'Yes' WHERE (`me_id` = '6');

/* VIEW CART*/
SELECT menu_item.me_name,menu_item.me_free_delivery,menu_item.me_price from cart
inner join menu_item on menu_item.me_id=cart.ct_pr_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=2;

/* ADD TO CART*/
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('101', '1', '1');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('102', '1', '2');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('103', '1', '3');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('104', '2', '3');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('105', '2', '4');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('106', '2', '5');

/* VIEW CART*/
SELECT user.us_id,sum(menu_item.me_price) as me_total from cart
inner join menu_item on menu_item.me_id=cart.ct_pr_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=2;

/* REMOVE ITEM FROM CART*/
SELECT menu_item.me_name,menu_item.me_free_delivery,menu_item.me_price from cart
inner join menu_item on menu_item.me_id=cart.ct_pr_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=2;
delete from truyum.cart where ct_us_id=2 and ct_pr_id=3; 

