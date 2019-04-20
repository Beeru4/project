package com.beerus.service.impl;

import com.beerus.dao.StreetDao;
import com.beerus.dao.impl.StreetDaoImpl;
import com.beerus.service.StreetService;

public class StreetServiceImpl implements StreetService {
    StreetDao biz = new StreetDaoImpl();

}
