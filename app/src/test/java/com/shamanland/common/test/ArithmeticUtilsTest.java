package com.shamanland.common.test;

import android.test.suitebuilder.annotation.SmallTest;

import com.shamanland.common.ArithmeticUtils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SmallTest
public class ArithmeticUtilsTest {
    @Test
    public void test1() {
        assertThat(ArithmeticUtils.divAndRoundUp(1, 1), is(1));
    }

    @Test
    public void test2() {
        assertThat(ArithmeticUtils.divAndRoundUp(5, 4), is(2));
    }

    @Test
    public void test3() {
        assertThat(ArithmeticUtils.divAndRoundUp(7, 4), is(2));
    }

    @Test
    public void test4() {
        assertThat(ArithmeticUtils.divAndRoundUp(8, 4), is(2));
    }
}
