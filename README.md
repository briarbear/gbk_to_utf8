# 项目说明
> 经常阅读书籍附赠代码时或者其他源码时，会遇到很多GBK编码的文本文件，比如java文件，其中的中文在其他编辑器下阅读的效果不好，
如vscode，sublime（也可用插件解决），要是直接能批量将GBK编码的文件转UTF-8该多好，于是，去网上找了相关的软件，结果很遗憾，
就是自己动手造轮子吧，才有这个小工具

---

## 使用说明
- 本开源工程很简单，里面的源码可供Java程序员学习交流，由于是原始版本，也未作其他测试，可能会存在转码失败，请联系本作者修复
- 数据转码前请做好备份操作，以免转码失败丢失
- 针对非程序员用户，可直接将根目录下的`convert.jar`文件复制到你需要转码的`文件夹`下面
- 然后在正确配置Java环境变量的情况下，（未转为exe可执行文件，望见谅），具体配置java环境变量可自信百度，谷歌
- 执行命令格式`java -jar convert.jar 参数1,参数2`，其中参数为你需要转码的文本格式文件，参数已逗号（英文逗号）分隔
-
  ```shell
  java -jar convert.jar txt,java,md
  # 则会将该目录下所有的txt、java、md文件的GBK编码转成UTF-8编码
  ```


---
## 如有其它问题，请联系作者
- [码云](www.gitee.com/val1ant)
- [Github](www.github.com/val1antx)
- [简书](https://www.jianshu.com/p/babd15f88d4a)
- [Blog](www.val1ant.xin)
- E-mail:xiongzp08@163.com
