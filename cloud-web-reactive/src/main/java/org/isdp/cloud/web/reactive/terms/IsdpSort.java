package org.isdp.cloud.web.reactive.terms;


import java.io.Serializable;
import java.util.List;

public class IsdpSort implements Serializable {

    private List<columns> columnsList;

    public List<columns> getColumnsList() {
        return columnsList;
    }

    public void setColumnsList(List<columns> columnsList) {
        this.columnsList = columnsList;
    }

    public IsdpSort() {
    }

    public void toSort() {

    }

    private class  columns{
        private String name;
        private String direction = "Ascending";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }
    }
}
