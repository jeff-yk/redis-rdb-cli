/*
 * Copyright 2018-2019 Baoyi Chen
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

package com.moilioncircle.redis.rdb.cli.cmd;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Baoyi Chen
 */
public class Version {
    
    static {
        ClassLoader loader = Version.class.getClassLoader();
        try (InputStream in = loader.getResourceAsStream("git.properties")) {
            System.getProperties().load(in);
        } catch (IOException e) {
        }
    }
    
    private static final String VERSION = "0.1.10";
    
    public static final Version INSTANCE = new Version();
    
    private Version() {
    }
    
    public String version() {
        return VERSION;
    }
    
    public String home() {
        return System.getProperty("rct.home");
    }
    
    public String date() {
        return System.getProperty("git.build.time");
    }
    
    public String commit() {
        return System.getProperty("git.commit.id");
    }
}
