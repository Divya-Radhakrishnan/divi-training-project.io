/* VIEW MOVIE LIST ADMIN */
INSERT INTO `movie_crusier`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_gener`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787846097', 'yes', '2017-03-15', 'Science Fiction', 'yes');
INSERT INTO `movie_crusier`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_gener`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '2678085654', 'yes', '2017-12-23', 'Superhero', 'no');
INSERT INTO `movie_crusier`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_gener`, `mo_has_teaser`) VALUES ('3', 'Titanic', '1754097450', 'yes', '2017-08-21', 'Romance', 'no');
INSERT INTO `movie_crusier`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_gener`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '2862094672', 'no', '2017-07-02', 'Science Fiction', 'yes');
INSERT INTO `movie_crusier`.`movie_list` (`mo_id`, `mo_title`, `mo_gross`, `mo_active`, `mo_date_of_launch`, `mo_gener`, `mo_has_teaser`) VALUES ('5', 'Avengers:End Game', '2678836673', 'yes', '2022-11-02', 'Superhero', 'yes');

/* VIEW MOVIE LIST CUSTOMER */
use movie_crusier;
INSERT INTO `movie_crusier`.`user` (`us_id`, `us_name`) VALUES ('1', 'Vijay');
INSERT INTO `movie_crusier`.`user` (`us_id`, `us_name`) VALUES ('2', 'Ajith');
 
/* VIEW MOVIE LIST CUSTOMER */
select mo_id, mo_title, mo_active,mo_gross, mo_date_of_launch,mo_gener, mo_has_teaser from movie_crusier.movie_list
where movie_list.mo_date_of_launch>'2020-01-03' and mo_active='Yes'; 

/* EDIT MOVIE LIST*/
SELECT * FROM movie_crusier.movie_list where mo_id=1;
UPDATE `movie_crusier`.`movie_list` SET `mo_id` = '4', `mo_title` = 'Jo & the boy', `mo_gross` = '3345609845', `mo_active` = 'Yes', `mo_date_of_launch` = '2022-10-03', `mo_gener` = 'Science Fiction', `mo_has_teaser` = 'Yes' WHERE (`mo_id` = '4');


/* VIEW FAVOURITES*/
SELECT movie_list.mo_title,movie_list.mo_has_teaser,movie_list.mo_gross from favourites
inner join movie_list on movie_list.mo_id=favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;

/* ADD TO FAVOURITES*/
INSERT INTO `movie_crusier`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('1', '1');
INSERT INTO `movie_crusier`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('1', '2');
INSERT INTO `movie_crusier`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('1', '3');
INSERT INTO `movie_crusier`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('2', '3');
INSERT INTO `movie_crusier`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('2', '4');
INSERT INTO `movie_crusier`.`favourites` (`fv_us_id`, `fv_gr_id`) VALUES ('2', '5');


/* VIEW FAVOURITES*/
SELECT user.us_id,count (*) as mo_fav from favourites
inner join movie_list on movie_list.mo_id=favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;

/* REMOVE FAVOURITES*/
SELECT movie_list.mo_title,movie_list.mo_has_teaser,movie_list.mo_gross from favourites
inner join movie_list on movie_list.mo_id=favourites.fv_gr_id
inner join user on user.us_id=favourites.fv_us_id
where user.us_id=2;
delete from movie_crusier.favourites where fv_us_id=2 and fv_gr_id=3; 