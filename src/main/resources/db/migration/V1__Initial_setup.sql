CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE meal (
  meal_id text PRIMARY KEY DEFAULT uuid_generate_v4(),
  name text);

CREATE TABLE ingredient (
  ingredient_id text PRIMARY KEY DEFAULT uuid_generate_v4(),
  name text,
  gram integer,
  calories_per_gram integer);

CREATE TABLE meal_ingredient (
  meal_ingredient_id text PRIMARY KEY DEFAULT uuid_generate_v4(),
  meal_id text,
  ingredient_id text,
  CONSTRAINT fk_meal_ingredient FOREIGN KEY (meal_id) REFERENCES meal(meal_id) ON DELETE CASCADE,
  CONSTRAINT fk_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id) ON DELETE CASCADE);

CREATE TABLE nutritional_value (
nutritional_value_id text PRIMARY KEY DEFAULT uuid_generate_v4(),
name text,
value integer);

CREATE TABLE ingredient_nutritional_value (
ingredient_nutritional_values_id text PRIMARY KEY DEFAULT uuid_generate_v4(),
ingredient_id text,
nutritional_value_id text,
CONSTRAINT fk_ingredient_nutrition FOREIGN KEY (ingredient_id) REFERENCES ingredient(ingredient_id) ON DELETE CASCADE,
CONSTRAINT fk_nutritional_value FOREIGN KEY (nutritional_value_id) REFERENCES nutritional_value(nutritional_value_id) ON DELETE CASCADE);

CREATE TABLE "user" (
user_id text PRIMARY KEY DEFAULT uuid_generate_v4(),
email text,
password_hash text);

CREATE TABLE user_meal (
user_meal_id text PRIMARY KEY DEFAULT uuid_generate_v4(),
user_id text,
meal_id text,
CONSTRAINT fk_user_collection FOREIGN KEY (user_id) REFERENCES "user"(user_id) ON DELETE CASCADE,
CONSTRAINT fk_meal_collection FOREIGN KEY (meal_id) REFERENCES meal(meal_id) ON DELETE CASCADE);

CREATE TABLE review (
review_id text PRIMARY KEY DEFAULT uuid_generate_v4(),
user_id text,
meal_id text,
CONSTRAINT fk_user_review FOREIGN KEY (user_id) REFERENCES "user"(user_id) ON DELETE CASCADE,
CONSTRAINT fk_meal_review FOREIGN KEY (meal_id) REFERENCES meal(meal_id) ON DELETE CASCADE);