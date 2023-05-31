package org.isdp.orm.panache.builder;

import java.io.Serializable;
/**
 * 添加对kv数据库的影射支持
 */
public final class KV implements Serializable{

	private static final long serialVersionUID = -3617796537738183236L;
	public String k;
	public Object v;
	public KV(){}
	public KV(String k, Object v){
		this.k = k;
		this.v = v;
	}
	
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	public Object getV() {
		return v;
	}
	public void setV(Object v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return "KV{" +
				"k='" + k + '\'' +
				", v=" + v +
				'}';
	}
}