# Linux实战学习

## 一、Linux背景知识

### 1、常见目录介绍

- **/** 根目录
- **/root** root用户的家目录
- **/home/username** 普通用户的家目录
- **/etc** 配置文件目录
- **/bin** 命令目录
- **/sbin** 管理命令目录
- **/usr/bin /usr/sbin** 系统预装的其他命令

## 二、系统操作篇

### 1、万能帮助命令：man、help、info

```bash
# 指定章节，1一般不用写，可省略
// man 1 passwd
# 只知道名字，不知道是命令还是文件，可以用这个命令
// man -a passwd
```

```bash
# 内部命令
// help cd
# 外部命令
// ls --help
# 区分内部命令还是外部命令
// type cd
// type ls
```

```bash
# help 的补充
// info ls
```

### 2、初始pwd和ls命令

```bash
[root@VM-24-10-centos ~]# pwd [option]
[root@VM-24-10-centos ~]# ls [option]
# 切换用户
[root@VM-24-10-centos ~]# su - root
```

- ls的可选项
    - path 展示指定路径的文件

### 3、ls命令详解

- 多个路径

```bash
[root@VM-24-10-centos ~]# ls /root /
/:
bin  boot  data  dev  etc  home  lib  lib64  lost+found  media  mnt  opt  proc  root  run  sbin  srv  sys  tmp  usr  var

/root:
manpages-zh-1.5.1.tar.gz
```

- ls -l

```bash
# 1. 文件类型和权限  
#  1.1 - 表示文件 d 表示目录
#  1.2 rwxrwxrwx 表示权限
# 2. 文件数量
# 3. 用户
# 4. 用户组
# 5. 
# 6. 最后修改时间
# 7. 文件名
[root@VM-24-10-centos ~]# ls -l
总用量 1924
drwxrwxrwx 5 lighthouse lighthouse    4096 1月  30 22:17 manpages-zh-1.5.1
-rw-r--r-- 1 root       root       1965336 12月 17 2010 manpages-zh-1.5.1.tar.gz
# ls -lh 展示文件大小时，以M为单位展示
[root@VM-24-10-centos ~]# ls -lh /tmp/etc-backup.tar*
-rw-r--r-- 1 root root 11M 1月  31 22:15 /tmp/etc-backup.tar.gz
```

- ls -a

```bash
# 隐藏文件 .开头
[root@VM-24-10-centos ~]# ls -a
.              .bash_logout   .cache   manpages-zh-1.5.1         .pydistutils.cfg
..             .bash_profile  .config  manpages-zh-1.5.1.tar.gz  .ssh
.bash_history  .bashrc        .cshrc   .pip                      .tcshrc
```

- ls -r 逆序显示

```bash
[root@VM-24-10-centos ~]# ls -rl
总用量 1924
-rw-r--r-- 1 root       root       1965336 12月 17 2010 manpages-zh-1.5.1.tar.gz
drwxrwxrwx 5 lighthouse lighthouse    4096 1月  30 22:17 manpages-zh-1.5.1
[root@VM-24-10-centos ~]# ls -l
总用量 1924
drwxrwxrwx 5 lighthouse lighthouse    4096 1月  30 22:17 manpages-zh-1.5.1
-rw-r--r-- 1 root       root       1965336 12月 17 2010 manpages-zh-1.5.1.tar.gz
```

- ls -t 按照时间顺序显示

```bash
[root@VM-24-10-centos ~]# ls -l
总用量 1924
drwxrwxrwx 5 lighthouse lighthouse    4096 1月  30 22:17 manpages-zh-1.5.1
-rw-r--r-- 1 root       root       1965336 12月 17 2010 manpages-zh-1.5.1.tar.gz
[root@VM-24-10-centos ~]# ls -rl
总用量 1924
-rw-r--r-- 1 root       root       1965336 12月 17 2010 manpages-zh-1.5.1.tar.gz
drwxrwxrwx 5 lighthouse lighthouse    4096 1月  30 22:17 manpages-zh-1.5.1
```

- ls -R 递归显示

```bash
[root@VM-24-10-centos tmp]# ls -R
.:
8a6be2f9e39171ef24ae0f7757c5d095  setRps.log
cpuidle_support.log               stargate.lock
cvm_init.log                      systemd-private-c1d893f5f6ce491f9b0fa43be2eaf6c3-ntpd.service-9RFUT7
disable_rt_runtime_share.log      tat_agent
net_affinity.log                  virtio_blk_affinity.log
nv_driver_install.log             virtio_blk_affinity_udev.log
nvenc_ai_sdk_install.log          yddaemon.log
nvenc_ai_sdk_install.sh           ydeye_install.log
nv_gpu_conf.log

./8a6be2f9e39171ef24ae0f7757c5d095:

./systemd-private-c1d893f5f6ce491f9b0fa43be2eaf6c3-ntpd.service-9RFUT7:
tmp

./systemd-private-c1d893f5f6ce491f9b0fa43be2eaf6c3-ntpd.service-9RFUT7/tmp:

./tat_agent:
self_update

./tat_agent/self_update:
agent_update_unzip  agent_update.zip

./tat_agent/self_update/agent_update_unzip:
install.sh      tat_agent          tat_agent.service       uninstall.sh
self_update.sh  tat_agent_service  tat_agent_service.conf
```

### 4、cd命令详解

> cd 更改当前的操作目录

- cd /path/to/... 绝对路径 根目录下
- cd ./path/to/... 相对路径 当前目录下
- cd ../path/to/... 相对路径 上级目录下
- cd path/to/... 相对路径 当前目录下
- cd - 切换到上一次操作的目录

```bash
# cd - 表示返回上一次操作的目录
[root@VM-24-10-centos ~]# cd -
/tmp
[root@VM-24-10-centos tmp]# cd -
/root
```

### 5、文件操作命令

- mkdir  创建目录
    - 创建多个文件
    - 创建多级目录
        - mkdir -p /a/b/c/d/e/f/g
- rmdir 删除目录
    - 不允许删除非空目录
- rm 删除目录
    - rm -r 删除(进行提示)
    - rm -r -f 删除(不进行提示)
- cp 复制文件和目录
    - cp -r source target
    - cp -v source target
        - 显示复制进度
    - cp -p source target
        - 保留⽤户、权限、时间等⽂件属性
    - cp -a source target
      - 
- mv 移动文件 或者 重命名文件
- touch 创建文件

### 6、通配符

> 用于操作文件，通常是有规律的文件

- \* 匹配任何字符串
- ? 匹配1个字符串
- [xyz] 匹配xyz任意一个字符
- [a-z] 匹配一个范围
- [!xyz] 或者 [\^xyz] 不匹配xyz任何一个字符

### 7、文本查看命令

- cat
    - 文本内容显示到终端
- head
    - 查看文件开头
- tail
    - 查看文件结尾
    - -f 常用参数，文件内容更新后，显示信息同步更新
- wc
    - 统计文件内容信息
- more
- less

### 7、打包与压缩命令

- tar 打包命令
    - c 执行打包，建立新的存档
    - f 打包为文件
    - z 结合gzip压缩指令 将指定文件(linux一切接文件)打包压缩为.tar.gz双拓展文件
    - j 结合bzip2压缩指令 将指定文件打包压缩为.tar.bz2双拓展文件
    - x 结合gizp或者bzip2解压缩指令，将压缩文件解压
    - -C 指定路径解压
- gzip bzip2 压缩与解压缩命令

```bash
# 
[root@VM-24-10-centos ~]# tar czf /tmp/etc-backup.tar.gz /etc
tar: 从成员名中删除开头的“/”
[root@VM-24-10-centos ~]# tar cjf /tmp/etc-backup.tar.bz2 /etc
tar: 从成员名中删除开头的“/”
[root@VM-24-10-centos ~]# tar cf /tmp/etc-backup.tar /etc
tar: 从成员名中删除开头的“/”
[root@VM-24-10-centos ~]# ls -lh /tmp/etc-backup.tar*
-rw-r--r-- 1 root root  30M 1月  31 22:23 /tmp/etc-backup.tar
-rw-r--r-- 1 root root 9.1M 1月  31 22:23 /tmp/etc-backup.tar.bz2
-rw-r--r-- 1 root root  11M 1月  31 22:15 /tmp/etc-backup.tar.gz
[root@VM-24-10-centos ~]# tar xf /tmp/etc-backup.tar.bz2 -C /root
[root@VM-24-10-centos ~]# ls
a  b  c  etc  manpages-zh-1.5.1  manpages-zh-1.5.1.tar.gz  markus
```

### 8、文本编辑器vi

vim的模式

- 正常模式
    - h 光标向左移动
    - j 光标向下移动
    - k 光标向上移动
    - l 光标向右移动
    - yy 复制当前行的数据
    - y$ 复制当前光标到行尾的数据
    - dd 剪切当前行的数据
    - d$ 剪切当前光标到行尾的数据
    - u 撤销（可多次执行）
    - ctrl+r 重做（可多次执行）
    - x 删除光标所在的元素
    - r 替换光标所在的元素
    - g 光标移至第一行开头位置
    - G 光标移至最后一行开头位置
    - num+G 光标移至指定行数的开头位置
    - ^ 行的开头
    - $ 行的结尾
- 插入模式
    - i 进入插入模式，光标在当前位置
    - I 进入插入模式，光标在当前行的开头位置
    - a 进入插入模式，光标在当前位置的下一位
    - A 进入插入模式，光标在当前行的结尾位置
    - o 进入插入模式，在当前光标上面插入一行
    - O 进入插入模式，在当前光标下面插入一行
- 命令模式
    - : 进入命令行模式
    - :set nu 显示文本行数
        - vim /etc/vimrc 设置指令 set nu 全局展示文件的行号
    - :set nonu 取消显示文本行数
    - :set nohlsearch 取消文本高亮
    - : w fileName 保存到指定路径下的文件（还可以通过vim file 后续编辑文件后进行 : w即可）
    - : q 退出
    - :!command 在文本编辑器中执行其他指令
    - /x 搜索文本当中的x文本
    - :s/old/new 替换光标所在行的第一个old文本到new文本
    - :%s/old/new 替换光标所在行的old文本到new文本
    - :%s/old/new/g 全局替换文本
    - :3,5s/old/new 文本3-5行替换文本old到new
- 可视模式
    - v 字符可视模式
    - V 行可视模式
    - ctrl+v 块可视模式
        - 配合d和I(大写i)命令可以进行块的便利操作

### 9、用户与权限管理

#### 用户管理常用命令

- useradd 新建用户(root用户才有权限)
    - cat /etc/password
    - tail -10 /etc/shadow
    - id user
    - useradd -g gourp user
- userdel 删除用户
    - userdel user 删除指定用户
    - userdel -r user 删除指定用户及其用户目录
- passwd 修改用户密码
    - passwd user设置密码
    - passwd 更改当前用户的密码
- usermod 修改用户属性
    - usermod -d path w
    - usermod -g group user
- chage 修改用户属性

#### 组管理命令

- groupadd 新建用户组
- groupdel 删除用户组

#### 用户切换命令

- su 切换用户
    - su - user 表示切换到user用户下，- 起到的作用是切换过程中将环境一并切换
    - su user 不完全切换
- sudo 以其他用户身份执行命令
    - visudo 设置需要使用sudo的用户(组)

#### 用户配置文件

> vim /etc/passwd 用户配置文件

```bash
ntp:x:38:38::/etc/ntp:/sbin/nologin
# /sbin/nologin 不允许当前用户登录终端
lighthouse:x:1000:1000::/home/lighthouse:/bin/bash
用户名:登录是否需要密码:uid:gid:用户日志:家目录:用户的命令解释器
```



> vim /etc/shadow 用户密码相关配置文件



> vim /etc/group 用户组配置文件

```bash
# 用户组:是否需要密码登录:gid:其他组设置
lighthouse:x:1000:lighthouse
mail:x:12:postfix
```



## 三、系统管理篇

## 四、Shell篇

## 五、文本操作篇

## 六、服务管理篇