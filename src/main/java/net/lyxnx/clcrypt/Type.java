package net.lyxnx.clcrypt;

import java.util.Arrays;

public enum Type {
    MD5,
    SHA_1,
    SHA_256,
    SHA_512;
    
    public static Type of(String string) {
        if (string == null) {
            return MD5;
        }
        
        return Arrays.stream(values())
                .filter(t -> t.name().toLowerCase().replace("_", "").equals(string))
                .findFirst().orElse(MD5);
    }
    
    @Override
    public String toString() {
        return name().replace("_", "-");
    }
}