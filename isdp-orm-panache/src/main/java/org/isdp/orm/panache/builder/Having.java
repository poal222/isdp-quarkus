package org.isdp.orm.panache.builder;

public final class Having {

    private String aliaOrFunction;
    private Op op;
    private Object value;

    private Having() {
    }

    public static Having of(Op op, Object value){
        Having having = new Having();
        having.op = op;
        having.value = value;
        return having;
    }

    public String getAliaOrFunction() {
        return aliaOrFunction;
    }

    public void setAliaOrFunction(String aliaOrFunction) {
        this.aliaOrFunction = aliaOrFunction;
    }

    public Op getOp() {
        return op;
    }

    public void setOp(Op op) {
        this.op = op;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
