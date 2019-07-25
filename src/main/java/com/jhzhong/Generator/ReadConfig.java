package com.jhzhong.Generator;

import java.io.*;
import java.util.Properties;

/**
 * @author jhzhong
 * Copyright (c) 2019, jhzhong All Rights Reserved.
 * @description: TODO:// 读取配置文件
 * @projectName: simple-ssm
 * @packageName: com.jhzhong.Generator
 * @date: 2019-07-25 13:15
 */
public class ReadConfig {
    public String filePath;

    ReadConfig(String filePath) {
        super();
        this.filePath = filePath;
    }

    public String getProperty(String key) {
        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(
                    new FileReader(filePath));
            properties.load(bufferedReader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 获取key对应的value值
        return properties.getProperty(key).trim();
    }
}
