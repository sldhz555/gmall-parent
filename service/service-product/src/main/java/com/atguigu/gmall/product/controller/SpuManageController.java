package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.ManageService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "spu")
@RestController
@RequestMapping("admin/product")
public class SpuManageController {
    @Autowired
    private ManageService manageService;


  // http://api.gmall.com/admin/product/{page}/{limit}?category3Id=61
    @ApiOperation("获取spu分页列表")
    @GetMapping("{page}/{limit}")
   public Result getSpuInfoPage(@PathVariable Long page,
                                @PathVariable Long limit,
                                Long category3Id){
        Page<SpuInfo> spuInfoPage = new Page<>(page, limit);
        //获取数据
    IPage<SpuInfo> spuInfoPageList= manageService.getSpuInfoPage(spuInfoPage,category3Id);
        return Result.ok(spuInfoPageList);
   }

    //http://api.gmall.com/admin/product/baseSaleAttrList
    @ApiOperation("获取销售属性")
    @GetMapping("baseSaleAttrList")
    public  Result baseSaleAttrList(){
       List<BaseSaleAttr> list= manageService.getBaseSaleAttrList();

        return Result.ok(list);
    }

   // http://api.gmall.com/admin/product/saveSpuInfo
    @PostMapping("saveSpuInfo")
    @ApiOperation("添加spu")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo){

    manageService.saveSpuInfo(spuInfo);
    return Result.ok();


    }


}
