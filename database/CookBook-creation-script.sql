--DROP TABLE weekly_cookbook;
--DROP TABLE user_to_cookbook;
--DROP TABLE cookbook_to_recipe;
--DROP TABLE cookbook;
--DROP TABLE recipe;
--DROP TABLE user_profile;
--DROP TABLE auth;

CREATE TABLE recipe (
  "id" serial primary key,
  "name" varchar(100) not null,
  "author" int4 not null,
  "featured" boolean not null,
  "servings" int4,
  "prep_time" int4 not null,
  "cook_time" int4 not null,
  "steps" text not null,
  "tags" text,
  "ingredients" text not null,
  "description" text not null,
  "recipe_image" bytea
);

CREATE TABLE user_profile (
  "id" serial primary key,
  "username" varchar(30) not null,
  "passphrase" varchar(150) not null,
  "auth" int4,
  "first_name" varchar(50) not null,
  "last_name" varchar(50) not null
);

CREATE TABLE cookbook (
  "id" serial primary key,
  "name" varchar(100) not null,
  "author" int4,
  "featured" boolean not null,
  "cover_image" bytea
);

CREATE TABLE cookbook_to_recipe (
  "recipe_id" int4 ,
  "cookbook_id" int4,
  PRIMARY KEY(recipe_id, cookbook_id)
);

CREATE TABLE auth (
  "id" int4 primary key,
  "level" varchar(30) not null
);

CREATE TABLE user_to_cookbook (
  "user_id" int4 ,
  "cookbook_id" int4 ,
  "favorite" boolean not null,
  PRIMARY KEY(user_id, cookbook_id)
);

CREATE TABLE weekly_cookbook (
  "id" serial primary key,
  "cookbook_id" int4,
  "curation_date" date not null,
  "recipe_1" int4,
  "recipe_2" int4,
  "recipe_3" int4,
  "recipe_4" int4,
  "recipe_5" int4,
  "recipe_6" int4,
  "recipe_7" int4
);

ALTER TABLE recipe ADD CONSTRAINT FK_user
FOREIGN KEY (author) REFERENCES user_profile (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE cookbook_to_recipe ADD CONSTRAINT FK_many_to_cookbook
FOREIGN KEY (cookbook_id) REFERENCES cookbook (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE cookbook_to_recipe ADD CONSTRAINT FK_many_to_recipe
FOREIGN KEY (recipe_id) REFERENCES recipe (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_profile ADD CONSTRAINT FK_authorization
FOREIGN KEY (auth) REFERENCES auth (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE cookbook ADD CONSTRAINT FK_user
FOREIGN KEY (author) REFERENCES user_profile (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_to_cookbook ADD CONSTRAINT FK_user
FOREIGN KEY (user_id) REFERENCES user_profile (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE user_to_cookbook ADD CONSTRAINT FK_cookbook
FOREIGN KEY (cookbook_id) REFERENCES cookbook (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weekly_cookbook ADD CONSTRAINT FK_cookbook
FOREIGN KEY (cookbook_id) REFERENCES cookbook (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weekly_cookbook ADD CONSTRAINT FK_weekly_recipe_1
FOREIGN KEY (recipe_1) REFERENCES recipe (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weekly_cookbook ADD CONSTRAINT FK_weekly_recipe_2
FOREIGN KEY (recipe_2) REFERENCES recipe (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weekly_cookbook ADD CONSTRAINT FK_weekly_recipe_3
FOREIGN KEY (recipe_3) REFERENCES recipe (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weekly_cookbook ADD CONSTRAINT FK_weekly_recipe_4
FOREIGN KEY (recipe_4) REFERENCES recipe (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weekly_cookbook ADD CONSTRAINT FK_weekly_recipe_5
FOREIGN KEY (recipe_5) REFERENCES recipe (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weekly_cookbook ADD CONSTRAINT FK_weekly_recipe_6
FOREIGN KEY (recipe_6) REFERENCES recipe (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE weekly_cookbook ADD CONSTRAINT FK_weekly_recipe_7
FOREIGN KEY (recipe_7) REFERENCES recipe (id) 
ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO auth VALUES (1, 'STANDARD');
INSERT INTO auth VALUES (2, 'AFFILIATED');
INSERT INTO auth VALUES (3, 'MODERATOR');
