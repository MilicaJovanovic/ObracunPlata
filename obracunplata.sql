-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 03, 2017 at 01:36 PM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

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
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `semester_number` int(11) NOT NULL,
  `subjects_in_spring_semester` int(11) NOT NULL,
  `subjects_in_autumn_semester` int(11) NOT NULL,
  `special_add_value` int(11) NOT NULL,
  `functionas_add_value` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8_bin NOT NULL,
  `lastname` varchar(250) COLLATE utf8_bin NOT NULL,
  `faculty` varchar(250) COLLATE utf8_bin NOT NULL,
  `bank_account` varchar(250) COLLATE utf8_bin NOT NULL,
  `email` varchar(250) COLLATE utf8_bin NOT NULL,
  `teaching_position` varchar(250) COLLATE utf8_bin NOT NULL,
  `eployment_percentage` varchar(250) COLLATE utf8_bin NOT NULL,
  `subject_number` varchar(250) COLLATE utf8_bin NOT NULL,
  `kbp` varchar(250) COLLATE utf8_bin NOT NULL,
  `kro` varchar(250) COLLATE utf8_bin NOT NULL,
  `kt` varchar(250) COLLATE utf8_bin NOT NULL,
  `kpr` varchar(250) COLLATE utf8_bin NOT NULL,
  `isum_hours_autumn` float NOT NULL,
  `isum_hours_spring` float NOT NULL,
  `isum_money_autumn` float NOT NULL,
  `isum_money_spring` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `mdita`
--

CREATE TABLE `mdita` (
  `id` int(11) NOT NULL,
  `broj_reci` float NOT NULL,
  `broj_objekata_ucenja` float NOT NULL,
  `assesment` float NOT NULL,
  `multiple_choice` float NOT NULL,
  `question_and_answers` float NOT NULL,
  `java_grader` float NOT NULL,
  `forum` float NOT NULL,
  `noticeboard` float NOT NULL,
  `notebook` float NOT NULL,
  `chat` float NOT NULL,
  `submit_files` float NOT NULL,
  `shared_resources` float NOT NULL,
  `picture_gallery` float NOT NULL,
  `video` float NOT NULL,
  `audio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

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
  `change_percetnage` float NOT NULL,
  `proc1` float NOT NULL,
  `proc2` float NOT NULL,
  `proc3` float NOT NULL,
  `proc4` float NOT NULL,
  `proc5` float NOT NULL,
  `proc6` float NOT NULL,
  `proc7` float NOT NULL,
  `proc8` float NOT NULL,
  `proc9` float NOT NULL,
  `proc10` float NOT NULL,
  `proc11` float NOT NULL,
  `proc12` float NOT NULL,
  `proc13` float NOT NULL,
  `proc14` float NOT NULL,
  `proc15` float NOT NULL,
  `words_number` float NOT NULL,
  `fee` float NOT NULL,
  `fpm` float NOT NULL,
  `fob` float NOT NULL,
  `fin1` float NOT NULL,
  `fin2` float NOT NULL,
  `fmm` float NOT NULL,
  `fkv` float NOT NULL,
  `employee_id` int(11) NOT NULL,
  `part_time_employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `subject_mark`
--

CREATE TABLE `subject_mark` (
  `subject_mark_id` int(11) NOT NULL,
  `name` varchar(250) COLLATE utf8_bin NOT NULL,
  `value` float NOT NULL,
  `subject_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(250) COLLATE utf8_bin NOT NULL,
  `role` varchar(250) COLLATE utf8_bin NOT NULL,
  `password` varchar(250) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `role`, `password`) VALUES
(1, 'admin', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `mdita`
--
ALTER TABLE `mdita`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `part_time_employee`
--
ALTER TABLE `part_time_employee`
  ADD PRIMARY KEY (`part_time_employee_id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`subject_id`),
  ADD KEY `FK_706i7tusxpuvh2ks0vd1o91df` (`employee_id`),
  ADD KEY `FK_9annjlxsgi2uucuke8jw0e05f` (`part_time_employee_id`);

--
-- Indexes for table `subject_mark`
--
ALTER TABLE `subject_mark`
  ADD PRIMARY KEY (`subject_mark_id`),
  ADD KEY `FK_rnj4xhbv5n0jx2qh140y1b713` (`subject_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `mdita`
--
ALTER TABLE `mdita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `part_time_employee`
--
ALTER TABLE `part_time_employee`
  MODIFY `part_time_employee_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `subject`
--
ALTER TABLE `subject`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `subject_mark`
--
ALTER TABLE `subject_mark`
  MODIFY `subject_mark_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `FK_706i7tusxpuvh2ks0vd1o91df` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  ADD CONSTRAINT `FK_9annjlxsgi2uucuke8jw0e05f` FOREIGN KEY (`part_time_employee_id`) REFERENCES `part_time_employee` (`part_time_employee_id`);

--
-- Constraints for table `subject_mark`
--
ALTER TABLE `subject_mark`
  ADD CONSTRAINT `FK_rnj4xhbv5n0jx2qh140y1b713` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
