{{define 'deployments_with_migration' (unique (filter environment.deployments '@it.initial_data')) ~}}
{{#each deployments_with_migration as |deployment| ~}}
build_{{lower-snake deployment.name}}_migration() {
  (cd $DEPLOYMENT_BASE_DIR/{{deployment.instance_name}}-migration
    ./gradlew build
  )
}
{{/each}}
