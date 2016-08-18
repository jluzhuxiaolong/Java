package com.servlet.demo;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Administrator on 2016/8/18.
 */
@WebServlet("/Identity")
public class IdentityServlet extends HttpServlet {
    public   static  final  char[] RANDCHARS={'2','3','4','5','6','7','8','9','A','B','C'};

    public  static Random random = new Random();

    public  String getRandomString(){
        StringBuffer sbf = new StringBuffer();
        for(int i=0;i<4;i++){
            sbf.append(RANDCHARS[random.nextInt(RANDCHARS.length)]);
        }
        return  sbf.toString();
    }

    public Color getRandomColor(){
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }

    public  Color getReverseColor(Color c){
        return  new Color(255-c.getRed(),255-c.getGreen(),255-c.getBlue());
    }
    @Override
    public  void doGet(HttpServletRequest request,
                       HttpServletResponse response)throws ServletException,IOException{

        response.setContentType("image/jpeg");

        String randomString = getRandomString();

        request.getSession(true).setAttribute("random",randomString);

        int width = 100;
        int height = 30;

        Color color = getRandomColor();
        Color reverse = getReverseColor(color);
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();
        g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        g.setColor(color);
        g.fillRect(0,0,width,height);
        g.setColor(reverse);
        g.drawString(randomString,18,20);

        for(int i=0,n=random.nextInt(100);i<n;i++){
            g.drawRect(random.nextInt(width),random.nextInt(height),1,1);
        }

        ServletOutputStream os = response.getOutputStream();

        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        encoder.encode(bi);
        os.flush();
        os.close();
    }
}
