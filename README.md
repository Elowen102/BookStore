# BookStore

Spring Boot + Kotlin 后端项目骨架，适合图书/书店类业务场景。

## 技术栈
- Kotlin
- Spring Boot 3.x
- Spring Data JPA
- PostgreSQL
- Flyway
- Spring Security（基础准备）
- OpenAPI / Swagger UI

## 目录结构
```text
.
├── src/
│   ├── main/
│   │   ├── kotlin/com/elowen102/bookstore/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── BookStoreApplication.kt
│   │   └── resources/
│   │       ├── application.yml
│   │       └── db/migration/
│   └── test/
├── Dockerfile
├── docker-compose.yml
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## 快速运行
```bash
gradle bootRun
```

## 本地数据库
使用 PostgreSQL，默认配置如下：
- URL: jdbc:postgresql://localhost:5432/bookstore
- 用户名: bookuser
- 密码: password

也可以直接启动容器：
```bash
docker compose up --build
```

## API
应用启动后，可访问：
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- 书籍 API: http://localhost:8080/api/v1/books

## 说明
当前仓库已初始化为可扩展的后端脚手架，后续可继续加入：
- 用户认证
- 订单模块
- 购物车模块
- 文件上传
- Redis 缓存
- 前端对接
