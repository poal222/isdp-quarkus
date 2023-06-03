package org.isdp.orm.panache.criteria;

import org.isdp.orm.panache.builder.Condition;
import org.isdp.orm.support.Dialect;

public class InsertCriteria implements Criteria{



    private Dialect dialect;

    private InsertCriteriaBuilder criteriaBuilder;

    public InsertCriteria(Dialect dialect) {
        this.dialect = dialect;
        criteriaBuilder = new InsertCriteriaBuilder();
    }
    public InsertCriteria insertTable(String tableName){
        criteriaBuilder.insertTable(tableName);
        return this;

    }
    public InsertCriteria insert(Condition... conditions){
        criteriaBuilder.insertColumn(conditions);
        return this;

    }

    @Override
    public CriteriaBuilder getCriteriaBuilder() {
        if(criteriaBuilder == null){
            return new InsertCriteriaBuilder();
        }
        return criteriaBuilder;
    }

    @Override
    public ResultMapBuilder getResultMapBuilder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultMapBuilder'");
    }


}
