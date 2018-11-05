package cn.ak.gc.commen.model;

import java.util.List;

public class Page<T> {
    private int total;
    private int size;
    private List<T> data;
}
