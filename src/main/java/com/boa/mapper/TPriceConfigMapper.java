package com.boa.mapper;

import com.boa.entity.TPriceConfig;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TPriceConfigMapper extends BaseMapper<TPriceConfig, Long> {


    List<TPriceConfig> findAllOrderByLevel();

}