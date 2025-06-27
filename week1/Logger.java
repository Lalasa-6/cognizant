{\rtf1\ansi\ansicpg1252\cocoartf2639
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww28600\viewh14340\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class Logger \{\
    private static Logger instance;\
\
    private Logger() \{\
        System.out.println("Logger instance created!");\
    \}\
\
    public static synchronized Logger getInstance() \{\
        if (instance == null) \{\
            instance = new Logger();\
        \}\
        return instance;\
    \}\
\
    public void log(String message) \{\
        System.out.println("[LOG] " + getCurrentTimestamp() + ": " + message);\
    \}\
\
    public void logError(String errorMessage) \{\
        System.err.println("[ERROR] " + getCurrentTimestamp() + ": " + errorMessage);\
    \}\
\
    public void logWarning(String warningMessage) \{\
        System.out.println("[WARNING] " + getCurrentTimestamp() + ": " + warningMessage);\
    \}\
\
    private String getCurrentTimestamp() \{\
        return java.time.LocalDateTime.now().toString();\
    \}\
\
    public String getInstanceInfo() \{\
        return "Logger instance hash: " + this.hashCode();\
    \}\
\}}