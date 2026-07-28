-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 28, 2026 at 10:13 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cuppabliss40`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `category` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `category`, `price`, `quantity`) VALUES
(8, 'Espresso', 'Coffee', 2.5, 99),
(9, 'Americano', 'Coffee', 2.8, 90),
(10, 'Cappuccino', 'Coffee', 3.5, 80),
(11, 'Latte', 'Coffee', 4, 85),
(12, 'Mocha', 'Coffee', 4.25, 9),
(13, 'Black Tea', 'Tea', 1.8, 150),
(14, 'Green Tea', 'Tea', 2, 140),
(15, 'Herbal Tea', 'Tea', 2.2, 130),
(16, 'Chai Tea', 'Tea', 2.5, 120),
(17, 'Oolong Tea', 'Tea', 2.7, 110),
(18, 'Croissant', 'Pastries', 2.75, 60),
(19, 'Chocolate Muffin', 'Pastries', 3, 55),
(20, 'Blueberry Scone', 'Pastries', 2.85, 50),
(21, 'Cinnamon Roll', 'Pastries', 3.25, 45),
(22, 'Apple Danish', 'Pastries', 3.1, 40),
(23, 'Potato Chips', 'Snacks', 1.5, 200),
(24, 'Granola Bar', 'Snacks', 1.2, 180),
(26, 'Chocolate Cookie', 'Snacks', 1.75, 170);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `role`) VALUES
(8, 'manager', '123', 'Manager'),
(9, 'barista', '123', 'Barista');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
