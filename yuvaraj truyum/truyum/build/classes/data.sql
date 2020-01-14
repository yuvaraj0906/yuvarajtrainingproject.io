/*View Menu Item List Admin*/ 
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('1', 'burger', '300', 'yes', '2020-01-22', 'maincourse', 'yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('2', 'sandwhich', '150', 'no', '2020-01-15', 'starters', 'yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('3', 'french fries', '200', 'yes', '2020-01-14', 'starters', 'yes');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('4', 'pizza', '200', 'yes', '2020-01-13', 'maincourse', 'no');
INSERT INTO `truyum`.`menu_item` (`me_id`, `me_name`, `me_price`, `me_active`, `me_date_of_launch`, `me_category`, `me_free_delivery`) VALUES ('5', 'chocolatebrownie', '350', 'no', '2020-01-12', 'sidedish', 'no');

/*View Menu Item List customer*/
use truyum;
insert into user(us_id, us_name) values (1,'vijay');
insert into user(us_id, us_name) values (2,'ajith');

/*Add to Cart*/
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('101', '1', '1');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('102', '1', '2');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('103', '1', '3');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('104', '2', '3');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('105', '2', '4');
INSERT INTO `truyum`.`cart` (`ct_id`, `ct_us_id`, `ct_pr_id`) VALUES ('106', '2', '5');


/*edit menu item*/
SELECT me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery FROM truyum.menu_item where me_id=1;
UPDATE `truyum`.`menu_item` SET `me_id` = '1', `me_name` = 'sandwhich', `me_price` = '300', `me_active` = 'no', `me_free_delivery` = 'yes';

/*View Menu Item List customer*/
select me_id,me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery from menu_item
where menu_item.me_date_of_launch>'2020-01-03' and me_active='yes';

/*View Cart*/
use truyum;
select menu_item.me_name,menu_item.me_price,menu_item.me_active,menu_item.me_date_of_launch,menu_item.me_category,menu_item.me_free_delivery from cart
inner join menu_item on menu_item.me_id = cart.ct_pr_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=2;

/*View Cart*/
use truyum;
select user.us_id,sum(menu_item.me_price) as me_total from cart
inner join menu_item on menu_item.me_id = cart.ct_pr_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=2;

/*Remove Item from Cart*/
select user.us_id,sum(menu_item.me_price) as me_total from cart
inner join menu_item on menu_item.me_id = cart.ct_pr_id
inner join user on user.us_id=cart.ct_us_id
where user.us_id=2;
delete from cart where ct_us_id='2' and ct_pr_id='4';