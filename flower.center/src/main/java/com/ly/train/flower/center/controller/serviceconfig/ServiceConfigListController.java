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
package com.ly.train.flower.center.controller.serviceconfig;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.ly.train.flower.center.controller.BaseController;
import com.ly.train.flower.center.service.ReturnService;
import com.ly.train.flower.center.service.ServiceConfigListService;
import com.ly.train.flower.common.annotation.Flower;
import com.ly.train.flower.common.service.config.ServiceConfig;

/**
 * @author leeyazhou
 *
 */
@RestController
@RequestMapping("/serviceconfig/")
@Flower(serviceName = "ServiceA", value = "ServiceA", flowNumber = 32)
public class ServiceConfigListController extends BaseController {

  @RequestMapping("list")
  protected void process(String data, HttpServletRequest req) throws IOException {
    ServiceConfig serviceConfig = JSONObject.parseObject(data, ServiceConfig.class);
    logger.info("请求参数 : {}", serviceConfig);
    doProcess(serviceConfig, req);
  }



  @Override
  public void buildFlower() {
    getServiceFlow().buildFlow(ServiceConfigListService.class, ReturnService.class);
  }
}
