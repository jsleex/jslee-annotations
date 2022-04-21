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

import com.jsleex.annotation.Sbb;
import com.jsleex.annotation.Service;
import com.jsleex.annotation.example.TestParent;

@Service(name = "Test2", vendor = "Test", version = "1.0")
@Sbb(name = "Test2", vendor = "Test", version = "1.0", reentrant = true)
public abstract class TestSbb2 extends TestParent {
}
