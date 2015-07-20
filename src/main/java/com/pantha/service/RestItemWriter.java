/*
 * Copyright 2015 by Xebia IT Architects,
 *  612, 6th Floor, BPTP Park Centra, Sector 30, Gurgaon - 122001, Haryana, India
 *  All rights reserved.
 *
 *  This software is confidential and proprietary information of Xebia IT Architects ("Confidential Information").
 *  You shall not disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 *  you entered into with Xebia IT Architects.
 */

package com.pantha.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.Iterator;
import java.util.List;

/**
 * Created by rajeshkumar on 19/07/15.
 */

public class RestItemWriter<T> implements ItemWriter<T> {
    private final RestTemplate restTemplate;
    private final String url;
    private final Log log = LogFactory.getLog(this.getClass());

    public RestItemWriter(RestTemplate restTemplate, String url) {
        Assert.notNull(restTemplate, "RestTemplate must not be null");
        Assert.notNull(url, "url must not be null");
        this.restTemplate = restTemplate;
        this.url = url;
    }

    public void write(List<? extends T> items) throws Exception {
        if (this.log.isDebugEnabled()) {
            this.log.debug("Writing to Rest Endpoint with " + items.size() + " items.");
        }

        Iterator i$ = items.iterator();

        while (i$.hasNext()) {
            Object item = i$.next();
            this.restTemplate.put(url, item);
        }
    }
}