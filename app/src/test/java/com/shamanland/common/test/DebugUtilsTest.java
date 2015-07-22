package com.shamanland.common.test;

import android.content.res.Resources;
import android.test.suitebuilder.annotation.SmallTest;

import com.shamanland.common.DebugUtils;
import com.shamanland.template.R;
import com.shamanland.template.TemplateApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.GreaterThan;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;

import xdroid.core.Global;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SmallTest
public class DebugUtilsTest {
    @Mock
    TemplateApplication mApp;

    @Mock
    Resources mRes;

    @Before
    public void initMocks() {
        Global.init(mApp);
    }

    @Test
    public void test_getOneDpValue() {
        when(mRes.getDimensionPixelSize(R.dimen.space_nano)).thenReturn(3);
        when(mApp.getResources()).thenReturn(mRes);

        assertThat(DebugUtils.getOneDpValue(), is(3));
    }

    @Test
    public void test_createMemoryDump() {
        File dumpFile = DebugUtils.createMemoryDump();

        assertThat(dumpFile, notNullValue());
        //noinspection ConstantConditions
        assertThat(dumpFile.exists(), is(true));
        assertThat(dumpFile.isFile(), is(true));
        assertThat(dumpFile.length(), new GreaterThan<>(0L));
    }
}
