{{#*inline "ENV_TO_JAVA_PROPERTY" ~}}
  {{printf '${%s:+ --%s=}${%s}' (upper-snake PROP_NAME) PROP_NAME (upper-snake PROP_NAME)}} \
{{~/inline ~}}
{{#*inline "CONDITIONAL_OPTION" ~}}
  {{printf '${%s:+ %s}' CONDITION OPTION}} \
{{~/inline ~}}
#!/usr/bin/env bash

set -e
set -x

java \
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_DEBUG' OPTION='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:${DEBUG_PORT}'}}
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_JMX' OPTION='-Dcom.sun.management.jmxremote'}}
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_JMX' OPTION='-Djava.rmi.server.hostname=0.0.0.0'}}
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_JMX' OPTION='-Dcom.sun.management.jmxremote.port=${JMX_PORT}'}}
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_JMX' OPTION='-Dcom.sun.management.jmxremote.rmi.port=${JMX_PORT}'}}
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_JMX' OPTION='-Dcom.sun.management.jmxremote.authenticate=false'}}
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_JMX' OPTION='-Dcom.sun.management.jmxremote.ssl=false'}}
  -Djava.security.egd=file:/dev/./urandom \
  ${IMAGE_VERSION:+ -Dimage.version=}${IMAGE_VERSION} \
  -jar /app/api.jar \
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_JMX' OPTION='--spring.jmx.enabled=true'}}
  {{#if service.blocking_datasources ~}}
  {{>CONDITIONAL_OPTION CONDITION='ENABLE_JMX' OPTION=(concat '--spring.datasource.hikari.register-mbeans=true')}}
  {{~/if}}
  {{#each service.blocking_datasources as |datasource| ~}}
  {{define 'prefix' (concat 'datasource.' (hyphen datasource.name) '.') ~}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'username')}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'password')}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'jdbc-url')}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'hikari.connection-timeout')}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'hikari.idle-timeout')}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'hikari.max-lifetime')}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'hikari.minimum-idle')}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'hikari.maximum-pool-size')}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=(concat prefix 'logging.slow-query-threshold-mills')}}
  {{/each}}
  {{#if service.depends_on_redis_cache ~}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME='spring.redis.password'}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME='spring.redis.host'}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME='spring.redis.port'}}
  {{~/if}}
  {{#each service.configurations as |config| ~}}
  {{>ENV_TO_JAVA_PROPERTY PROP_NAME=config.key}}
  {{/each}}
