Flyway整合
---

1. 整合过程中发现`8.2.1`及以后的`flyway`不支持MySQL数据库，需要额外引入新的依赖。
```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-mysql</artifactId>
</dependency>
```
2. 如何调整可重复执行（`repeatable`）脚本和version脚本的顺序？

主要从命名来区分