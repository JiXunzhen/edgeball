use edgeball;

drop table if exists `t_user`;
create table `t_user` (
    `id` bigint(20) primary key auto_increment comment '主键id',
    `name` varchar(128) not null comment '用户名',
    `password` varchar(128) not null comment '密码',
    `mobile` varchar(128) not null comment '手机号',
    `gender` tinyint not null default 0 comment '性别, 0 未知, 1 男, 2 女',
    unique index `uk_name` (`name`),
    unique index `uk_mobile` (`mobile`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

