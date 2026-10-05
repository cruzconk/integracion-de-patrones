package com.company.documents.flyweight;

import java.util.*;

public class FlyweightFactory {
    private final Map<String,CharacterFlyweight> cache=new HashMap<>();
    public CharacterFlyweight get(char c,String font){String k=c+"|"+font; return cache.computeIfAbsent(k,x->new CharacterFlyweight(c,font));}
    public int sharedCount(){return cache.size();}
}
