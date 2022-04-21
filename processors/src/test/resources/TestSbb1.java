/*
 * JSLEE Annotations
 * Copyright (C) 2015 Piotr Grabowski
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package sbb;

import com.jsleex.annotation.*;
import com.jsleex.annotation.Sbb;
import com.jsleex.annotation.example.TestLocalInterface;
import com.jsleex.annotation.example.TestParent;

import javax.slee.*;

@Service(name = "Test", vendor = "Test", version = "1.0")
@Sbb(name = "Test", vendor = "Test", version = "1.0", sbbLocalInterfaceName = TestLocalInterface.class)
@LibraryRef(name = "ExampleLibrary", vendor = "Test", version = "1.0")
@RaTypeBinding(resourceAdaptorTypeName = "ExampleRA", resourceAdaptorTypeVendor = "Test", resourceAdaptorTypeVersion = "1.0",
        resourceAdaptorEntityLinks = "test-entity", resourceAdaptorObjectNames = "test-object")
@SbbRef(name = "ExampleChild", vendor = "Test", version = "1.0", alias = "exampleChildSbb")
@EjbRef(ejbRefName = "ExampleEjb", ejbRefType = EjbRef.EjbRefType.ENTITY, home = "com.jsleex.ejb.ExampleEJB", remote = "remote", ejbLink = "ejbLink")
@SbbActivityContextAttributeAlias(attributeAliasName = "alias", sbbActivityContextAttributesNames = "example")
public abstract class TestSbb1 extends TestParent {
    @EventMethod(eventTypeName = "ExampleEvent", eventTypeVendor = "Test", eventTypeVersion = "1.0",
            initialEventSelectVariable = { EventMethod.InitialEventSelectVariable.ACTIVITY_CONTEXT, EventMethod.InitialEventSelectVariable.EVENT},
            initialEvent = true)
    public void onExampleEvent(Object event, ActivityContextInterface aci) {

    }

    @EventMethod(eventTypeName = "ExampleEvent", eventTypeVendor = "Test", eventTypeVersion = "1.0")
    public abstract void fireExampleEvent(Object event, ActivityContextInterface aci, Address address);

    @ChildRelationMethod(sbbAliasRef = "exampleChildSbb")
    public abstract ChildRelation getExampleChildSbb();
}
