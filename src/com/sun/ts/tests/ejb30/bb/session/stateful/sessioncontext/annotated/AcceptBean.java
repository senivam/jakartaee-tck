/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * @(#)AcceptBean.java	1.1 05/10/17
 */

package com.sun.ts.tests.ejb30.bb.session.stateful.sessioncontext.annotated;

import com.sun.ts.tests.ejb30.common.sessioncontext.AcceptBeanBase;
import com.sun.ts.tests.ejb30.common.sessioncontext.AcceptIF;
import com.sun.ts.tests.ejb30.common.sessioncontext.AcceptLocalIF;
import jakarta.ejb.Local;
import jakarta.ejb.Remote;
import jakarta.ejb.Remove;
import jakarta.ejb.Stateful;
import jakarta.ejb.SessionContext;
import jakarta.annotation.Resource;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;

@Stateful(name = "AcceptBean")
@Remote({ AcceptIF.class })
@Local({ AcceptLocalIF.class })
// use bmt so that it can be safely removed from the calling bean (TestBean)
@TransactionManagement(TransactionManagementType.BEAN)
public class AcceptBean extends AcceptBeanBase {
  @Resource(name = "sessionContext")
  private SessionContext sessionContext;

  protected SessionContext getSessionContext() {
    return sessionContext;
  }

  public AcceptBean() {
  }

  @Remove
  public void remove() {
  }

}
