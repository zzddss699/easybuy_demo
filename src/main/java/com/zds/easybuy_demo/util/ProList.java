package com.zds.easybuy_demo.util;

import com.zds.easybuy_demo.entity.Product;

import java.util.List;

/**
 * @ClassName ProList
 * @Description TODO
 * @Author 157
 * @Date 2021/5/7 18:19
 * @Version 1.0
 **/
public class ProList {

    private String Level1;
    private List<String> Level2;
    private List<Product> Level3;

    public String getLevel1() {
        return Level1;
    }

    public void setLevel1(String level1) {
        Level1 = level1;
    }

    public List<String> getLevel2() {
        return Level2;
    }

    public void setLevel2(List<String> level2) {
        Level2 = level2;
    }

    public List<Product> getLevel3() {
        return Level3;
    }

    public void setLevel3(List<Product> level3) {
        Level3 = level3;
    }
}
