package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DishService {
    /**
     * 新增菜品
     * @param dishDTO
     */
    public void savewithFlavor(DishDTO dishDTO);

    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    void deleteBatch(List<Long> ids);

    DishVO getByIdWithFlavor(Long id);

    /**
     * 根据ID更新菜品信息
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);

    List<Dish> list(Long categoryId);

    /**
     * 条件查询菜品和口味
     * @param categoryId
     * @return
     */
    List<DishVO> listWithFlavor(Long categoryId);
}
