CREATE TABLE IF NOT EXISTS `billett` (
    `id` INTEGER AUTO_INCREMENT PRIMARY KEY,
    `film` VARCHAR(50) NOT NULL,
    `amount` INTEGER NOT NULL,
    `fname` VARCHAR(50) NOT NULL,
    `lname` VARCHAR(50) NOT NULL,
    `telnr` INTEGER NOT NULL,
    `email` VARCHAR(50) NOT NULL
    );

