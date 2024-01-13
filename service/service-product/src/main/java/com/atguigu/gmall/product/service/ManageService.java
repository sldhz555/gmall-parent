package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

public interface ManageService {
    //获取一级分类
    List<BaseCategory1> getCategory1();

    //获取二级分类
    List<BaseCategory2> getCategory2(Long category1Id);

    //获取三级分类
    List<BaseCategory3> getCategory3(Long category2Id);

    //根据id获取属性与属性值
    List<BaseAttrInfo> getAttrInfoList(Long category1Id, Long category2Id, Long category3Id);

    //添加或修改属性
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    //根据平台属性ID获取平台属性对象数据
    List<BaseAttrValue> getAttrValueList(Long attrId);
    //获取spu分页列表
    IPage<SpuInfo> getSpuInfoPage(Page<SpuInfo> spuInfoPage, Long category3Id);


    //获取销售属性
    List<BaseSaleAttr> getBaseSaleAttrList();

    //添加spu
    void saveSpuInfo(SpuInfo spuInfo);
}
