package net.lyxnx.clcrypt;

import org.apache.commons.cli.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        Options options = new Options();
        
        Option type = new Option("t", "type", true, "Hash type " + Arrays.toString(Type.values()));
        type.setRequired(true);
        
        options.addOption(type);
        
        CommandLineParser parser = new BasicParser();
        HelpFormatter formatter = new HelpFormatter();
        
        CommandLine cmd;
        
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("<type> <text>[,...]", options);
            
            System.exit(1);
            return;
        }
        
        Type hashType = Type.of(cmd.getOptionValue("type"));
        
        String[] cmdArgs = cmd.getArgs();
        
        if (cmdArgs.length == 0) {
            System.out.println("Missing text to encrypt");
            
            System.exit(1);
            return;
        }
        
        System.out.println("---------- " + hashType + " ----------");
        
        System.out.println();
        
        try {
            for (String string : cmd.getArgs()) {
                System.out.println(string + " = " + hash(hashType, string));
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("An error has occurred: " + e.getMessage());
        }
    }
    
    private static String hash(Type type, String string) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(type.toString());
        md.update(string.getBytes(), 0, string.length());
        
        return new BigInteger(1, md.digest()).toString(16);
    }
}