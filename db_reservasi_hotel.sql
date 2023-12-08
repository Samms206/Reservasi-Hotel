-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Waktu pembuatan: 04 Des 2023 pada 10.05
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_reservasi_hotel`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kamar`
--

CREATE TABLE `kamar` (
  `nomor_kamar` int(11) NOT NULL,
  `tipe` varchar(50) NOT NULL,
  `kasur` varchar(50) NOT NULL,
  `harga` int(11) NOT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kamar`
--

INSERT INTO `kamar` (`nomor_kamar`, `tipe`, `kasur`, `harga`, `status`) VALUES
(101, 'AC', 'Single', 150000, NULL),
(102, 'Non AC', 'Double', 120000, NULL),
(103, 'AC', 'Triple', 180000, NULL),
(104, 'Non AC', 'Single', 100000, NULL),
(105, 'AC', 'Double', 160000, NULL),
(106, 'Non AC', 'Triple', 200000, NULL),
(107, 'AC', 'Single', 150000, NULL),
(108, 'Non AC', 'Double', 120000, NULL),
(109, 'AC', 'Triple', 180000, NULL),
(110, 'Non AC', 'Single', 100000, NULL),
(111, 'AC', 'Double', 160000, NULL),
(112, 'Non AC', 'Triple', 200000, NULL),
(113, 'AC', 'Single', 150000, NULL),
(114, 'Non AC', 'Double', 120000, NULL),
(115, 'AC', 'Triple', 180000, NULL),
(116, 'Non AC', 'Single', 100000, NULL),
(117, 'AC', 'Double', 160000, NULL),
(118, 'Non AC', 'Triple', 200000, NULL),
(119, 'AC', 'Single', 150000, NULL),
(120, 'Non AC', 'Double', 120000, NULL);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kamar`
--
ALTER TABLE `kamar`
  ADD PRIMARY KEY (`nomor_kamar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
