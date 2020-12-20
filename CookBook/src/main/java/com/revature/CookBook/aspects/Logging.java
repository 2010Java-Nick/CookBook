package com.revature.CookBook.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
@Aspect
public class Logging {

    private static Logger LogUser = LogManager.getLogger("User");
    private static Logger LogRecipe = LogManager.getLogger("Recipe");
    private static Logger LogCookbook = LogManager.getLogger("Cookbook");
    private static Logger LogFeatured = LogManager.getLogger("Featured");


    @Pointcut("within(com.revature.CookBook..*User*)")
    public void pointcutForUserMethods() {}

    @Pointcut("within(com.revature.CookBook..*Recipe*)")
    public void pointcutForRecipeMethods() {}

    @Pointcut("within(com.revature.CookBook..*Cookbook*)")
    public void pointcutForCookbookMethods() {}

    @Pointcut("within(com.revature.CookBook..*Featured*)")
    public void pointcutForFeaturedMethods() {}


    // ------------------- User logging -------------------- \\
    @Before(value = "pointcutForUserMethods() && args(object)")
    public void logBeforeUserMethods(JoinPoint jp, Object object) {
        LogUser.info(jp.getSignature() + "\nPassed-In: " + object.toString());
    }

    @AfterReturning(value = "pointcutForUserMethods()", returning = "returnValue")
    public void logAfterReturningUserMethods(JoinPoint jp, Object returnValue) {
        if (returnValue != null){
            LogUser.info("Returned: " + returnValue.toString() + " - " + jp.getSignature());

        } else { LogUser.info(jp.getSignature()); }
    }

    @AfterThrowing(value = "pointcutForUserMethods()", throwing = "exception")
    public void logAfterThrowingUserMethods(JoinPoint jp, Throwable exception) {
        LogUser.warn(jp.getSignature() + " Exception: " + exception.toString());
    }


    // ------------------- Recipe logging -------------------- \\
    @Before(value = "pointcutForRecipeMethods() && args(object)")
    public void logBeforeRecipeMethods(JoinPoint jp, Object object) {
        LogRecipe.info(jp.getSignature() + "\nPassed-In: " + object.toString());
    }

    @AfterReturning(value = "pointcutForRecipeMethods()", returning = "returnValue")
    public void logAfterReturningRecipeMethods(JoinPoint jp, Object returnValue) {
        if (returnValue != null){
            LogRecipe.info("Returned: " + returnValue.toString() + " - " + jp.getSignature());

        } else { LogRecipe.info(jp.getSignature()); }
    }

    @AfterThrowing(value = "pointcutForRecipeMethods()", throwing = "exception")
    public void logAfterThrowingRecipeMethods(JoinPoint jp, Throwable exception) {
        LogRecipe.warn(jp.getSignature() + " Exception: " + exception.toString());
    }


    // ------------------- Cookbook logging -------------------- \\
    @Before(value = "pointcutForCookbookMethods() && args(object)")
    public void logBeforeCookbookMethods(JoinPoint jp, Object object) {
        LogCookbook.info(jp.getSignature() + "\nPassed-In: " + object.toString());
    }

    @AfterReturning(value = "pointcutForCookbookMethods()", returning = "returnValue")
    public void logAfterReturningCookbookMethods(JoinPoint jp, Object returnValue) {
        if (returnValue != null){
            LogCookbook.info("Returned: " + returnValue.toString() + " - " + jp.getSignature());

        } else { LogCookbook.info(jp.getSignature()); }
    }

    @AfterThrowing(value = "pointcutForCookbookMethods()", throwing = "exception")
    public void logAfterThrowingCookbookMethods(JoinPoint jp, Throwable exception) {
        LogCookbook.warn(jp.getSignature() + " Exception: " + exception.toString());
    }
    

    // ------------------- Featured logging -------------------- \\
    @Before(value = "pointcutForFeaturedMethods() && args(object)")
    public void logBeforeFeaturedMethods(JoinPoint jp, Object object) {
        LogFeatured.info(jp.getSignature() + "\nPassed-In: " + object.toString());
    }

    @AfterReturning(value = "pointcutForFeaturedMethods()", returning = "returnValue")
    public void logAfterReturningFeaturedMethods(JoinPoint jp, Object returnValue) {
        if (returnValue != null){
            LogFeatured.info("Returned: " + returnValue.toString() + " - " + jp.getSignature());

        } else { LogFeatured.info(jp.getSignature()); }
    }

    @AfterThrowing(value = "pointcutForFeaturedMethods()", throwing = "exception")
    public void logAfterThrowingFeaturedMethods(JoinPoint jp, Throwable exception) {
        LogFeatured.warn(jp.getSignature() + " Exception: " + exception.toString());
    }
}
