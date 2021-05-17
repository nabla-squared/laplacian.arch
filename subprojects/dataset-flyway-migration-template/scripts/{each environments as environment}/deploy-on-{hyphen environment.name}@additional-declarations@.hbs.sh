{{define 'db_migrations'
  (unique (filter environment.deployments '(and @it.isa_db_container_deployment @it.enable_db_migration)'))
~}}
{{#each db_migrations as |deployment| ~}}
build_{{lower-snake deployment.name}}_migration() {
  (cd $DEPLOYMENT_BASE_DIR/{{deployment.instance_name}}-migration
    ./gradlew build -x test
  )
}
{{/each}}
