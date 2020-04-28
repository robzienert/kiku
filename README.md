# kiku

Testing some spring context hierarchies.

```
2020-04-27 23:36:18.911  INFO 50643 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : Starting KikuApplicationKt on Robs-MacBook-Pro.local with PID 50643 (/Users/rzienert/scratch/kiku/build/classes/kotlin/main started by rzienert in /Users/rzienert/scratch/kiku)
2020-04-27 23:36:18.916  INFO 50643 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : No active profile set, falling back to default profiles: default
2020-04-27 23:36:18.966  INFO 50643 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2020-04-27 23:36:19.450  INFO 50643 --- [  restartedMain] c.r.kiku.shared.SharedPostProcessor      : postProcessBeanDefinitionRegistry for core
2020-04-27 23:36:19.534  INFO 50643 --- [  restartedMain] c.r.kiku.shared.SharedPostProcessor      : postProcessBeanFactory for core
2020-04-27 23:36:19.544  INFO 50643 --- [  restartedMain] Context$$EnhancerBySpringCGLIB$$d8aa45a4 : core
2020-04-27 23:36:19.550  INFO 50643 --- [  restartedMain] com.robzienert.kiku.core.CoreService     : post-construct
2020-04-27 23:36:19.560  INFO 50643 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : Started KikuApplicationKt in 0.921 seconds (JVM running for 1.661)
2020-04-27 23:36:19.577  INFO 50643 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2020-04-27 23:36:19.577  INFO 50643 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2020-04-27 23:36:19.587  INFO 50643 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : No active profile set, falling back to default profiles: default
2020-04-27 23:36:19.808  INFO 50643 --- [  restartedMain] c.r.kiku.shared.SharedPostProcessor      : postProcessBeanDefinitionRegistry for kiku
2020-04-27 23:36:19.810  INFO 50643 --- [  restartedMain] c.r.kiku.shared.SharedPostProcessor      : postProcessBeanFactory for kiku
2020-04-27 23:36:19.907  INFO 50643 --- [  restartedMain] ication$$EnhancerBySpringCGLIB$$42f79b40 : kiku
2020-04-27 23:36:19.908  INFO 50643 --- [  restartedMain] com.robzienert.kiku.app.Bandana          : post-construct
2020-04-27 23:36:20.102  INFO 50643 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2020-04-27 23:36:20.201  INFO 50643 --- [  restartedMain] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port(s): 8080
2020-04-27 23:36:20.202  INFO 50643 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : Started KikuApplicationKt in 0.64 seconds (JVM running for 2.303)
```
