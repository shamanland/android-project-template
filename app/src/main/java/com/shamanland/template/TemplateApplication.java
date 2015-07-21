package com.shamanland.template;

import com.rollbar.android.Rollbar;
import com.shamanland.common.CommonUtils;

import xdroid.app.ApplicationExt;

import static com.shamanland.template.BuildConfig.BUILD_TYPE;
import static com.shamanland.template.BuildConfig.PRODUCTION;
import static com.shamanland.template.BuildConfig.ROLLBAR_TOKEN;
import static com.shamanland.template.BuildConfig.SNAPSHOT;

public class TemplateApplication extends ApplicationExt {
    @Override
    public void onCreate() {
        super.onCreate();

        if (PRODUCTION) {
            if (SNAPSHOT) {
                final Thread.UncaughtExceptionHandler defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread thread, Throwable ex) {
                        if (ex instanceof OutOfMemoryError) {
                            CommonUtils.createMemoryDump();
                        }

                        defaultHandler.uncaughtException(thread, ex);
                    }
                });
            }

            Rollbar.init(getContext(), ROLLBAR_TOKEN, BUILD_TYPE);
        }
    }
}
