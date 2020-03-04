-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 04, 2020 at 06:57 AM
-- Server version: 10.1.39-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `foodkart`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `email` varchar(40) NOT NULL,
  `password` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`email`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_id` int(10) NOT NULL,
  `Customer_name` varchar(50) NOT NULL,
  `Customer_email` varchar(50) NOT NULL,
  `Customer_password` text NOT NULL,
  `Phone_number` varchar(20) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_id`, `Customer_name`, `Customer_email`, `Customer_password`, `Phone_number`, `Address`) VALUES
(1, 'Bhupesh', 'bhupeshjoshi293@gmail.com', '1234', '99690286', 'kanchanpur'),
(2, 'charchit', 'charchit@gmail.com', '1234', '12345', 'kupandole');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `Order_number` int(10) NOT NULL,
  `order_message` varchar(250) DEFAULT NULL,
  `Current_phn_num` varchar(20) DEFAULT NULL,
  `Current_Location` varchar(50) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `no_of_items` int(10) NOT NULL,
  `order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`Order_number`, `order_message`, `Current_phn_num`, `Current_Location`, `item_name`, `no_of_items`, `order_time`) VALUES
(4, '.', '9805793365', 'KU ', 'momo', 2, '2019-07-26 03:11:42'),
(5, '.', '9812725964', 'KU gate', 'momo', 3, '2019-07-29 18:04:08'),
(6, '.', '9805793365', 'ku gate', 'Pizza', 3, '2019-07-30 06:51:21'),
(7, '.', '9805793365', 'ku', 'momo', 2, '2019-07-30 07:41:44');

-- --------------------------------------------------------

--
-- Table structure for table `resfood`
--

CREATE TABLE `resfood` (
  `item_no` int(20) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `price` varchar(20) NOT NULL,
  `item photo` longblob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resfood`
--

INSERT INTO `resfood` (`item_no`, `item_name`, `price`, `item photo`) VALUES
(15, 'momo', 'Rs50', ''),
(16, 'Pizza', 'Rs150', ''),
(17, 'noodles', 'Rs50', ''),
(18, 'burger', 'Rs150', '');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `restaurant_no` int(20) NOT NULL,
  `r_address` varchar(50) NOT NULL,
  `r_name` varchar(50) NOT NULL,
  `image` blob NOT NULL,
  `r_email` varchar(20) NOT NULL,
  `r_password` varchar(20) NOT NULL,
  `r_phn_num` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`restaurant_no`, `r_address`, `r_name`, `image`, `r_email`, `r_password`, `r_phn_num`) VALUES
(2, 'KU gate', 'SK', '', 'restaurant', 'restaurant', 0),
(3, 'KU gate', 'SARITA', '', '', '', 0),
(4, 'KU gate', 'BFC', '', '', '', 0),
(5, 'KU gate', 'MONSOON', '', '', '', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`Order_number`);

--
-- Indexes for table `resfood`
--
ALTER TABLE `resfood`
  ADD PRIMARY KEY (`item_no`),
  ADD UNIQUE KEY `item_name` (`item_name`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`restaurant_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `Order_number` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `resfood`
--
ALTER TABLE `resfood`
  MODIFY `item_no` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `restaurant_no` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
