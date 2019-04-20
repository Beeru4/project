package com.beerus.dao.impl;

import com.beerus.dao.HouseDao;
import com.beerus.entity.House;
import com.beerus.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class HouseDaoImpl extends HibernateUtils implements HouseDao {

    public List<House> listFindAllHouse() {
        return getSession().createQuery("FROM House").list();
    }

    public List<House> listFindByUserHouse(Integer id) {
        return getSession().createQuery("FROM House WHERE users.id = ?").setInteger(0, id).list();
    }

    public Integer saveHouse(House house) {
        Serializable id = getSession().save(house);
        return null == id ? null : (Integer) id;
    }

    public List<House> listByConditionHouse(House params) throws HibernateException {
        StringBuffer sb = new StringBuffer("FROM House WHERE 1 = 1 ");
        Query query = currentSql(sb, params);
        if (null != params) {
            return query.setProperties(params).list();
        }
        return query.list();
    }

    public List<House> listByPageHouse(House params, int currPageNo, int pageSize) throws HibernateException {
        StringBuffer sb = new StringBuffer("FROM House WHERE 1 = 1 ");
        Query query = currentSql(sb, params);
        query.setFirstResult((currPageNo - 1) * pageSize);
        query.setMaxResults(pageSize);
        if (null != params) {
            return query.setProperties(params).list();
        }
        return query.list();
    }


    public Long totalRow(House params) {
        StringBuffer sb = new StringBuffer("SELECT COUNT(id) FROM House WHERE 1 = 1 ");
        Query query = currentSql(sb, params);
        if (null != params) {
            return (Long) (query.setProperties(params).uniqueResult());
        }
        return (Long) (query.uniqueResult());
    }

    public House getHouseById(Integer id) {
        return (House) getSession().createQuery("FROM House WHERE id = :id").setParameter("id", id).uniqueResult();
    }

    /**
     * 生成sql语句方法
     *
     * @param params 条件
     * @return
     */
    private Query currentSql(StringBuffer sb, House params) {
        if (null != params) {
            //拼接标题
            if (null != params.getTitle() && !"".equals(params.getTitle().trim())) {
                params.setTitle("%" + params.getTitle() + "%");
                sb.append("  AND title LIKE :title");
            }
            //拼接价格
            if (null != params.getPrice()) {
                switch (params.getPrice()) {
                    case 100:
                        sb.append("  AND price < :price");
                        break;
                    case 200:
                        sb.append("  AND price >= 100 AND price < 200");
                        break;
                    case 201:
                        sb.append("  AND price  >= 200 AND price < 50000");
                        break;
                }
            }
            //拼接位置
            if (null != params.getPostion() && 0 != params.getPostion()) {
                sb.append("  AND street.id = :postion");
            }
            //拼接房型
            if (null != params.getType().getId() && 0 != params.getType().getId()) {
                sb.append("  AND typeId = :typeId");
            }
            //拼接面积
            if (null != params.getFloorage()) {
                switch (params.getFloorage()) {
                    case 40:
                        sb.append("  AND floorage < :floorage");
                        break;
                    case 500:
                        sb.append("  AND floorage >= 40 AND floorage < 500");
                        break;
                    case 501:
                        sb.append("  AND floorage  >= 500 AND floorage < 50000");
                        break;
                }

            }
        }
        return getSession().createQuery(sb.toString());
    }

}
