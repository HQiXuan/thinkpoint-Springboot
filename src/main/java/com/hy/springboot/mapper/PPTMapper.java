package com.hy.springboot.mapper;

import com.hy.springboot.bean.PPT;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper或者@MapperScan将接口扫描装配到容器中
@Repository
public interface PPTMapper {

    public List<PPT> getAll();
    public String findName(String name,int label2);
    public String findNamebak(String name);
    public void addPPT(PPT ppt);
}
