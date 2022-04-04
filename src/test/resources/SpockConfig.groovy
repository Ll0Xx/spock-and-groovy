import org.spockframework.runtime.model.parallel.ExecutionMode

runner {
    parallel {
        enabled true
        defaultExecutionMode = ExecutionMode.CONCURRENT
    }
}
