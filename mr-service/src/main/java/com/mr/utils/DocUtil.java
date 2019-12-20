package com.mr.utils;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.extractor.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author LiuWen
 * @date 2019-12-20 11:04
 * @description 解析上传的晨读材料
 */
public class DocUtil {
    public static String doc2String(String filePath) {
        StringBuilder result = new StringBuilder();
        try {
            if (filePath.endsWith(".doc")) {
                InputStream is = new FileInputStream(new File(filePath));
                WordExtractor ex = new WordExtractor(is);
                result.append(ex.getText());
                ex.close();
            } else if (filePath.endsWith(".docx")) {
                OPCPackage opcPackage = POIXMLDocument.openPackage(filePath);
                POIXMLTextExtractor extractor = new XWPFWordExtractor(opcPackage);
                result.append(extractor.getText());
                extractor.close();
            } else {
                result.append("type_error");
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return result.toString();
    }
}
