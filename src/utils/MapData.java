package utils;

import inter.Generator;
import mode.Pair;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author: luzhiyuan
 * date: 2018-07-26 18:04:29
 * email: luzhiyuan90@163.com
 */
public class MapData<K, V> extends LinkedHashMap<K, V> {

    public MapData(Generator<Pair<K,V>> generator, int quantity) {
        for (int i=0; i<quantity; i++) {
            Pair<K, V> pair = generator.next();
            put(pair.key, pair.value);
        }
    }

    public MapData(Generator<K> genK, Generator<V> genV, int quantity) {
        for (int i=0; i<quantity; i++) {
            put(genK.next(), genV.next());
        }
    }

    public MapData(Generator<K> genK, V value, int quantity) {
        for (int i=0; i<quantity; i++) {
            put(genK.next(), value);
        }
    }

    public MapData(Iterable<K> genK, Generator<V> genV) {
        for (K k : genK) {
            put(k, genV.next());
        }
    }

    public MapData(Iterable<K> genK, V value) {
        Iterator it = genK.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
//        for (K k : genK) {
//            put(k, value);
//        }
    }

    public static <K, V> MapData<K, V> map(Generator<Pair<K,V>> generator, int quantity) {
        return new MapData<>(generator, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, Generator<V> genV, int quantity) {
        return new MapData<>(genK, genV, quantity);
    }

    public static <K, V> MapData<K, V> map(Generator<K> genK, V value, int quantity) {
        return new MapData<>(genK, value, quantity);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, Generator<V> genV) {
        return new MapData<>(genK, genV);
    }

    public static <K, V> MapData<K, V> map(Iterable<K> genK, V value) {
        return new MapData<>(genK, value);
    }
}
