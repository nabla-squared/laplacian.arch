{{define 'deployment_components' (unique (map environment.deployments '@it.component')) ~}}
{{#each deployment_components as |component| ~}}
{{#if component.custom_built ~}}
{{#if (eq component.type 'springboot2_api_service_container_image') ~}}
build_{{lower-snake component.name}}() {
  (cd $COMPONENT_BASE_DIR/{{hyphen component.name}}-lib
    ./gradlew publish
  )
  {{#if component.function_model.has_custom_logic ~}}
  (cd $COMPONENT_BASE_DIR/{{hyphen component.name}}-logic
    ./gradlew publish
  )
  {{~/if}}
  (cd $COMPONENT_BASE_DIR/{{hyphen component.name}}
    ./gradlew build
  )
}
{{/if}}
{{/if}}
{{/each}}
