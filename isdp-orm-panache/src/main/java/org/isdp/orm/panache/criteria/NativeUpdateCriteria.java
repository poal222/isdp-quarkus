package org.isdp.orm.panache.criteria;

import org.isdp.orm.support.Dialect;
/**
 * 原生 update 类sql 组装器
 */
public class NativeUpdateCriteria implements Criteria{

    

    private Dialect dialect;

    private NativeUpdateCriteriaBuilder criteriaBuilder;

    public NativeUpdateCriteria(Dialect dialect) {
        this.dialect = dialect;
        criteriaBuilder = new NativeUpdateCriteriaBuilder();
    }

        /**
     * 原生update sql
     * @param sql 完整的原生update语句
     */
    public NativeUpdateCriteria updateSql(String sql){
        getCriteriaBuilder().updateSql(sql);
        return this;
    }

    @Override
    public NativeUpdateCriteriaBuilder getCriteriaBuilder() {
        if(criteriaBuilder == null){
            return new NativeUpdateCriteriaBuilder();
        }
        return criteriaBuilder;
    }

    @Override
    public ResultMapBuilder getResultMapBuilder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getResultMapBuilder'");
    }
}
