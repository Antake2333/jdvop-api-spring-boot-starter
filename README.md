# jdvop-api-spring-boot-starter

jdvop api for springboot java JD 大客户文档对接APi

如何使用

1.引入依赖(maven)

```xml

<dependency>
    <groupId>com.orcas</groupId>
    <artifactId>jdvop-api-spring-boot-starter</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

2.配置application.properties

```properties
debug=true
jdvop.url=xxxx (提供默认的)
jdvop.client-id=xxxxxxxx
jdvop.client-secret=xxxxxx
jdvop.username=xxxxxxx
jdvop.password=xxxxxxx
jdvop.temp-token=ddddddd (测试临时TOKEN配置,避免频繁获取TOKEN)
```

3.扫描组件(可以按需扫描)

```java

@SpringBootApplication
@ComponentScan(basePackages = {"com.orcas"})
public class DemoApplication {
}
```

4.引入client

```java

@SpringBootTest(classes = DemoApplication.class)
public class AddressTest {
    @Autowired
    private AddressClient client;

    @Test
    void first() {
        System.out.println(client.getFirstAddress());
    }
}
```
异常处理 
//待补充