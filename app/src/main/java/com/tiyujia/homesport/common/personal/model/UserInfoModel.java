package com.tiyujia.homesport.common.personal.model;

import com.tiyujia.homesport.entity.User;

import java.io.Serializable;

/**
 * 作者: Cymbi on 2016/11/24 16:21.
 * 邮箱:928902646@qq.com
 */

public class UserInfoModel implements Serializable{

    public int state;
    public String successmsg;
    public UserModel data;
    public class UserModel{
        public int id;
        public String phone;
        public String nickname;
        public String sex;
        public String avatar;
        public String signature;
        public String address;
        public long birthday;
        /*public class level{
            public int id;
            public int userId;
            public int pointCount;
            public String pointDesc;

        }*/
    }

}
