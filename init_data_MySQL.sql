CREATE TABLE IF NOT EXISTS quotes (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  content TEXT,
  author VARCHAR(255)
) ENGINE = InnoDB;

INSERT INTO quotes (content, `author`) VALUES
  ('Life isn\'t about finding yourself. Life is about creating yourself', 'George Bernard Shaw'),
  ('Learn to say ''no'' to the good so you can say ''yes'' to the best', 'John C. Maxwell'),
  ('In the practice of tolerance, one''s enemy is the best teacher', 'Dalai Lama'),
  ('With great power comes great responsibility', 'Voltaire'),
  ('Many of life''s failures are people who did not realize how close they were to success when they gave up', 'Thomas A. Edison'),
  ('Our greatest weakness lies in giving up. The most certain way to succeed is always to try just one more time', 'Thomas A. Edison');


CREATE TABLE IF NOT EXISTS categories (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255)
) ENGINE = InnoDB;

INSERT INTO categories (`name`) VALUES
  ('Design'),
  ('Technology'),
  ('Video');

CREATE TABLE IF NOT EXISTS projects (
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  category_id INTEGER,
  name VARCHAR(255),
  short_description TEXT(400),
  money_goal INTEGER,
  pledged INTEGER,
  total_days INTEGER,
  adding_date DATETIME,
  full_description TEXT,
  link TEXT
) ENGINE = InnoDB;

INSERT INTO projects (`category_id`, `name`, `short_description`, `money_goal`, `pledged`, `total_days`, `adding_date`, `full_description`, `link`) VALUES
  (1, 'SNAP', 'Design Your Own Furniture', 15000, 27000, 60, '2015-06-28 22:00:00', 'full_decr 1', 'http://link1'),
  (1, 'HYDAWAY', 'A Pocket-Sized Water Bottle Fit for any Adventure', 200000, 181437, 25, '2015-06-28 22:00:00', 'full_decr 2', 'http://link2'),
  (1, 'DASH 4.0 WALLET', 'A Minimal Wallet Redefined', 15000, 2001, 40, '2015-06-28 22:00:00', 'full_decr 3', 'http://link3'),
  (1, 'USB CHARGEDOUBLER', 'Double your charging speed!', 154500, 2700, 50, '2015-06-28 22:00:00', 'full_decr 4', 'http://link4'),
  (2, 'FIREFLY HAND', 'Light up your life', 154500, 0, 35, '2015-06-28 22:00:00', 'full_decr 5', 'http://link5'),
  (3, 'CUBIT', 'The Make Anything Platform', 232340, 2555, 20, '2015-06-28 22:00:00', 'full_decr 6', 'http://link6'),
  (3, 'NOKI', 'The smart doorlock for Europe', 2700, 300, 20, '2015-06-28 22:00:00', 'full_decr 7', 'http://link7');




