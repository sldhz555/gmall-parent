package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.*;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.product.service.ManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api(tags = "商品基础属性接口")
@RestController
@RequestMapping("admin/product")
public class BaseManageController {
    @Autowired
    private ManageService manageService;




    @GetMapping("getCategory1")
    @ApiOperation("获取一级分类")
    public Result getCategory1(){

        List<BaseCategory1> category1 = manageService.getCategory1();

        return Result.ok(category1);
    }

    @GetMapping("getCategory2/{category1Id}")
    @ApiOperation("获取二级分类")
    public Result getCategory2(@PathVariable Long category1Id){
       List<BaseCategory2> category2= manageService.getCategory2(category1Id);
        return Result.ok(category2);
    }

    @GetMapping("getCategory3/{category2Id}")
    @ApiOperation("获取三级分类")
    public Result getCategory3(@PathVariable Long category2Id){
        List<BaseCategory3> category3= manageService.getCategory3(category2Id);
        return Result.ok(category3);
    }

    @GetMapping("attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    @ApiOperation("根据id获取属性与属性值")
   public Result attrInfoList(@PathVariable Long category1Id,
                              @PathVariable Long category2Id,
                              @PathVariable Long category3Id){

    List<BaseAttrInfo> list=  manageService.getAttrInfoList(category1Id,category2Id,category3Id);

        return Result.ok(list);
   }

   @PostMapping("saveAttrInfo")
   @ApiOperation("添加或修改平台属性")
  public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo ){
        manageService.saveAttrInfo(baseAttrInfo);

    return Result.ok();
  }

  @GetMapping("getAttrValueList/{attrId}")
  @ApiOperation("根据平台属性ID获取平台属性对象数据")
    public Result getAttrValueList(@PathVariable Long attrId){
    List<BaseAttrValue> list=  manageService.getAttrValueList(attrId);

    return Result.ok(list);

  }



}
