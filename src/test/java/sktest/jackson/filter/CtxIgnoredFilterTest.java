package sktest.jackson.filter;

import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.Assert;
import org.junit.Test;
import org.shaneking.jackson.ctx.JacksonCtx;
import org.shaneking.jackson.databind.OM3;
import org.shaneking.jackson.filter.CtxIgnoredFilter;
import org.shaneking.test.SKUnit;
import sktest.jackson.filter.tstfiles.PrepareCtxIgnored;

public class CtxIgnoredFilterTest extends SKUnit {

  @Test
  public void include() {
    SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
    simpleFilterProvider.addFilter(CtxIgnoredFilter.FILTER_NAME, new CtxIgnoredFilter());
    OM3.om().setFilterProvider(simpleFilterProvider);
    PrepareCtxIgnored prepareCtxIgnored = new PrepareCtxIgnored().setI1(1).setS1("s1").setS2("s2");
    Assert.assertEquals("{\"s1\":\"s1\",\"i1\":1,\"s2\":\"s2\"}", OM3.writeValueAsString(prepareCtxIgnored));
    JacksonCtx.scenario.set("scenario2");
    Assert.assertEquals("{\"s1\":\"s1\",\"i1\":1}", OM3.writeValueAsString(prepareCtxIgnored));
  }
}
