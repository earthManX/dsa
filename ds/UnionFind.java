package ds;

import java.util.*;

public class UnionFind<T> {
    
    Map<T, T> treeMap;

    UnionFind(){
        treeMap = new HashMap<T, T>();
    }

    T find(T node){
        T curr = treeMap.getOrDefault(node, node);
        if( curr != node){
            curr = find( curr );
        }
        return curr;
    }

    void merge(T node1 , T node2){
        treeMap.put(find(node1), find(node2));
    }

    T findOptimised( T node ){
        T curr = treeMap.getOrDefault(node, node);
        if( curr != node){
            curr = find(curr);
            treeMap.put(node, curr);
        }
        return curr;
    }
}
