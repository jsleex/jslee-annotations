/*
 * JSLEE Annotations
 * Copyright (c) 2015-2022 Piotr Grabowski, All rights reserved.
 */

package com.jsleex.annotation;

import javax.slee.ActivityContextInterface;
import javax.slee.SbbLocalObject;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Sbb {
    String id() default "";

    String name();

    String vendor();

    String version();

    boolean reentrant() default false;

    Class<? extends SbbLocalObject> sbbLocalInterfaceName() default SbbLocalObject.class;

    String sbbLocalInterfaceDescription() default "";

    Class<? extends ActivityContextInterface> sbbActivityContextInterfaceName() default ActivityContextInterface.class;

    String sbbActivityContextInterfaceDescription() default "";

    Class sbbUsageParameterInterfaceName() default void.class;

    String sbbUsageParameterInterfaceDescription() default "";

    String addressProfileSpecAliasRef() default "";

    String securityPermissions() default "";
}
