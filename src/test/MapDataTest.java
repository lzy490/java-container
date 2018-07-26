package test;

import mode.Letters;
import utils.MapData;


/**
 * @author: luzhiyuan
 * date: 2018-07-26 22:11:47
 * email: luzhiyuan90@163.com
 */
public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 11));

        System.out.println(MapData.map(new Letters(), "POP"));
    }
}
