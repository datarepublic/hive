package org.apache.hive.hcatalog.templeton;

import junit.framework.TestCase;
import org.junit.Before;

public class HcatDelegatorTest extends TestCase {

    @Before
    public void setUp(){
        final String[] args = new String[] {};
        final Main main = new Main(args);
        final AppConfig config = main.getAppConfigInstance();
    }

    public void testGetCatalogStatementWithUse() {
        HcatDelegator.SchemaStatement cs = HcatDelegator.getSchemaStatement("use db1; show create table x;");
        assertEquals("db1", cs.schema);
        assertEquals("show create table x", cs.statement);
    }

    public void testGetCatalogStatementWithoutUse() {
        HcatDelegator.SchemaStatement cs = HcatDelegator.getSchemaStatement("show create table db1.x;");
        assertEquals(null, cs.schema);
        assertEquals("show create table db1.x", cs.statement);
    }
}
