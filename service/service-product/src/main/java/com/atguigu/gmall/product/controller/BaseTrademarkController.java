package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product/baseTrademark")
public class BaseTrademarkController {

   @Autowired
   private BaseTrademarkService baseTrademarkService;

   //http://api.gmall.com/admin/product/baseTrademark/getTrademarkList
   @GetMapping("getTrademarkList")
   @ApiOperation("获取品牌属性")
   public Result getTrademarkList(){
      List<BaseTrademark> list = baseTrademarkService.list(null);
      return Result.ok(list);
   }

   //http://api.gmall.com/admin/product/baseTrademark/{page}/{limit}
   @GetMapping("{page}/{limit}")
   @ApiOperation("获取品牌分页列表")
   public Result getBaseTrademarkPage(@PathVariable Long page,
                                      @PathVariable Long limit){
      Page<BaseTrademark> baseTrademarkPage = new Page<>(page,limit);
      IPage<BaseTrademark> iPage = baseTrademarkService.page(baseTrademarkPage, new QueryWrapper<BaseTrademark>().orderByAsc("id"));
      return Result.ok(iPage);


   }

   //http://api.gmall.com/admin/product/baseTrademark/save
   @PostMapping("save")
   @ApiOperation("添加品牌")
   public Result save(@RequestBody BaseTrademark baseTrademark){
      baseTrademarkService.save(baseTrademark);
      return Result.ok();

   }

   //http://api.gmall.com/admin/product/baseTrademark/update
   @PutMapping("update")
   @ApiOperation("修改品牌")
   public Result update(@RequestBody BaseTrademark baseTrademark){
      baseTrademarkService.updateById(baseTrademark);
      return Result.ok();

   }

   //http://api.gmall.com/admin/product/baseTrademark/remove/{id}
   @DeleteMapping("remove/{id}")
   @ApiOperation("删除品牌")
   public Result remove(@PathVariable Long id){
      baseTrademarkService.removeById(id);
      return Result.ok();
   }

   //http://api.gmall.com/admin/product/baseTrademark/get/{id}
   @GetMapping("get/{id}")
   @ApiOperation("根据id获取品牌")
   public Result get(@PathVariable Long id){
      BaseTrademark baseTrademark = baseTrademarkService.getById(id);
      return Result.ok(baseTrademark);
   }







}
