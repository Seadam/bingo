package com.example.bingo.entity;


import com.example.bingo.annotation.*;
import com.example.bingo.extension.activerecord.Model;
import lombok.Data;

import java.util.Date;

/**
 * <pre>
 * 业务功能实体
 * </pre>
 *
 * @author maozhi.lan@meicloud.com
 * @version 1.00.00
 * <p>
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
@TableName("t_cpf_function")
@Data
public class CpfFunction extends Model<CpfFunction> {

    /**
     * 业务功能id
     */
    @TableId(value = "function_id", type = IdType.AUTO)
    private Long functionId;

    /**
     * 业务功能编码
     */
    @TableField(value = "function_code")
    private String functionCode;

    /**
     * 业务功能名称
     */
    @TableField(value = "function_name")
    private String functionName;

    /**
     * 版本号
     */
    @TableField(value = "function_version")
    private Integer functionVersion;

    /**
     * 技术模板类型
     */
    @TableField(value = "template_type")
    private String templateType;

    /**
     * 单据设置ID
     */
    @TableField(value = "data_model_tpl_id")
    private Long dataModelTplId;

    /**
     * 配置内容
     */
    @TableField(value = "config_content")
    private String configContent;

    /**
     * 配置草稿
     */
    @TableField(value = "config_draft")
    private String configDraft;

    /**
     * 是否已发布
     */
    @TableField(value = "is_publish")
    private String isPublish;

    /**
     * 发布时间
     */
    @TableField(value = "publish_time")
    private Date publishTime;

    /**
     * 是否已停用
     */
    @TableField(value = "is_stop")
    private String isStop;

    /**
     * 是否删除
     */
    @TableLogic(value = "N", delval = "Y")
    @TableField(value = "is_delete")
    private String isDelete;

    /**
     * 创建人
     */
    @TableField(value = "created_by")
    private Long createdBy;

    /**
     * 创建时间
     */
    @TableField(value = "creation_date")
    private Date creationDate;

    /**
     * 最后更新人
     */
    @TableField(value = "updated_by")
    private Long updatedBy;

    /**
     * 最后更新时间
     */
    @TableField(value = "update_date")
    private Date updateDate;


}