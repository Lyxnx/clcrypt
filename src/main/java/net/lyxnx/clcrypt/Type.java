package net.lyxnx.clcrypt;

import java.util.Arrays;

public enum Type {
    MD5,
    SHA_1,
    SHA_256,
    SHA_384,
    SHA_512;
    
    public static Type of(String string) {
        return Arrays.stream(values())
                .filter(t -> t.name().toLowerCase().replace("_", "").equalsIgnoreCase(string))
                .findFirst().orElse(null);
    }
    
    @Override
    public String toString() {
        return name().replace("_", "-");
    }
}