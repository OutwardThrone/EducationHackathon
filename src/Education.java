/**
 * Education
 */
import java.util.*;

public class Education {

    public static String conjugateVerb(String verb, String verbForm) {

        String substring = verb.substring(Integer.max(verb.length()-2, 0));

        switch(substring)
        {
            case "er":
            {
                return conjugateER(verb, verbForm);
            }
            case "ir":{
                return conjugateIR(verb, verbForm);
            }
            case "ar":{
                return conjugateAR(verb, verbForm);
            }
            default:
            {
                return "ERROR";
            }
        }

    }

    public static String conjugateER(String verb, String verbForm){
        String root = verb.substring(0, verb.length() - 2);

        switch (verbForm) {
            case "yo": {
                return root + "o";
            }
            case "tú": {
                return root + "es";
            }
            case "usted": {
                return root + "e";
            }
            case "nosotros": {
                return root + "emos";
            }
            case "ustedes": {
                return root + "en";
            }
            default: {
                return "ERROR";
            }
        }

    }
    public static String conjugateIR(String verb, String verbForm){
        String root = verb.substring(0, verb.length() - 2);

        switch (verbForm) {
            case "yo": {
                return root + "o";
            }
            case "tú": {
                return root + "es";
            }
            case "usted": {
                return root + "e";
            }
            case "nosotros": {
                return root + "imos";
            }
            case "ustedes": {
                return root + "en";
            }
            default: {
                return "ERROR";
            }
        }
    }
    
    public static String conjugateAR(String verb, String verbForm){
        String root = verb.substring(0, verb.length() - 2);

        switch (verbForm) {
            case "yo": {
                return root + "o";
            }
            case "tú": {
                return root + "as";
            }
            case "usted": {
                return root + "a";
            }
            case "nosotros": {
                return root + "amos";
            }
            case "ustedes": {
                return root + "an";
            }
            default: {
                return "ERROR";
            }
        }
    }
}
