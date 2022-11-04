package com.lijiawei.videotest;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import org.junit.jupiter.api.Test;

/**
 * @author Li JiaWei
 * @ClassName: VideoTest
 * @Description:
 * @Date: 2022/11/4 16:49
 * @Version: 1.0
 */
public class VideoTest {

    // 初始化客户端组件
    public static DefaultAcsClient initVodClient(String accessKeyId, String accessSecret) {
        String regionId = "cn-shanghai";
        DefaultProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, accessSecret);
        DefaultAcsClient defaultAcsClient = new DefaultAcsClient(profile);
        return defaultAcsClient;
    }

    // 初始化
    @Test
    public void test1() {

    }
}
