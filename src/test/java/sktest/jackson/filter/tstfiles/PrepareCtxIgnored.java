package sktest.jackson.filter.tstfiles;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.shaneking.jackson.annotation.CtxIgnored;
import org.shaneking.jackson.filter.CtxIgnoredFilter;

@Accessors(chain = true)
@JsonFilter(CtxIgnoredFilter.FILTER_NAME)
@ToString
public class PrepareCtxIgnored {
  @CtxIgnored("scenario1")
  @Getter
  @Setter
  private String s1;
  @CtxIgnored
  @Getter
  @Setter
  private Integer i1;
  @CtxIgnored({"scenario1", "scenario2"})
  @Getter
  @Setter
  private String s2;
}
