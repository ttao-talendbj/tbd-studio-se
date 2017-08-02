// ============================================================================
//
// Copyright (C) 2006-2017 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.ibms210.modulegroup;

import java.util.HashSet;
import java.util.Set;

import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.ibms210.IBMS210Constant;

public class IBMS210HDFSModuleGroup {

	public static Set<DistributionModuleGroup> getModuleGroups() {
		Set<DistributionModuleGroup> hs = new HashSet<>();
		DistributionModuleGroup dmg = new DistributionModuleGroup(
				IBMS210Constant.HDFS_MODULE_GROUP.getModuleName());
		hs.add(dmg);
		return hs;
	}

}
