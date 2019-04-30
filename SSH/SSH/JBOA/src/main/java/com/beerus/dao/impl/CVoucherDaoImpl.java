package com.beerus.dao.impl;

import com.beerus.dao.CVoucherDao;
import com.beerus.entity.BizClaimVoucher;
import com.beerus.utils.HibernateUtils;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Beerus
 * @Description
 * @Date 2019/4/15
 **/
public class CVoucherDaoImpl implements CVoucherDao {
    public Serializable save(BizClaimVoucher claimVoucher) {
        return HibernateUtils.getSession().save(claimVoucher);
    }

    public List<BizClaimVoucher> listAllVoucherByFilter(BizClaimVoucher claimVoucher, int currSize, int pageSize) {
        StringBuffer sb = new StringBuffer("FROM BizClaimVoucher WHERE 1 = 1  ");
        Query query = appendFilter(sb, claimVoucher);
        query.setFirstResult((currSize - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }


    public int count_Row(BizClaimVoucher claimVoucher) {
        StringBuffer sb = new StringBuffer("SELECT COUNT(id) FROM BizClaimVoucher WHERE 1 = 1  ");
        return ((Long) appendFilter(sb, claimVoucher).uniqueResult()).intValue();
    }


    public BizClaimVoucher getVoucher(int id) {
        return (BizClaimVoucher) HibernateUtils.getSession().createQuery(
                "FROM BizClaimVoucher WHERE id = :id").setParameter("id", id).uniqueResult();
    }

    /**
     * 拼接条件
     *
     * @param sb
     * @param claimVoucher
     * @return
     */
    private Query appendFilter(StringBuffer sb, BizClaimVoucher claimVoucher) {
        if (null != claimVoucher) {
            boolean isT = false;
            //判断是什么职务拼接对应的hql语句
            if (null != claimVoucher.getNextDealSn() && null != claimVoucher.getNextDealSn().getSn() && 0 < claimVoucher.getNextDealSn().getSn().length()) {
                sb.append(" AND nextDealSn.sn = :sn");
                isT = true;
            }
            //拼接创建报销单员工
            if (null != claimVoucher.getSn() && claimVoucher.getSn().length() > 0 && !isT) {
                sb.append(" AND createSn.sn = :sn");
            }
            //拼接状态
            if (null != claimVoucher.getStatus() && claimVoucher.getStatus().length() > 0) {
                sb.append(" AND status = :status");
            }
            //创建时间
            if (null != claimVoucher.getCreateTime()) {
                sb.append(" AND createTime = :createTime");
            }
            //拼接结束时间
            if (null != claimVoucher.getModifyTime()) {
                sb.append(" AND modifyTime = :modifyTime");
            }
            sb.append(" ORDER BY createTime DESC");
            return HibernateUtils.getSession().createQuery(sb.toString()).setProperties(claimVoucher);
        }
        sb.append(" ORDER BY createTime DESC");
        return HibernateUtils.getSession().createQuery(sb.toString());
    }
}
