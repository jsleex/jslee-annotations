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

package profile;

import jsleeannotations.slee.EnvEntry;
import jsleeannotations.slee.ProfileSpec;

@ProfileSpec(id = "Test", name = "Test", vendor = "Test", version = "Test")
@EnvEntry(envEntryName = "test1", envEntryType = java.lang.String.class, envEntryValue = "test1")
public class TestProfile extends TestParent implements TestInterface {
}
