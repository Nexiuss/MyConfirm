package enum_;

import java.util.*;

public enum  ServerTypeEnum
{
    DMS("DMS",4 ,2) ,MTS("MTS",2 ,0), SS("SS", 1,1), DGWS("DGWS",22 ,22), CAS("CAS",23 ,23), IMGE("IMGS", null, 18);

    private String typeName;
    private Integer cppTypeInt;
    private Integer webTypeInt;

    /**
     *
     * @param typeName 类型名称
     * @param cppTypeInt c++ 服务器对应的int枚举
     * @param webTypeInt web 服务器对应的int 枚举
     */
    ServerTypeEnum(String typeName, Integer cppTypeInt, Integer webTypeInt)
    {
        this.typeName = typeName;
        this.cppTypeInt = cppTypeInt;
        this.webTypeInt = webTypeInt;
    }

    private static final Set<ServerTypeEnum> serverTypeEnums = new HashSet<>();
    static {
        serverTypeEnums.add(ServerTypeEnum.DMS);
        serverTypeEnums.add(ServerTypeEnum.MTS);
        serverTypeEnums.add(ServerTypeEnum.SS);
        serverTypeEnums.add(ServerTypeEnum.DGWS);
        serverTypeEnums.add(ServerTypeEnum.CAS);
        serverTypeEnums.add(ServerTypeEnum.IMGE);
    }

    /**
     *  通过枚举获取c++服务器那边对应的一套int类型。
     * @return
     */
    public Integer getCppTypeInt()
    {
        return this.cppTypeInt;
    }

    /**
     * 通过枚举获取web对应的int类型
     * @return
     */
    public Integer getWebTypeInt()
    {
        return this.webTypeInt;
    }

    /**
     *  通过web服务器类型的int 获取服务器枚举。
     * @param webTypeInt
     * @return
     */
    public static ServerTypeEnum getEnumByWebType(Integer webTypeInt)
    {
        ServerTypeEnum serverTypeEnum = null;
        for (ServerTypeEnum serverTypeEnumTmp : serverTypeEnums)
        {
            if(serverTypeEnumTmp.webTypeInt == webTypeInt)
            {
                serverTypeEnum = serverTypeEnumTmp;
                break;
            }
        }

        return serverTypeEnum;
    }

    /**
     * 通过cpp服务器int获取服务器枚举。
     * @param cppTypeInt
     * @return
     */
    public static ServerTypeEnum getEnumByCppType(Integer cppTypeInt)
    {
        ServerTypeEnum serverTypeEnum = null;
        for (ServerTypeEnum serverTypeEnumTmp : serverTypeEnums)
        {
            if(serverTypeEnumTmp.cppTypeInt == cppTypeInt)
            {
                serverTypeEnum = serverTypeEnumTmp;
                break;
            }
        }

        return serverTypeEnum;
    }

    public static void main(String[] args) {
        ServerTypeEnum enumByCppType = getEnumByCppType(1);
        System.out.println(enumByCppType.typeName);

        String format = String.format("domainid 不能为空，前%s位为%s", "1111".length(), "1111");
        System.out.println(format);

        List list = new ArrayList();
        Map map = new HashMap();
        Set set = new HashSet();
    }
}
