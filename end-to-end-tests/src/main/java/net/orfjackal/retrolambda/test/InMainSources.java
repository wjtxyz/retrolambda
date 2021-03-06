// Copyright © 2013-2015 Esko Luontola <www.orfjackal.net>
// This software is released under the Apache License 2.0.
// The license text is at http://www.apache.org/licenses/LICENSE-2.0

package net.orfjackal.retrolambda.test;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.Callable;

public class InMainSources {

    public static int callLambda() throws Exception {
        Callable<Integer> lambda = () -> 42;
        return lambda.call();
    }

    public static List<String> useLambdaOfImportedType(List<String> items) {
        return Lists.transform(items, String::toUpperCase);
    }

    public interface Interface {
        default String defaultMethod() {
            return "default";
        }
    }

    public static class Implementer implements Interface {
    }

    public static class Overrider implements Interface {
        @Override
        public String defaultMethod() {
            return "overridden";
        }
    }
}
