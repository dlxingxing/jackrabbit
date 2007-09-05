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
package org.apache.jackrabbit.core.query.jsr283.qom;

/**
 * Tests whether the {@link #getSelectorName selector} node is a descendant
 * of a node reachable by absolute path {@link #getPath path}.
 * <p/>
 * A node-tuple satisfies the constraint only if:
 * <pre>  selectorNode.getAncestor(n).isSame(session.getNode(path)) &&
 *     selectorNode.getDepth() > n</pre>
 * would return true for some non-negative integer <code>n</code>, where
 * {@link #getSelectorName selectorNode} is the node for the specified
 * selector.
 * <p/>
 * The query is invalid if:
 * <ul>
 * <li>{@link #getSelectorName selector} is not the name of a selector in the
 * query, or</li>
 * <li>{@link #getPath path} is not a syntactically valid absolute path.  Note,
 * however, that if the path is syntactically valid but does not identify a
 * node in the repository (or the node is not visible to this session,
 * because of access control constraints), the query is valid but the
 * constraint is not satisfied.</li>
 * </ul>
 *
 * @since JCR 2.0
 */
public interface DescendantNode
        extends Constraint {
    /**
     * Gets the name of the selector against which to apply this constraint.
     *
     * @return the selector name; non-null
     */
    public String getSelectorName();

    /**
     * Gets the absolute path.
     *
     * @return the path; non-null
     */
    public String getPath();
}
