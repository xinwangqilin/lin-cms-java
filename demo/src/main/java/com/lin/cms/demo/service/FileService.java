package com.lin.cms.demo.service;

import com.lin.cms.demo.model.FileDO;
import com.lin.cms.demo.bo.UploadFileBO;
import com.lin.cms.demo.service.base.Service;
import com.lin.cms.exception.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


/**
 * Created by lin on 2019/06/14.
 */
public interface FileService extends Service<FileDO> {
    List<UploadFileBO> upload(MultiValueMap<String, MultipartFile> fileMap) throws NotFound, Parameter, FileTooMany, FileExtension, FileTooLarge;
}
