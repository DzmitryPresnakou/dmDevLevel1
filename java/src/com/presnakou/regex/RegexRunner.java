package com.presnakou.regex;

import com.presnakou.regex.utils.RegexHelper;

import java.io.File;
import java.nio.file.Path;

public class RegexRunner {

    public static void main(String[] args) {

        File complaints = Path.of("resources", "complaints.csv").toFile();
        System.out.println(RegexHelper.getDataFromFile(complaints));
        System.out.println(RegexHelper.processedAndwriteInFile(complaints));

    }
}
