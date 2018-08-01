package cn.shil.control;

import java.io.*;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/upload")
public class FileUploadController{
    @RequestMapping(value="/multpartFile", method=RequestMethod.POST)
    public String uploadForMultpartFile(Model model, @RequestPart("multipartFile") MultipartFile multipartFile){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream=new FileOutputStream(new File("F:/f1234.jpeg"));
            byte[] bytes=multipartFile.getBytes();
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        try
//        {
//            multipartFile.transferTo(new File("F:/1234.jpeg"));
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
        model.addAttribute("uploadparam", "multipartFile");
        return "uploadok";
    }

    /**
     * byte数组接收multipart请求数据会出现参数解析器无法解析的情况
     * 如果前端数据内容为空，则会抛出异常信息且无法通过逻辑判断处理避免
     * 建议不使用该种类型参数接收multipart请求数据
     * @param byteArray
     * @param model
     * @return
     */
    @RequestMapping(value="/byteArray", method=RequestMethod.POST)
    public String uploadForByteArray(
            @RequestPart("byteArray") byte[] byteArray,
            Model model){
        model.addAttribute("uploadparam", "bytes");
        return "uploadok";
    }

    @RequestMapping(value="/part", method=RequestMethod.POST)
    public String uploadForPart(Model model, @RequestPart("part") Part part){
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            inputStream = part.getInputStream();
            fileOutputStream = new FileOutputStream(new File("F:/part2.jpeg"));
            byte[] bytes = new byte[1024];
            while (-1!=inputStream.read(bytes)){
                fileOutputStream.write(bytes);
            }
            fileOutputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//        try
//        {
//            part.write("F:/part2.jpeg");
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
        model.addAttribute("uploadparam", "part");
        return "uploadok";
    }
}