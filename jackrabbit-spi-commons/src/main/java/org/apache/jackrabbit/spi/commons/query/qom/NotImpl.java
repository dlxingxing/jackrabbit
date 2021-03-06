/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.spi.commons.query.qom;

import javax.jcr.query.qom.Constraint;
import javax.jcr.query.qom.Not;

import org.apache.jackrabbit.spi.commons.conversion.NamePathResolver;

/**
 * <code>NotImpl</code>...
 */
public class NotImpl extends ConstraintImpl implements Not {

    /**
     * The constraint negated by this <code>Not</code> constraint.
     */
    private final ConstraintImpl constraint;

    NotImpl(NamePathResolver resolver, ConstraintImpl constraint) {
        super(resolver);
        this.constraint = constraint;
    }

    /**
     * Gets the constraint negated by this <code>Not</code> constraint.
     *
     * @return the constraint; non-null
     */
    public Constraint getConstraint() {
        return constraint;
    }

    //------------------------< AbstractQOMNode >-------------------------------

    /**
     * Accepts a <code>visitor</code> and calls the appropriate visit method
     * depending on the type of this QOM node.
     *
     * @param visitor the visitor.
     */
    public Object accept(QOMTreeVisitor visitor, Object data) throws Exception {
        return visitor.visit(this, data);
    }

    //------------------------< Object >----------------------------------------

    public String toString() {
        return "NOT " + protect(constraint);
    }

}
