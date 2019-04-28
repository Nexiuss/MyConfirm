/**
 * FileName: Deviceid
 * Author:   Administrator
 * Date:     2019/1/5 15:07
 * Description:
 */
package lock;

public class Deviceid {

    String deviceid;

    public Deviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEq = false;
        if(obj instanceof Deviceid)
        {
            if(this.deviceid.equals(((Deviceid) obj).deviceid != null))            {
                isEq = true;
            }
        }

        return isEq;
    }
}
