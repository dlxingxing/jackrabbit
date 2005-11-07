/*
 * Copyright 2004-2005 The Apache Software Foundation or its licensors,
 *                     as applicable.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.jackrabbit.server;

import javax.jcr.LoginException;
import javax.jcr.Session;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * This Interface defines a provider for repository sessions
 */
public interface SessionProvider {

    /**
     * Provides the repository session suitable for the given request.
     *
     * @param request
     * @param rep the repository to login
     * @param workspace the workspace name
     * @return the session or null
     * @throws LoginException if the credentials are invalid
     * @throws ServletException if an error occurrs
     */
    public Session getSession(HttpServletRequest request, Repository rep, String workspace)
            throws LoginException, ServletException, RepositoryException;

    /**
     * Informs this provider that the session aquired by a previous
     * {@link #getSession} call is no longer needed.
     *
     * @param session
     */
    public void releaseSession(Session session);
}
