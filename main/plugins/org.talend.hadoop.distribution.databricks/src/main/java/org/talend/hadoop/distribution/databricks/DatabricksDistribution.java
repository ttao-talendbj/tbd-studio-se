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
package org.talend.hadoop.distribution.databricks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.talend.hadoop.distribution.AbstractDistribution;
import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.EHadoopVersion;
import org.talend.hadoop.distribution.ESparkVersion;
import org.talend.hadoop.distribution.NodeComponentTypeBean;
import org.talend.hadoop.distribution.component.HiveOnSparkComponent;
import org.talend.hadoop.distribution.component.SparkBatchComponent;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.constants.SparkBatchConstant;
import org.talend.hadoop.distribution.constants.databricks.IDatabricksDistribution;
import org.talend.hadoop.distribution.databricks.modulegroup.DatabricksHiveOnSparkModuleGroup;
import org.talend.hadoop.distribution.databricks.modulegroup.DatabricksSparkBatchModuleGroup;

public class DatabricksDistribution extends AbstractDistribution implements SparkBatchComponent, HiveOnSparkComponent, IDatabricksDistribution {

    public final static String VERSION = "Databricks";

    public static final String VERSION_DISPLAY = "Databricks (Rest API)";

    private final static String YARN_APPLICATION_CLASSPATH = "$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*"; //$NON-NLS-1$

    protected Map<ComponentType, Set<DistributionModuleGroup>> moduleGroups;

    protected Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> nodeModuleGroups;

    protected Map<ComponentType, ComponentCondition> displayConditions;

    protected Map<ComponentType, String> customVersionDisplayNames;

    public DatabricksDistribution() {
        displayConditions = buildDisplayConditions();
        customVersionDisplayNames = buildCustomVersionDisplayNames();
        moduleGroups = buildModuleGroups();
        nodeModuleGroups = buildNodeModuleGroups(getDistribution(), getVersion());
    }

    protected Map<ComponentType, ComponentCondition> buildDisplayConditions() {
        return new HashMap<>();
    }

    protected Map<ComponentType, String> buildCustomVersionDisplayNames() {
        Map<ComponentType, String> result = new HashMap<>();
        return result;
    }

    protected Map<ComponentType, Set<DistributionModuleGroup>> buildModuleGroups() {
        Map<ComponentType, Set<DistributionModuleGroup>> result = new HashMap<>();
        result.put(ComponentType.SPARKBATCH, DatabricksSparkBatchModuleGroup.getModuleGroups());
        result.put(ComponentType.HIVEONSPARK, DatabricksHiveOnSparkModuleGroup.getModuleGroups());
        return result;
    }

    protected Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> buildNodeModuleGroups(String distribution, String version) {
        Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> result = new HashMap<>();
        // Azure
        return result;
    }

	@Override
	public String getDistribution() {
		// TODO Auto-generated method stub
        return DISTRIBUTION_NAME;
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
        return VERSION;
	}

	@Override
	public EHadoopVersion getHadoopVersion() {
		// TODO Auto-generated method stub
        return EHadoopVersion.HADOOP_2;
	}

	@Override
	public boolean doSupportKerberos() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDistributionName() {
		// TODO Auto-generated method stub
        return DISTRIBUTION_DISPLAY_NAME;
	}

	@Override
	public String getVersionName(ComponentType componentType) {
		// TODO Auto-generated method stub
        return VERSION_DISPLAY;
	}

	@Override
	public boolean doSupportUseDatanodeHostname() {
		// TODO Auto-generated method stub
        return true;
	}

	@Override
	public Set<DistributionModuleGroup> getModuleGroups(
			ComponentType componentType) {
		// TODO Auto-generated method stub
        return moduleGroups.get(componentType);
	}
	
	@Override
	public Set<ESparkVersion> getSparkVersions() {
		Set<ESparkVersion> version = new HashSet<>();
		version.add(ESparkVersion.SPARK_2_2_1);
        return version;
    }

	@Override
	public boolean doSupportDynamicMemoryAllocation() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean doSupportCrossPlatformSubmission() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean doSupportImpersonation() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean isDatabricksDistribution() {
	    return true;
	}
	
	@Override
	public boolean isCloudDistribution() {
	    return true;
    }
	
	@Override
	public boolean useCloudLauncher() {
	    return true;
    }
	
	@Override
	public boolean doSupportSparkStandaloneMode() {
	    return false;
    }
	
	@Override
	public boolean doSupportSparkYarnClientMode() {
	    return false;
    }
	
    @Override
    public boolean doSupportAzureBlobStorage() {
        return true;
    }

    @Override
    public boolean doSupportAzureDataLakeStorage() {
        return true;
    }

}