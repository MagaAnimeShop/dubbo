/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.springboot.demo.provider.dubbo.service;

import org.apache.dubbo.springboot.demo.idl.CategoryRequest;
import org.apache.dubbo.springboot.demo.idl.CategoryResponse;
import org.apache.dubbo.springboot.demo.idl.DubboGreeterTriple.GreeterImplBase;
import org.apache.dubbo.springboot.demo.idl.GreeterReply;
import org.apache.dubbo.springboot.demo.idl.GreeterRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class GreeterImpl extends GreeterImplBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(GreeterImpl.class);

    @Override
    public GreeterReply greet(GreeterRequest request) {
        LOGGER.info("Server received greet request {}" , request);
        return GreeterReply.newBuilder()
                .setMessage("hello," + request.getName())
                .build();
    }

    @Override
    public CategoryResponse getCategory(CategoryRequest request){
        LOGGER.info("Server received greet request {}" , request);
        return CategoryResponse.newBuilder()
                .setName("hello," + request.getName())
                .setType("test")
                .build();
    }

}
