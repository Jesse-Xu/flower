/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * 
 */
package com.ly.train.flower.filter;

import com.ly.train.flower.common.service.container.ServiceContext;

/**
 * @author leeyazhou
 *
 */
public abstract class AbstractFilter implements Filter {

  private AbstractFilter nextFilter;

  @Override
  public void filter(ServiceContext serviceContext) {
    doFilter(serviceContext);
    if (nextFilter != null) {
      nextFilter.filter(serviceContext);
    }
  }

 public abstract void doFilter(ServiceContext serviceContext);

  public void addFilter(Filter filter) {
    if (this.nextFilter == null) {
      this.nextFilter = (AbstractFilter) filter;
    } else {
      this.nextFilter.addFilter(filter);
    }
  }

}
