package org.common;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern emailPattern = Pattern.compile("^[^._\\s\\W]{2,}\\.[^._\\s\\W]{2,}@germinare\\.org\\.br$");
    public static final Pattern senhaPattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{8,}$");
}
