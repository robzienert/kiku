# kiku

Testing some spring context hierarchies.

```
2020-04-27 23:49:53.855  INFO 50844 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : Starting KikuApplicationKt on Robs-MacBook-Pro.local with PID 50844 (/Users/rzienert/scratch/kiku/build/classes/kotlin/main started by rzienert in /Users/rzienert/scratch/kiku)
2020-04-27 23:49:53.858  INFO 50844 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : No active profile set, falling back to default profiles: default
2020-04-27 23:49:53.891  INFO 50844 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2020-04-27 23:49:54.215  INFO 50844 --- [  restartedMain] c.r.kiku.shared.SharedPostProcessor      : postProcessBeanDefinitionRegistry for core
2020-04-27 23:49:54.257  INFO 50844 --- [  restartedMain] c.r.kiku.shared.SharedPostProcessor      : postProcessBeanFactory for core
2020-04-27 23:49:54.266  INFO 50844 --- [  restartedMain] Context$$EnhancerBySpringCGLIB$$4be3dc27 : core
2020-04-27 23:49:54.271  INFO 50844 --- [  restartedMain] com.robzienert.kiku.core.CoreService     : post-construct
2020-04-27 23:49:54.282  INFO 50844 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : Started KikuApplicationKt in 0.643 seconds (JVM running for 1.065)
2020-04-27 23:49:54.298  INFO 50844 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : Devtools property defaults active! Set 'spring.devtools.add-properties' to 'false' to disable
2020-04-27 23:49:54.298  INFO 50844 --- [  restartedMain] .e.DevToolsPropertyDefaultsPostProcessor : For additional web related logging consider setting the 'logging.level.web' property to 'DEBUG'

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.6.RELEASE)

2020-04-27 23:49:54.308  INFO 50844 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : No active profile set, falling back to default profiles: default
2020-04-27 23:49:54.539  INFO 50844 --- [  restartedMain] c.r.kiku.shared.SharedPostProcessor      : postProcessBeanDefinitionRegistry for kiku
2020-04-27 23:49:54.541  INFO 50844 --- [  restartedMain] c.r.kiku.shared.SharedPostProcessor      : postProcessBeanFactory for kiku
2020-04-27 23:49:54.629  INFO 50844 --- [  restartedMain] ication$$EnhancerBySpringCGLIB$$b63131c3 : kiku
2020-04-27 23:49:54.630  INFO 50844 --- [  restartedMain] com.robzienert.kiku.app.Bandana          : post-construct
2020-04-27 23:49:54.636  INFO 50844 --- [  restartedMain] com.robzienert.kiku.app.Dog              : Bandana: floral (from app)
2020-04-27 23:49:54.636  INFO 50844 --- [  restartedMain] com.robzienert.kiku.app.Dog              : Collar: purple (from core)
2020-04-27 23:49:54.823  INFO 50844 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2020-04-27 23:49:54.931  INFO 50844 --- [  restartedMain] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port(s): 8080
2020-04-27 23:49:54.934  INFO 50844 --- [  restartedMain] c.robzienert.kiku.app.KikuApplicationKt  : Started KikuApplicationKt in 0.65 seconds (JVM running for 1.717)
```
