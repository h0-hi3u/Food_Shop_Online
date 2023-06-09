USE [master]
GO
/****** Object:  Database [dbsSE161557]    Script Date: 5/31/2023 6:05:22 PM ******/
CREATE DATABASE [dbsSE161557]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'dbsSE161557', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.HOTRONGHIEU\MSSQL\DATA\dbsSE161557.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'dbsSE161557_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.HOTRONGHIEU\MSSQL\DATA\dbsSE161557_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [dbsSE161557] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbsSE161557].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbsSE161557] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbsSE161557] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbsSE161557] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbsSE161557] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbsSE161557] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbsSE161557] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbsSE161557] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbsSE161557] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbsSE161557] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbsSE161557] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbsSE161557] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbsSE161557] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbsSE161557] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbsSE161557] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbsSE161557] SET  ENABLE_BROKER 
GO
ALTER DATABASE [dbsSE161557] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbsSE161557] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbsSE161557] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbsSE161557] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbsSE161557] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbsSE161557] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbsSE161557] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbsSE161557] SET RECOVERY FULL 
GO
ALTER DATABASE [dbsSE161557] SET  MULTI_USER 
GO
ALTER DATABASE [dbsSE161557] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbsSE161557] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbsSE161557] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbsSE161557] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [dbsSE161557] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [dbsSE161557] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'dbsSE161557', N'ON'
GO
ALTER DATABASE [dbsSE161557] SET QUERY_STORE = OFF
GO
USE [dbsSE161557]
GO
/****** Object:  Table [dbo].[tblChiTietHoaDon]    Script Date: 5/31/2023 6:05:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblChiTietHoaDon](
	[mahd] [nvarchar](50) NOT NULL,
	[masp] [nvarchar](5) NOT NULL,
	[soluong] [int] NULL,
	[dongia] [float] NULL,
	[khuyenmai] [float] NULL,
	[giatri] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[mahd] ASC,
	[masp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblDanhMuc]    Script Date: 5/31/2023 6:05:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblDanhMuc](
	[madm] [nvarchar](5) NOT NULL,
	[tendm] [nvarchar](50) NULL,
	[trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[madm] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblHoaDon]    Script Date: 5/31/2023 6:05:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblHoaDon](
	[mahd] [nvarchar](50) NOT NULL,
	[ngayhd] [datetime] NULL,
	[trangthaixuly] [int] NULL,
	[makh] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[mahd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNhaCungCap]    Script Date: 5/31/2023 6:05:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNhaCungCap](
	[mancc] [nvarchar](5) NOT NULL,
	[tenncc] [nvarchar](50) NULL,
	[diachi] [nvarchar](100) NULL,
	[trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[mancc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblNhomTaiKhoan]    Script Date: 5/31/2023 6:05:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblNhomTaiKhoan](
	[nhomtk] [nvarchar](5) NOT NULL,
	[mota] [nvarchar](50) NULL,
	[trangthai] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[nhomtk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSanPham]    Script Date: 5/31/2023 6:05:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSanPham](
	[masp] [nvarchar](5) NOT NULL,
	[tensp] [nvarchar](50) NULL,
	[mota] [nvarchar](250) NULL,
	[soluong] [int] NULL,
	[dongia] [float] NULL,
	[hinhanh] [nvarchar](100) NULL,
	[trangthai] [bit] NULL,
	[madm] [nvarchar](5) NULL,
	[mancc] [nvarchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[masp] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblTaiKhoan]    Script Date: 5/31/2023 6:05:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblTaiKhoan](
	[tentk] [nvarchar](10) NOT NULL,
	[matkhau] [nvarchar](50) NULL,
	[trangthai] [bit] NULL,
	[email] [nvarchar](50) NULL,
	[nhomtk] [nvarchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[tentk] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD1', N'SP001', 1, 3000, 0, 3000)
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD2', N'SP001', 1, 3000, 0, 3000)
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD2', N'SP002', 1, 80000, 0, 80000)
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD3', N'SP003', 1, 30000, 0, 30000)
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD3', N'SP004', 1, 300000, 0, 300000)
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD4', N'SP002', 1, 80000, 0, 80000)
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD4', N'SP003', 1, 30000, 0, 30000)
INSERT [dbo].[tblChiTietHoaDon] ([mahd], [masp], [soluong], [dongia], [khuyenmai], [giatri]) VALUES (N'HD4', N'SP004', 1, 300000, 0, 300000)
GO
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'DM1', N'Spice', 1)
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'DM2', N'Meat', 0)
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'DM3', N'Vegetable', 1)
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'DM4', N'Fish', 0)
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'DM5', N'Noodles', 0)
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'DM6', N'Milk', 1)
INSERT [dbo].[tblDanhMuc] ([madm], [tendm], [trangthai]) VALUES (N'DM7', N'Beer', 0)
GO
INSERT [dbo].[tblHoaDon] ([mahd], [ngayhd], [trangthaixuly], [makh]) VALUES (N'HD1', CAST(N'2023-03-13T00:00:00.000' AS DateTime), 1, N'username')
INSERT [dbo].[tblHoaDon] ([mahd], [ngayhd], [trangthaixuly], [makh]) VALUES (N'HD2', CAST(N'2023-03-14T16:09:26.000' AS DateTime), 1, N'username')
INSERT [dbo].[tblHoaDon] ([mahd], [ngayhd], [trangthaixuly], [makh]) VALUES (N'HD3', CAST(N'2023-03-20T15:02:16.000' AS DateTime), 1, N'username')
INSERT [dbo].[tblHoaDon] ([mahd], [ngayhd], [trangthaixuly], [makh]) VALUES (N'HD4', CAST(N'2023-05-31T18:00:30.000' AS DateTime), 1, N'hieuht')
GO
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'NCC01', N'NCC Spice', N'VietNam', 1)
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'NCC02', N'NCC Meat', N'Cambodia', 1)
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'NCC03', N'NCC Vegetable', N'ThaiLand', 0)
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'NCC04', N'NCC Fish', N'Japan', 0)
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'NCC05', N'NCC Noodles', N'Korean', 0)
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'NCC06', N'NCC Milk', N'Netherland', 1)
INSERT [dbo].[tblNhaCungCap] ([mancc], [tenncc], [diachi], [trangthai]) VALUES (N'NCC07', N'NCC Beer', N'USA', 0)
GO
INSERT [dbo].[tblNhomTaiKhoan] ([nhomtk], [mota], [trangthai]) VALUES (N'Admin', N'Quan li', 1)
INSERT [dbo].[tblNhomTaiKhoan] ([nhomtk], [mota], [trangthai]) VALUES (N'Vip1', N'mua hang tren 500k', 1)
INSERT [dbo].[tblNhomTaiKhoan] ([nhomtk], [mota], [trangthai]) VALUES (N'Vip2', N'mua hang tren 2M', 0)
INSERT [dbo].[tblNhomTaiKhoan] ([nhomtk], [mota], [trangthai]) VALUES (N'Vip3', N'mua hang tren 5M', 1)
INSERT [dbo].[tblNhomTaiKhoan] ([nhomtk], [mota], [trangthai]) VALUES (N'Vip4', N'mua hang tren 10M', 1)
INSERT [dbo].[tblNhomTaiKhoan] ([nhomtk], [mota], [trangthai]) VALUES (N'Vip5', N'mua hang tren 20M', 0)
GO
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP001', N'Muoi I-OT', N'rat man nha', 100, 3000, N'https://sieuthinhanh.com.vn/public/products/muoi-iot-2_1636345995.jpg', 1, N'DM1', N'NCC01')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP002', N'Thit Bo', N'thit mau do', 300, 80000, N'https://suckhoedoisong.qltns.mediacdn.vn/Images/nguyenhong/2018/12/01/bo-ham-du-du-21.jpg', 1, N'DM2', N'NCC02')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP003', N'Rau Salad', N'tuoi va moi', 120, 30000, N'https://i-giadinh.vnecdn.net/2021/10/26/saladrauqua-1635240739-5476-1635240778.jpg', 0, N'DM3', N'NCC03')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP004', N'Ca Hoi', N'lam sushi va sashimi', 10, 300000, N'https://cdn.dangcapphaidep.vn/wp-content/uploads/2020/04/ca-hoi-nhat-ban-4.jpg', 0, N'DM4', N'NCC04')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP005', N'Mi Cay', N'best sale', 500, 30000, N'https://shophat.vn/wp-content/uploads/2018/05/muamy-mi-han-quoc-mi-kho-ga-cay-samyang-140g-1-1.jpg', 0, N'DM5', N'NCC05')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP006', N'Co gai Ha Lan', N'tang Vitamin B3, B12', 1000, 3000, N'https://www.dutchlady.com.vn/sites/default/files/2022-06/FRESH.png', 1, N'DM6', N'NCC06')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP007', N'Heniken', N'uong ko nhuc dau', 1000, 26000, N'https://media3.scdn.vn/img4/2020/05_22/tHOroPSJ4zu4CPrj2US9.jpg', 0, N'DM7', N'NCC07')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP008', N'Ca Ngu Dai Duong', N'lam sushi va sashimi', 8, 29000, N'https://angisaigon.com/wp-content/uploads/2022/01/Ca-ngu-dai-duong-cat-Saku-dep-mat.-1.jpg', 1, N'DM4', N'NCC04')
INSERT [dbo].[tblSanPham] ([masp], [tensp], [mota], [soluong], [dongia], [hinhanh], [trangthai], [madm], [mancc]) VALUES (N'SP009', N'Thit Ga', N'ga tha vuon', 100, 120000, N'https://vinafood.vn/wp-content/uploads/2022/05/ga-dong-lanh.jpg', 1, N'DM2', N'NCC02')
GO
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'BuiThiE', N'BuiThiE123', 0, N'BuiThiE@gmail.com', N'Vip5')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'DangVanI', N'DangVanI123', 1, N'DangVanI@gmail.com', N'Vip4')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'hieuht', N'hieuht123', 1, N'hieuht123@gmail.com', N'Admin')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'HoangF', N'HoangF123', 0, N'HoangF@gmail.com', N'Vip1')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'LeVanB', N'LeVanB123', 0, N'LeVanB@mail.com', N'Vip2')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'NguyenVanA', N'NguyenVanA123', 1, N'NguyenVanA@gmail.com', N'Vip1')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'PhamThiE', N'PhamThiE123', 1, N'PhamThiE@gmail.com', N'Vip5')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'PhanVanD', N'PhanVanD123', 0, N'PhanVanD@gmail.com', N'Vip4')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'TranThiC', N'TranThiC123', 0, N'TranThiC@gmail.com', N'Vip3')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'username', N'password', 1, N'username@gmail.com', N'Vip4')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'VoThiH', N'VoThiH123', 0, N'VoThiH@gmail.com', N'Vip3')
INSERT [dbo].[tblTaiKhoan] ([tentk], [matkhau], [trangthai], [email], [nhomtk]) VALUES (N'VuVanG', N'VuVanG123', 1, N'VuVanG@gmail.com', N'Vip2')
GO
ALTER TABLE [dbo].[tblHoaDon]  WITH CHECK ADD  CONSTRAINT [FK__tblHoaDon__makh__29572725] FOREIGN KEY([makh])
REFERENCES [dbo].[tblTaiKhoan] ([tentk])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[tblHoaDon] CHECK CONSTRAINT [FK__tblHoaDon__makh__29572725]
GO
ALTER TABLE [dbo].[tblSanPham]  WITH CHECK ADD  CONSTRAINT [FK__tblSanPha__mancc__4AB81AF0] FOREIGN KEY([mancc])
REFERENCES [dbo].[tblNhaCungCap] ([mancc])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[tblSanPham] CHECK CONSTRAINT [FK__tblSanPha__mancc__4AB81AF0]
GO
ALTER TABLE [dbo].[tblSanPham]  WITH CHECK ADD  CONSTRAINT [FK__tblSanPham__madm__49C3F6B7] FOREIGN KEY([madm])
REFERENCES [dbo].[tblDanhMuc] ([madm])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[tblSanPham] CHECK CONSTRAINT [FK__tblSanPham__madm__49C3F6B7]
GO
ALTER TABLE [dbo].[tblTaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK__tblTaiKho__nhomt__267ABA7A] FOREIGN KEY([nhomtk])
REFERENCES [dbo].[tblNhomTaiKhoan] ([nhomtk])
ON UPDATE CASCADE
ON DELETE SET NULL
GO
ALTER TABLE [dbo].[tblTaiKhoan] CHECK CONSTRAINT [FK__tblTaiKho__nhomt__267ABA7A]
GO
USE [master]
GO
ALTER DATABASE [dbsSE161557] SET  READ_WRITE 
GO
