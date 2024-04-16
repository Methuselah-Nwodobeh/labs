# Map Reduce Model

-------

## Definition:

- Map reduce is a programming model for processing large datasets in a distributed and parallel manner.

## Main Concepts:

- **The Map Function:**
    - The input data is divided into small chunks, and each chuck is processed individually by the map function.
    - the function generates key-value pairs for the dataset.
    - These pairs are partitioned across nodes in the surprising cluster to be processed.
- **The Reduce Function:**
    - This function processes all values associated with the same key and generates the final output.

## Benefits:

- The biggest benefit is it's scalable, to increase the processing power ou just need to add more nodes.
- The model can be made fault-tolerant easily by passing filed tasks to other nodes.
- This model is very simple to implement and easy to understand

## Limitations:

- Writing MapReduce jobs can be difficult
  as the programmer has to learn distributed computing concepts like data partitioning,
  key-value serialization, and fault tolerance.
- THis model is optimized for throughput rather than low-latency processing; this means there can be high latency,
  especially when performing iterative tasks. Hence, it's not suitable for real-time applications
- It provides suboptimal performance for certain workloads like: graph processing, ML, data streaming. Processing
  engines like Apache Spark may offer better performance.