/*
 * JSLEE Annotations
 * Copyright (c) 2015 Piotr Grabowski, All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library.
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
