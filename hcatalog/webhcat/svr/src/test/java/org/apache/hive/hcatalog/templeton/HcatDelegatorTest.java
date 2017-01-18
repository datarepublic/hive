package org.apache.hive.hcatalog.templeton;

import junit.framework.TestCase;

public class HcatDelegatorTest extends TestCase {
    public void testGetCatalogStatementWithUse() {
        HcatDelegator.CatalogStatement cs = HcatDelegator.getCatalogStatement("use db1; show create table x;");
        assertEquals("db1", cs.catalog);
        assertEquals("show create table x", cs.statement);
    }

    public void testGetCatalogStatementWithoutUse() {
        HcatDelegator.CatalogStatement cs = HcatDelegator.getCatalogStatement("show create table db1.x;");
        assertEquals(null, cs.catalog);
        assertEquals("show create table db1.x", cs.statement);
    }
}
