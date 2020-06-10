package everyday;

import dataStructure.UnionFind;

public class SatisfiabilityofEqualityEquations {
    public boolean equitionsPossible(String[] equations){
        UnionFind<Character> uf = new UnionFind<>();
        for(String str:equations){
            if(str.charAt(1)=='='){
                uf.union(str.charAt(0),str.charAt(3));
            }
        }
        for(String str:equations){
            if(str.charAt(1)=='!'){
                if(uf.connected(str.charAt(0),str.charAt(3)))return false;
            }
        }
        return true;
    }
}
