package cn.xyq.cloud.common.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class CodeMsg implements Serializable {
    private int code;
    private String msg;
}
