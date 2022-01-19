

```
███╗░░░███╗██╗███╗░░██╗██╗██╗░░██╗
████╗░████║██║████╗░██║██║██║░██╔╝
██╔████╔██║██║██╔██╗██║██║█████═╝░
██║╚██╔╝██║██║██║╚████║██║██╔═██╗░
██║░╚═╝░██║██║██║░╚███║██║██║░╚██╗
╚═╝░░░░░╚═╝╚═╝╚═╝░░╚══╝╚═╝╚═╝░░╚═╝
```


# Minik -  A tiny (mock) web server.

*Implementation a tiny (mock\*) web server in java.*

<div style='page-break-after: always'></div>

*: *future*

<p>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
<img src="https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" />
</p>

## Getting Started



### Prerequisites

| Package     | Version      |
|:----------------|:---------------|
| java| 1.8+ |
| maven| 2.0+ |



## Packaging
```powershell
$ mvn clean package
```

```powershell
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------< com.drovahkinn:minik >------------------------
[INFO] Building minik 0.3
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-enforcer-plugin:3.0.0-M3:enforce (default) @ minik ---
[INFO]
[INFO] --- maven-checkstyle-plugin:3.1.0:check (checkstyle) @ minik ---
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.4:prepare-agent (pre-unit-test) @ minik ---
[WARNING] The artifact xml-apis:xml-apis:jar:2.0.2 has been relocated to xml-apis:xml-apis:jar:1.0.b2
[INFO] argLine set to -javaagent:C:\\Users\\USR\\.m2\\repository\\org\\jacoco\\org.jacoco.agent\\0.8.4\\org.jacoco.agent-0.8.4-runtime.jar=destfile=E:\\DIR\\server\\minik\\target\\jacoco.exec
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ minik ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource to E:\DIR\server\minik\target
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ minik ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 11 source files to E:\DIR\server\minik\target\classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ minik ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory E:\DIR\server\minik\src\test\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ minik ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to E:\DIR\server\minik\target\test-classes
[INFO]
[INFO] --- maven-surefire-plugin:3.0.0-M4:test (default-test) @ minik ---
[INFO] Tests are skipped.
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.4:report (post-unit-test) @ minik ---
[INFO] Skipping JaCoCo execution due to missing execution data file.
[INFO]
[INFO] --- jacoco-maven-plugin:0.8.4:check (check-unit-test) @ minik ---
[INFO] Skipping JaCoCo execution due to missing execution data file:E:\DIR\server\minik\target\jacoco.exec
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ minik ---
[INFO] Building jar: E:\DIR\server\minik\target\minik-0.3.jar
[INFO]
[INFO] --- maven-assembly-plugin:2.2.1:single (make-assembly) @ minik ---
[INFO] META-INF/ already added, skipping
[INFO] META-INF/MANIFEST.MF already added, skipping
[INFO] META-INF/maven/ already added, skipping
[INFO] Building jar: E:\DIR\server\minik\target\minik-0.3-jar-with-dependencies.jar
[INFO] META-INF/ already added, skipping
[INFO] META-INF/MANIFEST.MF already added, skipping
[INFO] META-INF/maven/ already added, skipping
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  13.328 s
[INFO] ------------------------------------------------------------------------
```
JAR will be generated at 
```powershell
DIR\server\minik\target\minik-0.3-jar-with-dependencies.jar
```


## Running

```powershell
java -jar minik.jar <PORT>
```
*default port: 8083*
## License

MIT

## Future


 * Add mock capabilities
 * properties based config management


