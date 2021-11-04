<#include "/layout/header.ftl" encoding="UTF-8">
<div class="container">
    <div class="card">
        <div class="card-header">
            <h3 class="card-title">FreeMarker模板读取配置</h3>
        </div>
        <div class="card-body">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>来源</th>
                    <th>序号</th>
                    <th>名称</th>
                    <th>主键</th>
                    <th>数据值类型</th>
                    <th>配置值</th>
                    <th>描述信息</th>
                    <th>添加时间</th>
                </tr>
                </thead>
                <tbody>
                <#list configList as cf>
                    <tr>
                        <td>configList</td>
                        <td>${cf?index+1}</td>
                        <td>${cf.configName}</td>
                        <#if cf?index%3==0>
                            <td>${cf.configKey}</td>
                        <#elseif cf?index%3==1>
                            <td>${"读取主键为："+cf.configKey}</td>
                        <#else >
                            <td>${"读取主键是：${cf.configKey}"}</td>
                        </#if>
                        <td>${cf.configType}</td>
                        <td>${cf.configValue}</td>
                        <td>${cf.configDes}</td>
                        <#if cf?index%4==0>
                            <td>${cf.addTime?string("yyyy-MM-dd")}</td>
                        <#elseif cf?index%4==1>
                            <td>${cf.addTime?date}</td>
                        <#elseif cf?index%4==2>
                            <td>${cf.addTime?datetime}</td>
                        <#else >
                            <td>${cf.addTime?time}</td>
                        </#if>
                    </tr>
                </#list>
                <#assign index=1>
                <#list config?keys as k>
                    <tr>
                        <td>config</td>
                        <td>${index}</td>
                        <td>-</td>
                        <td>${k}</td>
                        <td>-</td>
                        <td>${config[k]}</td>
                        <td>-</td>
                        <td>-</td>
                    </tr>
                    <#assign index=index+1>
                </#list>
                </tbody>
            </table>
        </div>
        <div class="card-footer">
            <#-- freemarket macro宏定义-->
            <#macro pageItem name url>
                <li class="page-item"><a class="page-link" href="${url}">${name}</a></li>
            </#macro>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <@pageItem name="上一页" url="#"/>
                    <@pageItem name="1" url="#"/>
                    <@pageItem name="2" url="#"/>
                    <@pageItem name="3" url="#"/>
                    <@pageItem name="4" url="#"/>
                    <@pageItem name="5" url="#"/>
                    <@pageItem name="6" url="#"/>
                    <li class="page-item"><a class="page-link" href="#">下一页</a></li>
                </ul>
            </nav>
            <#-- 导入自定义的库-->
            <#import "/macro/pagination.ftl" as page>
            <#-- 调用库内定义的macro-->
            <@page.pagination navList=[1,2,3,4,5,6,7,8,9]/>
        </div>
    </div>
</div>
<#include "/layout/footer.ftl" encoding="UTF-8">