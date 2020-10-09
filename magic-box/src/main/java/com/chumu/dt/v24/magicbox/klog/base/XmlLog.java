package com.chumu.dt.v24.magicbox.klog.base;


import android.util.Log;

import com.chumu.dt.v24.magicbox.klog.ChuMuKLog;
import com.chumu.dt.v24.magicbox.klog.ChuMuKLogUtil;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;

/***
 * @Description:主要功能:
 * @Prject: magic-box
 * @date: 2017年05月16日 16:56
 * @Copyright: 共有开源知识版权
 * @Company:
 * @version: v11-2.0.6-beta
 */
public class XmlLog {

    public static void printXml(String tag, String xml, String headString) {

        if (xml != null) {
            xml = XmlLog.formatXML(xml);
            xml = headString + "\n" + xml;
        } else {
            xml = headString + ChuMuKLog.NULL_TIPS;
        }

        ChuMuKLogUtil.printLine(tag, true);
        String[] lines = xml.split(ChuMuKLog.LINE_SEPARATOR);
        for (String line : lines) {
            if (!ChuMuKLogUtil.isEmpty(line)) {
                Log.d(tag, "║ " + line);
            }
        }
        ChuMuKLogUtil.printLine(tag, false);
    }

    private static String formatXML(String inputXML) {
        try {
            Source xmlInput = new StreamSource(new StringReader(inputXML));
            StreamResult xmlOutput = new StreamResult(new StringWriter());
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString().replaceFirst(">", ">\n");
        } catch (Exception e) {
            e.printStackTrace();
            return inputXML;
        }
    }

}