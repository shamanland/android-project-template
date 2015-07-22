package com.shamanland.common;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

import static com.shamanland.common.BuildConfig.SNAPSHOT;
import static xdroid.core.Global.getResources;
import static xdroid.core.IoUtils.close;

public class DebugUtils {
    static {
        if (!SNAPSHOT) {
            throw new AssertionError();
        }
    }

    public static int getOneDpValue() {
        return getResources().getDimensionPixelSize(R.dimen.space_nano);
    }

    public static File createMemoryDump() {
        // TODO create unique file name
        File result = new File(Environment.getExternalStorageDirectory(), "dump.hprof");

        if (!result.exists()) {
            try {
                if (!result.createNewFile()) {
                    return null;
                }
            } catch (IOException ex) {
                return null;
            }
        }

        // TODO write a dump here
        PrintStream out = null;

        try {
            out = new PrintStream(result);
            out.println("[binary data]");
        } catch (FileNotFoundException ex) {
            return null;
        } finally {
            close(out);
        }

        return result;
    }
}
