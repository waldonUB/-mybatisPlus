package cn.ak.gc.commen.utils;

import cn.ak.gc.domain.entities.DownloadStatus;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

public class FtpConfig {
    private FTPClient ftp = new FTPClient();
    private Properties properties = PropertiesLoaderUtils.loadAllProperties("ftpConfig.properties");
    private String ip = properties.getProperty("ftp.ip");
    private int port = Integer.parseInt(properties.getProperty("ftp.port"));
    private String user_name = properties.getProperty("ftp.user_name");
    private String password = properties.getProperty("ftp.password");
    private String filePath = properties.getProperty("ftp.filePath");
    private String cache = properties.getProperty("ftp.cache");

    public FtpConfig() throws IOException {
    }

    public boolean connectServer() {
        try {
            ftp.connect(ip, port);
            ftp.setControlEncoding("GBK");
            if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) { // 这里判断有无响应
                return ftp.login(user_name, password);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public DownloadStatus download(String remote, String local) {
        return DownloadStatus.DOWNLOAD_FROM_BREAK_FAILED;
    }
}
