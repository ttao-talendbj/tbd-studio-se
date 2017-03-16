//============================================================================
//
//Copyright (C) 2006-2017 Talend Inc. - www.talend.com
//
//This source code is available under agreement available at
//%InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
//You should have received a copy of the agreement
//along with this program; if not, write to Talend SA
//9 rue Pages 92150 Suresnes, France
//
//============================================================================
package org.talend.hadoop.distribution.dataproc11.modulegroup;

import java.util.HashSet;
import java.util.Set;

import org.talend.hadoop.distribution.DistributionModuleGroup;

public class Dataproc11HDFSModuleGroup {

 public static final String MODULE_GROUP_NAME = "HDFS-LIB-DATAPROC_1_1_LATEST"; //$NON-NLS-1$

 public static Set<DistributionModuleGroup> getModuleGroups() {
     Set<DistributionModuleGroup> hs = new HashSet<>();
     DistributionModuleGroup dmg = new DistributionModuleGroup(MODULE_GROUP_NAME);
     hs.add(dmg);
     return hs;
 }

}