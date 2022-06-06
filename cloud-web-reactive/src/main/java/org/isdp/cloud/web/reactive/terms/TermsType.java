package org.isdp.cloud.web.reactive.terms;

public enum TermsType {

    like("like"),eq("=");

    private final String name;

    TermsType(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

//    public static void main(String[] args) {
//        System.out.println(TermsType.eq.getName());
//    }

    @Override
    public String toString() {
        return "TermsType{" +
                "name='" + name + '\'' +
                '}';
    }
}
