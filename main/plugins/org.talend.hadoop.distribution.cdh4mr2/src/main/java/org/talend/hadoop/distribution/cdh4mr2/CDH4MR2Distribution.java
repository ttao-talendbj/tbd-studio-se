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

package org.talend.hadoop.distribution.cdh4mr2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.talend.hadoop.distribution.AbstractDistribution;
import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.EHadoopVersion;
import org.talend.hadoop.distribution.component.HBaseComponent;
import org.talend.hadoop.distribution.component.HDFSComponent;
import org.talend.hadoop.distribution.component.HiveComponent;
import org.talend.hadoop.distribution.component.MRComponent;
import org.talend.hadoop.distribution.component.PigComponent;
import org.talend.hadoop.distribution.component.SqoopComponent;
import org.talend.hadoop.distribution.condition.BasicExpression;
import org.talend.hadoop.distribution.condition.BooleanOperator;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.condition.EqualityOperator;
import org.talend.hadoop.distribution.condition.MultiComponentCondition;
import org.talend.hadoop.distribution.condition.NestedComponentCondition;
import org.talend.hadoop.distribution.condition.SimpleComponentCondition;
import org.talend.hadoop.distribution.constants.Constant;
import org.talend.hadoop.distribution.constants.cdh.IClouderaDistribution;

@SuppressWarnings("nls")
public class CDH4MR2Distribution extends AbstractDistribution implements HDFSComponent, MRComponent, HBaseComponent,
        SqoopComponent, PigComponent, HiveComponent, IClouderaDistribution {

    public static final String VERSION = "Cloudera_CDH4_YARN";

    public static final String VERSION_DISPLAY = "Cloudera CDH4.3+(YARN mode) - DEPRECATED";

    private final static String YARN_APPLICATION_CLASSPATH = "$HADOOP_CONF_DIR,$HADOOP_COMMON_HOME/*,$HADOOP_COMMON_HOME/lib/*,$HADOOP_HDFS_HOME/*,$HADOOP_HDFS_HOME/lib/*,$HADOOP_MAPRED_HOME/*,$HADOOP_MAPRED_HOME/lib/*,$YARN_HOME/*,$YARN_HOME/lib/*,$HADOOP_YARN_HOME/*,$HADOOP_YARN_HOME/lib/*,$HADOOP_COMMON_HOME/share/hadoop/common/*,$HADOOP_COMMON_HOME/share/hadoop/common/lib/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/*,$HADOOP_HDFS_HOME/share/hadoop/hdfs/lib/*,$HADOOP_YARN_HOME/share/hadoop/yarn/*,$HADOOP_YARN_HOME/share/hadoop/yarn/lib/*"; //$NON-NLS-1$

    private static Map<ComponentType, Set<DistributionModuleGroup>> moduleGroups;

    private static Map<ComponentType, ComponentCondition> displayConditions = new HashMap<>();

    static {
        moduleGroups = new HashMap<>();

        ComponentCondition c1 = new NestedComponentCondition(new MultiComponentCondition(new SimpleComponentCondition(
                new BasicExpression(Constant.PIG_STORE_PARAMETER, EqualityOperator.NOT_EQ, Constant.PIG_HCATSTORER_PARAMETER)),
                BooleanOperator.AND, //
                new SimpleComponentCondition(new BasicExpression(Constant.PIG_STORE_PARAMETER, EqualityOperator.NOT_EQ,
                        Constant.PIG_PARQUETSTORER_PARAMETER))));
        displayConditions.put(ComponentType.PIGOUTPUT, c1);
    }

    @Override
    public String getDistribution() {
        return DISTRIBUTION_NAME;
    }

    @Override
    public String getDistributionName() {
        return DISTRIBUTION_DISPLAY_NAME;
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public String getVersionName(ComponentType componentType) {
        return VERSION_DISPLAY;
    }

    @Override
    public EHadoopVersion getHadoopVersion() {
        return EHadoopVersion.HADOOP_2;
    }

    @Override
    public boolean doSupportKerberos() {
        return true;
    }

    @Override
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType) {
        return moduleGroups.get(componentType);
    }

    @Override
    public String getYarnApplicationClasspath() {
        return YARN_APPLICATION_CLASSPATH;
    }

    @Override
    public boolean doSupportUseDatanodeHostname() {
        return true;
    }

    @Override
    public boolean doSupportCrossPlatformSubmission() {
        return false;
    }

    @Override
    public boolean doSupportSequenceFileShortType() {
        return true;
    }

    @Override
    public boolean doSupportNewHBaseAPI() {
        return false;
    }

    @Override
    public boolean doJavaAPISupportStorePasswordInFile() {
        return false;
    }

    @Override
    public boolean doJavaAPISqoopImportSupportDeleteTargetDir() {
        return true;
    }

    @Override
    public boolean doJavaAPISqoopImportAllTablesSupportExcludeTable() {
        return true;
    }

    @Override
    public boolean doSupportHCatalog() {
        return false;
    }

    @Override
    public boolean pigVersionPriorTo_0_12() {
        // return false because this distribution doesn't support HCatalog.
        return false;
    }

    @Override
    public boolean doSupportHBase() {
        return true;
    }

    @Override
    public boolean doSupportImpersonation() {
        return true;
    }

    @Override
    public boolean doSupportHive1() {
        return true;
    }

    @Override
    public boolean doSupportHive2() {
        return true;
    }

    @Override
    public boolean doSupportTezForHive() {
        return false;
    }

    @Override
    public boolean doSupportHBaseForHive() {
        return true;
    }

    @Override
    public boolean doSupportSSL() {
        return true;
    }

    @Override
    public boolean doSupportORCFormat() {
        return false;
    }

    @Override
    public boolean doSupportAvroFormat() {
        return true;
    }

    @Override
    public boolean doSupportParquetFormat() {
        return true;
    }

    @Override
    public boolean doSupportStoreAsParquet() {
        return false;
    }

    @Override
    public ComponentCondition getDisplayCondition(ComponentType componentType) {
        return displayConditions.get(componentType);
    }

    // Note :
    // Azure Blob & Datalake support have been disabled for now on this distribution
    // New versions of this distribution should be tested for Azure support and
    // the changes backported to all earlier versions
    @Override
    public boolean doSupportAzureBlobStorage() {
        return false;
    }

    @Override
    public boolean doSupportAzureDataLakeStorage() {
        return false;
    }

    @Override
    public boolean isActivated() {
        return false;
    }

    // End

}
