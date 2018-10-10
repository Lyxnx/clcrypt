package net.lyxnx.clcrypt;

import joptsimple.OptionException;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    public static void main(String[] args) throws IOException {
        OptionParser parser = new OptionParser();
        
        parser.acceptsAll(Arrays.asList("t", "type"), "Required hash type")
                .withRequiredArg()
                .required();
        
        parser.acceptsAll(Arrays.asList("h", "?", "help"), "Display usage information")
                .forHelp();
        
        OptionSet options;
        
        try {
            options = parser.parse(args);
        } catch (OptionException e) {
            System.out.println(e.getMessage());
            parser.printHelpOn(System.out);
            return;
        }
        
        if (options.has("help")) {
            parser.printHelpOn(System.out);
            return;
        }
        
        Type hashType = Type.of(options.valueOf("type").toString());
        
        if (hashType == null) {
            System.err.println("Invalid hash type.");
            System.err.println("Supported hash types: " + mkString(Type.values()));
            
            return;
        }
        
        List<String> cmdArgs = (List<String>) options.nonOptionArguments();
        
        if (cmdArgs.isEmpty()) {
            System.err.println("Missing text to encrypt");
            return;
        }
        
        System.out.println("---------- " + hashType + " ----------");
        
        System.out.println();
        
        try {
            for (String string : cmdArgs) {
                System.out.println(string + " = " + hash(hashType, string));
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }
    
    private static <T> String mkString(T[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        
        for (T x : arr) {
            if (first) {
                sb.append(x);
                first = false;
            } else
                sb.append(", ").append(x);
        }
        
        return sb.toString();
    }
    
    private static String hash(Type type, String string) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(type.toString());
        md.update(string.getBytes(), 0, string.length());
        
        return new BigInteger(1, md.digest()).toString(16);
    }
}