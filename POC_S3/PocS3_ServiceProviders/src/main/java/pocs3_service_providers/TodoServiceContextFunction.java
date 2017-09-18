package pocs3_service_providers;

import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;

import pocs3_service_definitions.ITodoService;

// @Component(name="TodoServiceContextfunction", service=IContextFunction.class,
// property= {
// "service.context.key=pocs3_service_definitions.ITodoService1",
// "service.context.key2=pocs3_service_definitions.ITodoService2"
// })
public class TodoServiceContextFunction extends ContextFunction {
    @Override
    public Object compute(IEclipseContext context, String contextKey) {

        return new MyTodoServiceImpl(contextKey);
    }

    static class MyTodoServiceImpl implements ITodoService {
        String options;

        MyTodoServiceImpl(String contextKey) {
            this.options = contextKey;
        }

        @Override
        public String getOption() {
            return this.options;
        }

        @Override
        public String toString() {
            return this.options;
        }

    }
}

//@Component(service = ITodoService.class)
//public class TodoServiceContextFunction implements ITodoService {
//    // LogService log;
//
//    @Activate
//    void activate(
//        ComponentContext cc,
//        BundleContext bc,
//        Map<String, Object> config) {}
//
//    @Deactivate
//    void deactivate(
//        ComponentContext cc,
//        BundleContext bc,
//        Map<String, Object> config) {}
//
//    @Modified
//    void modified(Map<String, Object> config) {}
//
//    // @Reference
//    // void setLogService(LogService log) {
//    // this.log = log;
//    // }
//
//    @Override
//    public String getOption() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//}
