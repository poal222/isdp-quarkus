package org.isdp.orm.panache.builder;
/**
 * sql条件
 * 抽象出来，所有带参数的都归结为条件
 * <p>
 *  使用方式：
 * 
 * </>
 */


public class Condition {
    /**
     * 参数索引
     */
    private int index;
    /**
     * 参数名称
     */
    private String param;
    /**
     * 参数值
     */
    private Object values;
    
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public String getParam() {
        return param;
    }
    public void setParam(String param) {
        this.param = param;
    }
    public Object getValues() {
        return values;
    }
    public void setValues(Object values) {
        this.values = values;
    }

    public static void main(String[] args) {
        Condition condition = new Condition();
        condition.setIndex(1);
        condition.setParam("code");
        condition.setValues("codevalue");
    }
    
    
}
