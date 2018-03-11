package org.csu.pubg.persistence;

import org.csu.pubg.domain.UserAddress;
import java.util.*;

/**
 * Created by Tovi on 2017/9/20.
 */
public interface UserAddressDao {
    //通过用户昵称获取用户所有邮寄地址信息
    List<UserAddress> getUserAddressByNickName(String nickName);

    //修改地址栏
    boolean modifyAddress(int id,UserAddress userAddress);
    //添加用户地址
    boolean addAddress(UserAddress userAddress);

}
