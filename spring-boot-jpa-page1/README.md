march action

# JPA:

http://localhost:8080/hello.html
http://localhost:8080/hello

http://localhost:8080/


# JPA 多表关联查询:
<plugin>
                <groupId>com.mysema.maven</groupId>
                <artifactId>apt-maven-plugin</artifactId>
                <version>1.1.3</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>process</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>target/generated-sources/java</outputDirectory>
                            <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                        </configuration>
                    </execution>
                </executions>
            </plugin>


# 关联查询
QApplicationPay qApplicationPay = QApplicationPay.applicationPay;
        QApplication qApplication = QApplication.application;
        JPAQuery<ApplicationPay> query = new JPAQuery<>(entityManager).select(qApplicationPay)
                .from(qApplication, qApplicationPay).where(predicate);
        CostomPageRequest pageable = new CostomPageRequest(pageNum, pageSize);

        Page<ApplicationPay> pageList = this.specialRepository.findAll(query, pageable, qApplicationPay.id.desc());






















