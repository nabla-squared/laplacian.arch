#!/usr/bin/env bash
set -e
PROJECT_BASE_DIR=$(cd $"${BASH_SOURCE%/*}/../" && pwd)
SCRIPT_BASE_DIR="$PROJECT_BASE_DIR/scripts"
DEPLOYMENT_BASE_DIR=$PROJECT_BASE_DIR/environments/{{hyphen environment.name}}
COMPONENT_BASE_DIR=$PROJECT_BASE_DIR/components
{{define 'deployment_components' (unique (map environment.deployments '@it.component')) ~}}
{{define 'db_migrations'
  (unique (filter environment.deployments '(and @it.isa_db_container_deployment @it.enable_db_migration)'))
~}}
main () {
  build_components
  build_migration_tasks
  deploy_containers
}

build_components() {
  echo "Building deployable components..."
  {{#each deployment_components as |component| ~}}
  {{#if component.custom_built ~}}
  build_{{lower-snake component.name}}
  {{/if}}
  {{/each}}
}

build_migration_tasks() {
  echo "Building data migration tasks..."
  {{#each db_migrations as |deployment| ~}}
  build_{{lower-snake deployment.name}}_migration
  {{/each}}
}

deploy_containers() {
  echo "Deploying application modules..."
  (cd $DEPLOYMENT_BASE_DIR
    docker-compose rm \
      --force

    docker-compose up \
      --force-recreate \
      --build
  )
}

#@+additional-declarations@
#@additional-declarations@

main
