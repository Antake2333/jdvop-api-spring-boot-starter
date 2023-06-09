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

异常处理 //待补充

补充说明 新增统一门面 JdVopApiClient后续都只通过这个来调用京东的API,参考例子如下:

```java

@SpringBootTest(classes = DemoApplication.class)
public class ApiTest {
    @Autowired
    private JdVopApiClient client;

    @Test
    void testApi() throws InstantiationException, IllegalAccessException {
        ApiEnum orderConfirmReceived = ApiEnum.ORDER_CONFIRM_RECEIVED;
        OrderConfirmReceivedRequest request = OrderConfirmReceivedRequest.builder().jdOrderId(45465465L).build();
        // toApiRequest 会自动将request转换为对应的apiRequest,当然可以自己根据类型来声明入参,这样写比较方便
        OrderConfirmReceivedResponse execute = client.execute(request.toApiRequest(orderConfirmReceived));
        System.out.println(client.execute(request.toApiRequest(orderConfirmReceived)));
        // PS: 在BaseRequest里面定义了Into方法,重写该方法可以用来适配自己的参数转换成京东的参数,方便对外暴露参数,避免因为京东接口参数不规范恶心影响写代码心情
    }
}
```