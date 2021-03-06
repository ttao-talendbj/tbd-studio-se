// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.hdinsight360.modulegroup.node.pigoutput;

import java.util.HashSet;
import java.util.Set;

import org.talend.core.hadoop.version.EHadoopDistributions;
import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.condition.BooleanOperator;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.condition.EqualityOperator;
import org.talend.hadoop.distribution.condition.LinkedNodeExpression;
import org.talend.hadoop.distribution.condition.MultiComponentCondition;
import org.talend.hadoop.distribution.constants.PigOutputConstant;
import org.talend.hadoop.distribution.hdinsight360.HDInsight36Constant;
import org.talend.hadoop.distribution.hdinsight360.HDInsight36Distribution;

public class HDInsight36PigOutputNodeModuleGroup {

    private static final ComponentCondition condition = new MultiComponentCondition( //
            new LinkedNodeExpression(PigOutputConstant.PIGSTORE_COMPONENT_LINKEDPARAMETER,
                    ComponentType.PIG.getDistributionParameter(), EqualityOperator.EQ,
                    EHadoopDistributions.MICROSOFT_HD_INSIGHT.getName()), //
            BooleanOperator.AND, //
            new LinkedNodeExpression(PigOutputConstant.PIGSTORE_COMPONENT_LINKEDPARAMETER,
                    ComponentType.PIG.getVersionParameter(), EqualityOperator.EQ, HDInsight36Distribution.VERSION));

    public static Set<DistributionModuleGroup> getModuleGroups() {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        hs.add(new DistributionModuleGroup(HDInsight36Constant.PIG_PARQUET_MODULE_GROUP.getModuleName(), false, condition));
        return hs;
    }
}
