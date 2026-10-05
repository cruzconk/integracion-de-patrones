package com.company.documents.flyweight;

public final class CharacterFlyweight {
    private final char character; private final String font;
    public CharacterFlyweight(char character, String font){this.character=character;this.font=font;}
    public String draw(int x,int y,String color,double scale){return "Character='"+character+"' font="+font+" x="+x+" y="+y+" color="+color+" scale="+scale;}
}
