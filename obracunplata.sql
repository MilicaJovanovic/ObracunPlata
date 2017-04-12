-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 12, 2017 at 11:56 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `obracunplata`
--

-- --------------------------------------------------------

--
-- Table structure for table `email_flag`
--

CREATE TABLE `email_flag` (
  `email_flag_id` int(11) NOT NULL,
  `flag` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `email_flag`
--

INSERT INTO `email_flag` (`email_flag_id`, `flag`) VALUES
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `semester_number` int(11) NOT NULL DEFAULT '0',
  `subjects_in_spring_semester` int(11) NOT NULL DEFAULT '0',
  `subjects_in_autumn_semester` int(11) NOT NULL DEFAULT '0',
  `special_add_value` int(11) NOT NULL DEFAULT '0',
  `functions_add_value` int(11) NOT NULL DEFAULT '0',
  `name` varchar(250) COLLATE utf8_bin NOT NULL,
  `lastname` varchar(250) COLLATE utf8_bin NOT NULL,
  `faculty` varchar(250) COLLATE utf8_bin NOT NULL,
  `bank_account` varchar(250) COLLATE utf8_bin NOT NULL,
  `email` varchar(250) COLLATE utf8_bin NOT NULL,
  `teaching_position` varchar(250) COLLATE utf8_bin NOT NULL,
  `employment_percentage` varchar(250) COLLATE utf8_bin NOT NULL DEFAULT '',
  `subject_number` varchar(250) COLLATE utf8_bin NOT NULL,
  `kbp` varchar(250) COLLATE utf8_bin NOT NULL,
  `kro` varchar(250) COLLATE utf8_bin NOT NULL,
  `kt` varchar(250) COLLATE utf8_bin NOT NULL,
  `kpr` varchar(250) COLLATE utf8_bin NOT NULL,
  `isum_hours_autumn` float NOT NULL DEFAULT '0',
  `isum_hours_spring` float NOT NULL DEFAULT '0',
  `isum_money_autumn` float NOT NULL DEFAULT '0',
  `isum_money_spring` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `semester_number`, `subjects_in_spring_semester`, `subjects_in_autumn_semester`, `special_add_value`, `functions_add_value`, `name`, `lastname`, `faculty`, `bank_account`, `email`, `teaching_position`, `employment_percentage`, `subject_number`, `kbp`, `kro`, `kt`, `kpr`, `isum_hours_autumn`, `isum_hours_spring`, `isum_money_autumn`, `isum_money_spring`) VALUES
(1, 2, 5, 5, 0, 0, 'Svetlana', 'Cvetanvoic', 'Fakultet informacionih tehnologija', '123456789', 'svetlana.cvetanvoic@metropolitan.ac.rs', 'Docent', '100', '12', '1.0', '1.0', '1.2', '1.0', 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `part_time_employee`
--

CREATE TABLE `part_time_employee` (
  `part_time_employee_id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8_bin NOT NULL,
  `lastname` varchar(250) COLLATE utf8_bin NOT NULL,
  `subjects_in_spring_semester` int(11) NOT NULL,
  `subjects_in_autumn_semester` int(11) NOT NULL,
  `faculty` varchar(250) COLLATE utf8_bin NOT NULL,
  `bank_account` varchar(250) COLLATE utf8_bin NOT NULL,
  `email` varchar(250) COLLATE utf8_bin NOT NULL,
  `teaching_position` varchar(250) COLLATE utf8_bin NOT NULL,
  `employment_percentage` varchar(250) COLLATE utf8_bin NOT NULL,
  `subject_number` varchar(250) COLLATE utf8_bin NOT NULL,
  `kt` varchar(250) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `part_time_employee`
--

INSERT INTO `part_time_employee` (`part_time_employee_id`, `name`, `lastname`, `subjects_in_spring_semester`, `subjects_in_autumn_semester`, `faculty`, `bank_account`, `email`, `teaching_position`, `employment_percentage`, `subject_number`, `kt`) VALUES
(1, 'Jovana', 'Jovic', 5, 5, 'Fakultet informacionih tehnologija', '123456789', 'jovana.jovic@metropolitan.ac.rs', 'Master', '100', '12', '1.2');

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8_bin NOT NULL,
  `location` varchar(250) COLLATE utf8_bin NOT NULL,
  `type` varchar(250) COLLATE utf8_bin NOT NULL,
  `semester` varchar(250) COLLATE utf8_bin NOT NULL,
  `code` varchar(250) COLLATE utf8_bin NOT NULL,
  `class_number` int(11) NOT NULL,
  `group_exercise_number` int(11) NOT NULL,
  `individual_exercise_number` int(11) NOT NULL,
  `espb` int(11) NOT NULL,
  `groups_number` int(11) NOT NULL,
  `words_number` float NOT NULL,
  `fpm` float NOT NULL,
  `fob` float NOT NULL,
  `fin1` float NOT NULL,
  `fin2` float NOT NULL,
  `fmm` float NOT NULL,
  `fkv` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `subject`
--

INSERT INTO `subject` (`subject_id`, `name`, `location`, `type`, `semester`, `code`, `class_number`, `group_exercise_number`, `individual_exercise_number`, `espb`, `groups_number`, `words_number`, `fpm`, `fob`, `fin1`, `fin2`, `fmm`, `fkv`) VALUES
(1, 'CS101 Uvod u OO Programiranje', 'NiÅ¡', 'Klas.', 'J', '', 3, 1, 3, 10, 2, 4000, 1, 0.9, 1.1, 0.975, 1.1, 0.8),
(2, 'CS102 Algoritmi i strukture podataka', 'NiÅ¡', 'Klas.', 'P', '', 3, 1, 3, 10, 2, 4000, 1, 0.9, 1.1, 0.975, 1.1, 0.8),
(3, 'IT350 Baze podataka', 'Beograd', 'Hibr.', 'P', '', 3, 1, 3, 10, 2, 4000, 1, 0.9, 1.1, 0.975, 1.1, 0.8);

-- --------------------------------------------------------

--
-- Table structure for table `subject_employee`
--

CREATE TABLE `subject_employee` (
  `subject_employee_id` int(11) UNSIGNED NOT NULL,
  `employee_id` int(11) NOT NULL,
  `subject_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject_employee`
--

INSERT INTO `subject_employee` (`subject_employee_id`, `employee_id`, `subject_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `subject_part_time_employee`
--

CREATE TABLE `subject_part_time_employee` (
  `subject_part_time_employee_id` int(11) UNSIGNED NOT NULL,
  `part_time_employee_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(250) COLLATE utf8_bin NOT NULL,
  `password` varchar(250) COLLATE utf8_bin NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `username`, `password`, `enabled`) VALUES
(1, 'admin', 'admin', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL,
  `username` varchar(250) COLLATE utf8_bin NOT NULL,
  `role` varchar(25) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(1, 'admin', 'ROLE_ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `email_flag`
--
ALTER TABLE `email_flag`
  ADD PRIMARY KEY (`email_flag_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `part_time_employee`
--
ALTER TABLE `part_time_employee`
  ADD PRIMARY KEY (`part_time_employee_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`);

--
-- Indexes for table `subject_employee`
--
ALTER TABLE `subject_employee`
  ADD PRIMARY KEY (`subject_employee_id`),
  ADD KEY `se_employee` (`employee_id`),
  ADD KEY `se_subject` (`subject_id`);

--
-- Indexes for table `subject_part_time_employee`
--
ALTER TABLE `subject_part_time_employee`
  ADD PRIMARY KEY (`subject_part_time_employee_id`),
  ADD KEY `sp_employee` (`part_time_employee_id`),
  ADD KEY `sp_subject` (`subject_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `email_flag`
--
ALTER TABLE `email_flag`
  MODIFY `email_flag_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `part_time_employee`
--
ALTER TABLE `part_time_employee`
  MODIFY `part_time_employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `subject_employee`
--
ALTER TABLE `subject_employee`
  MODIFY `subject_employee_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `subject_part_time_employee`
--
ALTER TABLE `subject_part_time_employee`
  MODIFY `subject_part_time_employee_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `user_role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `subject_employee`
--
ALTER TABLE `subject_employee`
  ADD CONSTRAINT `se_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `se_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

--
-- Constraints for table `subject_part_time_employee`
--
ALTER TABLE `subject_part_time_employee`
  ADD CONSTRAINT `sp_employee` FOREIGN KEY (`part_time_employee_id`) REFERENCES `part_time_employee` (`part_time_employee_id`),
  ADD CONSTRAINT `sp_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
