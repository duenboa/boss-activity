package com.boa.util;

import com.boa.entity.TPriceConfig;
import com.boa.mapper.TPriceConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 中奖结果概率计算
 *
 * @author DuenBoa
 * @date 2017/10/29
 */
@Component
public class PriceCalcuUtil {

    private static final Random random = new Random();
    private static final int ONE_HUNDRED = 100;
    private static volatile Map<Integer, int[]> levelRangeMap;
    @Autowired
    private TPriceConfigMapper tPriceConfigMapper;

    public void init() {
        List<TPriceConfig> all = tPriceConfigMapper.findAllOrderByLevel();
        int totalProbability = 0;
        int[] currRange;
        int[] lastRange = new int[2];
        boolean isFirst = true;
        for (int i = 0; i < all.size(); i++) {
            TPriceConfig t = all.get(i);
            Integer probability = t.getProbability();
            totalProbability += probability;
            currRange = new int[2];
            if (isFirst) {
                currRange[0] = 0;
                currRange[1] = probability;
                isFirst = false;
            } else {
                currRange[0] = lastRange[1];
                currRange[1] = lastRange[1] + probability;
            }
            lastRange = currRange;
            levelRangeMap.put(t.getLevel(), currRange);
        }

        if (totalProbability != ONE_HUNDRED) {
            throw new RuntimeException("请联系管理员配置中奖概率, 中奖概率之和为100");
        }
    }

    public Integer getGiftLevel() {
        if (levelRangeMap == null) {
            levelRangeMap = new HashMap<>();
            init();
        }
        int val = random.nextInt(100);
        for (Map.Entry<Integer, int[]> entry : levelRangeMap.entrySet()) {
            int[] value = entry.getValue();
            if (val >= value[0] && val <= value[1]) {
                return entry.getKey();
            }
        }
        return null;
    }

}
