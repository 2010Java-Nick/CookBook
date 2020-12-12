/***********************
*DROP Database Tables*
***********************/
drop table "Recipe";
drop table "User";
drop table "Cookbook";
drop table "Cookbook_To_Recipe";
drop table "Authorization";
drop table "User_To_Cookbook";
drop table "Weekly_Cookbook";
/***********************
*Create Database Tables*
***********************/
CREATE TABLE "Recipe" (
  "recipe_id" serial,
  "name" varchar(100) not null,
  "user_id" int4 not null,
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
CREATE TABLE "User" (
  "user_id" serial,
  "username" varchar(30) not null,
  "passphrase" varchar(150) not null,
  "auth" int4,
  "first_name" varchar(50) not null,
  "last_name" varchar(50) not null
);
CREATE TABLE "Cookbook" (
  "cookbook_id" serial,
  "name" varchar(100) not null,
  "user_id" int4,
  "featured" boolean not null,
  "cover_image" bytea
);
CREATE TABLE "Cookbook_To_Recipe" (
  "recipe_id" int4 ,
  "cookbook_id" int4
);
CREATE TABLE "Authorization" (
  "id" int4 primary key,
  "level" varchar(30) not null
);
CREATE TABLE "User_To_Cookbook" (
  "user_id" int4 ,
  "cookbook_id" int4 ,
  "favorite" boolean not null
);
CREATE TABLE "Weekly_Cookbook" (
  "id" serial,
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
/****************************
Add Foriegn Key Constraints
****************************/
ALTER TABLE "User" ADD CONSTRAINT FK_authid
FOREIGN KEY ("auth") REFERENCES "Authorization"("id");

ALTER TABLE "Recipe" ADD CONSTRAINT FK_userid
FOREIGN KEY ("user_id") REFERENCES "User"("user_id");

ALTER TABLE "Cookbook" ADD CONSTRAINT FK_author
FOREIGN KEY ("user_id") REFERENCES "User"("user_id");

ALTER TABLE "User_To_Cookbook" ADD CONSTRAINT FK_userid_cookbook
FOREIGN KEY ("user_id") REFERENCES "User"("user_id");

ALTER TABLE "User_To_Cookbook" ADD CONSTRAINT FK_cookbookid_user_to_cookbook
FOREIGN KEY ("cookbook_id") REFERENCES "Cookbook"("cookbook_id");

ALTER TABLE "Cookbook_To_Recipe" ADD CONSTRAINT FK_recipeid_cookbook_to_recipe
FOREIGN KEY ("recipe_id") REFERENCES "Recipe"("recipe_id");

ALTER TABLE "Cookbook_To_Recipe" ADD CONSTRAINT FK_cookbookid_cookbook_to_recipe
FOREIGN KEY ("cookbook_id") REFERENCES "Cookbook"("cookbook_id");

ALTER TABLE "Weekly_Cookbook" ADD CONSTRAINT FK_weekly_cookbookid
FOREIGN KEY ("cookbook_id") REFERENCES "Cookbook"("cookbook_id");

ALTER TABLE "Weekly_Cookbook" ADD CONSTRAINT FK_weekly_cookbookid_1
FOREIGN KEY ("recipe_1") REFERENCES "Recipe"("recipe_id");
ALTER TABLE "Weekly_Cookbook" ADD CONSTRAINT FK_weekly_cookbookid_2
FOREIGN KEY ("recipe_2") REFERENCES "Recipe"("recipe_id");
ALTER TABLE "Weekly_Cookbook" ADD CONSTRAINT FK_weekly_cookbookid_3
FOREIGN KEY ("recipe_3") REFERENCES "Recipe"("recipe_id");
ALTER TABLE "Weekly_Cookbook" ADD CONSTRAINT FK_weekly_cookbookid_4
FOREIGN KEY ("recipe_4") REFERENCES "Recipe"("recipe_id");
ALTER TABLE "Weekly_Cookbook" ADD CONSTRAINT FK_weekly_cookbookid_5
FOREIGN KEY ("recipe_5") REFERENCES "Recipe"("recipe_id");
ALTER TABLE "Weekly_Cookbook" ADD CONSTRAINT FK_weekly_cookbookid_6
FOREIGN KEY ("recipe_6") references "Recipe"("recipe_id");
ALTER TABLE "Weekly_Cookbook" ADD CONSTRAINT FK_weekly_cookbookid_7
FOREIGN KEY ("recipe_7") REFERENCES "Recipe"("recipe_id");





