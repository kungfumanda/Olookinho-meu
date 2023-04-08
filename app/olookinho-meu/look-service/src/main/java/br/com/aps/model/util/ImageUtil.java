package br.com.aps.model.util;


import java.io.IOException;
import java.util.Base64;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.com.aps.olookinhomeu.model.PecaDeRoupa.PecaDeRoupa;

public class ImageUtil {
    public String getImgData(byte[] byteData) {
        return Base64.getMimeEncoder().encodeToString(byteData);
    }

    public PecaDeRoupa setImagem(PecaDeRoupa pecaDeRoupa, MultipartFile imagem) throws IOException {
        String fileName = StringUtils.cleanPath(imagem.getOriginalFilename());
        try {
            if (isImage(imagem)) {
                pecaDeRoupa.setNomeImagem(fileName);
                pecaDeRoupa.setImagem(imagem.getBytes());
            }
        } catch (IOException ex) {
            throw new IOException("Could not store file " + fileName);
        }

        return pecaDeRoupa;
    }

    private boolean isImage(MultipartFile imagem) {

        String type = imagem.getContentType();
        return ((type != null) && (type.contains("image")));

    }

}