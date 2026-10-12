package com.e_commerce.site;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Component
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    public String[] upload(MultipartFile file) throws IOException {
        try {
            Map map = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.emptyMap()
            );

            String url = map.get("url").toString();
            String public_id = map.get("public_id").toString();

            return new String[]{url, public_id};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
