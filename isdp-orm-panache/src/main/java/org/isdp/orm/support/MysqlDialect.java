package org.isdp.orm.support;

public class MysqlDialect implements Dialect{

    @Override
    public String getDbType() {
       return "Mysql";
    }

    @Override
    public String getPk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPk'");
    }

    @Override
    public String getLimited(int index, int offset) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLimited'");
    }
    
}
