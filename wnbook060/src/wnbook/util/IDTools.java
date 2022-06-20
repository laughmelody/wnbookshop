package wnbook.util;

import org.junit.Test;

import java.util.UUID;

public class IDTools {
    public static String getId() {
        UUID uuid =UUID.randomUUID();
        return TimeHelper.getDate("yyyyMMddHHmmss")+uuid.toString().replace("-","").substring(5,15);
    }
    @Test
    public void test(){
        UUID uuid =UUID.randomUUID();
        String time = TimeHelper.getDate("yyyyMMddHHmmss");
        String id = time + uuid.toString().replace("-","").substring(5,15);
        System.out.println(uuid);
    }
}
