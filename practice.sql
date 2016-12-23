-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- 主機: localhost
-- 產生時間： 2016 年 12 月 23 日 04:59
-- 伺服器版本: 10.1.19-MariaDB
-- PHP 版本： 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `practice`
--

-- --------------------------------------------------------

--
-- 資料表結構 `Customer`
--

CREATE TABLE `Customer` (
  `CustomerID` bigint(20) NOT NULL,
  `Name` text NOT NULL,
  `Phone` text NOT NULL,
  `Address` text NOT NULL,
  `Level` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `Customer`
--

INSERT INTO `Customer` (`CustomerID`, `Name`, `Phone`, `Address`, `Level`) VALUES
(2, 'pipi', '0987878787', '87', 'A'),
(3, 'taco', '0978255850', 'a22629743@gmail.com', 'A');

-- --------------------------------------------------------

--
-- 資料表結構 `manager`
--

CREATE TABLE `manager` (
  `ManagerID` int(11) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Phone` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `Email` text NOT NULL,
  `Account` text NOT NULL,
  `Password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `manager`
--

INSERT INTO `manager` (`ManagerID`, `Name`, `Phone`, `Address`, `Email`, `Account`, `Password`) VALUES
(15, '1234', '123', '123', '123', '123', '123'),
(16, 'a', '0978255850', '新北市土城區', 'a22629743@gmail.com', '林紘鋙', '1'),
(19, 'b', '0987878787', 's_M', 'pipi@gmail.com', '°a', '2'),
(20, 'c', '88908', 'g', '983', '', '3'),
(21, 'sad', 'asd', 'asd', 'asd', 'b', '1'),
(22, 's', 's', 's', 's', 'a', '1'),
(23, 's', 's', 's', 's', 'a', '1');

-- --------------------------------------------------------

--
-- 資料表結構 `product`
--

CREATE TABLE `product` (
  `ProductID` bigint(11) NOT NULL,
  `Category` int(11) NOT NULL,
  `Description` text NOT NULL,
  `Inventory` int(11) NOT NULL,
  `ReorderPoint` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `product`
--

INSERT INTO `product` (`ProductID`, `Category`, `Description`, `Inventory`, `ReorderPoint`) VALUES
(1, 1, 'coat', 80, 30),
(2, 1, 'jeans', 100, 50),
(3, 1, 'wallet', 112, 57);

-- --------------------------------------------------------

--
-- 資料表結構 `purchaseorder`
--

CREATE TABLE `purchaseorder` (
  `POID` bigint(20) NOT NULL,
  `ProductID` bigint(20) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `OrderTime` datetime NOT NULL,
  `InventoryArrivalTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `purchaseorder`
--

INSERT INTO `purchaseorder` (`POID`, `ProductID`, `Quantity`, `OrderTime`, `InventoryArrivalTime`) VALUES
(18, 3, 5, '2016-12-19 19:02:29', '2016-12-19 19:02:35'),
(20, 2, 6, '2016-12-20 14:03:13', NULL),
(21, 3, 7, '2016-12-20 14:03:15', NULL),
(22, 1, 40, '2016-12-20 18:14:31', '2016-12-20 18:14:35'),
(23, 1, 100, '2016-12-21 13:06:49', '2016-12-21 13:07:00'),
(24, 2, 100, '2016-12-21 13:06:53', '2016-12-21 13:07:02'),
(25, 3, 100, '2016-12-21 13:06:57', '2016-12-21 13:07:04');

-- --------------------------------------------------------

--
-- 資料表結構 `salesorder`
--

CREATE TABLE `salesorder` (
  `SOID` bigint(20) NOT NULL,
  `CustomerName` varchar(20) DEFAULT NULL,
  `CustomerAddress` varchar(100) DEFAULT NULL,
  `CustomerPhone` varchar(20) DEFAULT NULL,
  `OrderTime` datetime NOT NULL,
  `ShippingTime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `salesorder`
--

INSERT INTO `salesorder` (`SOID`, `CustomerName`, `CustomerAddress`, `CustomerPhone`, `OrderTime`, `ShippingTime`) VALUES
(6, NULL, NULL, NULL, '2016-12-19 17:46:58', NULL),
(7, NULL, NULL, NULL, '2016-12-19 19:14:20', NULL),
(8, NULL, NULL, NULL, '2016-12-19 19:30:01', NULL),
(9, NULL, NULL, NULL, '2016-12-19 19:30:44', NULL),
(10, NULL, NULL, NULL, '2016-12-20 13:49:42', NULL),
(11, NULL, NULL, NULL, '2016-12-20 13:52:02', NULL),
(12, NULL, NULL, NULL, '2016-12-20 18:13:09', NULL),
(13, NULL, NULL, NULL, '2016-12-20 18:14:11', NULL),
(14, NULL, NULL, NULL, '2016-12-20 22:47:44', NULL),
(15, NULL, NULL, NULL, '2016-12-20 23:27:32', NULL),
(16, NULL, NULL, NULL, '2016-12-21 12:57:40', NULL),
(17, NULL, NULL, NULL, '2016-12-21 12:58:42', NULL),
(18, NULL, NULL, NULL, '2016-12-21 13:04:44', NULL);

-- --------------------------------------------------------

--
-- 資料表結構 `salesorderitem`
--

CREATE TABLE `salesorderitem` (
  `id` bigint(20) NOT NULL,
  `SOID` bigint(20) NOT NULL,
  `ProductID` bigint(20) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `customerID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表的匯出資料 `salesorderitem`
--

INSERT INTO `salesorderitem` (`id`, `SOID`, `ProductID`, `Quantity`, `customerID`) VALUES
(56, 6, 1, 1, 0),
(57, 7, 1, 1, 0),
(58, 7, 2, 1, 0),
(59, 8, 1, 1, 0),
(60, 9, 1, 1, 0),
(61, 9, 2, 1, 0),
(62, 10, 1, 1, 0),
(63, 11, 3, 1, 0),
(64, 12, 1, 20, 0),
(65, 13, 1, 3, 0),
(66, 13, 2, 8, 0),
(67, 14, 1, 20, 0),
(68, 15, 2, 20, 0),
(69, 15, 3, 30, 0),
(70, 16, 1, 20, 2),
(71, 17, 2, 20, 2),
(72, 17, 1, 30, 2),
(73, 18, 3, 2, 3);

--
-- 已匯出資料表的索引
--

--
-- 資料表索引 `Customer`
--
ALTER TABLE `Customer`
  ADD PRIMARY KEY (`CustomerID`);

--
-- 資料表索引 `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`ManagerID`);

--
-- 資料表索引 `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductID`);

--
-- 資料表索引 `purchaseorder`
--
ALTER TABLE `purchaseorder`
  ADD PRIMARY KEY (`POID`);

--
-- 資料表索引 `salesorder`
--
ALTER TABLE `salesorder`
  ADD PRIMARY KEY (`SOID`);

--
-- 資料表索引 `salesorderitem`
--
ALTER TABLE `salesorderitem`
  ADD PRIMARY KEY (`id`);

--
-- 在匯出的資料表使用 AUTO_INCREMENT
--

--
-- 使用資料表 AUTO_INCREMENT `Customer`
--
ALTER TABLE `Customer`
  MODIFY `CustomerID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 使用資料表 AUTO_INCREMENT `manager`
--
ALTER TABLE `manager`
  MODIFY `ManagerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- 使用資料表 AUTO_INCREMENT `product`
--
ALTER TABLE `product`
  MODIFY `ProductID` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- 使用資料表 AUTO_INCREMENT `purchaseorder`
--
ALTER TABLE `purchaseorder`
  MODIFY `POID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- 使用資料表 AUTO_INCREMENT `salesorder`
--
ALTER TABLE `salesorder`
  MODIFY `SOID` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- 使用資料表 AUTO_INCREMENT `salesorderitem`
--
ALTER TABLE `salesorderitem`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
