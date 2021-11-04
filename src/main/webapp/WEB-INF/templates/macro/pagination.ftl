<#macro pagination navList>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <#list navList as item>
            <li class="page-item"><a class="page-link" href="${item}">${item}</a></li>
            </#list>
        </ul>
    </nav>
</#macro>