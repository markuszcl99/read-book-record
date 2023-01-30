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

## 三、系统管理篇

## 四、Shell篇

## 五、文本操作篇

## 六、服务管理篇