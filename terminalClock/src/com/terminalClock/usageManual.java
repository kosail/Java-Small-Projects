package com.terminalClock;

import com.consoleCustomPrint.ConsoleCustomPrint;
import com.consoleCustomPrint.ForegroundColors;

class usageManual {
    public static void getUsage() {
        ConsoleCustomPrint.printWithColor(ForegroundColors.GREEN, "Usage: java -jar <jarFile> -{windows/unix} -{12/24} -[optional colors]\n\n", false);
        
        System.out.println("""
                Arguments following the jar file are:
                
                \t-windows / -unix
                \tIndicates to the program if it is running in a Windows or an Unix like system (e.g. Linux). As there are only two choices, it can be "-windows" or "-unix".
                
                \t-12 / -24
                \tindicates the type of clock to operate. If you want a 12-hours type of clock, then type "-12". In the other hand "-24" will indicate the program to use 24-hours clock.
                
                """);
        
        ConsoleCustomPrint.printWithColor(ForegroundColors.YELLOW, "Optional colors field refers to the color in which the clock should be printed out, and ", false);
        ConsoleCustomPrint.printWithColor(ForegroundColors.BLUE_LIGHT, "it only works with UNIX, not with Windows.\n", true);
        
        System.out.println("""
                \tThis field can be omitted, in which case it will print in the default terminal color for text.
                
                \t"-metal" for blue gradient.
                
                \t"-rainbow" for multicolor gradient.
                """);
        
        System.exit(0);
    }
    
    public static void invalidArguments() {
        ConsoleCustomPrint.printWithColor(ForegroundColors.RED, "Error: Too many or no arguments!\n", true);
        ConsoleCustomPrint.printWithColor(ForegroundColors.YELLOW, "Use \"java -jar <thisJarFile> -h\" for help.\n", false);
        System.exit(1);
    }
}
