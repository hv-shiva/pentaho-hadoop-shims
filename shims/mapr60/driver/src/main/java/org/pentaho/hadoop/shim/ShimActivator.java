/*! ******************************************************************************
 *
 * Pentaho
 *
 * Copyright (C) 2024 by Hitachi Vantara, LLC : http://www.pentaho.com
 *
 * Use of this software is governed by the Business Source License included
 * in the LICENSE.TXT file.
 *
 * Change Date: 2029-07-20
 ******************************************************************************/
package org.pentaho.hadoop.shim;

import org.pentaho.hadoop.shim.common.osgi.jaas.JaasRealmsRegistrar;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


public class ShimActivator implements BundleActivator {
  private static final String MAPR_LIB_PROPERTY = "mapr.library.flatclass";
  private static final String MAPR_CONFIG_FILE = "mapr.login.conf";

  @Override
  public void start( BundleContext bundleContext ) throws Exception {
    System.setProperty( MAPR_LIB_PROPERTY, "true" );
    JaasRealmsRegistrar registar = new JaasRealmsRegistrar( bundleContext );
    registar.setRealms( MAPR_CONFIG_FILE );
  }

  @Override
  public void stop( BundleContext bundleContext ) throws Exception {

  }
}
