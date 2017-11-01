package com.boa.service;

import com.boa.common.util.pagination.Page;
import com.boa.entity.TOrder;
import com.boa.entity.TPriceConfig;
import com.boa.enums.DeletedEnum;
import com.boa.enums.TOrderStatusEnum;
import com.boa.mapper.TOrderMapper;
import com.boa.mapper.TPriceConfigMapper;
import com.boa.util.PriceCalcuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;


/**
 * @author duenboa
 */
@Service
public class OrderService {

    @Autowired
    private TOrderMapper tTOrderMapper;
    @Autowired
    private TPriceConfigMapper tPriceConfigMapper;
    @Autowired
    private PriceCalcuUtil priceCalcuUtil;

    public Page<TOrder> page(Page<TOrder> page, TOrder order) {
        Long phone = order.getPhone();
        tTOrderMapper.findPageOrderByCreateDate(page, phone);
        return page;
    }


    public TOrder save(TOrder tOrder) {
        Long phone = tOrder.getPhone();
        Assert.notNull(phone, "电话必填");
        Date now = new Date();
        TOrder condition = new TOrder();
        condition.setPhone(phone);
        List<TOrder> oldList = tTOrderMapper.findByCondition(condition);
        if (oldList != null && !oldList.isEmpty()) {
            TOrder old = oldList.get(0);
            String state = old.getState();
            String msg;
            switch (TOrderStatusEnum.nameOf(state)) {
                case browse:
                    msg = "请到门店领取您的奖品吧~";
                    break;
                case visit:
                    msg = "欢迎您进门店领取您的奖品!";
                    break;
                case taked:
                    msg = "您已经领取了奖品, 您可以推广给好友哦~";
                    break;
                default:
                    msg = "您的手机号[" + phone + "]已经参与过本次活动~";
            }
            throw new IllegalStateException(msg);
        }

        //随机概率
        Integer giftLevel = priceCalcuUtil.getGiftLevel();
        TPriceConfig configCondition = new TPriceConfig();
        configCondition.setLevel(giftLevel);

        List<TPriceConfig> configList = tPriceConfigMapper.findByCondition(configCondition);
        TPriceConfig tPriceConfig = configList.get(0);
        String description = tPriceConfig.getDescription();
        tOrder.setGiftLevel(giftLevel);
        tOrder.setGift(description);
        tOrder.setCreateAt(now);
        tOrder.setState(TOrderStatusEnum.browse.name());
        tOrder.setDeleted(DeletedEnum.NO.getCode());
        tTOrderMapper.save(tOrder);
        return tOrder;
    }


    public void logicDelete(Long id) {
        Assert.notNull(id, "id不能为空");
        TOrder order = tTOrderMapper.findById(id);
        Assert.notNull(order, "id无效,你是坏人");
        order.setDeleted(DeletedEnum.YES.getCode());
        tTOrderMapper.updateById(order);
    }


    public void updateStatus(TOrder order) {
        Assert.notNull(order, "系统参数确少");
        Long id = order.getId();
        String state = order.getState();
        Date visitDate = order.getVisitDate();
        Date takedDate = order.getTakedDate();
        Assert.notNull(id, "id不能为空");
        Assert.hasText(order.getState(), "状态不能为空");
        TOrderStatusEnum statusEnum = TOrderStatusEnum.nameOf(state);
        Assert.notNull(statusEnum, "状态无效");
        TOrder old = tTOrderMapper.findById(id);
        Assert.notNull(old, "id无效,你是坏人");

        /*后台管理系统只能将状态置为到店,已领取奖品. 这时候对应的时间必须输入.
         */
        switch (statusEnum) {
            case visit: {
                Assert.notNull(visitDate, "到店时间必填");
                old.setState(state);
                old.setVisitDate(visitDate);
                break;
            }

            case taked: {
                Assert.notNull(takedDate, "领奖时间必填");
                old.setState(state);
                old.setVisitDate(takedDate);
                break;
            }

        }
        tTOrderMapper.updateById(old);
    }


}
