

# **DateHistogramInterval**
**namespace:** laplacian.arch.backend.api.elasticsearch.aggregate

An entity describing a date_histogram_interval.



---

## Properties

### type: `String`
The type of this date_histogram_interval.

### unit: `String`
The unit of this date_histogram_interval.

### value: `String`
The value of this date_histogram_interval.

### variable_unit: `Boolean`
Defines this date_histogram_interval is variable_unit or not.
- **Code:**
  ```kotlin
  unit.contains("\${")
  ```

### variable_value: `Boolean`
Defines this date_histogram_interval is variable_value or not.
- **Code:**
  ```kotlin
  value.contains("\${")
  ```

## Relationships
