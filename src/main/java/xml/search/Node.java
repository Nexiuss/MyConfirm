/**
 * FileName: Node
 * Author:   Administrator
 * Date:     2018/12/20 11:05
 * Description:
 */
package xml.search;

public abstract class Node
{


    /**
     * 查询条件的构造
     *
     * @param deviceid
     */
    public static Node deviceSearchBean(String deviceid) {
        Device device = new Device();
        device.setId(deviceid);
        return  device;
    }

    public static Node departmentSearchBeanByCoding(String coding)
    {
        Department department = new Department();
        department.setCoding(coding);
        return department;
    }


    public static Node ChannelSearchBean(String channelid)
    {
        Channel channel = new Channel();
        channel.setId(channelid);

        return channel;
    }
}
