package com.beerus.action;

import com.beerus.entity.BizCheckResult;
import com.beerus.entity.BizClaimVoucher;
import com.beerus.entity.BizClaimVoucherDetall;
import com.beerus.entity.SysEmployee;
import com.beerus.service.CVoucherService;
import com.beerus.service.impl.CVoucherServiceImpl;
import com.beerus.utils.HibernateUtils;
import com.beerus.utils.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.util.*;

/**
 * @Author Beerus
 * @Description 报销单
 * @Date 2019/4/15
 **/
public class CVoucherAction extends ActionSupport {
    //业务层
    private CVoucherService cVoucherService = new CVoucherServiceImpl();
    //报销单
    private BizClaimVoucher voucher;
    //报销单详情集合
    private List<BizClaimVoucherDetall> detailList = new ArrayList<BizClaimVoucherDetall>();
    //员工对象
    private SysEmployee employee;
    //员工报销单
    private Set<BizClaimVoucher> items = new HashSet<BizClaimVoucher>();
    //订单id
    private int id;
    //动态结果
    private String nextPage;
    //当前页码
    private int currPageNo = 1;
    //页大小
    private int pageSize;
    //分页对象
    private Page<BizClaimVoucher> param;
    //总页码
    private int totalPage;
    //总行数
    private int totalRow;
    //报销单核对
    private BizCheckResult checkResult;

    public BizCheckResult getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(BizCheckResult checkResult) {
        this.checkResult = checkResult;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
    }

    public Page<BizClaimVoucher> getBizClaimVoucherPage() {
        return param;
    }

    public void setBizClaimVoucherPage(Page<BizClaimVoucher> param) {
        this.param = param;
    }

    public int getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(int currPageNo) {
        this.currPageNo = currPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public SysEmployee getEmployee() {
        return employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<BizClaimVoucher> getItems() {
        return items;
    }

    public void setItems(Set<BizClaimVoucher> items) {
        this.items = items;
    }

    public void setEmployee(SysEmployee employee) {
        this.employee = employee;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public BizClaimVoucher getVoucher() {
        return voucher;
    }

    public void setVoucher(BizClaimVoucher voucher) {
        this.voucher = voucher;
    }

    public List<BizClaimVoucherDetall> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<BizClaimVoucherDetall> detailList) {
        this.detailList = detailList;
    }

    /**
     * 添加报销单详情信息
     *
     * @return
     */
    public String add_Voucher() {
        SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("emp");
        //设置创建人
        voucher.setCreateSn(employee);
        //设置处理人
        if ("新创建".equals(voucher.getStatus().trim())) {
            voucher.setNextDealSn(employee);
        } else {
            //设置下一步处理人
            voucher.setNextDealSn(new SysEmployee("003"));
        }
        //设置订单下的订单详情 保存订单的时候保存详情
        voucher.getVoucherDetalls().addAll(detailList);
        //遍历详情集合 设置双方关联
        for (BizClaimVoucherDetall detall : detailList) {
            detall.setClaimVoucher(voucher);
        }
        //执行保存
        if (cVoucherService.save(voucher)) {
            //添加成功
            /*  return SUCCESS;*/
            return null;
        } else {
            //添加失败
            return LOGIN;
        }

    }

    /**
     * 员工查询已填写的报销单
     *
     * @return
     */
    public String list_Voucher() {
        employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("emp");
        /*   System.out.println(employee.getItem().size());*/
        //直接点查询是空的
        if (null == voucher) {
            voucher = new BizClaimVoucher();
        }

        if ("员工".equals(employee.getPosition().getNameCn())) {
            //设置创建人
            voucher.setSn(employee.getSn());
        } else {
            //设置下一步处理人
            voucher.setNextDealSn(employee);
            voucher.setSn(employee.getSn());
        }
        if (null != voucher && null != voucher.getStatus() && 0 < voucher.getStatus().trim().length() && "全部".equals(voucher.getStatus().trim()))
            voucher.setStatus(null);
        param = cVoucherService.listAllVoucherById(voucher, currPageNo, 5);
        totalPage = param.getTotalPage();
        totalRow = param.getTotalCount();
        items.addAll(param.getPages());
        nextPage = "claim_voucher_list";
        return SUCCESS;
    }

    /**
     * 查询单个订单
     *
     * @return
     */
    public String get_Voucher() {
        employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("emp");
        voucher = cVoucherService.getVoucher(id);
        nextPage = "claim_voucher_view";
        return SUCCESS;
    }

    /**
     * 审核订单
     *
     * @return
     */
    public String getCheck_Voucher() {
        employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("emp");
        voucher = cVoucherService.getVoucher(id);
        nextPage = "claim_voucher_check";
        return SUCCESS;
    }

    /**
     * 修改之前跳到修改页面
     *
     * @return
     */
    public String forword_Voucher() {
        voucher = cVoucherService.getVoucher(id);
        detailList.addAll(voucher.getVoucherDetalls());
        nextPage = "claim_voucher_update";
        return SUCCESS;
    }

    /**
     * 审批报销单
     *
     * @return
     */
    public String checkRescult_Voucher() {
        employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("emp");
        //先查找订单
        voucher = cVoucherService.getVoucher(voucher.getId());
        voucher.setModifyTime(new Date());
        //总经理
        if (voucher.getTotalAccount() >= 5000
                && !"打回".equals(checkResult.getResult())
                && !"财务".equals(employee.getPosition().getNameCn())) {
            voucher.setStatus("待审批");
            //判断是否是第二次提交 也就是总经理审核通过交给财务处理
            if ("通过".equals(checkResult.getResult()) && voucher.getTotalAccount() < 5000 || "总经理".equals(employee.getPosition().getNameCn())) {
                voucher.setNextDealSn(new SysEmployee("002"));
            } else {
                voucher.setNextDealSn(new SysEmployee("004"));
            }
        } else if ("财务".equals(employee.getPosition().getNameCn())) {
            voucher.setStatus("已付款");
            voucher.setNextDealSn(null);
        } else {
            //判断添加结果 添加报销单之后修改报销单状态
            if ("通过".equals(checkResult.getResult())) {
                voucher.setStatus("已审批");
                voucher.setNextDealSn(new SysEmployee("002"));
            } else if ("拒绝".equals(checkResult.getResult())) {
                voucher.setStatus("已终止");
                voucher.setNextDealSn(null);
            } else if ("打回".equals(checkResult.getResult())) {
                voucher.setStatus("已打回");
                voucher.setNextDealSn(voucher.getCreateSn());
            }
        }

        //设置检查时间
        checkResult.setCheckTime(new Date());
        //设置检查人
        checkResult.setCheckerSn(employee);

        //设置报销单ID
        checkResult.setBizClaimVoucher(voucher);
        voucher.getCheckDetall().add(checkResult);

        return null;
    }

    /**
     * 修改报销单详情信息
     *
     * @return
     */
    public String update_Voucher() {
        try {
            //临时保存数据
            String status = voucher.getStatus().trim();
            String event = voucher.getEvent().trim();
            int totalPrice = voucher.getTotalAccount();
            SysEmployee employee = (SysEmployee) ServletActionContext.getRequest().getSession().getAttribute("emp");
            //查找订单 转化为持久态对象
            voucher = cVoucherService.getVoucher(voucher.getId());
            //设置处理人
            if (!"新创建".equals(status)) {
                //设置状态
                voucher.setStatus(status);
                //设置下一步处理人
                voucher.setNextDealSn(new SysEmployee("003"));
            }
            voucher.setEvent(event);
            voucher.setTotalAccount(totalPrice);
            //遍历详情集合 设置双方关联
            for (BizClaimVoucherDetall detall : detailList) {
                //判断是否是和原来的对象一样 防止重复添加报错
                if (null == detall.getId()) {
                    //设置订单下的订单详情 保存订单的时候保存详情
                    voucher.getVoucherDetalls().add(detall);
                }
                detall.setClaimVoucher(voucher);
            }
            //添加成功
            return null;
        } catch (Exception e) {
            //添加失败
            return LOGIN;
        }
    }

}
