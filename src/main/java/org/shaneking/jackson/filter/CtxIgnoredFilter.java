package org.shaneking.jackson.filter;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import org.shaneking.jackson.annotation.CtxIgnored;
import org.shaneking.jackson.ctx.JacksonCtx;

import java.io.Serializable;
import java.util.Arrays;

public class CtxIgnoredFilter extends SimpleBeanPropertyFilter implements Serializable {
  public static final String FILTER_NAME = "org.shaneking.jackson.filter.CtxIgnoredFilter";

  @Override
  protected boolean include(BeanPropertyWriter writer) {
    CtxIgnored ctxIgnored = writer.getAnnotation(CtxIgnored.class);
    return ctxIgnored == null || ctxIgnored.value().length == 0 || !Arrays.asList(ctxIgnored.value()).contains(JacksonCtx.scenario.get());
  }

  @Override
  protected boolean include(PropertyWriter writer) {
    CtxIgnored ctxIgnored = writer.getAnnotation(CtxIgnored.class);
    return ctxIgnored == null || ctxIgnored.value().length == 0 || !Arrays.asList(ctxIgnored.value()).contains(JacksonCtx.scenario.get());
  }
}
