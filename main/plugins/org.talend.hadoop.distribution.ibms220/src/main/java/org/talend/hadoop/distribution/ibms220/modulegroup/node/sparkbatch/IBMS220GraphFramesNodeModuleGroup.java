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
package org.talend.hadoop.distribution.ibms220.modulegroup.node.sparkbatch;

import java.util.HashSet;
import java.util.Set;

import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.condition.common.SparkBatchLinkedNodeCondition;

public class IBMS220GraphFramesNodeModuleGroup {

	public static final String GRAPHFRAMES_GROUP_NAME = "SPARK-GRAPHFRAMES-LIB-MRREQUIRED-IBMS_2_2_0"; //$NON-NLS-1$

	public static Set<DistributionModuleGroup> getModuleGroups(
			String distribution, String version) {
		Set<DistributionModuleGroup> hs = new HashSet<>();
		DistributionModuleGroup dmg = new DistributionModuleGroup(
				GRAPHFRAMES_GROUP_NAME, true,
				new SparkBatchLinkedNodeCondition(distribution, version)
						.getCondition());
		hs.add(dmg);
		return hs;
	}
}