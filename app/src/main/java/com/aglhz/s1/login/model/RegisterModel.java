package com.aglhz.s1.login.model;


import com.aglhz.s1.entity.bean.BaseBean;
import com.aglhz.s1.common.ApiService;
import com.aglhz.s1.common.Params;
import com.aglhz.s1.login.contract.RegisterContract;

import cn.itsite.abase.mvp.model.base.BaseModel;
import cn.itsite.abase.network.http.HttpHelper;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author：leguang on 2017/4/12 0009 14:23
 * Email：langmanleguang@qq.com
 */

public class RegisterModel extends BaseModel implements RegisterContract.Model {

    @Override
    public Observable<BaseBean> register(Params params) {
        return HttpHelper.getService(ApiService.class)
                .requestRegister(ApiService.requestRegister,
                        params.sc,
                        params.account,
                        params.verifyCode,
                        params.password1,
                        params.password2)
                .subscribeOn(Schedulers.io());
    }

    @Override
    public Observable<BaseBean> requestVerifyCode(Params params) {
        return HttpHelper.getService(ApiService.class)
                .requestVerifyCode(ApiService.requestVerifyCode,
                        params.sc,
                        params.phoneNo,
                        params.verifyType)
                .subscribeOn(Schedulers.io());
    }
}
