/* 	View Movie Admin */
INSERT INTO `moviecruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'avatar', '29877979', 'yes', '2020-01-26', 'science fiction', 'yes');
INSERT INTO `moviecruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'the avengers', '25636878', 'yes', '2020-01-12', 'super hero', 'yes');
INSERT INTO `moviecruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'titanic', '26576463', 'no', '2020-01-15', 'romantic', 'no');
INSERT INTO `moviecruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'jurassic world', '25777378', 'no', '2020-01-13', 'adventure', 'yes');
INSERT INTO `moviecruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'avengers', '25536563', 'yes', '2020-01-26', 'superhero', 'no');

/*View Movie List Customer*/
use moviecruiser;
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'vinoth');
INSERT INTO `moviecruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'saran');

/*View Movie List Customer*/
SELECT mo_id,mo_title,mo_gross,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser FROM moviecruiser.movie_list
where movie_list.mo_date_of_launch>'2020-01-03' and mo_active='yes';

/*Edit Movie list*/
SELECT mo_id,mo_title,mo_gross,mo_active,mo_date_of_launch,mo_genre,mo_has_teaser FROM moviecruiser.movie_list WHERE (`mo_id` = '1');
UPDATE `moviecruiser`.`movie_list` SET `mo_id` = '1', `mo_title` = 'tenet', `mo_gross` = '300', `mo_active` = 'no',`mo_genre`='sciencefiction';

/*Add to Favourites*/
INSERT INTO `moviecruiser`.`favourites` (`fv_id`, `fv_us_id`, `fv_gr_id`) VALUES ('101', '1', '1');
INSERT INTO `moviecruiser`.`favourites` (`fv_id`, `fv_us_id`, `fv_gr_id`) VALUES ('102', '1', '2');
INSERT INTO `moviecruiser`.`favourites` (`fv_id`, `fv_us_id`, `fv_gr_id`) VALUES ('103', '1', '3');
INSERT INTO `moviecruiser`.`favourites` (`fv_id`, `fv_us_id`, `fv_gr_id`) VALUES ('104', '2', '3');
INSERT INTO `moviecruiser`.`favourites` (`fv_id`, `fv_us_id`, `fv_gr_id`) VALUES ('105', '2', '4');
INSERT INTO `moviecruiser`.`favourites` (`fv_id`, `fv_us_id`, `fv_gr_id`) VALUES ('106', '2', '5');

/*View Cart*/
use moviecruiser;
select movie_list.mo_title,movie_list.mo_gross,movie_list.mo_active,movie_list.mo_date_of_launch,movie_list.mo_genre,movie_list.mo_has_teaser from favourites
inner join movie_list on movie_list.mo_id = favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;

/*View Cart*/
use moviecruiser;
select user.us_id,count(movie_list.mo_id) as mo_totalfavourites from favourites
inner join movie_list on movie_list.mo_id = favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;

/*remove cart*/
select movie_list.mo_title,movie_list.mo_has_teaser,movie_list.mo_gross from favourites
inner join movie_list on movie_list.mo_id = favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;
delete from moviecruiser.favourites where fv_us_id='2' and fv_gr_id='4';