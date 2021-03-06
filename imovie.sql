USE [db_imovie]
GO
/****** 对象:  Table [dbo].[cinema]    脚本日期: 07/03/2015 10:28:00 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[cinema](
	[cid] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[place] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF

USE [db_imovie]
GO
/****** 对象:  Table [dbo].[cinema_room]    脚本日期: 07/03/2015 10:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[cinema_room](
	[crid] [int] IDENTITY(1,1) NOT NULL,
	[cid] [int] NOT NULL,
	[roomname] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
	[seat_x] [int] NULL DEFAULT ((0)),
	[seat_y] [int] NULL DEFAULT ((0)),
	[statu] [varchar](3) COLLATE Chinese_PRC_CI_AS NULL DEFAULT ((0)),
PRIMARY KEY CLUSTERED 
(
	[crid] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF

USE [db_imovie]
GO
/****** 对象:  Table [dbo].[demo]    脚本日期: 07/03/2015 10:29:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[demo](
	[id] [varchar](10) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[name] [varchar](64) COLLATE Chinese_PRC_CI_AS NULL,
	[price] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF

USE [db_imovie]
GO
/****** 对象:  Table [dbo].[movie_info]    脚本日期: 07/03/2015 10:29:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[movie_info](
	[mid] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
	[nickname] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
	[director] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
	[country] [varchar](10) COLLATE Chinese_PRC_CI_AS NULL,
	[mtype] [varchar](3) COLLATE Chinese_PRC_CI_AS NULL,
	[myear] [varchar](4) COLLATE Chinese_PRC_CI_AS NULL,
	[msummary] [varchar](4000) COLLATE Chinese_PRC_CI_AS NULL,
	[sub] [int] NULL CONSTRAINT [DF_movie_info_sub]  DEFAULT ((0)),
	[sup] [int] NULL CONSTRAINT [DF_movie_info_sup]  DEFAULT ((0)),
	[imgurl] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
 CONSTRAINT [PK_movie_info] PRIMARY KEY CLUSTERED 
(
	[mid] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ__movie_info__08EA5793] UNIQUE NONCLUSTERED 
(
	[director] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ__movie_info__09DE7BCC] UNIQUE NONCLUSTERED 
(
	[name] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF

USE [db_imovie]
GO
/****** 对象:  Table [dbo].[movie_price]    脚本日期: 07/03/2015 10:29:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[movie_price](
	[mid] [int] NOT NULL,
	[cid] [int] NOT NULL,
	[mptype] [varchar](3) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[price] [numeric](8, 2) NOT NULL,
	[starttime] [varchar](5) COLLATE Chinese_PRC_CI_AS NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF

USE [db_imovie]
GO
/****** 对象:  Table [dbo].[order]    脚本日期: 07/03/2015 10:30:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[order](
	[uid] [int] NOT NULL,
	[content] [varchar](4000) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[createDateTime] [datetime] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF

USE [db_imovie]
GO
/****** 对象:  Table [dbo].[sys_code]    脚本日期: 07/03/2015 10:30:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sys_code](
	[name] [varchar](50) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[code] [varchar](50) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[value] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
	[isenabled] [int] NULL,
 CONSTRAINT [PK_sys_code] PRIMARY KEY CLUSTERED 
(
	[name] ASC,
	[code] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF

USE [db_imovie]
GO
/****** 对象:  Table [dbo].[sys_user]    脚本日期: 07/03/2015 10:30:42 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[sys_user](
	[uid] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](32) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[email] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[mobile] [varchar](11) COLLATE Chinese_PRC_CI_AS NULL,
	[passwd] [varchar](200) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[expires_in] [datetime] NOT NULL,
	[salt] [int] NOT NULL,
	[access_token] [varchar](200) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[address] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
PRIMARY KEY CLUSTERED 
(
	[uid] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[mobile] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[email] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户编号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'uid'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'用户名' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'username'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'电子邮箱' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'email'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'手机' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'mobile'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'密码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'passwd'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'过期时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'expires_in'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'盐值' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'salt'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'访问令牌' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'access_token'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'密码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'sys_user', @level2type=N'COLUMN',@level2name=N'address'

USE [db_imovie]
GO
/****** 对象:  View [dbo].[v_movie_cinema]    脚本日期: 07/03/2015 10:31:15 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE view [dbo].[v_movie_cinema] as 
select m.mid,m.name as movie ,c.cid,c.name as cinema,mp.price,mp.mptype, mp.starttime, cr.crid, 
cr.seat_x,cr.seat_y ,cr.roomname,cr.statu from movie_price mp,movie_info m, cinema c,cinema_room cr  
where mp.cid = c.cid and mp.mid = m.mid and cr.cid = c.cid;

