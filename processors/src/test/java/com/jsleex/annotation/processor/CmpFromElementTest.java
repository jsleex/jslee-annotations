package com.jsleex.annotation.processor;

import org.junit.Assert;
import org.junit.Test;

public class CmpFromElementTest {

    @Test
    public void testPattern() {
        final String comment = "@slee.cmp-method sbb-alias-ref=\"SampleChildSbb\"";
        CmpFromElement.ElementAndComment elementAndComment = new CmpFromElement.ElementAndComment(null, comment);
        Assert.assertTrue("Is not CMP field", elementAndComment.isCmpField());
        Assert.assertEquals("SBB alias ref name not matching", "SampleChildSbb", elementAndComment.getSbbAliasName());
    }

    @Test
    public void testPatternWithExtraComment() {
        final String comment =
                "ACI CMP method for local\n" +
                " SLEE CMP Method\n" +
                " @slee.cmp-method\n" +
                " sbb-alias-ref=\"SampleChildSbb\"";
        CmpFromElement.ElementAndComment elementAndComment = new CmpFromElement.ElementAndComment(null, comment);
        Assert.assertTrue("Is not CMP field", elementAndComment.isCmpField());
        Assert.assertEquals("SBB alias ref name not matching", "SampleChildSbb", elementAndComment.getSbbAliasName());
    }
}